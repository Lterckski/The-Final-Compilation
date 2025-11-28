package enemies;

import characters.Character;
import inventory.Armor;
import utils.PrintUtil;
import utils.RandomUtil;

public class FinalBoss extends Enemy {
    private int nullEnergy = 0;
    private int voidEnergy = 0;
    private boolean encapsulated = false;
    private boolean shieldBroken = false;
    private int shield = 0; // 🛡️ Shield value (temporary, lasts 1 turn)

    public FinalBoss() {
        super("Khai the Necromancer", 3455, 50, 185);
    }

    public int getShield(){ return shield; }
    // 🩸 Skill 1: Soul Drain
    public void soulDrain(Character target) {
        System.out.println("💀 " + name + " casts Soul Drain!");
        PrintUtil.pause(800);
        if (target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = attack;
        int reduced = calculateDamage(target, damage);

        System.out.println("→💔 Soul Drain hits for " + reduced + " damage!");
        PrintUtil.pause(800);
        target.takeDamage(reduced);

        int heal = reduced;
        hp = Math.min(maxHP, hp + heal);
        System.out.println("💝 " + name + " absorbs life and heals " + heal + " HP!");
        PrintUtil.pause(800);

        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println("🛡️ " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!");
                PrintUtil.pause(800);
                this.takeDamage(reflectDamage);
            }
        }
    }

    // 🛡️ Skill 2: Encapsulation (creates a 1-turn shield)
    public void encapsulation() {
        System.out.println("🧿 " + name + " uses Encapsulation!");
        PrintUtil.pause(800);
        if (!encapsulated) {
            shield = 50; // Shield lasts one turn
            encapsulated = true;
            shieldBroken = false;
            System.out.println("🌑 A dark barrier forms, shielding Khai from harm! (+50 Shield for 1 turn)");
            PrintUtil.pause(800);
        }
    }

