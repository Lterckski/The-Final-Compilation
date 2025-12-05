package battle;

import characters.Character;
import enemies.FinalBoss;
import utils.ColorUtil;
import utils.PrintUtil;

import java.util.ArrayList;

public class Effects {
    private final Character owner;

    // --- Buff/Debuff storage ---
    private ArrayList<StatModifier> atkBuffs = new ArrayList<>();
    private ArrayList<StatModifier> atkDebuffs = new ArrayList<>();
    private ArrayList<StatModifier> defBuffs = new ArrayList<>();
    private ArrayList<StatModifier> defDebuffs = new ArrayList<>();

    // --- 1-turn Pre-turn Effects ---
    private boolean frozen = false;
    private boolean stunned = false;
    private boolean immobilized = false;
    private boolean feared = false;

    // --- 1-turn Battle Effects ---
    private boolean confused = false;
    private boolean nimble = false;

    // --- Multi-turn DoT Effects ---
    private int poisonTurnsLeft = 0;
    private int bleedInitialTurns = 0;
    private int bleedTurnsLeft = 0;
    private int burnTurnsLeft = 0;

    public Effects(Character owner) {
        this.owner = owner;
    }

    private static class StatModifier {
        int amount;
        int turnsLeft;

        StatModifier(int amount, int turnsLeft) {
            this.amount = amount;
            this.turnsLeft = turnsLeft;
        }
    }

    // ------------------- APPLY STATUS/EFFECTS -------------------
    public void applyFreeze() {
        frozen = true;
        System.out.println(ColorUtil.brightMagenta("❄️ Target is Frozen solid and skips their turn!"));
        PrintUtil.pause(800);
    }

    public void applyStun() {
        stunned = true;
        System.out.println(ColorUtil.brightMagenta("💫 Target is Stunned and can't act!"));
        PrintUtil.pause(800);
    }

    public void applyImmobilize() {
        immobilized = true;
        System.out.println(ColorUtil.brightMagenta("⛓️ Target is Immobilized and cannot move!"));
        PrintUtil.pause(800);
    }

    public void applyConfuse() {
        confused = true;
        System.out.println(ColorUtil.brightMagenta("💭 Target is Confused and might miss their next attack!"));
        PrintUtil.pause(800);
    }

    public void applyFear() {
        feared = true;
        confused = true; // Fear also confuses the target
        System.out.println(ColorUtil.boldBrightMagenta("😱 Target is Terrified by Fear, skips their turn, and becomes Confused!"));
        PrintUtil.pause(800);
    }

    public void applyNimble() {
        nimble = true;
        System.out.println(ColorUtil.brightMagenta("⚡ You become Nimble and may dodge the next attack!"));
        PrintUtil.pause(800);
    }

    // ------------------- APPLY BUFFS/DEBUFFS -------------------
    public void applyAttackBuff(int percent, int duration) {
        int amount = (int) Math.round(owner.getAttack() * (percent / 100.0));
        atkBuffs.add(new StatModifier(amount, duration+1));
        owner.setAttack(owner.getAttack() + amount);

        System.out.println(ColorUtil.brightMagenta("💪 Strengthen activated! +" + percent + "% ATK for " + duration + " turn/s!"));
        PrintUtil.pause(800);
    }

    public void applyAttackDebuff(int percent, int duration) {
        int amount = (int) Math.round(owner.getAttack() * (percent / 100.0));
        atkDebuffs.add(new StatModifier(amount, duration+1));
        owner.setAttack(owner.getAttack() - amount);

        System.out.println(ColorUtil.brightMagenta("💢 Weaken applied! -" + percent + "% ATK for " + duration + " turn/s!"));
        PrintUtil.pause(800);
    }

    public void applyDefenseBuff(int percent, int duration) {
        int amount = (int) Math.round(owner.getDefense() * (percent / 100.0));
        defBuffs.add(new StatModifier(amount, duration+1));
        owner.setDefense(owner.getDefense() + amount);

        System.out.println(ColorUtil.brightMagenta("🛡️ Fortified activated! +" + percent + "% DEF for " + duration + " turn/s!"));
        PrintUtil.pause(800);
    }

    // Fixed amount version (like a shield)
    public void applyDefenseBuff(int amount, int duration, boolean fixedAmountIsPassed) {
        defBuffs.add(new StatModifier(amount, duration));
        owner.setDefense(owner.getDefense() + amount);

        System.out.println(ColorUtil.brightMagenta("🛡️ Shield activated! +" + amount + " DEF for " + duration + " turn/s!"));
        PrintUtil.pause(800);
    }

