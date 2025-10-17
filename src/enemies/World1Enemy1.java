package enemies;

import characters.Character;
import inventory.Armor;
import utils.RandomUtil;

public class World1Enemy1 extends Enemy {
    // Constructor
    public World1Enemy1() { super("Rotfang Wolf", 60, 5, 10); }

    // Skill: Savage Howl (10–15 damage)
    public void savageHowl(Character target) {
        System.out.println("🐺 " + name + " unleashes Savage Howl!");
        if (target.getEffects().checkDodge()) return;

        int damage = (int) RandomUtil.range(attack, attack * 1.5);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        System.out.println("→ Savage Howl hits for " + reduced + " damage!");
        target.takeDamage(reduced);

        // Armor reflect check
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!");
                this.takeDamage(reflectDamage);
            }
        }
    }

    @Override
    public void showSkills(){
        System.out.println("\n------- ROTFANG WOLVES SKILLS -------");
        System.out.println("Skill – Savage Howl");
        System.out.println("Description: The wolves unleash a feral howl, striking their target with raw power.");
        System.out.println("Damage: (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.50) + ")");
        System.out.println("Effects: —");
        System.out.println("-------------------------------------");
    }

    @Override
    public void turn(Character target) {
        savageHowl(target);
    }

    @Override
    public void dropLoot(Character player){
        player.getPotions().lootPotions();
    }

    @Override
    public int getExp(){
        return RandomUtil.range(34,36);
    }
}
