package gtPlusPlus.xmod.gregtech.loaders.recipe;

import com.dreammaster.gthandler.GT_CoreModSupport;
import com.github.bartimaeusnek.bartworks.system.material.WerkstoffLoader;
import com.github.technus.tectech.recipe.TT_recipeAdder;
import com.github.technus.tectech.thing.block.QuantumGlassBlock;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gtPlusPlus.core.item.chemistry.GenericChem;
import gtPlusPlus.core.lib.CORE;
import gtPlusPlus.core.material.ALLOY;
import gtPlusPlus.core.material.ELEMENT;
import gtPlusPlus.core.material.MISC_MATERIALS;
import gtPlusPlus.core.recipe.common.CI;
import gtPlusPlus.core.util.minecraft.ItemUtils;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class RecipeLoader_ChemicalSkips {

    public static void generate() {
        createRecipes();
    }

    private static void createRecipes() {
        quantumTransformerRecipes();
        fusionReactorRecipes();
        catalystRecipes();
        tieredCasingRecipes();
    }

    // All the recipes that the QFT can do. Each recipe has a machine tier.
    // -> Tier 1 is UEV (UEV circuits and 1 Eternal Singularity);
    // -> Tier 2 needs new item from QFT, plus stacks of Infinity;
    // -> Tier 3 needs new item from QFT, plus stacks of Transcendent Metal;
    // -> Tier 4 needs new item from QFT, plus stacks of Spacetime;
    // (Until they are created, the new items are represented by
    // HSS-G for Tier 2, HSS-S for Tier 3 and HSS-E for Tier 4)

    private static void quantumTransformerRecipes() {
        // Platline
        CORE.RA.addQuantumTransformerRecipe(
                new ItemStack[] {
                    WerkstoffLoader.PTMetallicPowder.get(OrePrefixes.dust, 32),
                    ItemUtils.getSimpleStack(GenericChem.mPlatinumGroupCatalyst, 0)
                },
                new FluidStack[] {},
                new FluidStack[] {},
                new ItemStack[] {
                    Materials.Platinum.getDust(64),
                    Materials.Palladium.getDust(64),
                    Materials.Iridium.getDust(64),
                    Materials.Osmium.getDust(64),
                    WerkstoffLoader.Rhodium.get(OrePrefixes.dust, 64),
                    WerkstoffLoader.Ruthenium.get(OrePrefixes.dust, 64)
                },
                new int[] {1667, 1667, 1667, 1667, 1667, 1667},
                20 * 20,
                (int) GT_Values.VP[8],
                1);

        // Early Plastics
        CORE.RA.addQuantumTransformerRecipe(
                new ItemStack[] {
                    Materials.Carbon.getDust(64), ItemUtils.getSimpleStack(GenericChem.mPlasticPolymerCatalyst, 0)
                },
                new FluidStack[] {
                    Materials.Oxygen.getGas(1000 * 16),
                    Materials.Hydrogen.getGas(1000 * 16),
                    Materials.Chlorine.getGas(1000 * 16),
                    Materials.Fluorine.getGas(1000 * 16)
                },
                new FluidStack[] {
                    Materials.Plastic.getMolten(144 * 256),
                    Materials.PolyvinylChloride.getMolten(144 * 128),
                    Materials.Polystyrene.getMolten(144 * 64),
                    Materials.Polytetrafluoroethylene.getMolten(144 * 128),
                    Materials.Epoxid.getMolten(144 * 64),
                    Materials.Polybenzimidazole.getMolten(144 * 64)
                },
                null,
                new int[] {2000, 2000, 2000, 2000, 2000, 2000},
                20 * 20,
                (int) GT_Values.VP[7],
                1);

        // Early Rubbers/Cable Materials
        CORE.RA.addQuantumTransformerRecipe(
                new ItemStack[] {
                    Materials.Carbon.getDust(64), ItemUtils.getSimpleStack(GenericChem.mRubberPolymerCatalyst, 0)
                },
                new FluidStack[] {
                    Materials.Oxygen.getGas(1000 * 16),
                    Materials.Hydrogen.getGas(1000 * 16),
                    Materials.Chlorine.getGas(1000 * 16)
                },
                new FluidStack[] {
                    Materials.Silicone.getMolten(144 * 64),
                    Materials.StyreneButadieneRubber.getMolten(144 * 64),
                    Materials.PolyphenyleneSulfide.getMolten(144 * 128),
                    Materials.Rubber.getMolten(144 * 256)
                },
                null,
                new int[] {2500, 2500, 2500, 2500},
                20 * 20,
                (int) GT_Values.VP[7],
                1);

        // Glues and Solders
        CORE.RA.addQuantumTransformerRecipe(
                new ItemStack[] {
                    Materials.Carbon.getDust(32),
                    Materials.Bismuth.getDust(32),
                    ItemUtils.getSimpleStack(GenericChem.mAdhesionPromoterCatalyst, 0)
                },
                new FluidStack[] {Materials.Oxygen.getFluid(10000), Materials.Hydrogen.getFluid(10000)},
                new FluidStack[] {
                    MISC_MATERIALS.ETHYL_CYANOACRYLATE.getFluidStack(1000 * 32),
                    Materials.AdvancedGlue.getFluid(1000 * 16),
                    ALLOY.INDALLOY_140.getFluidStack(144 * 64),
                    Materials.SolderingAlloy.getMolten(144 * 128)
                },
                new ItemStack[] {ItemList.StableAdhesive.get(1)},
                new int[] {2000, 2000, 2000, 2000, 2000},
                20 * 20,
                (int) GT_Values.VP[8],
                1);

        // Titanium, Tungsten, Indium
        CORE.RA.addQuantumTransformerRecipe(
                new ItemStack[] {
                    Materials.Lead.getDust(16),
                    Materials.Bauxite.getDust(32),
                    Materials.Tungstate.getDust(16),
                    ItemUtils.getSimpleStack(GenericChem.mTitaTungstenIndiumCatalyst, 0)
                },
                new FluidStack[] {},
                new FluidStack[] {},
                new ItemStack[] {
                    Materials.Titanium.getDust(64),
                    Materials.TungstenSteel.getDust(64),
                    Materials.TungstenCarbide.getDust(64),
                    Materials.Indium.getDust(64)
                },
                new int[] {2500, 2500, 2500, 2500},
                20 * 20,
                (int) GT_Values.VP[8],
                1);

        // Thorium, Uranium, Plutonium
        CORE.RA.addQuantumTransformerRecipe(
                new ItemStack[] {
                    Materials.Thorium.getDust(32),
                    Materials.Uranium.getDust(32),
                    ItemUtils.getSimpleStack(GenericChem.mRadioactivityCatalyst, 0)
                },
                new FluidStack[] {},
                new FluidStack[] {},
                new ItemStack[] {
                    ELEMENT.getInstance().THORIUM232.getDust(64),
                    ELEMENT.getInstance().URANIUM233.getDust(64),
                    Materials.Uranium235.getDust(64),
                    ELEMENT.getInstance().PLUTONIUM238.getDust(64),
                    Materials.Plutonium.getDust(64),
                    Materials.Plutonium241.getDust(64)
                },
                new int[] {1667, 1667, 1667, 1667, 1667, 1667},
                20 * 20,
                (int) GT_Values.VP[8],
                1);

        // Monaline
        CORE.RA.addQuantumTransformerRecipe(
                new ItemStack[] {
                    Materials.Monazite.getDust(32), ItemUtils.getSimpleStack(GenericChem.mRareEarthGroupCatalyst, 0)
                },
                new FluidStack[] {},
                new FluidStack[] {},
                new ItemStack[] {
                    Materials.Cerium.getDust(64),
                    Materials.Gadolinium.getDust(64),
                    Materials.Samarium.getDust(64),
                    GT_ModHandler.getModItem("bartworks", "gt.bwMetaGenerateddust", 64L, 11000), // Hafnium
                    GT_ModHandler.getModItem("bartworks", "gt.bwMetaGenerateddust", 64L, 11007), // Zirconium
                    ItemList.SuperconductorComposite.get(1)
                },
                new int[] {1667, 1667, 1667, 1667, 1667, 1667},
                20 * 20,
                (int) GT_Values.VP[9],
                2);

        // Early Naqline (Naquadah should be Naquadahine)
        CORE.RA.addQuantumTransformerRecipe(
                new ItemStack[] {
                    GT_ModHandler.getModItem("bartworks", "gt.bwMetaGenerateddust", 32L, 10054), // Naq Oxide
                    ItemUtils.getSimpleStack(GenericChem.mSimpleNaquadahCatalyst, 0)
                },
                new FluidStack[] {},
                new FluidStack[] {},
                new ItemStack[] {
                    Materials.Naquadah.getDust(64),
                    Materials.Adamantium.getDust(64),
                    Materials.Gallium.getDust(64),
                    Materials.Titanium.getDust(64)
                },
                new int[] {2500, 2500, 2500, 2500},
                20 * 20,
                (int) GT_Values.VP[9],
                2);

        // Advanced Naqline
        CORE.RA.addQuantumTransformerRecipe(
                new ItemStack[] {
                    GT_ModHandler.getModItem("bartworks", "gt.bwMetaGenerateddust", 32L, 10067), // Enriched Naq Oxide
                    GT_ModHandler.getModItem("bartworks", "gt.bwMetaGenerateddust", 32L, 10072), // Naquadria Oxide
                    ItemUtils.getSimpleStack(GenericChem.mAdvancedNaquadahCatalyst, 0)
                },
                new FluidStack[] {},
                new FluidStack[] {},
                new ItemStack[] {
                    Materials.Naquadria.getDust(64),
                    Materials.NaquadahEnriched.getDust(64),
                    Materials.Trinium.getDust(64),
                    Materials.Barium.getDust(64),
                    ItemList.NaquadriaSupersolid.get(1)
                },
                new int[] {2000, 2000, 2000, 2000, 2000},
                20 * 20,
                (int) GT_Values.VP[11],
                3);

        // Stem Cells
        CORE.RA.addQuantumTransformerRecipe(
                new ItemStack[] {
                    Materials.Calcium.getDust(32),
                    Materials.MeatRaw.getDust(32),
                    GT_ModHandler.getModItem("dreamcraft", "GTNHBioItems", 32, 2),
                    ItemUtils.getSimpleStack(GenericChem.mRawIntelligenceCatalyst, 0)
                },
                new FluidStack[] {},
                new FluidStack[] {
                    Materials.GrowthMediumRaw.getFluid(1000 * 1024),
                    Materials.GrowthMediumSterilized.getFluid(1000 * 512)
                },
                new ItemStack[] {ItemList.Circuit_Chip_Stemcell.get(64)},
                new int[] {3333, 3333, 3333},
                20 * 20,
                (int) GT_Values.VP[11],
                3);

        // Lategame Plastics (Missing Radox Polymer and Heavy Radox)
        CORE.RA.addQuantumTransformerRecipe(
                new ItemStack[] {
                    Materials.Carbon.getDust(64),
                    Materials.Osmium.getDust(24),
                    ItemUtils.getSimpleStack(GenericChem.mUltimatePlasticCatalyst, 0)
                },
                new FluidStack[] {
                    Materials.Hydrogen.getFluid(10000), Materials.Nitrogen.getFluid(10000),
                },
                new FluidStack[] {
                    GT_CoreModSupport.Xenoxene.getFluid(1000 * 16),
                    GT_CoreModSupport.RadoxPolymer.getMolten(144 * 64),
                    GT_CoreModSupport.RadoxHeavy.getFluid(1000 * 16),
                    MaterialsKevlar.Kevlar.getMolten(144 * 64)
                },
                new ItemStack[] {},
                new int[] {2500, 2500, 2500, 2500},
                20 * 20,
                (int) GT_Values.VP[11],
                4);

        // Bio Cells and Mutated Solder
        CORE.RA.addQuantumTransformerRecipe(
                new ItemStack[] {
                    ItemList.Circuit_Chip_Stemcell.get(16),
                    Materials.InfinityCatalyst.getDust(4),
                    ItemUtils.getSimpleStack(GenericChem.mBiologicalIntelligenceCatalyst, 0)
                },
                new FluidStack[] {},
                new FluidStack[] {
                    MISC_MATERIALS.MUTATED_LIVING_SOLDER.getFluidStack(144 * 128),
                    Materials.BioMediumSterilized.getFluid(1000 * 256),
                    Materials.BioMediumRaw.getFluid(1000 * 512)
                },
                new ItemStack[] {ItemList.Circuit_Chip_Biocell.get(64)},
                new int[] {2500, 2500, 2500, 2500},
                20 * 20,
                (int) GT_Values.VP[10],
                4);
    }

    private static void fusionReactorRecipes() {
        GT_Values.RA.addFusionReactorRecipe(
                new FluidStack[] {Materials.Radon.getPlasma(100), Materials.Nitrogen.getPlasma(100)},
                new FluidStack[] {new FluidStack(ELEMENT.getInstance().NEPTUNIUM.getPlasma(), 100)},
                30 * 20,
                (int) GT_Values.VP[8],
                1000000000);

        GT_Values.RA.addFusionReactorRecipe(
                new FluidStack[] {Materials.Americium.getPlasma(100), Materials.Boron.getPlasma(100)},
                new FluidStack[] {new FluidStack(ELEMENT.getInstance().FERMIUM.getPlasma(), 100)},
                30 * 20,
                (int) GT_Values.VP[8],
                1000000000);
    }

    private static void catalystRecipes() {
        CORE.RA.addSixSlotAssemblingRecipe(
                new ItemStack[] {
                    CI.getNumberedCircuit(10),
                    CI.getEmptyCatalyst(1),
                    Materials.Infinity.getDust(1),
                    GT_ModHandler.getModItem("bartworks", "gt.bwMetaGenerateddust", 64L, 88),
                    Materials.Osmiridium.getDust(64)
                },
                GT_Values.NF,
                ItemUtils.getSimpleStack(GenericChem.mPlatinumGroupCatalyst, 1),
                60 * 20,
                (int) GT_Values.VP[9]);

        CORE.RA.addSixSlotAssemblingRecipe(
                new ItemStack[] {
                    CI.getNumberedCircuit(10),
                    CI.getEmptyCatalyst(1),
                    Materials.Infinity.getDust(1),
                    Materials.Polybenzimidazole.getDust(64),
                    Materials.Tetrafluoroethylene.getDust(64)
                },
                GT_Values.NF,
                ItemUtils.getSimpleStack(GenericChem.mPlasticPolymerCatalyst, 1),
                60 * 20,
                (int) GT_Values.VP[9]);

        CORE.RA.addSixSlotAssemblingRecipe(
                new ItemStack[] {
                    CI.getNumberedCircuit(10),
                    CI.getEmptyCatalyst(1),
                    Materials.Infinity.getDust(1),
                    Materials.Silicone.getDust(64),
                    Materials.StyreneButadieneRubber.getDust(64)
                },
                GT_Values.NF,
                ItemUtils.getSimpleStack(GenericChem.mRubberPolymerCatalyst, 1),
                60 * 20,
                (int) GT_Values.VP[9]);

        CORE.RA.addSixSlotAssemblingRecipe(
                new ItemStack[] {
                    CI.getNumberedCircuit(10), CI.getEmptyCatalyst(1), Materials.Infinity.getDust(1),
                    // ALLOY.INDALLOY_140.getDust(64)
                },
                new FluidStack(MISC_MATERIALS.ETHYL_CYANOACRYLATE.getFluid(), 10000),
                ItemUtils.getSimpleStack(GenericChem.mAdhesionPromoterCatalyst, 1),
                60 * 20,
                (int) GT_Values.VP[9]);

        CORE.RA.addSixSlotAssemblingRecipe(
                new ItemStack[] {
                    CI.getNumberedCircuit(10),
                    CI.getEmptyCatalyst(1),
                    Materials.TungstenSteel.getDust(64),
                    Materials.Indium.getDust(64)
                    // ALLOY.INDALLOY_140.getDust(64)
                },
                GT_Values.NF,
                ItemUtils.getSimpleStack(GenericChem.mTitaTungstenIndiumCatalyst, 1),
                60 * 20,
                (int) GT_Values.VP[9]);

        CORE.RA.addSixSlotAssemblingRecipe(
                new ItemStack[] {
                    CI.getNumberedCircuit(10),
                    CI.getEmptyCatalyst(1),
                    ELEMENT.getInstance().URANIUM235.getDust(64),
                    ELEMENT.getInstance().PLUTONIUM241.getDust(64)
                    // ALLOY.INDALLOY_140.getDust(64)
                },
                GT_Values.NF,
                ItemUtils.getSimpleStack(GenericChem.mRadioactivityCatalyst, 1),
                60 * 20,
                (int) GT_Values.VP[9]);

        CORE.RA.addSixSlotAssemblingRecipe(
                new ItemStack[] {
                    CI.getNumberedCircuit(10),
                    CI.getEmptyCatalyst(1),
                    Materials.Infinity.getDust(1),
                    Materials.Samarium.getDust(64),
                    Materials.Gadolinium.getDust(64),
                },
                GT_Values.NF,
                ItemUtils.getSimpleStack(GenericChem.mRareEarthGroupCatalyst, 1),
                60 * 20,
                (int) GT_Values.VP[9]);

        CORE.RA.addSixSlotAssemblingRecipe(
                new ItemStack[] {
                    CI.getNumberedCircuit(10),
                    CI.getEmptyCatalyst(1),
                    Materials.Infinity.getDust(1),
                    Materials.Naquadah.getDust(64),
                    Materials.Adamantium.getDust(64)
                },
                GT_Values.NF,
                ItemUtils.getSimpleStack(GenericChem.mSimpleNaquadahCatalyst, 1),
                60 * 20,
                (int) GT_Values.VP[9]);

        CORE.RA.addSixSlotAssemblingRecipe(
                new ItemStack[] {
                    CI.getNumberedCircuit(10),
                    CI.getEmptyCatalyst(1),
                    Materials.Infinity.getDust(1),
                    Materials.Naquadria.getDust(64),
                    Materials.Trinium.getDust(64)
                },
                GT_Values.NF,
                ItemUtils.getSimpleStack(GenericChem.mAdvancedNaquadahCatalyst, 1),
                60 * 20,
                (int) GT_Values.VP[9]);

        CORE.RA.addSixSlotAssemblingRecipe(
                new ItemStack[] {
                    CI.getNumberedCircuit(10),
                    CI.getEmptyCatalyst(1),
                    Materials.Infinity.getDust(1),
                    ItemList.Circuit_Chip_Stemcell.get(64)
                },
                GT_Values.NF,
                ItemUtils.getSimpleStack(GenericChem.mRawIntelligenceCatalyst, 1),
                60 * 20,
                (int) GT_Values.VP[9]);

        CORE.RA.addSixSlotAssemblingRecipe(
                new ItemStack[] {
                    CI.getNumberedCircuit(10),
                    CI.getEmptyCatalyst(1),
                    Materials.Infinity.getDust(1),
                    MaterialsKevlar.Kevlar.getDust(64)
                },
                GT_Values.NF,
                ItemUtils.getSimpleStack(GenericChem.mUltimatePlasticCatalyst, 1),
                60 * 20,
                (int) GT_Values.VP[9]);

        CORE.RA.addSixSlotAssemblingRecipe(
                new ItemStack[] {
                    CI.getNumberedCircuit(10),
                    CI.getEmptyCatalyst(1),
                    Materials.Infinity.getDust(1),
                    ItemList.Circuit_Chip_Biocell.get(64)
                },
                GT_Values.NF,
                ItemUtils.getSimpleStack(GenericChem.mBiologicalIntelligenceCatalyst, 1),
                60 * 20,
                (int) GT_Values.VP[9]);
    }

    private static void tieredCasingRecipes() {
        TT_recipeAdder.addResearchableAssemblylineRecipe(
                GregtechItemList.ForceFieldGlass.get(1),
                1024 * 30 * 20,
                1024,
                (int) GT_Values.VP[7],
                32,
                new ItemStack[] {
                    GregtechItemList.ForceFieldGlass.get(1),
                    Materials.Carbon.getNanite(4),
                    ItemList.Emitter_UHV.get(4),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUHV, 8),
                    GregtechItemList.Laser_Lens_Special.get(1),
                    GT_ModHandler.getModItem("GoodGenerator", "advancedRadiationProtectionPlate", 2)
                },
                new FluidStack[] {
                    Materials.Thulium.getMolten(144 * 10),
                    Materials.ExcitedDTCC.getFluid(5000),
                    new FluidStack(ELEMENT.getInstance().NEPTUNIUM.getPlasma(), 1000 * 10),
                    new FluidStack(ELEMENT.getInstance().FERMIUM.getPlasma(), 1000 * 10)
                },
                GregtechItemList.NeutronPulseManipulator.get(1),
                60 * 20,
                (int) GT_Values.VP[10]);

        TT_recipeAdder.addResearchableAssemblylineRecipe(
                GregtechItemList.NeutronPulseManipulator.get(1),
                2048 * 30 * 20,
                2048,
                (int) GT_Values.VP[8],
                32,
                new ItemStack[] {
                    GregtechItemList.ForceFieldGlass.get(2),
                    Materials.Carbon.getNanite(8),
                    ItemList.Emitter_UEV.get(4),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUEV, 8),
                    GregtechItemList.Laser_Lens_Special.get(1),
                    GT_ModHandler.getModItem("GoodGenerator", "advancedRadiationProtectionPlate", 4),
                    ItemList.StableAdhesive.get(4)
                },
                new FluidStack[] {
                    Materials.Thulium.getMolten(144 * 10),
                    Materials.ExcitedDTPC.getFluid(5000),
                    new FluidStack(ELEMENT.getInstance().NEPTUNIUM.getPlasma(), 1000 * 10),
                    new FluidStack(ELEMENT.getInstance().FERMIUM.getPlasma(), 1000 * 10)
                },
                GregtechItemList.CosmicFabricManipulator.get(1),
                75 * 20,
                (int) GT_Values.VP[11]);

        TT_recipeAdder.addResearchableAssemblylineRecipe(
                GregtechItemList.CosmicFabricManipulator.get(1),
                4096 * 30 * 20,
                4096,
                (int) GT_Values.VP[7],
                32,
                new ItemStack[] {
                    GregtechItemList.ForceFieldGlass.get(4),
                    Materials.Carbon.getNanite(16),
                    ItemList.Emitter_UIV.get(4),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUIV, 8),
                    GregtechItemList.Laser_Lens_Special.get(1),
                    GT_ModHandler.getModItem("GoodGenerator", "advancedRadiationProtectionPlate", 8),
                    ItemList.SuperconductorComposite.get(4)
                },
                new FluidStack[] {
                    Materials.Thulium.getMolten(144 * 10),
                    Materials.ExcitedDTRC.getFluid(5000),
                    new FluidStack(ELEMENT.getInstance().NEPTUNIUM.getPlasma(), 1000 * 10),
                    new FluidStack(ELEMENT.getInstance().FERMIUM.getPlasma(), 1000 * 10)
                },
                GregtechItemList.InfinityInfusedManipulator.get(1),
                90 * 20,
                (int) GT_Values.VP[12]);
        TT_recipeAdder.addResearchableAssemblylineRecipe(
                GregtechItemList.InfinityInfusedManipulator.get(1),
                1024 * 30 * 20,
                1024,
                (int) GT_Values.VP[7],
                32,
                new ItemStack[] {
                    GregtechItemList.ForceFieldGlass.get(8),
                    Materials.Carbon.getNanite(32),
                    ItemList.Emitter_UMV.get(4),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUMV, 8),
                    GregtechItemList.Laser_Lens_Special.get(1),
                    GT_ModHandler.getModItem("GoodGenerator", "advancedRadiationProtectionPlate", 16),
                    ItemList.NaquadriaSupersolid.get(4)
                },
                new FluidStack[] {
                    Materials.Thulium.getMolten(144 * 10),
                    Materials.ExcitedDTEC.getFluid(5000),
                    new FluidStack(ELEMENT.getInstance().NEPTUNIUM.getPlasma(), 1000 * 10),
                    new FluidStack(ELEMENT.getInstance().FERMIUM.getPlasma(), 1000 * 10)
                },
                GregtechItemList.SpaceTimeContinuumRipper.get(1),
                60 * 20,
                (int) GT_Values.VP[13]);

        TT_recipeAdder.addResearchableAssemblylineRecipe(
                ItemList.Casing_AdvancedRadiationProof.get(1),
                1024 * 30 * 20,
                1024,
                (int) GT_Values.VP[7],
                32,
                new ItemStack[] {
                    ALLOY.QUANTUM.getFrameBox(1),
                    GT_OreDictUnificator.get("plateDensePreciousMetalsAlloy", 4),
                    GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Infinity, 16),
                    ItemList.Field_Generator_UHV.get(1),
                    ELEMENT.STANDALONE.CHRONOMATIC_GLASS.getScrew(16)
                },
                new FluidStack[] {
                    MISC_MATERIALS.MUTATED_LIVING_SOLDER.getFluidStack(144 * 10),
                },
                GregtechItemList.NeutronShieldingCore.get(1),
                60 * 20,
                (int) GT_Values.VP[10]);

        TT_recipeAdder.addResearchableAssemblylineRecipe(
                GregtechItemList.NeutronShieldingCore.get(1),
                2048 * 30 * 20,
                2048,
                (int) GT_Values.VP[8],
                32,
                new ItemStack[] {
                    ALLOY.QUANTUM.getFrameBox(2),
                    GT_OreDictUnificator.get("plateDenseEnrichedNaquadahAlloy", 4),
                    GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Infinity, 16),
                    ItemList.Field_Generator_UEV.get(1),
                    GT_OreDictUnificator.get(OrePrefixes.screw, GT_CoreModSupport.RadoxPolymer, 16),
                    ItemList.StableAdhesive.get(4)
                },
                new FluidStack[] {
                    MISC_MATERIALS.MUTATED_LIVING_SOLDER.getFluidStack(144 * 20),
                },
                GregtechItemList.CosmicFabricShieldingCore.get(1),
                75 * 20,
                (int) GT_Values.VP[11]);

        TT_recipeAdder.addResearchableAssemblylineRecipe(
                GregtechItemList.CosmicFabricShieldingCore.get(1),
                4096 * 30 * 20,
                4096,
                (int) GT_Values.VP[9],
                32,
                new ItemStack[] {
                    ALLOY.QUANTUM.getFrameBox(4),
                    ELEMENT.STANDALONE.HYPOGEN.getPlateDense(4),
                    GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.TranscendentMetal, 16),
                    ItemList.Field_Generator_UIV.get(1),
                    GT_OreDictUnificator.get("screwMetastableOganesson", 16),
                    ItemList.SuperconductorComposite.get(4)
                },
                new FluidStack[] {
                    MISC_MATERIALS.MUTATED_LIVING_SOLDER.getFluidStack(144 * 40),
                },
                GregtechItemList.InfinityInfusedShieldingCore.get(1),
                90 * 20,
                (int) GT_Values.VP[12]);

        TT_recipeAdder.addResearchableAssemblylineRecipe(
                GregtechItemList.InfinityInfusedShieldingCore.get(1),
                8192 * 30 * 20,
                8192,
                (int) GT_Values.VP[10],
                32,
                new ItemStack[] {
                    ALLOY.QUANTUM.getFrameBox(8),
                    GT_OreDictUnificator.get("plateDenseShirabon", 4),
                    GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.SpaceTime, 16),
                    ItemList.Field_Generator_UMV.get(1),
                    GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Dilithium, 16),
                    ItemList.NaquadriaSupersolid.get(4)
                },
                new FluidStack[] {
                    MISC_MATERIALS.MUTATED_LIVING_SOLDER.getFluidStack(144 * 80),
                },
                GregtechItemList.SpaceTimeBendingCore.get(1),
                120 * 20,
                (int) GT_Values.VP[13]);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    new ItemStack(QuantumGlassBlock.INSTANCE, 1),
                    ItemList.Field_Generator_UV.get(4),
                    ELEMENT.STANDALONE.CELESTIAL_TUNGSTEN.getLongRod(6),
                    ELEMENT.STANDALONE.CHRONOMATIC_GLASS.getPlate(6)
                },
                ALLOY.QUANTUM.getFluidStack(144 * 6),
                GregtechItemList.ForceFieldGlass.get(1),
                10 * 20,
                (int) GT_Values.VP[10]);
    }
}