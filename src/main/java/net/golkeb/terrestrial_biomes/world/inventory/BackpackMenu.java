package net.golkeb.terrestrial_biomes.world.inventory;

import net.golkeb.terrestrial_biomes.world.item.BackpackItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class BackpackMenu extends AbstractContainerMenu {

    private final int slotCount;
    private final Container container;

    public BackpackMenu(int id, Inventory inv, ItemStack stack) {
        this(net.golkeb.terrestrial_biomes.world.inventory.MenuType.BACKPACK.get(), id, inv, BackpackItem.getInventory(stack));
    }

    public BackpackMenu(MenuType<? extends BackpackMenu> containerType, int id, Inventory inv, Container container) {
        super(containerType, id);
        this.container = container;
        this.slotCount = 9;

        addSlot(new Slot(container, 0, 61, 17));
        addSlot(new Slot(container, 1, 79, 17));
        addSlot(new Slot(container, 2, 97, 17));
        addSlot(new Slot(container, 3, 61, 35));
        addSlot(new Slot(container, 4, 79, 35));
        addSlot(new Slot(container, 5, 97, 35));
        addSlot(new Slot(container, 6, 61, 53));
        addSlot(new Slot(container, 7, 79, 53));
        addSlot(new Slot(container, 8, 97, 53));

        this.layoutPlayerInventorySlots(inv);
    }

    @Override
    public void removed(Player playerIn) {
        playerIn.level.playSound(null, playerIn.blockPosition(), SoundEvents.ARMOR_EQUIP_LEATHER, SoundSource.PLAYERS, 1, 1);
        super.removed(playerIn);
        this.container.stopOpen(playerIn);
    }

    @Override
    public boolean stillValid(@NotNull Player playerEntity) {
        return true;
    }

    public void layoutPlayerInventorySlots(Inventory playerInv) {
        int si;
        int sj;
        for (si = 0; si < 3; ++si)
            for (sj = 0; sj < 9; ++sj)
                this.addSlot(new Slot(playerInv, sj + (si + 1) * 9, 8 + sj * 18, 84 + si * 18));
        for (si = 0; si < 9; ++si)
            this.addSlot(new Slot(playerInv, si, 8 + si * 18, 142));
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < this.slotCount) {
                if (!this.moveItemStackTo(itemstack1, this.slotCount, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(itemstack1, itemstack);
            } else if (!this.moveItemStackTo(itemstack1, 0, this.slotCount, false)) {
                if (index < this.slotCount + 27) {
                    if (!this.moveItemStackTo(itemstack1, this.slotCount + 27, this.slots.size(), true)) {
                        return ItemStack.EMPTY;
                    }
                } else {
                    if (!this.moveItemStackTo(itemstack1, this.slotCount, this.slotCount + 27, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                return ItemStack.EMPTY;
            }
            if (itemstack1.getCount() == 0) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(playerIn, itemstack1);
        }
        return itemstack;
    }
}
