package dev.backupcup.plushified.datagen;

import dev.backupcup.plushified.register.RegisterBlocks;
import dev.backupcup.plushified.register.RegisterItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class PlushRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public PlushRecipeProvider(PackOutput output) {
        super(output);
    }

    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RegisterItems.PALETTE.get())
                .requires(Items.YELLOW_DYE).requires(Items.CYAN_DYE).requires(Items.MAGENTA_DYE)

                .unlockedBy(getHasName(Items.YELLOW_DYE), has(Items.YELLOW_DYE))
                .unlockedBy(getHasName(Items.CYAN_DYE), has(Items.CYAN_DYE))
                .unlockedBy(getHasName(Items.MAGENTA_DYE), has(Items.MAGENTA_DYE))
                .save(consumer);

        RegisterBlocks.PLUSHIES.forEach(plushie -> {
            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, plushie.getItem().get())
                    .pattern("ROY")
                    .pattern("P#G")
                    .pattern("BLC")

                    .define('R', Blocks.RED_WOOL)   .define('O', Blocks.ORANGE_WOOL)            .define('Y', Blocks.YELLOW_WOOL)
                    .define('P', Blocks.PURPLE_WOOL).define('#', RegisterItems.PALETTE.get())   .define('G', Blocks.GREEN_WOOL)
                    .define('B', Blocks.BLUE_WOOL)  .define('L', Blocks.LIGHT_BLUE_WOOL)        .define('C', Blocks.CYAN_WOOL)

                    .unlockedBy(getHasName(RegisterItems.PALETTE.get()), has(RegisterItems.PALETTE.get()))
                    .save(consumer);
        });
    }
}
