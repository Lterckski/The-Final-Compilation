package enemies;

import characters.Character;
import inventory.Armor;
import utils.RandomUtil;

public class FinalBoss extends Enemy {
    private boolean encapsulated = false;

    public FinalBoss() {
        super("Khai the Necromancer", 3455, 100, 185);
    }

    // 🩸 Skill 1: Soul Drain
    public void soulDrain(Character target) {
        System.out.println("💀 " + this.name + " casts Soul Drain!");
        if (!target.getEffects().checkDodge()) {
            int damage = (int) RandomUtil.range(this.attack * 1.0, this.attack * 1.0);
            int reduced = damage - target.getDefense();
            if (reduced < 0) reduced = 0;

            System.out.println("→ Soul Drain hits for " + reduced + " damage!");
            target.takeDamage(reduced);
            this.setHp(Math.min(this.getHp() + 100, this.getMaxHp()));
            System.out.println("💚 " + this.name + " absorbs life and heals 100 HP!");

            Armor equippedArmor = target.getInventory().getEquippedArmor();
            if (equippedArmor != null) {
                int reflectDamage = equippedArmor.checkReflectDamage(reduced);
                if (reflectDamage > 0) {
                    System.out.println("🛡️ " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + this.name + "!");
                    this.takeDamage(reflectDamage);
                }
            }
        }
    }

    // 🛡️ Skill 2: Encapsulation
    public void encapsulation() {
        System.out.println("🧿 " + this.name + " uses Encapsulation!");
        if (!this.encapsulated) {
            this.getEffects().applyDefenseBuff(100, 1, true);
            this.encapsulated = true;
        } else {
            System.out.println("⚠️ Encapsulation is still active!");
        }
    }

    // 🌑 Skill 3: Dark Ascension (AoE)
    public void darkAscension(Character[] targets) {
        System.out.println("🌘 " + this.name + " unleashes Dark Ascension!");

        for (Character target : targets) {
            if (target != null && target.getHp() > 0 && !target.getEffects().checkDodge()) {
                double multiplier = RandomUtil.range(1.6, 2.0);
                int damage = (int) (this.attack * multiplier);
                int reduced = damage - target.getDefense();
                if (reduced < 0) reduced = 0;

                System.out.println("→ " + target.getName() + " takes " + reduced + " AoE damage!");
                target.takeDamage(reduced);

                if (RandomUtil.chance(50)) {
                    target.getEffects().applyFear();
                }

                Armor equippedArmor = target.getInventory().getEquippedArmor();
                if (equippedArmor != null) {
                    int reflectDamage = equippedArmor.checkReflectDamage(reduced);
                    if (reflectDamage > 0) {
                        System.out.println("🛡️ " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + this.name + "!");
                        this.takeDamage(reflectDamage);
                    }
                }
            }
        }
    }

    // 📜 Display all boss skills
    public void showSkills() {
        System.out.println("\n------- FINAL BOSS: KHAI THE NECROMANCER SKILLS -------");
        System.out.println("Skill 1 – Soul Drain");
        System.out.println("Description: Drains the target’s life essence to heal himself.");
        System.out.println("Damage: (" + (int) (this.attack * 1.0) + ")");
        System.out.println("Effects:");
        System.out.println("- Heals self for 100 HP\n");

        System.out.println("Skill 2 – Encapsulation");
        System.out.println("Description: Forms a dark barrier, boosting defense temporarily.");
        System.out.println("Damage: —");
        System.out.println("Effects:");
        System.out.println("- Increases DEF by +100 for 1 turn\n");

        System.out.println("Skill 3 – Dark Ascension (AoE)");
        System.out.println("Description: Releases immense dark power to strike all foes.");
        System.out.println("Damage: (" + (int) (this.attack * 1.6) + " — " + (int) (this.attack * 2.0) + ")");
        System.out.println("Effects:");
        System.out.println("- 50% chance to apply Fear to all targets");
        System.out.println("---------------------------------------------------------");
    }

    // 🧠 Boss AI
    @Override
    public void turn(Character target) {
        if (!this.encapsulated && RandomUtil.chance(25)) {
            this.encapsulation();
        } else if (RandomUtil.chance(40)) {
            this.soulDrain(target);
        } else {
            this.darkAscension(new Character[]{target});
        }

        this.encapsulated = false;
    }

    // 🎁 Drops after defeat + Game end
    @Override
    public void dropLoot(Character player) {
        System.out.println("\n💎 " + this.name + " has fallen!");
        player.getPotions().lootPotions();
        player.getPotions().lootFullHealthPotions();
        System.out.println("🎁 You obtained rare potions and dark relics!");
        System.out.println("\n🏆 Congratulations! You have defeated the Final Boss!");
        System.out.println("🎮 The game has ended. Thank you for playing The Final Compilation!");
        System.exit(0);
    }

    // 🧩 Required by abstract class Enemy
    @Override
    public int rewardExp() {
        return 10000; // EXP gained for defeating the Final Boss
    }

    @Override
    public void displaySkills() {
        showSkills(); // required abstract method from Character
    }
}
