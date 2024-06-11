package mrthomas20121.functional_tfc.data;

import com.buuz135.functionalstorage.FunctionalStorage;
import com.buuz135.functionalstorage.util.StorageTags;
import mrthomas20121.functional_tfc.FunctionalTFC;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class FTFCItemTagsProvider extends ItemTagsProvider {


    public FTFCItemTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagLookup<Block>> lookupCompletableFuture, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256380_) {
        IntrinsicTagAppender<Item> drawerTag = this.tag(StorageTags.DRAWER);
        for (FunctionalStorage.DrawerType drawerType : FunctionalStorage.DRAWER_TYPES.keySet()) {
            for (RegistryObject<Block> blockRegistryObject : FunctionalStorage.DRAWER_TYPES.get(drawerType).stream().map(Pair::getLeft).toList()) {
                String blockName = FunctionalTFC.getBlockName(blockRegistryObject.get());
                if(blockName.contains("tfc") || blockName.contains("afc")) {
                    drawerTag.addOptional(FunctionalTFC.getRegistryName(blockRegistryObject.get()));
                }
            }
        }
    }

    @Override
    public String getName()
    {
        return "Functional Storage Item Tags";
    }

}