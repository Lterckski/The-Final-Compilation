package enemies;

import characters.Character;
import utils.ColorUtil;

public abstract class Enemy extends Character{
    // Constructor
    public Enemy(String name, int hp, int defense, int attack) {
        super(name, hp, defense,attack);
    }

    // Show stats
    @Override
    public void displayStats() {
        System.out.println();
        System.out.println(ColorUtil.boldBrightRed("┌───────────── 👹 ENEMY STATS 👹 ─────────────┐"));

// Name
        System.out.println(ColorUtil.boldBrightRed(" 🧟 Name    : ") + ColorUtil.boldBrightYellow(name));

// HP
        System.out.println(ColorUtil.boldBrightRed(" ❤️ HP      : ") + ColorUtil.boldBrightYellow(hp + " / " + maxHP));

// Attack difference
        int atkDiff = attack - baseAttack;
        String atkLabel = (atkDiff >= 0) ? "Buff" : "Debuff";
        System.out.println(ColorUtil.boldBrightRed(" ⚔️ Attack  : ") + ColorUtil.boldBrightYellow(
                attack + " (Base " + baseAttack + " | " + atkLabel + " " + String.format("%+d", atkDiff) + ")"));

// Defense difference
        int defDiff = defense - baseDefense;
        String defLabel = (defDiff >= 0) ? "Buff" : "Debuff";
        System.out.println(ColorUtil.boldBrightRed(" 🛡️ Defense : ") + ColorUtil.boldBrightYellow(
                defense + " (Base " + baseDefense + " | " + defLabel + " " + String.format("%+d", defDiff) + ")"));

// Outer bottom bar
        System.out.println(ColorUtil.boldBrightRed("└──────────────────────────────────────────────┘"));
        System.out.println();


    }



    public abstract void dropLoot(Character player);
    public abstract int rewardExp();

}
