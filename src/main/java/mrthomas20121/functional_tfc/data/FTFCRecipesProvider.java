package mrthomas20121.functional_tfc.data;

import com.buuz135.functionalstorage.FunctionalStorage;
import com.buuz135.functionalstorage.util.DrawerWoodType;
import com.buuz135.functionalstorage.util.IWoodType;
import com.hrznstudio.titanium.block.BasicBlock;
import com.hrznstudio.titanium.recipe.generator.TitaniumRecipeProvider;
import mrthomas20121.functional_tfc.FunctionalTFC;
import mrthomas20121.functional_tfc.TFCWoodType;
import mrthomas20121.functional_tfc.api.ITFCWoodType;
import net.dries007.tfc.common.TFCTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.common.util.NonNullLazy;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.function.Consumer;

public class FTFCRecipesProvider<T extends ITFCWoodType> extends TitaniumRecipeProvider implements IConditionBuilder {

    private List<T> woodTypes;

    public FTFCRecipesProvider(DataGenerator generator, List<T> values) {
        super(generator);
        this.woodTypes = values;
    }

    @Override
    public void register(Consumer<FinishedRecipe> consumer) {
        // todo: use the wood type to change the recipe
        for(ITFCWoodType woodType: woodTypes) {
            for(FunctionalStorage.DrawerType type: FunctionalStorage.DrawerType.values()) {
                // block name
                String name = woodType.getName() + "_" + type.getSlots();
                ResourceLocation blockName = new ResourceLocation(FunctionalStorage.MOD_ID, name);
                Block drawer = ForgeRegistries.BLOCKS.getValue(blockName);

                switch (type) {
                    case X_1 -> ConditionalRecipe.builder()
                            .addCondition(new ModLoadedCondition(woodType.getModID()))
                            .addRecipe(c -> ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, drawer)
                                    .define('P', woodType.getLumber())
                                    .define('C', Tags.Items.CHESTS_WOODEN)
                                    .pattern("PPP")
                                    .pattern("PCP")
                                    .pattern("PPP")
                                    .unlockedBy(getHasName(woodType.getPlanks()), has(woodType.getPlanks()))
                                    .save(c)).build(consumer, new ResourceLocation(FunctionalTFC.mod_id, "crafting/"+name));
                    case X_2 -> ConditionalRecipe.builder()
                            .addCondition(new ModLoadedCondition(woodType.getModID()))
                            .addRecipe(c -> ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, drawer)
                                    .define('P', woodType.getLumber())
                                    .define('C', Tags.Items.CHESTS_WOODEN)
                                    .pattern("PCP")
                                    .pattern("PPP")
                                    .pattern("PCP")
                                    .unlockedBy(getHasName(woodType.getPlanks()), has(woodType.getPlanks()))
                                    .save(c)).build(consumer, new ResourceLocation(FunctionalTFC.mod_id, "crafting/"+name));
                    case X_4 -> ConditionalRecipe.builder()
                            .addCondition(new ModLoadedCondition(woodType.getModID()))
                            .addRecipe(c -> ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, drawer)
                                    .define('P', woodType.getLumber())
                                    .define('C', Tags.Items.CHESTS_WOODEN)
                                    .pattern("CPC")
                                    .pattern("PPP")
                                    .pattern("CPC")
                                    .unlockedBy(getHasName(woodType.getPlanks()), has(woodType.getPlanks()))
                                    .save(c)).build(consumer, new ResourceLocation(FunctionalTFC.mod_id, "crafting/"+name));
                }

            }
        }
    }
}
