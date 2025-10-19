package battle;

import characters.Character;

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
        System.out.println("❄️ Target is Frozen solid and skips their turn!");
    }

    public void applyStun() {
        stunned = true;
        System.out.println("💫 Target is Stunned and can't act!");
    }

    public void applyImmobilize() {
        immobilized = true;
        System.out.println("⛓️ Target is Immobilized and cannot move!");
    }

    public void applyConfuse() {
        confused = true;
        System.out.println("💭 Target is Confused and might miss their next attack!");
    }

    public void applyFear() {
        feared = true;
        confused = true; // Fear also confuses the target
        System.out.println("😱 Target is Terrified by Fear, skips their turn, and becomes Confused!");
    }

    public void applyNimble() {
        nimble = true;
        System.out.println("⚡ You become Nimble and may dodge the next attack!");
    }

    // ------------------- APPLY BUFFS/DEBUFFS -------------------

    public void applyAttackBuff(int percent, int duration) {
        int amount = (int) Math.round(owner.getAttack() * (percent / 100.0));
        atkBuffs.add(new StatModifier(amount, duration+1));
        owner.setAttack(owner.getAttack() + amount);

        System.out.println("💪 Strengthen activated! +" + percent + "% ATK for " + duration + " turn/s!");
    }

    public void applyAttackDebuff(int percent, int duration) {
        int amount = (int) Math.round(owner.getAttack() * (percent / 100.0));
        atkDebuffs.add(new StatModifier(amount, duration+1));
        owner.setAttack(owner.getAttack() - amount);

        System.out.println("💢 Weaken applied! -" + percent + "% ATK for " + duration + " turn/s!");
    }

    public void applyDefenseBuff(int percent, int duration) {
        int amount = (int) Math.round(owner.getDefense() * (percent / 100.0));
        defBuffs.add(new StatModifier(amount, duration+1));
        owner.setDefense(owner.getDefense() + amount);

        System.out.println("🛡️ Fortified activated! +" + percent + "% DEF for " + duration + " turn/s!");
    }

    // Fixed amount version (like a shield)
    public void applyDefenseBuff(int amount, int duration, boolean fixedAmountIsPassed) {
        defDebuffs.add(new StatModifier(amount, duration));
        owner.setDefense(owner.getDefense() - amount);

        System.out.println("🛡️ Shield activated! +" + amount + " DEF for " + duration + " turn/s!");
    }

    public void applyDefenseDebuff(int percent, int duration) {
        int amount = (int) Math.round(owner.getDefense() * (percent / 100.0));
        defDebuffs.add(new StatModifier(amount, duration+1));
        owner.setDefense(owner.getDefense() - amount);

        System.out.println("🔻 Fragile applied! -" + percent + "% DEF for " + duration + " turn/s!");
    }


    public void applyPoison(int turns) {
        poisonTurnsLeft += turns;
        System.out.println("☠️ Target is poisoned for " + turns + " turn/s!");
    }

    public void applyBleed(int turns) {
        bleedInitialTurns += turns;
        bleedTurnsLeft += turns;
        System.out.println("🩸 Target is bleeding for " + turns + " turn/s!");
    }

    public void applyBurn(int turns) {
        burnTurnsLeft += turns;
        System.out.println("🔥 Target is burned for " + turns + " turn/s!");
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
            System.out.println(owner.getName() + " is Frozen. TURN SKIPPED!");
            frozen = false;
            return false;
        }
        if (stunned) {
            System.out.println(owner.getName() + " is Stunned. TURN SKIPPED!");
            stunned = false;
            return false;
        }
        if (immobilized) {
            System.out.println(owner.getName() + " is Immobilized. Can only regain energy. TURN SKIPPED!");
            owner.skipTurn();
            immobilized = false;
            return false;
        }
        if (feared) {
            System.out.println(owner.getName() + " is Feared. Can only regain energy. TURN SKIPPED!");
            owner.skipTurn();
            feared = false;
            return false;
        }
        return true;
    }

    public boolean checkConfuse() {
        if (confused) {
            if (Math.random() < 0.50) {
                System.out.println(owner.getName() + " missed the attack due to confusion!");
                return true;
            }
            confused = false;
        }
        return false;
    }

    public boolean checkDodge() {
        if (nimble) {
            if (Math.random() < .50) {
                System.out.println(owner.getName() + " dodged the attack due to Nimble!");
                nimble = false;
                return true;
            }
            nimble = false;
        }
        return false;
    }

    // ------------------- DoT EFFECTS -------------------
    public void updateDoTEffects() {
        if (poisonTurnsLeft > 0) {
            System.out.println(owner.getName() + " is poisoned☠! Took 5 damage💔.");
            owner.takeDamage(5);
            poisonTurnsLeft--;
        }
        if (bleedTurnsLeft > 0) {
            int bleedDamage = Math.min(5 + 2 * (bleedInitialTurns - bleedTurnsLeft), 16);
            System.out.println(owner.getName() + " is bleeding🩸! Took " + bleedDamage + " damage💔.");
            owner.takeDamage(bleedDamage);
            bleedTurnsLeft--;
        }
        if (burnTurnsLeft > 0) {
            System.out.println(owner.getName() + " is burning🔥! Took 5 damage💔.");
            owner.takeDamage(5);
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
                System.out.println(owner.getName() + "'s attack buff has worn off!");
            }
        }

        // --- ATK Debuffs ---
        for (int i = atkDebuffs.size() - 1; i >= 0; i--) {
            StatModifier mod = atkDebuffs.get(i);
            mod.turnsLeft--;
            if (mod.turnsLeft <= 0) {
                owner.setAttack(owner.getAttack() + mod.amount);
                atkDebuffs.remove(i);
                System.out.println(owner.getName() + "'s attack debuff has faded!");
            }
        }
    }

    // ------------------- UPDATE DEF BUFFS/DEBUFFS -------------------
    public void updateDefenseModifiers() {
        // --- DEF Buffs ---
        for (int i = defBuffs.size() - 1; i >= 0; i--) {
            StatModifier buff = defBuffs.get(i);
            buff.turnsLeft--;
            if (buff.turnsLeft <= 0) {
                owner.setDefense(owner.getDefense() - buff.amount);
                defBuffs.remove(i);
                System.out.println(owner.getName() + "'s defense buff has worn off!");
            }
        }

        // --- DEF Debuffs ---
        for (int i = defDebuffs.size() - 1; i >= 0; i--) {
            StatModifier mod = defDebuffs.get(i);
            mod.turnsLeft--;
            if (mod.turnsLeft <= 0) {
                owner.setDefense(owner.getDefense() + mod.amount);
                defDebuffs.remove(i);
                System.out.println(owner.getName() + "'s defense debuff has faded!");
            }
        }
    }


}
