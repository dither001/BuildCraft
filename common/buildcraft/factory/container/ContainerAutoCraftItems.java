/* Copyright (c) 2016 SpaceToad and the BuildCraft team
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of the MPL was not
 * distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/. */
package buildcraft.factory.container;

import buildcraft.factory.tile.TileAutoWorkbenchItems;
import buildcraft.lib.gui.ContainerBCTile;
import buildcraft.lib.gui.slot.SlotBase;
import buildcraft.lib.gui.slot.SlotDisplay;
import buildcraft.lib.gui.slot.SlotOutput;
import buildcraft.lib.gui.slot.SlotPhantom;
import net.minecraft.entity.player.EntityPlayer;

public class ContainerAutoCraftItems extends ContainerBCTile<TileAutoWorkbenchItems> {

    public final SlotBase[] materialSlots;

    public ContainerAutoCraftItems(EntityPlayer player, TileAutoWorkbenchItems tile) {
        super(player, tile);

        addSlotToContainer(new SlotOutput(tile.invResult, 0, 124, 35));
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                addSlotToContainer(new SlotPhantom(tile.invBlueprint, x + y * 3, 30 + x * 18, 17 + y * 18, false));
            }
        }
        materialSlots = new SlotBase[9];
        for (int x = 0; x < 9; x++) {
            // hide the filter slots, but still sync them
            addSlotToContainer(new SlotPhantom(tile.invMaterialFilter, x, -1000000, -1000000));
            addSlotToContainer(materialSlots[x] = new SlotBase(tile.invMaterials, x, 8 + x * 18, 84));
        }
        addSlotToContainer(new SlotDisplay(i -> tile.resultClient, 0, 93, 27));

        addFullPlayerInventory(115);
    }
}
