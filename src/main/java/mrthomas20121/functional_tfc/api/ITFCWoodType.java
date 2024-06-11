package mrthomas20121.functional_tfc.api;

import com.buuz135.functionalstorage.util.IWoodType;
import net.minecraft.world.item.Item;

public interface ITFCWoodType extends IWoodType {

    Item getLumber();

    String getModID();
}
