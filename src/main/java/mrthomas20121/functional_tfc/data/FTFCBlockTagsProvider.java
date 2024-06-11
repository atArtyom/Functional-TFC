package mrthomas20121.functional_tfc.data;

import com.buuz135.functionalstorage.FunctionalStorage;
import mrthomas20121.functional_tfc.FunctionalTFC;
import net.dries007.tfc.common.TFCTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class FTFCBlockTagsProvider extends BlockTagsProvider {

    public FTFCBlockTagsProvider(DataGenerator dataGenerator, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator.getPackOutput(), lookupProvider, FunctionalTFC.mod_id, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256380_) {
        IntrinsicTagAppender<Block> axeMineable = this.tag(BlockTags.MINEABLE_WITH_AXE);
        IntrinsicTagAppender<Block> needCopperTools = this.tag(TFCTags.Blocks.NEEDS_COPPER_TOOL);
        IntrinsicTagAppender<Block> toughness1 = this.tag(TFCTags.Blocks.TOUGHNESS_1);
        for (FunctionalStorage.DrawerType drawerType : FunctionalStorage.DRAWER_TYPES.keySet()) {
            for (RegistryObject<Block> blockRegistryObject : FunctionalStorage.DRAWER_TYPES.get(drawerType).stream().map(Pair::getLeft).toList()) {
                if(FunctionalTFC.getBlockName(blockRegistryObject.get()).contains("tfc")) {
                    axeMineable.addOptional(FunctionalTFC.getRegistryName(blockRegistryObject.get()));
                    needCopperTools.addOptional(FunctionalTFC.getRegistryName(blockRegistryObject.get()));
                    toughness1.addOptional(FunctionalTFC.getRegistryName(blockRegistryObject.get()));
                }
            }
        }
    }

}