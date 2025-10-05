package characters;

import utils.RandomUtil;

public class TestCharacter extends  Character {

    public TestCharacter() {
        super("Test Character", 150, 10, 150, 15);
    }

    @Override
    public void showSkills() {
        System.out.println("\nTest Character — Skills");
        System.out.println("OP Attack");
    }

    public void sampleAttack1(Character target){
        if(getEffects().checkConfuse()) return; // If self is confused and misses the attack

        int cost = 20;
        if (consumeEnergy(cost)) {
            System.out.println("Not enough energy to cast Ice Prison!");
            return;
        }

        int damage = (int) RandomUtil.range(attack, attack * 2);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        if(target.getEffects().checkDodge()) return; // if enemy has nimble and dodges the attack

        System.out.println("You cast sample attack 1 on " + target.getName() + " for " + reduced + " damage! (Energy: " + energy + "/" + maxEnergy + ")");
        target.takeDamage(reduced);
    }

    public void sampleAttack2(Character target){
        if(getEffects().checkConfuse()) return; // If self is confused and misses the attack

        int cost = 20;
        if (consumeEnergy(cost)) {
            System.out.println("Not enough energy to cast Ice Prison!");
            return;
        }

        int damage = (int) RandomUtil.range(attack * 0.50, attack * 0.80);
        int reduced = damage - target.getDefense();
        if (reduced < 0) reduced = 0;

        if(target.getEffects().checkDodge()) return; // if enemy has nimble and dodges the attack

        System.out.println("You cast sample attack 2 on " + target.getName() + " for " + reduced +
                " damage! " + target.getName() + " is STUNNED! BLEED is applied for 3 turns! (Energy: " + energy + "/" + maxEnergy + ")");

        target.takeDamage(reduced);
        target.getEffects().applyStun();
        target.getEffects().applyBleed(3);
    }

    @Override
    public void turn(Character target) {
        System.out.println("\n-- Your Turn --");

        System.out.println("(1) Skill 1   -  Sample Attack 1 (pure damage no effects)");
        System.out.println("(2) Skill 2   -  Sample Attack 2 (damage + stun + bleed)");
        System.out.println("(4) Skip Turn -  Restore 10% of Max Energy");
        System.out.print("Choose your action: ");

        int choice = utils.InputUtil.scan.nextInt();
        System.out.println("---------------");
        utils.InputUtil.scan.nextLine();

        switch (choice) {
            case 1 -> sampleAttack1(target);
            case 2 -> sampleAttack2(target);
            case 4 -> skipTurn();
            default -> System.out.println("❌ Invalid action! You missed your turn.");
        }
    }
}