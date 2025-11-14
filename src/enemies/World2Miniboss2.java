package enemies;

import characters.Character;
import utils.InputUtil;
import utils.PrintUtil;
import utils.RandomUtil;
import inventory.*;

public class World2Miniboss2 extends Enemy {
    public World2Miniboss2() {
        super("Luther Von", 854, 32, 140);
    }

    public void crownOfDespair(Character target) {
        System.out.println("👑 " + name + " casts Crown of Despair!");
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        // Check immunity to debuff
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null && equippedArmor.checkEffectsImmunity()) {
            System.out.println("✨ " + target.getName() + " resisted Weaken 👑 due to " + equippedArmor.getName() + "!");
            PrintUtil.pause(800);
        } else{
            target.getEffects().applyAttackDebuff(20, 2);
        }
    }

    public void darkJudgement(Character target){
        System.out.println("⚔️ " + name + " uses Dark Judgment!");
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 1.0, attack * 1.15);
        int reduced = calculateDamage(target, damage);

        System.out.println("→💔 Dark Judgment hits for " + reduced + " damage!");
        PrintUtil.pause(800);
        target.takeDamage(reduced);

        //Reflect damage check
        Armor equippedArmor = target.getInventory().getEquippedArmor();
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!");
                PrintUtil.pause(800);
                this.takeDamage(reflectDamage);
            }
        }
    }

    public void kingsWrath(Character target){
        System.out.println("🔥 " + name + " unleashes King's Wrath!");
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 0.71, attack * 0.85);
        int reduced = calculateDamage(target, damage);

        System.out.println("→💔 King's Wrath hits for " + reduced + " damage!");
        PrintUtil.pause(800);
        target.takeDamage(reduced);

        Armor equippedArmor = target.getInventory().getEquippedArmor();

        // Reflect damage check
        if (equippedArmor != null) {
            int reflectDamage = equippedArmor.checkReflectDamage(reduced);
            if (reflectDamage > 0) {
                System.out.println("🪞 " + equippedArmor.getName() + " reflected " + reflectDamage + " damage back to " + name + "!");
                PrintUtil.pause(800);
                this.takeDamage(reflectDamage);
            }
        }

        // chance to Stun
        if (RandomUtil.chance(30)) {
            target.getEffects().applyStun();
        }

    }

    @Override
    public void displaySkills() {
        System.out.println("\n------- THE CORRUPTED KING SKILLS -------");
        System.out.println("Skill 1 – Crown of Despair");
        System.out.println("Description: The Corrupted King raises his crown, instilling fear and weakening his foe.");
        System.out.println("Damage: —");
        System.out.println("Effects:");
        System.out.println("- Reduces hero’s ATK by 20% for 2 turns (Weaken)\n");

        System.out.println("Skill 2 – Dark Judgement");
        System.out.println("Description: A shadowy strike that crushes the hero with dark energy.");
        System.out.println("Damage: (" + (int)(attack * 1.0) + " — " + (int)(attack * 1.15) + ")");
        System.out.println("Effects: —\n");

        System.out.println("Skill 3 – King’s Wrath");
        System.out.println("Description: The Corrupted King unleashes a furious strike, overwhelming his enemy.");
        System.out.println("Damage: (" + (int)(attack * 0.71) + " — " + (int)(attack * 0.85) + ")");
        System.out.println("Effects:");
        System.out.println("- 30% chance to Stun the target");
        System.out.println("-----------------------------------------");
    }



    @Override
    public void turn(Character target) {
        if(!target.getEffects().hasAtkDebuff()){
            crownOfDespair(target);
        } else{
            if (RandomUtil.chance(66)) darkJudgement(target);
            else kingsWrath(target);
        }
    }

    @Override
    public void dropLoot(Character player){
        player.gainExp(rewardExp());
        player.getPotions().lootPotions();
        player.getPotions().lootFullHealthPotions();

        System.out.println("\n🎁 You obtained 2 Rare Weapons!");
        PrintUtil.pause(800);

        // Check the class type
        if (player.getClassType().equals("Swordsman")) {
            Sword twinstrikeBlade = Sword.TWINSTRIKE_BLADE;   // +15 ATK, 10% chance for 2nd attack
            Sword lifebondBlade = Sword.LIFEBOND_BLADE;    // +15 ATK, restores 3% HP of damage dealt

            System.out.println("1️⃣ " + twinstrikeBlade.getName() + " → +15 ATK, 10% chance for a second attack ⚡");
            PrintUtil.pause(800);
            System.out.println("2️⃣ " + lifebondBlade.getName() + " → +15 ATK, restores 3% HP of damage dealt 💖");
            PrintUtil.pause(800);
            System.out.print("\nChoose one to equip (1 or 2): ");

            int choice = InputUtil.scanInput();
            InputUtil.scan.nextLine();

            if (choice == 1) {
                twinstrikeBlade.equip(player);
                System.out.println("\n⚙\uFE0F You equipped " + twinstrikeBlade.getName() + "! The other weapon vanishes...");
                PrintUtil.pause(800);
            } else if (choice == 2) {
                lifebondBlade.equip(player);
                System.out.println("\n⚙\uFE0F You equipped " + lifebondBlade.getName() + "! The other weapon vanishes...");
                PrintUtil.pause(800);
            } else {
                System.out.println("\n❌ Invalid choice! Both weapons disappear...");
                PrintUtil.pause(800);
            }

        } else if (player.getClassType().equals("Archer")) {
            Bow twinshotBow = Bow.TWINSHOT_BOW;    // +15 ATK, 10% chance to attack twice
            Bow lifebloomBow = Bow.LIFEBLOOM_BOW;   // +15 ATK, restores 3% HP of damage dealt

            System.out.println("1️⃣ " + twinshotBow.getName() + " → +15 ATK, +10% chance to attack twice 🎯");
            PrintUtil.pause(800);
            System.out.println("2️⃣ " + lifebloomBow.getName() + " → +15 ATK, restores 3% HP of damage dealt 💖");
            PrintUtil.pause(800);
            System.out.print("\nChoose one to equip (1 or 2): ");

            int choice = InputUtil.scanInput();
            InputUtil.scan.nextLine();

            if (choice == 1) {
                twinshotBow.equip(player);
                System.out.println("\n⚙\uFE0F You equipped " + twinshotBow.getName() + "! The other weapon vanishes...");
                PrintUtil.pause(800);
            } else if (choice == 2) {
                lifebloomBow.equip(player);
                System.out.println("\n⚙\uFE0F You equipped " + lifebloomBow.getName() + "! The other weapon vanishes...");
                PrintUtil.pause(800);
            } else {
                System.out.println("\n❌ Invalid choice! Both weapons disappear...");
                PrintUtil.pause(800);
            }

        } else if (player.getClassType().equals("Mage")) {
            Staff mysticMindStaff = Staff.MYSTIC_MIND_STAFF; // +15 ATK, 30% chance to confuse
            Staff flameheartStaff = Staff.FLAMEHEART_STAFF;  // +15 ATK, restores 3% HP of damage dealt

            System.out.println("1️⃣ " + mysticMindStaff.getName() + " → +15 ATK, 30% chance to confuse enemy 🌀");
            PrintUtil.pause(800);
            System.out.println("2️⃣ " + flameheartStaff.getName() + " → +15 ATK, restores 3% HP of damage dealt 💖");
            PrintUtil.pause(800);
            System.out.print("\nChoose one to equip (1 or 2): ");

            int choice = InputUtil.scanInput();
            InputUtil.scan.nextLine();

            if (choice == 1) {
                mysticMindStaff.equip(player);
                System.out.println("The other weapon vanishes...");
                PrintUtil.pause(800);
            } else if (choice == 2) {
                flameheartStaff.equip(player);
                System.out.println("The other weapon vanishes...");
                PrintUtil.pause(800);
            } else {
                System.out.println("\n❌ Invalid choice. Both weapons disappear...");
                PrintUtil.pause(800);
            }
        }
    }

    @Override
    public int rewardExp(){
        return 5692;
    }
}