    public void applyDefenseDebuff(int percent, int duration) {
        int amount = (int) Math.round(owner.getDefense() * (percent / 100.0));
        defDebuffs.add(new StatModifier(amount, duration+1));
        owner.setDefense(owner.getDefense() - amount);

        System.out.println(ColorUtil.brightMagenta("🔻 Fragile applied! -" + percent + "% DEF for " + duration + " turn/s!"));
        PrintUtil.pause(800);
    }

    //-----------------------------------
    public void applyPoison(int turns) {
        poisonTurnsLeft += turns;
        System.out.println(ColorUtil.brightMagenta("☠️ Target is poisoned for " + turns + " turn/s!"));
        PrintUtil.pause(800);
    }

    public void applyBleed(int turns) {
        bleedInitialTurns += turns;
        bleedTurnsLeft += turns;
        System.out.println(ColorUtil.brightMagenta("🩸 Target is bleeding for " + turns + " turn/s!"));
        PrintUtil.pause(800);
    }

    public void applyBurn(int turns) {
        if(owner.getName().equals("Flame Revenant")){
            System.out.println(ColorUtil.brightMagenta("❌ Target is Immune to Burn! Effect can't be applied"));
            PrintUtil.pause(800);
            return;
        }
        burnTurnsLeft += turns;
        System.out.println(ColorUtil.brightMagenta("🔥 Target is burned for " + turns + " turn/s!"));
        PrintUtil.pause(800);
    }

    // Check if character has any active ATK buff
    public boolean hasAtkBuff() {
        return !atkBuffs.isEmpty();
    }

    // Check if character has any active ATK debuff
    public boolean hasAtkDebuff() {
        return !atkDebuffs.isEmpty();
    }

    // Check if character has any active DEF buff
    public boolean hasDefBuff() {
        return !defBuffs.isEmpty();
    }

    // Check if character has any active DEF debuff
    public boolean hasDefDebuff() {
        return !defDebuffs.isEmpty();
    }

    // ------------------- TURN CHECKS -------------------
    public boolean checkEffects() {
        if (frozen) {
            System.out.println(ColorUtil.boldBrightMagenta(owner.getName() + " is Frozen. TURN SKIPPED!"));
            PrintUtil.pause(800);
            frozen = false;
            return false;
        }
        if (stunned) {
            System.out.println(ColorUtil.boldBrightMagenta(owner.getName() + " is Stunned. TURN SKIPPED!"));
            PrintUtil.pause(800);
            stunned = false;
            return false;
        }
        if (immobilized) {
            System.out.println(ColorUtil.boldBrightMagenta(owner.getName() + " is Immobilized. Can only regain hp & energy. TURN SKIPPED!"));
            PrintUtil.pause(800);
            owner.skipTurn();
            immobilized = false;
            return false;
        }
        if (feared) {
            System.out.println(ColorUtil.boldBrightMagenta(owner.getName() + " is Feared. Can only regain hp & energy. TURN SKIPPED!"));
            PrintUtil.pause(800);
            owner.skipTurn();
            feared = false;
            return false;
        }
        return true;
    }

    public boolean checkConfuse() {
        if (confused) {
            if (Math.random() < 0.50) {
                PrintUtil.pause(1700);
                System.out.println(ColorUtil.boldBrightMagenta(owner.getName() + " missed the attack due to confusion!"));
                PrintUtil.pause(800);
                confused = false;
                return true;
            }
            confused = false;
        }
        return false;
    }

    public boolean checkDodge() {
        if (nimble) {
            if (Math.random() < 0.50) {
                System.out.println(ColorUtil.boldBrightMagenta(owner.getName() + " dodged the attack due to Nimble!"));
                PrintUtil.pause(800);
                nimble = false;
                return true;
            }
            nimble = false;
        }
        return false;
    }

