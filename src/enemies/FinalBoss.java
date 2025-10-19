package enemies;

import characters.Character;
import utils.RandomUtil;
import inventory.*;

public class FinalBoss extends Enemy {

    private boolean encapsulated = false; // track 1-turn defense buff

    public FinalBoss() {
        super("Khai the Necromancer", 3455, 100, 185);
    }

    // ----------------------- SKILL 1 — SOUL DRAIN -----------------------
    public void soulDrain(Character target) {
        System.out.println("💀 " + name + " casts Soul Drain!");
        if (target.getEffects().checkDodge()) return;

        int damage = (int) RandomUtil.range(attack * 1.0, attack * 1.0);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("→ Soul Drain hits for " + reduced + " damage!");
        target.takeDamage(reduced);

        // Heal self 100 HP
        this.setHp(Math.min(this.getHp() + 100, this.getMaxHp()));
        System.out.println("💚 " + name + " absorbs life and heals 100 HP!");

        // Reflect check
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!");
                this.takeDamage(reflectDamage);
            }
        }
    }

    // ----------------------- SKILL 2 — ENCAPSULATION -----------------------
    public void encapsulation() {
        System.out.println("🪄 " + name + " uses Encapsulation!");
        if (!encapsulated) {
            this.getEffects().applyDefenseBuff(100, 1, true); // +100 DEF for 1 turn
            encapsulated = true;
        } else {
            System.out.println("⚠️ Encapsulation is still active!");
        }
    }

    // ----------------------- SKILL 3 — DARK ASCENSION -----------------------
    public void darkAscension(Character[] targets) {
        System.out.println("🌑 " + name + " unleashes Dark Ascension!");
        for (Character target : targets) {
            if (target == null || target.getHp() <= 0) continue;
            if (target.getEffects().checkDodge()) continue;

            double multiplier = RandomUtil.range(1.60, 2.00);
            int damage = (int) (attack * multiplier);
            int reduced = damage - target.getDefense();
            if (reduced < 0) reduced = 0;

            System.out.println("→ " + target.getName() + " takes " + reduced + " AoE damage!");
            target.takeDamage(reduced);

            // 50% chance to apply Fear
            if (RandomUtil.chance(50)) {
                target.getEffects().applyFear();
            }

            // Reflect check
            Armor equippedArmor = target.getInventory().getEquippedArmor();
            if (equippedArmor != null) {
                int reflectDamage = equippedArmor.checkReflectDamage(reduced);
                if (reflectDamage > 0) {
                    System.out.println("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!");
                    this.takeDamage(reflectDamage);
                }
            }
        }
    }

    // ----------------------- DISPLAY SKILLS -----------------------
    @Override
    public void showSkills() {
        System.out.println("\n------- FINAL BOSS: KHAI THE NECROMANCER SKILLS -------");
        System.out.println("Skill 1 – Soul Drain");
        System.out.println("Description: Drains the target’s life essence to heal himself.");
        System.out.println("Damage: (" + (int)(attack * 1.0) + ")");
        System.out.println("Effects:");
        System.out.println("- Heals self for 100 HP\n");

        System.out.println("Skill 2 – Encapsulation");
        System.out.println("Description: Forms a dark barrier, boosting defense temporarily.");
        System.out.println("Damage: —");
        System.out.println("Effects:");
        System.out.println("- Increases DEF by +100 for 1 turn\n");

        System.out.println("Skill 3 – Dark Ascension (AoE)");
        System.out.println("Description: Releases immense dark power to strike all foes.");
        System.out.println("Damage: (" + (int)(attack * 1.60) + " — " + (int)(attack * 2.00) + ")");
        System.out.println("Effects:");
        System.out.println("- 50% chance to apply Fear to all targets");
        System.out.println("---------------------------------------------------------");
    }

    // ----------------------- TURN LOGIC -----------------------
    @Override
    public void turn(Character target) {
        if (!encapsulated && RandomUtil.chance(25)) {
            encapsulation();
        } else if (RandomUtil.chance(40)) {
            soulDrain(target);
        } else {
            darkAscension(new Character[]{target});
        }
        encapsulated = false; // Encapsulation breaks after one turn
    }

    // ----------------------- LOOT -----------------------
    @Override
    public void dropLoot(Character player) {
        System.out.println("\n💎 " + name + " has fallen!");
        player.getPotions().lootPotions();
        player.getPotions().lootFullHealthPotions();
        System.out.println("🎁 You obtained rare potions and dark relics!");
        // TODO: Add weapon/armor drop logic here
    }
}
