package battle;

import characters.Character;

import utils.InputUtil;

public class Battle {
    private final Character player;
    private final Character enemy;

    public Battle(Character player, Character enemy){
        this.player = player;
        this.enemy = enemy;
    }

    public void startBattle(){
        preBattleOptions();
        battleLoop();
    }

    public void preBattleOptions() {
        boolean willFight = false;

        while(!willFight){
            System.out.println("-------------------------------------");
            System.out.println("What will you do?");
            System.out.println("1. Fight enemy");
            System.out.println("2. Open Inventory");
            System.out.println("3. Show Player Stats");
            System.out.println("4. Show Player Skills Overview");
            System.out.println("5. Show Enemy Stats");
            System.out.println("6. Show Enemy Skills Overview");

            System.out.print("Enter choice: ");
            int choice = InputUtil.scan.nextInt();
            InputUtil.scan.nextLine();

            switch (choice){
                case 1 -> { System.out.println("⚔️ You chose to fight!"); willFight = true; }
                //case 2 ->  openInventory TODO: implement inventory
                case 3 -> player.showStats();
                case 4 -> player.showSkills();
                case 5 -> enemy.showStats();
                case 6 -> enemy.showSkills();
                default -> System.out.println("❌ Invalid choice! Please select a valid option.");
            }
        }
    }

    public void battleLoop(){
        System.out.println("------------------------------");
        System.out.println("\n⚔️ Battle Start! " + player.getName() + " vs " + enemy.getName());

        while(player.isAlive() && enemy.isAlive()){

            if(player.getEffects().checkEffects()){
                System.out.println("\n-- Your Turn --");
                player.turn(enemy);
                player.getEffects().updateModifiers();
            } else{
                InputUtil.pressEnterToContinue();
            }
            player.getEffects().updateDoTEffects();
            System.out.println("------------------------------");

            if(!enemy.isAlive()){
                System.out.println("You defeated " + enemy.getName() + "!");
                break;
            }

            if(enemy.getEffects().checkEffects()){
                System.out.println("\n-- Enemy Turn --");
                enemy.turn(player);
                enemy.getEffects().updateModifiers();
            } else{
                InputUtil.pressEnterToContinue();
            }
            enemy.getEffects().updateDoTEffects();
            System.out.println("------------------------------");
        }

        if(!player.isAlive()){
            System.out.println("You have been defeated... GAME OVER!");
        }
    }

}
