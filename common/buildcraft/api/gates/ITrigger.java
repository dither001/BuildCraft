package buildcraft.api.gates;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public interface ITrigger {

	/**
	 * Return your ID from the old API here, this is only used to convert old
	 * saves to the new format.
	 */
	int getLegacyId();

	String getUniqueTag();

	@SideOnly(Side.CLIENT)
	Icon getIcon();

	@SideOnly(Side.CLIENT)
	void registerIcons(IconRegister iconRegister);

	/**
	 * Return true if this trigger can accept parameters
	 */
	boolean hasParameter();

	/**
	 * Return true if this trigger requires a parameter
	 */
	boolean requiresParameter();

	/**
	 * Return the trigger description in the UI
	 */
	String getDescription();

	/**
	 * Create parameters for the trigger. As for now, there is only one kind of
	 * trigger parameter available so this subprogram is final.
	 */
	ITriggerParameter createParameter();
}
