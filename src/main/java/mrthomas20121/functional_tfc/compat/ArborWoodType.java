package mrthomas20121.functional_tfc.compat;

import com.buuz135.functionalstorage.util.IWoodType;
import com.therighthon.afc.common.blocks.AFCBlocks;
import com.therighthon.afc.common.blocks.AFCWood;
import com.therighthon.afc.common.items.AFCItems;
import mrthomas20121.functional_tfc.api.ITFCWoodType;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.wood.Wood;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ArborWoodType implements ITFCWoodType {

    private final AFCWood wood;

    public ArborWoodType(AFCWood wood) {
        this.wood = wood;
    }

    @Override
    public Block getWood() {
        return AFCBlocks.WOODS.get(this.wood).get(Wood.BlockType.LOG).get();
    }

    @Override
    public Block getPlanks() {
        return AFCBlocks.WOODS.get(this.wood).get(Wood.BlockType.PLANKS).get();
    }

    @Override
    public String getName() {
        return "afc_"+wood.getSerializedName();
    }

    @Override
    public Item getLumber() {
        return AFCItems.LUMBER.get(this.wood).get();
    }

    @Override
    public String getModID() {
        return "afc";
    }
}
