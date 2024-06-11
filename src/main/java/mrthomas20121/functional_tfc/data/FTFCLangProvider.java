package mrthomas20121.functional_tfc.data;

import com.buuz135.functionalstorage.FunctionalStorage;
import com.buuz135.functionalstorage.block.DrawerBlock;
import mrthomas20121.functional_tfc.FunctionalTFC;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.stream.Collectors;

public class FTFCLangProvider extends LanguageProvider {


    public FTFCLangProvider(PackOutput output) {
        super(output, FunctionalTFC.mod_id, "en_us");
    }

    @Override
    protected void addTranslations() {
        for (FunctionalStorage.DrawerType drawerType : FunctionalStorage.DRAWER_TYPES.keySet()) {
            for (RegistryObject<Block> blockRegistryObject : FunctionalStorage.DRAWER_TYPES.get(drawerType).stream().map(Pair::getLeft).toList()) {
                DrawerBlock drawerBlock = (DrawerBlock) blockRegistryObject.get();
                if(FunctionalTFC.getBlockName(drawerBlock).contains("tfc") || FunctionalTFC.getBlockName(drawerBlock).contains("afc")) {
                    this.add(drawerBlock, WordUtils.capitalize(drawerBlock.getWoodType().getName().replace('_', ' ').toLowerCase()) + " Drawer (" + drawerBlock.getType().getDisplayName() + ")");
                }
            }
        }
    }
}
