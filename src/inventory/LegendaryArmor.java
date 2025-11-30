package inventory;

public class LegendaryArmor extends Armor {

    public LegendaryArmor() {
        super(
                "Eternal Shell",
                "🟣",
                150,    // def buff
                true,   // immuneDebuff
                true,   // immuneEffects
                20,     // reflect chance
                50      // reflect percent
        );
    }
}
