package enemies;

import characters.Character;
import inventory.Armor;
import inventory.Bow;
import inventory.Staff;
import inventory.Sword;
import utils.PrintUtil;
import utils.RandomUtil;

public class World3Miniboss1 extends Enemy {

    public World3Miniboss1() { super("Zyrryl", 3455, 88, 170); }

    public void graveCleaver(Character target) {
        System.out.println("🤺 " + name + " used Grave Cleaver!");
        PrintUtil.pause(800);
        if(target.getEffects().checkDodge()) return;
        if (this.getEffects().checkConfuse()) return;

        int damage = (int)RandomUtil.range(attack * 1.00, attack * 1.15);

        System.out.println("→💔 Grave Cleaver hits for " + damage + " Pure Damage!");
        PrintUtil.pause(800);
        target.takeDamage(damage);
    }

    public void boneShield() {
        System.out.println("🦴 " + name + " used Bone Shield!");
        PrintUtil.pause(800);

        System.out.println("→🛡️ Bone Shield increases defense of " + name + " by +50 for 2 turns!");
        PrintUtil.pause(800);
        this.getEffects().applyDefenseBuff(50, 2, true);
    }

    @Override
    public void displaySkills() {
        System.out.println("┌──────────────────────────────── 🛡️🏰 THE TOWER WARDEN SKILLS 🏰🛡️ ───────────────────────────────┐");
        System.out.println(" 🗡️ Skill 1 – Grave Cleaver");
        System.out.println(" 📝 Description : The Tower Warden performs a deathly slash, inflicting pure damage to its victims.");
        System.out.println(" 💥 Damage      : (" + (int)(attack * 1.00) + " — " + (int)(attack * 1.15) + ")");
        System.out.println(" ✨ Effects     :");
        System.out.println(" - 🔥 Inflicts pure damage, ignoring defense.\n");

        System.out.println(" 🛡️ Skill 2 – Bone Shield");
        System.out.println(" 📝 Description : The Tower Warden raises its shield, increasing its defenses.");
        System.out.println(" 💥 Damage      : –");
        System.out.println(" ✨ Effects     :");
        System.out.println(" - 🛡️ Increases " + name + "'s DEF by 50 for 2 turns.");
        System.out.println("└──────────────────────────────────────────────────────────────────────────────────────────────────┘");
    }



    @Override
    public void turn(Character target) {
        if(!this.getEffects().hasDefBuff()) {
            boneShield();
        } else {
            graveCleaver(target);
        }
    }

    @Override
    public void dropLoot(Character player){
        System.out.println("╦════════════════════════════════════╦");
        System.out.println("  🎁 You received:");
        PrintUtil.pause(800);
        player.lootSoulShards(10);
        player.getPotions().lootPotions(true);
        player.gainExp(rewardExp());

        if (player.getClassType().equals("Swordsman")) {
            Sword eclipseGreatsword = Sword.ECLIPSE_GREATSWORD;
            if (eclipseGreatsword.lootWeapon()) {
                eclipseGreatsword.equip(player);
            }
        } else if (player.getClassType().equals("Archer")) {
            Bow aetherstrikeBow = Bow.AETHERSTRIKE_BOW;
            if (aetherstrikeBow.lootWeapon()) {
                aetherstrikeBow.equip(player);
            }
        } else if (player.getClassType().equals("Mage")) {
            Staff aethericStaff = Staff.AETHERIC_STAFF;
            if (aethericStaff.lootWeapon()) {
                aethericStaff.equip(player);
            }
        }

        PrintUtil.pause(800);

        Armor skyforgePlate = Armor.SKYFORGE_PLATE;
        if (skyforgePlate.lootArmor()) {
            skyforgePlate.equip(player);
        }
    }

    @Override
    public int rewardExp(){return 10066;}
}
