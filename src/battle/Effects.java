package battle;

import characters.Character;
import utils.InputUtil;

public class Effects {
    private final Character owner;

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

    // --- ATK & DEF Modifiers ---
    private int atkBuffModifier = 0;
    private int atkDebuffModifier = 0;
    private int defBuffModifier = 0;
    private int defDebuffModifier = 0;

    private int atkBuffTurnsLeft = 0;
    private int atkDebuffTurnsLeft = 0;
    private int defBuffTurnsLeft = 0;
    private int defDebuffTurnsLeft = 0;

    public Effects(Character owner) {
        this.owner = owner;
    }

    // ------------------- GETTERS -------------------
    public int getAtkBuffTurnsLeft(){ return atkBuffTurnsLeft; }
    public int getAtkDebuffTurnsLeft(){ return atkDebuffTurnsLeft; }
    public int getDefBuffTurnsLeft(){ return defBuffTurnsLeft; }
    public int getDefDebuffTurnsLeft(){ return defDebuffTurnsLeft; }

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

    public void applyAttackBuff(int percent, int duration) {
        int amount = (int) Math.round(owner.getAttack() * (percent / 100.0));
        atkBuffModifier = amount;
        owner.setAttack(owner.getAttack() + amount);
        atkBuffTurnsLeft = duration;
        System.out.println("💪 Strengthen activated! +" + percent + "% ATK for " + duration + " turns!");
    }

    public void applyAttackDebuff(int percent, int duration) {
        int amount = (int) Math.round(owner.getAttack() * (percent / 100.0));
        atkDebuffModifier = amount;
        owner.setAttack(owner.getAttack() - amount);
        atkDebuffTurnsLeft = duration;
        System.out.println("💢 Weaken Applied! Target's ATK is reduced by " + percent + "% for " + duration + " turns!");
    }

    public void applyDefenseBuff(int percent, int duration) {
        int amount = (int) Math.round(owner.getDefense() * (percent / 100.0));
        defBuffModifier = amount;
        owner.setDefense(owner.getDefense() + amount);
        defBuffTurnsLeft = duration;
        System.out.println("🛡️ Fortified activated! +" + percent + "% DEF for " + duration + " turns!");
    }

    public void applyDefenseDebuff(int percent, int duration) {
        int amount = (int) Math.round(owner.getDefense() * (percent / 100.0));
        defDebuffModifier = amount;
        owner.setDefense(owner.getDefense() - amount);
        defDebuffTurnsLeft = duration;
        System.out.println("🔻 Fragile Applied! Target's DEF is reduced by " + percent + "% for " + duration + " turns!");
    }

    public void applyPoison(int turns) {
        poisonTurnsLeft = turns;
        System.out.println("☠️ Target is poisoned for " + turns + " turns!");
    }

    public void applyBleed(int turns) {
        bleedInitialTurns = turns;
        bleedTurnsLeft = turns;
        System.out.println("🩸 Target is bleeding for " + turns + " turns!");
    }

    public void applyBurn(int turns) {
        burnTurnsLeft = turns;
        System.out.println("🔥 Target is burned for " + turns + " turns!");
    }

    // ------------------- HEAL -------------------
    public void heal(int amount) {
        int newHp = owner.getHp() + amount;
        if (newHp > owner.getMaxHp()) newHp = owner.getMaxHp();
        owner.setHp(newHp);
        System.out.println(owner.getName() + " healed for " + amount + " HP. (HP: " + owner.getHp() + "/" + owner.getMaxHp() + ")");
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
            System.out.println(owner.getName() + " is poisoned! Took 5 damage.");
            owner.takeDamage(5);
            poisonTurnsLeft--;
        }
        if (bleedTurnsLeft > 0) {
            int bleedDamage = 5 * (bleedInitialTurns - bleedTurnsLeft + 1);
            System.out.println(owner.getName() + " is bleeding! Took " + bleedDamage + " damage.");
            owner.takeDamage(bleedDamage);
            bleedTurnsLeft--;
        }
        if (burnTurnsLeft > 0) {
            System.out.println(owner.getName() + " is burning! Took 5 damage.");
            owner.takeDamage(5);
            burnTurnsLeft--;
        }
    }

    // ------------------- BUFF/DEBUFF MODIFIERS -------------------
    public void updateModifiers() {
        if (atkBuffTurnsLeft > 0) {
            atkBuffTurnsLeft--;
            if (atkBuffTurnsLeft == 0) {
                owner.setAttack(owner.getAttack() - atkBuffModifier);
                atkBuffModifier = 0;
                System.out.println(owner.getName() + "'s attack buff has worn off!");
            }
        }
        if (atkDebuffTurnsLeft > 0) {
            atkDebuffTurnsLeft--;
            if (atkDebuffTurnsLeft == 0) {
                owner.setAttack(owner.getAttack() + atkDebuffModifier);
                atkDebuffModifier = 0;
                System.out.println(owner.getName() + "'s attack debuff has faded!");
            }
        }
        if (defBuffTurnsLeft > 0) {
            defBuffTurnsLeft--;
            if (defBuffTurnsLeft == 0) {
                owner.setDefense(owner.getDefense() - defBuffModifier);
                defBuffModifier = 0;
                System.out.println(owner.getName() + "'s defense buff has worn off!");
            }
        }
        if (defDebuffTurnsLeft > 0) {
            defDebuffTurnsLeft--;
            if (defDebuffTurnsLeft == 0) {
                owner.setDefense(owner.getDefense() + defDebuffModifier);
                defDebuffModifier = 0;
                System.out.println(owner.getName() + "'s defense debuff has faded!");
            }
        }
    }

}
