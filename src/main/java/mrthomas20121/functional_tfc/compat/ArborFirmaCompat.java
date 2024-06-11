package mrthomas20121.functional_tfc.compat;

import com.buuz135.functionalstorage.FunctionalStorage;
import com.therighthon.afc.common.blocks.AFCWood;

import java.util.Arrays;
import java.util.List;

public class ArborFirmaCompat {

    public static void init() {
        FunctionalStorage.WOOD_TYPES.addAll(getWoodTypes());
    }

    public static List<ArborWoodType> getWoodTypes() {
        return Arrays.stream(AFCWood.VALUES).map(ArborWoodType::new).toList();
    }
}
