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

    // ------------------- APPLY STATUS/EFFECTS -------------------
    public void applyFreeze() { frozen = true; }
    public void applyStun() { stunned = true; }
    public void applyImmobilize() { immobilized = true; }
    public void applyConfuse() { confused = true; }
    public void applyFear() { feared = true; confused = true; } // fear also confuses
    public void applyNimble() { nimble = true; }

    public void applyAttackBuff(int amount, int duration) {
        atkBuffModifier = amount;
        owner.setAttack(owner.getAttack() + amount);
        atkBuffTurnsLeft = duration;
    }
    public void applyAttackDebuff(int amount, int duration) {
        atkDebuffModifier = amount;
        owner.setAttack(owner.getAttack() - amount);
        atkDebuffTurnsLeft = duration;
    }
    public void applyDefenseBuff(int amount, int duration) {
        defBuffModifier = amount;
        owner.setDefense(owner.getDefense() + amount);
        defBuffTurnsLeft = duration;
    }
    public void applyDefenseDebuff(int amount, int duration) {
        defDebuffModifier = amount;
        owner.setDefense(owner.getDefense() - amount);
        defDebuffTurnsLeft = duration;
    }

    public void applyPoison(int turns) { poisonTurnsLeft = turns; }
    public void applyBleed(int turns) {
        bleedInitialTurns = turns;
        bleedTurnsLeft = turns;
    }
    public void applyBurn(int turns) { burnTurnsLeft = turns; }

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
            if (Math.random() < 0.3) {
                System.out.println(owner.getName() + " missed the attack due to confusion!");
                return true;
            }
            confused = false;
        }
        return false;
    }

    public boolean checkDodge() {
        if (nimble) {
            if (Math.random() < 0.3) {
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
