package net.rtc.hammertime.common.items;

import net.dries007.tfc.common.capabilities.ItemCapabilities;
import net.dries007.tfc.common.component.mold.IMold;
import net.dries007.tfc.common.component.mold.Mold;
import net.dries007.tfc.common.items.MoldItem;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import org.jetbrains.annotations.Nullable;

public class ModItemCapabilities {

    public static void register(RegisterCapabilitiesEvent event){


        event.registerItem(ItemCapabilities.MOLD, ModItemCapabilities::getMold,
                ModItems.EXCAVATOR_HEAD_MOLD.get(),
                ModItems.SLEDGEHAMMER_HEAD_MOLD.get()
        );

        event.registerItem(ItemCapabilities.FLUID, ModItemCapabilities::getMold,
                ModItems.EXCAVATOR_HEAD_MOLD.get(),
                ModItems.SLEDGEHAMMER_HEAD_MOLD.get()
        );

        event.registerItem(ItemCapabilities.HEAT, ModItemCapabilities::getMold,
                ModItems.EXCAVATOR_HEAD_MOLD.get(),
                ModItems.SLEDGEHAMMER_HEAD_MOLD.get()
        );
    }

    public static IMold getMold(ItemStack stack, @Nullable Void context)
    {
        return stack.getItem() instanceof MoldItem item ? new Mold(stack, item.containerInfo()) : null;
    }
}


