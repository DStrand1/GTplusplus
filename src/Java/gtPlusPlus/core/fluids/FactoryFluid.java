package gtPlusPlus.core.fluids;
import gregtech.api.GregTech_API;
import gtPlusPlus.core.lib.CORE;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraftforge.fluids.Fluid;

public class FactoryFluid extends Fluid implements Runnable {

	private final String mTextureName;
	private final short[] mRGBa;

	public FactoryFluid(String fluidName, final short[] aRGBa) {
		this(fluidName, null, Short.MIN_VALUE, Short.MIN_VALUE, Short.MIN_VALUE, Short.MIN_VALUE, false, EnumRarity.common, aRGBa);
	}

	public FactoryFluid(String fluidName, int luminosity, int density, int temp, int viscosity, final short[] aRGBa) {
		this(fluidName, null, luminosity, density, temp, viscosity, (density == Short.MIN_VALUE || density >= 0 ? false : true), EnumRarity.common, aRGBa);
	}
	
	public FactoryFluid(String fluidName, Block aBlock, int luminosity, int density, int temp, int viscosity, boolean gas, EnumRarity aRarity, final short[] aRGBa) {
		super(fluidName);
		this.mRGBa = aRGBa;
		this.setBlock(aBlock);
		if (luminosity != Short.MIN_VALUE)
		this.setLuminosity(luminosity);
		if (density != Short.MIN_VALUE)
		this.setDensity(density);
		if (temp != Short.MIN_VALUE)
		this.setTemperature(temp);
		if (viscosity != Short.MIN_VALUE)
		this.setViscosity(viscosity);
		this.setGaseous(gas);
		this.setRarity(aRarity);
		this.mTextureName = CORE.MODID+":fluids/fluid.fluid.autogenerated";
		GregTech_API.sGTBlockIconload.add(this);
	}

	@Override
	public int getColor() {
		return (Math.max(0, Math.min(255, this.mRGBa[0])) << 16) | (Math.max(0, Math.min(255, this.mRGBa[1])) << 8) | Math.max(0, Math.min(255, this.mRGBa[2]));
	}

	@Override
	public void run() {
		this.setIcons(GregTech_API.sBlockIcons.registerIcon(this.mTextureName));		
	}

}