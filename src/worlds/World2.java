package worlds;

import enemies.*;
import battle.Battle;
import characters.Character;
import story.ScenePrinter;
import utils.InputUtil;

import java.lang.reflect.Method;

public class World2 {

    public void run(Character player) {
        ScenePrinter.title("World 2 — The Town of Decay & The Black Castle");

        ScenePrinter.type(
                "Beyond the forest lies a town. Relief surges—until you step closer. The place is diseased.\n" +
                        "Children cough in alleys, merchants peddle spoiled goods, and hollow-eyed guards demand bribes.\n" +
                        "Every face tells the same story: something has poisoned this world.\n"
        );

        ScenePrinter.say("Sir Khai", "\"The Stones,\" he murmurs. \"They are both curse and cure.\"\n");
        InputUtil.pressEnterToContinue();

        Enemy enemy1 = new World2Enemy1();
        Battle battle1 = new Battle(player, enemy1);

        ScenePrinter.line();
        ScenePrinter.type("""
        🐀 The stench of rot fills the air.
        From the sewers, two Plague Vermins scuttle out—diseased, hissing, and hungry.
        Their claws drip with venomous filth.
        """);

        ScenePrinter.type("🎯 Objective: Defeat 3 Plague Vermins!\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        for(int i = 1; i <= 3; i++){
            ScenePrinter.hr();
            System.out.println("🐀 Vermin " + i + " lunges at you!");
            ScenePrinter.hr();

            battle1.startBattle();

            if (!enemy1.isAlive()) {
                System.out.println("✅ You have defeated Vermin " + i + "!");
                ScenePrinter.line();
                enemy1.dropLoot(player);

                if (i < 3) { // reset for next vermin
                    enemy1 = new World2Enemy1();
                    battle1 = new Battle(player, enemy1);
                }
            }
        }

        if (player.isAlive()) {
            ScenePrinter.line();
            ScenePrinter.type("""
            🎉 Victory! The last of the Plague Vermins collapses into the sludge.
            The foul air clears just enough for you to breathe again.
            """);
            ScenePrinter.loot("You gain experience and loot from your hard-fought battle.\n");
            InputUtil.pressEnterToContinue();
            ScenePrinter.line();
        }


        ScenePrinter.event("You wander through the town's crumbling streets.");
        ScenePrinter.effect("Townsfolk whisper rumors between coughs.");
        ScenePrinter.type(
                "You can trade, gather rumors, and help townsfolk—small acts of kindness that might matter later.\n" +
                        "They tell you of the *Necromancer*, a phantom who rules from the shadows.\n" +
                        "His grip spreads from the Black Castle, where the Corrupted King hoards the Second Stone.\n"
        );
        InputUtil.pressEnterToContinue();

        ScenePrinter.effect("The townsfolk warn of zealots who worship decay itself...");
        ScenePrinter.type("""
                In a ruined chapel, two Forsaken Cultists emerge,
                their eyes glowing with fanatic light as they chant forbidden rites.
                """);

        ScenePrinter.type("🎯 Objective: Defeat 2 Forsaken Cultists!\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        Enemy enemy2 = new World2Enemy2();
        Battle battle2 = new Battle(player, enemy2);

        for (int i = 1; i <= 2; i++) {
            ScenePrinter.hr();
            System.out.println("☠️ Cultist " + i + " raises a cursed dagger!");
            ScenePrinter.hr();

            battle2.startBattle();

            if (!enemy2.isAlive()) {
                System.out.println("✅ You have defeated Cultist " + i + "!");
                ScenePrinter.line();
                enemy2.dropLoot(player);

                if (i < 2) {
                    enemy2 = new World2Enemy2();
                    battle2 = new Battle(player, enemy2);
                }
            }
        }

        if (player.isAlive()) {
            ScenePrinter.line();
            ScenePrinter.type("""
                    🎉 Victory! The cultists’ ch ants fade into silence.
                    The air still hums with dark energy, but you stand victorious.
                    """);
            ScenePrinter.loot("You gain experience and loot from your grim battle.\n");
            InputUtil.pressEnterToContinue();
            ScenePrinter.line();
        }



        ScenePrinter.title("THE BLACK CASTLE");
        ScenePrinter.event("Thunder cracks as you push open the gates.");
        ScenePrinter.effect("Knights with cracked armor and bleeding eyes lurch from the darkness.");

        ScenePrinter.type("""
                Two Ghoul Footmen emerge, dragging rusted blades.
                Their movements are jerky, puppets of a cruel master.
                """);

        ScenePrinter.type("🎯 Objective: Defeat 2 Ghoul Footmen!\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        Enemy enemy3 = new World2Enemy3();
        Battle battle3 = new Battle(player, enemy3);

        for(int i = 1; i <= 2; i++){
            ScenePrinter.hr();
            System.out.println("🪓 Ghoul Footman " + i + " staggers toward you!");
            ScenePrinter.hr();

            battle3.startBattle();

            if (!enemy3.isAlive()) {
                System.out.println("✅ You have defeated Ghoul Footman " + i + "!");
                ScenePrinter.line();
                enemy3.dropLoot(player);

                if (i < 2) {
                    enemy3 = new World2Enemy3();
                    battle3 = new Battle(player, enemy3);
                }
            }
        }

        if (player.isAlive()) {
            ScenePrinter.line();
            ScenePrinter.type("""
                    🎉 Victory! The last ghoul crumbles into dust.
                    You tighten your grip on your weapon, ready for whatever lies ahead.
                    """);
            ScenePrinter.loot("You gain experience and loot from your hard-fought battle.\n");
            InputUtil.pressEnterToContinue();
            ScenePrinter.line();
        }

        InputUtil.pressEnterToContinue();
        ScenePrinter.effect("A low growl echoes from the halls ahead...");
        ScenePrinter.type("""
                From the black mist, two Blight Hounds leap forth,
                their fangs glinting and bodies wrapped in poisonous clouds.
                """);

        ScenePrinter.type("🎯 Objective: Defeat 3 Blight Hounds!\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        Enemy enemy4 = new World2Enemy3();
        Battle battle4 = new Battle(player, enemy4);
        for (int i = 1; i <= 3; i++) {
            ScenePrinter.hr();
            System.out.println("🐕 Blight Hound " + i + " snarls and lunges!");
            ScenePrinter.hr();

            battle4.startBattle();

            if (!enemy4.isAlive()) {
                System.out.println("✅ You have defeated Blight Hound " + i + "!");
                ScenePrinter.line();
                enemy4.dropLoot(player);

                if (i < 3) {
                    enemy4 = new World2Enemy4();
                    battle4 = new Battle(player, enemy4);
                }
            }
        }

        if (player.isAlive()) {
            ScenePrinter.line();
            ScenePrinter.type("""
                    🎉 Victory! The cultists’ chants fade into silence.
                    The air still hums with dark energy, but you stand victorious.
                    """);
            ScenePrinter.loot("You gain experience and loot from your grim battle.\n");
            InputUtil.pressEnterToContinue();
            ScenePrinter.line();
        }

        //TODO : MINIBOSS 1 : THE BLACK JAILER
        ScenePrinter.title("MINI-BOSS — The Black Jailer");
        ScenePrinter.type("""
                In the dungeons below, chains rattle.
                The Black Jailer steps from the shadows, dragging hooks and blades behind him.
                """);
        ScenePrinter.type("🎯 Objective: Defeat The Black Jailer!\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        Enemy miniBoss = new World2Miniboss1();
        Battle miniBattle = new Battle(player, miniBoss);
        miniBattle.startBattle();

        if (player.isAlive()) {
            ScenePrinter.line();
            ScenePrinter.type("""
                    🏆 Mini-Boss Defeated!
                    The Black Jailer drops to his knees, his chains falling silent.
                    You have triumphed over his tyranny.
                    """);
            ScenePrinter.loot("You gain rare loot and a surge of experience!\n");
            InputUtil.pressEnterToContinue();
            ScenePrinter.line();
        }



        ScenePrinter.title("BOSS — The Corrupted King");
        ScenePrinter.type(
                "In the throne room, the King sits slumped—his crown fused to his skull.\n" +
                        "You battle him; each blow shakes the hall until, finally, he falls.\n"
        );

        ScenePrinter.type("🎯 Objective: Defeat The Corrupted King!\n");
        InputUtil.pressEnterToContinue();
        ScenePrinter.line();

        Enemy boss = new World2Miniboss2();
        Battle bossBattle = new Battle(player, boss);
        bossBattle.startBattle();

        if (player.isAlive()) {
            ScenePrinter.line();
            ScenePrinter.type("""
                    👑 Final Victory!
                    The Corrupted King’s crown falls to the floor, echoing through the halls.
                    Darkness fades, and you stand as the savior of this cursed land.
                    """);
            ScenePrinter.loot("You gain immense experience and legendary loot!\n");
            InputUtil.pressEnterToContinue();
            ScenePrinter.line();
        }

        ScenePrinter.effect("The King's breath rattles. His eyes regain a hint of clarity.");
        ScenePrinter.say("Corrupted King", "\"The Necromancer… is not what he seems...\"");
        ScenePrinter.event("His body turns to dust.");
        InputUtil.pressEnterToContinue();


        ScenePrinter.event("You seize the Second Stone.");
        ScenePrinter.effect("A dark wind howls through the castle, extinguishing every torch.");
        InputUtil.pressEnterToContinue();
    }
}
