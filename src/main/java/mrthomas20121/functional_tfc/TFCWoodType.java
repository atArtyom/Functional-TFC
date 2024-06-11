package mrthomas20121.functional_tfc;

import com.buuz135.functionalstorage.util.IWoodType;
import mrthomas20121.functional_tfc.api.ITFCWoodType;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.wood.Wood;
import net.dries007.tfc.common.items.TFCItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TFCWoodType implements ITFCWoodType {

    private final Wood wood;

    public TFCWoodType(Wood wood) {
        this.wood = wood;
    }

    @Override
    public Block getWood() {
        return TFCBlocks.WOODS.get(this.wood).get(Wood.BlockType.LOG).get();
    }

    @Override
    public Block getPlanks() {
        return TFCBlocks.WOODS.get(this.wood).get(Wood.BlockType.PLANKS).get();
    }

    @Override
    public String getName() {
        return "tfc_"+wood.getSerializedName();
    }

    @Override
    public Item getLumber() {
        return TFCItems.LUMBER.get(wood).get();
    }

    @Override
    public String getModID() {
        return "tfc";
    }
}
