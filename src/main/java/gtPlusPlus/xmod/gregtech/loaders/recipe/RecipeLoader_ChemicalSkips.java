package gtPlusPlus.xmod.gregtech.loaders.recipe;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import gtPlusPlus.core.item.ModItems;
import gtPlusPlus.core.item.chemistry.AgriculturalChem;
import gtPlusPlus.core.item.chemistry.GenericChem;
import gtPlusPlus.core.lib.CORE;
import gtPlusPlus.core.lib.LoadedMods;
import gtPlusPlus.core.material.MISC_MATERIALS;
import gtPlusPlus.core.recipe.common.CI;
import gtPlusPlus.core.util.minecraft.FluidUtils;
import gtPlusPlus.core.util.minecraft.ItemUtils;
import gtPlusPlus.core.util.minecraft.MaterialUtils;
import gtPlusPlus.plugin.agrichem.BioRecipes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class RecipeLoader_ChemicalSkips {

    public static void generate() {
        createRecipes();
    }

    private static void createRecipes() {
        quantumTransformerRecipes();
    }

    private static void quantumTransformerRecipes() {
        CORE.RA.addQuantumTransformerRecipe(
                new ItemStack[]{
                        MISC_MATERIALS.CYANOACETIC_ACID.getDust(1),
                        ItemUtils.getSimpleStack(GenericChem.mSolidAcidCatalyst, 0)
                },
                new FluidStack[]{
                        MISC_MATERIALS.ETHYL_CYANOACETATE.getFluidStack(1000)
                },
                new FluidStack[]{

                },
                new ItemStack[]{
                        Materials.Platinum.getDust(1),
                        Materials.Palladium.getDust(1),
                        Materials.Iridium.getDust(1),
                        Materials.Osmium.getDust(1)
                },
                new int[]{
                        100,100,100,100
                },
                50 * 20,
                8000,
                1
        );
        CORE.RA.addQuantumTransformerRecipe(
                new ItemStack[]{
                        MISC_MATERIALS.SODIUM_CYANIDE.getDust(1)
                },
                new FluidStack[]{
                        MISC_MATERIALS.ETHYL_CYANOACETATE.getFluidStack(1000)
                },
                new FluidStack[]{

                },
                new ItemStack[]{
                        Materials.Platinum.getDust(1),
                        Materials.Palladium.getDust(1),
                        Materials.Iridium.getDust(1),
                        Materials.Osmium.getDust(1)
                },
                new int[]{
                        100,100,100,100
                },
                50 * 20,
                8000,
                0
        );
        CORE.RA.addQuantumTransformerRecipe(
                new ItemStack[]{
                        MISC_MATERIALS.SODIUM_HYDROXIDE.getDust(1),
                        ItemUtils.getSimpleStack(GenericChem.mSolidAcidCatalyst, 0)
                },
                new FluidStack[]{
                },
                new FluidStack[]{

                },
                new ItemStack[]{
                        Materials.Platinum.getDust(1),
                        Materials.Palladium.getDust(1),
                        Materials.Iridium.getDust(1),
                        Materials.Osmium.getDust(1)
                },
                new int[]{
                        10000,10000,10000,10000
                },
                50 * 20,
                8000,
                0
        );
    }
}
