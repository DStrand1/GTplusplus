/*
 * Copyright (c) 2019 bartimaeusnek
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.bartimaeusnek.crossmod.galacticraft.solarsystems;

import com.github.bartimaeusnek.crossmod.BartWorksCrossmod;
import com.github.bartimaeusnek.crossmod.galacticraft.UniversalTeleportType;
import com.github.bartimaeusnek.crossmod.galacticraft.blocks.UniversalSpaceBlocks;
import com.github.bartimaeusnek.crossmod.galacticraft.planets.ross128.world.worldprovider.WorldProviderRoss128b;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.*;
import micdoodle8.mods.galacticraft.api.prefab.core.BlockMetaPair;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.Arrays;

public class Ross128 {

    private Ross128(){}

    public static SolarSystem Ross128System;
    public static Star Ross128;
    public static Planet Ross128b;
    public static Moon Ross128ba;
//    public static Block Ross128bBlocks;
//    public static BlockMetaPair Ross128bStone,Ross128bDirt,Ross128bGrass;
    public static int ross128ID = -64;
    public static void init() {

//        Ross128bBlocks = new UniversalSpaceBlocks("Ross128bBlocks",new String[]{BartWorksCrossmod.MOD_ID+":Ross128bStone",BartWorksCrossmod.MOD_ID+":Ross128bDirt",BartWorksCrossmod.MOD_ID+":Ross128bGrass"});

        Ross128System = new SolarSystem("Ross128System", "milkyWay").setMapPosition(new Vector3(-1.0D, 1.3D, 0.0D));
        Ross128 = (Star) new Star("Ross128").setParentSolarSystem(Ross128System).setTierRequired(-1);
        Ross128.setUnreachable();
        Ross128.setBodyIcon(new ResourceLocation(BartWorksCrossmod.MOD_ID+":galacticraft/Ross128b/MapObjs/Ross128.png"));
        Ross128System.setMainStar(Ross128);

        Ross128b = new Planet("Ross128b").setParentSolarSystem(Ross128System);
        Ross128b.setRingColorRGB((0x9F)/255f, (0x8A)/255f, (0x79)/255f);
        Ross128b.setPhaseShift(1.25F);
        Ross128b.setBodyIcon(new ResourceLocation(BartWorksCrossmod.MOD_ID+":galacticraft/Ross128b/MapObjs/Ross128b.png"));
        Ross128b.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.75F, 1.75F));
        Ross128b.setRelativeOrbitTime(0.65F);
        Ross128b.atmosphere.addAll(Arrays.asList(IAtmosphericGas.OXYGEN,IAtmosphericGas.NITROGEN,IAtmosphericGas.ARGON));
        Ross128b.setDimensionInfo(ross128ID, WorldProviderRoss128b.class);
        Ross128b.setTierRequired(Loader.isModLoaded("galaxyspace") ? 4 : Loader.isModLoaded("GalacticraftMars") ? 3 : -1);

        Ross128ba = new Moon("Ross128ba").setParentPlanet(Ross128b);
        Ross128ba.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(10f,15f)).setRelativeOrbitTime(1 / 0.01F);
        Ross128ba.setBodyIcon(new ResourceLocation(BartWorksCrossmod.MOD_ID+":galacticraft/Ross128b/MapObjs/Ross128ba.png"));
        Ross128ba.setUnreachable(); //for now

//        GameRegistry.registerBlock(Ross128bBlocks,Ross128bBlocks.getUnlocalizedName());
//
//        Ross128bStone=new BlockMetaPair(Ross128bBlocks, (byte) 0);
//        Ross128bDirt=new BlockMetaPair(Ross128bBlocks, (byte) 1);
//        Ross128bGrass=new BlockMetaPair(Ross128bBlocks, (byte) 2);

        GalaxyRegistry.registerPlanet(Ross128b);
        GalaxyRegistry.registerMoon(Ross128ba);
        GalaxyRegistry.registerSolarSystem(Ross128System);
        GalacticraftRegistry.registerTeleportType(WorldProviderRoss128b.class, new UniversalTeleportType());
    }

}
