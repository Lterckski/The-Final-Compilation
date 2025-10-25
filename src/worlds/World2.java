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

        //TODO : ENEMY 1 : 2 PLAGUE VERMINS ENCOUNTERED
        ScenePrinter.event("You wander through the town's crumbling streets.");
        ScenePrinter.effect("Townsfolk whisper rumors between coughs.");
        ScenePrinter.type(
                "You can trade, gather rumors, and help townsfolk—small acts of kindness that might matter later.\n" +
                        "They tell you of the *Necromancer*, a phantom who rules from the shadows.\n" +
                        "His grip spreads from the Black Castle, where the Corrupted King hoards the Second Stone.\n"
        );
        InputUtil.pressEnterToContinue();
        //TODO : ENEMY 2 : 2 FORSAKEN CULTISTS ENCOUNTERED

        ScenePrinter.title("THE BLACK CASTLE");
        ScenePrinter.event("Thunder cracks as you push open the gates.");
        ScenePrinter.effect("Knights with cracked armor and bleeding eyes lurch from the darkness.");
        //TODO : ENEMY 3 : 2 GHOUL FOOTMEN ENCOUNTERED
        //TODO : ENEMY 4 : 2 BLIGHT HOUNDS ENCOUNTERED
        InputUtil.pressEnterToContinue();

        //TODO : MINIBOSS 1 : THE BLACK JAILER

        ScenePrinter.title("BOSS — The Corrupted King");
        ScenePrinter.type(
                "In the throne room, the King sits slumped—his crown fused to his skull.\n" +
                        "You battle him; each blow shakes the hall until, finally, he falls.\n"
        );
        //TODO : MINI BOSS 2 : LUTHER VON


        ScenePrinter.effect("The King's breath rattles. His eyes regain a hint of clarity.");
        ScenePrinter.say("Corrupted King", "\"The Necromancer… is not what he seems...\"");
        ScenePrinter.event("His body turns to dust.");
        InputUtil.pressEnterToContinue();


        ScenePrinter.event("You seize the Second Stone.");
        ScenePrinter.effect("A dark wind howls through the castle, extinguishing every torch.");
        InputUtil.pressEnterToContinue();
    }



}