    // ------------------- DoT EFFECTS -------------------
    public void updateDoTEffects() {
// ----- POISON (scales with Max HP) -----
        if (poisonTurnsLeft > 0) {
            int poisonDamage = Math.max(1, (int)(owner.getMaxHP() * 0.05)); // 5% of Max HP
            System.out.println(ColorUtil.brightMagenta("☠ " + owner.getName() + " is poisoned! 💔 Took " + poisonDamage + " damage."));
            PrintUtil.pause(800);
            owner.takeDamage(poisonDamage);
            poisonTurnsLeft--;
        }

// ----- BLEED (scales with Missing HP) -----
        if (bleedTurnsLeft > 0) {
            int missingHP = owner.getMaxHP() - owner.getHp();
            int bleedDamage = Math.max(1, (int)(missingHP * 0.04)); // 4% of missing HP
            System.out.println(ColorUtil.brightMagenta("🩸 " + owner.getName() + " is bleeding! 💔 Took " + bleedDamage + " damage (based on missing HP)."));
            // Scales 4%, 6%, 8%, ... up to 16%
            int scalePercent = Math.min(4 + 2 * (bleedInitialTurns - bleedTurnsLeft), 16);
            int bleedDamage = Math.max(1, (atk * scalePercent) / 100);

            System.out.println(ColorUtil.brightMagenta("🩸 " + owner.getName() + " is bleeding! 💔 Took "
                    + bleedDamage + " damage."));
            PrintUtil.pause(800);
            owner.takeDamage(bleedDamage);
            bleedTurnsLeft--;
        }

// ----- BURN (scales with Current HP) -----
        if (burnTurnsLeft > 0) {
            int burnDamage;

            if (owner instanceof FinalBoss) {
                // Boss: weaker burn to avoid instant melting
                int rawBurn = (int)((owner.getMaxHP() * 0.01) + (owner.getHp() * 0.01));
                int burnCap = (int)(owner.getMaxHP() * 0.03); // max 3% of Max HP
                burnDamage = Math.max(1, Math.min(rawBurn, burnCap));
            } else {
                // Normal enemies: standard hybrid burn
                int rawBurn = (int)((owner.getMaxHP() * 0.02) + (owner.getHp() * 0.02));
                int burnCap = (int)(owner.getMaxHP() * 0.06); // max 6% of Max HP
                burnDamage = Math.max(1, Math.min(rawBurn, burnCap));
            }

            System.out.println(ColorUtil.brightMagenta("🔥 " + owner.getName() + " is burning! 💔 Took " + burnDamage + " damage."));
            PrintUtil.pause(800);
            owner.takeDamage(burnDamage);
            burnTurnsLeft--;
        }
    }


    // ------------------- UPDATE ATK BUFFS/DEBUFFS -------------------
    public void updateAttackModifiers() {
        // --- ATK Buffs ---
        for (int i = atkBuffs.size() - 1; i >= 0; i--) {
            StatModifier mod = atkBuffs.get(i);
            mod.turnsLeft--;
            if (mod.turnsLeft <= 0) {
                owner.setAttack(owner.getAttack() - mod.amount);
                atkBuffs.remove(i);
                System.out.println(ColorUtil.boldBrightMagenta(owner.getName() + "'s attack buff has worn off!"));
                PrintUtil.pause(800);
            }
        }

        // --- ATK Debuffs ---
        for (int i = atkDebuffs.size() - 1; i >= 0; i--) {
            StatModifier mod = atkDebuffs.get(i);
            mod.turnsLeft--;
            if (mod.turnsLeft <= 0) {
                owner.setAttack(owner.getAttack() + mod.amount);
                atkDebuffs.remove(i);
                System.out.println(ColorUtil.boldBrightMagenta(owner.getName() + "'s attack debuff has faded!"));
                PrintUtil.pause(800);
            }
        }
    }


    // ------------------- UPDATE DEF BUFFS/DEBUFFS -------------------
    public void updateDefenseModifiers() {
        // --- DEF Buffs ---
        for (int i = defBuffs.size() - 1; i >= 0; i--) {
            StatModifier mod = defBuffs.get(i);
            mod.turnsLeft--;
            if (mod.turnsLeft <= 0) {
                owner.setDefense(owner.getDefense() - mod.amount);
                defBuffs.remove(i);
                System.out.println(ColorUtil.boldBrightMagenta(owner.getName() + "'s defense buff has worn off!"));
                PrintUtil.pause(800);
            }
        }

        // --- DEF Debuffs ---
        for (int i = defDebuffs.size() - 1; i >= 0; i--) {
            StatModifier mod = defDebuffs.get(i);
            mod.turnsLeft--;
            if (mod.turnsLeft <= 0) {
                owner.setDefense(owner.getDefense() + mod.amount);
                defDebuffs.remove(i);
                System.out.println(ColorUtil.boldBrightMagenta(owner.getName() + "'s defense debuff has faded!"));
                PrintUtil.pause(800);
            }
        }
    }


    // ------------------- RESET ALL EFFECTS -------------------
    public void resetAllEffects() {
        // Clear all buffs and debuffs
        atkBuffs.clear();
        atkDebuffs.clear();
        defBuffs.clear();
        defDebuffs.clear();

        // Reset temporary statuses
        frozen = false;
        stunned = false;
        immobilized = false;
        feared = false;
        confused = false;
        nimble = false;

        // Reset DoT effects
        poisonTurnsLeft = 0;
        bleedInitialTurns = 0;
        bleedTurnsLeft = 0;
        burnTurnsLeft = 0;

    }

}