    // 🌑 Skill 3: Dark Ascension
    public void darkAscension(Character target) {
        System.out.println("🌘 " + name + " unleashes Dark Ascension!");
        PrintUtil.pause(800);
        if (target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int) RandomUtil.range(attack * 1.6, attack * 2.0);
        int reduced = calculateDamage(target, damage);

        System.out.println("→💔 Dark Ascension hits for " + reduced + " damage!");
        PrintUtil.pause(800);
        target.takeDamage(reduced);

        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println("🛡️ " + equippedArmor.getName() +
                        " reflected " + reflectDamage + " damage back to " + name + "!");
                PrintUtil.pause(800);
                this.takeDamage(reflectDamage);
            }
        }

        if (RandomUtil.chance(50)) target.getEffects().applyFear();
    }

    public void reduceShield(int amount) {
        if (amount <= 0) return; // do nothing if no damage
        shield -= amount;

        if (shield <= 0) {
            shield = 0;
            shieldBroken = true;
            checkBrokenShield();
        }
    }

    public void checkBrokenShield() {
        if (encapsulated) {
            if (shieldBroken) {
                voidEnergy++;
                baseDefense = (int) (baseDefense * 1.05);
                defense = baseDefense;
                System.out.println("-");
                System.out.println("💥 The barrier shatters! Khai gains 1 stack of Void Energy! (+5% DEF)");
                System.out.println("🛡️ Khai's Current DEF: " + baseDefense + " | 🕳 Void Energy Stacks: " + voidEnergy);
                System.out.println("-");
                PrintUtil.pause(800);
            }
        }
    }

    public void checkUnbrokenShield(){
        if (encapsulated) {
            if (!shieldBroken) {
                nullEnergy++;
                baseAttack = (int) (baseAttack * 1.05);
                attack = baseAttack;
                System.out.println("-");
                System.out.println("🌑 The barrier remains unbroken... Khai gains 1 stack of Null Energy! (+5% ATK)");
                System.out.println("⚔️ Khai's Current ATK: " + baseAttack + " | 🔮 Null Energy Stacks: " + nullEnergy);
                System.out.println("-");
                PrintUtil.pause(800);
            }
        }

        encapsulated = false;
        shieldBroken = false;
        shield = 0; // Shield expires after one turn
    }

    public void applyStun() {
        // Immediately remove shield if active
        if (encapsulated && shield > 0) {
            shield = 0;
            shieldBroken = true;
            encapsulated = false;
        }
    }

    // 🧠 Boss AI
    @Override
    public void turn(Character target) {
        checkUnbrokenShield();
        double hpPercent = ((double) this.hp / this.maxHP) * 100;

        if(hpPercent > 80){
            if(RandomUtil.chance(80))
                encapsulation();
            else
                soulDrain(target);

        } else if(hpPercent > 30){
            int roll = RandomUtil.range(1,100);

            if(roll <= 20) soulDrain(target);
            else if(roll <= 30) encapsulation();
            else darkAscension(target);

        } else{
            int roll = RandomUtil.range(1,100);

            if(roll <= 10) encapsulation();
            else if(roll <= 30) darkAscension(target);
            else soulDrain(target);
        }
    }

    // 🎁 Drops after defeat + Game end
    @Override
    public void dropLoot(Character player) {
        return;
    }

    // 🧩 Required by abstract class Enemy
    @Override
    public int rewardExp() {
        return 999999; // EXP gained for defeating the Final Boss
    }

    @Override
    public void displayStats() {
        System.out.println("\n┌───────────── \uD83D\uDC79 ENEMY STATS \uD83D\uDC79 ─────────────┐");
        System.out.println(" 👤 Name    : " + name);
        System.out.println(" ❤️ HP      : " + hp + "/" + maxHP);

        // ⚔️ Attack
        System.out.print(" ⚔\uFE0F Attack  : " + baseAttack);
        if (attack > baseAttack) System.out.print(" (+" + (attack - baseAttack) + ")");
        else if (attack < baseAttack) System.out.print(" (-" + (baseAttack - attack) + ")");
        System.out.println();

        // 🛡️ Defense
        System.out.print(" \uD83D\uDEE1\uFE0F Defense : " + baseDefense);
        if (defense > baseDefense) System.out.print(" (+" + (defense - baseDefense) + ")");
        else if (defense < baseDefense) System.out.print(" (-" + (baseDefense - defense) + ")");
        System.out.println();

        // 🩸 Shield
        if (shield > 0) System.out.println("🛡️ Active Shield : " + shield + " (1 Turn)");

        // 📈 Stack Info
        System.out.println(" 🔮 Null Energy Stacks : " + nullEnergy);
        System.out.println(" 🌑 Void Energy Stacks : " + voidEnergy);
        System.out.println("└──────────────────────────────────────────────┘");

    }

    @Override
    public void displaySkills() {
        System.out.println("┌───────────── 🕷️ FINAL BOSS: KHAI THE NECROMANCER SKILLS 🕷️ ──────────────┐");
        System.out.println(" 💀 Skill 1 – Soul Drain");
        System.out.println(" 📝 Description : Drains the target’s life essence to heal himself.");
        System.out.println(" ⚔️ Damage      : (" + (int)(attack * 1.0) + ")");
        System.out.println(" ✨ Effects     :");
        System.out.println(" - ❤️ Heals self for 100 HP\n");

        System.out.println(" 🛡️ Skill 2 – Encapsulation");
        System.out.println(" 📝 Description : Forms a dark barrier that absorbs 50 damage for 1 turn.");
        System.out.println(" ⚔️ Damage      : —");
        System.out.println(" ✨ Effects     :");
        System.out.println(" - 🛡️ Grants a 50-damage shield for 1 turn");
        System.out.println(" - 🔮 If shield remains intact → Gain Null Energy (+5% ATK permanently)");
        System.out.println(" - 🌑 If shield breaks → Gain Void Energy (+5% DEF permanently)\n");

        System.out.println(" 🌌 Skill 3 – Dark Ascension");
        System.out.println(" 📝 Description : Releases immense dark power upon the target.");
        System.out.println(" ⚔️ Damage      : (" + (int)(attack * 1.6) + " — " + (int)(attack * 2.0) + ")");
        System.out.println(" ✨ Effects     :");
        System.out.println(" - 😱 50% chance to apply Fear to target");
        System.out.println("└──────────────────────────────────────────────────────────────────────────┘");
    }


}
