package net.rtc.hammertime;


import net.dries007.tfc.common.TFCCreativeTabs;
import net.dries007.tfc.util.Metal;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.rtc.hammertime.common.items.ModItems;
import net.rtc.hammertime.common.items.SledgeItem;

public class ModCreativeModeTab {
    public static void AddCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == TFCCreativeTabs.METAL.tab().getKey()) {
            for (Metal metal : Metal.values()) {
                DeferredHolder<Item, SledgeItem> sledgehammer = ModItems.SLEDGEHAMMERS.get(metal);
                DeferredHolder<Item, SledgeItem> excavator = ModItems.EXCAVATORS.get(metal);
                DeferredHolder<Item, Item> sledgehammer_heads = ModItems.SLEDGEHAMMER_HEADS.get(metal);
                DeferredHolder<Item, Item> excavator_heads = ModItems.EXCAVATOR_HEADS.get(metal);
                if (sledgehammer != null) {
                    event.accept(sledgehammer.get());
                    event.accept(sledgehammer_heads.get());
                    event.accept(excavator.get());
                    event.accept(excavator_heads.get());
                }
            }
        }
        if (event.getTabKey() == TFCCreativeTabs.MISC.tab().getKey()){
            event.accept(ModItems.UNFIRED_EXCAVATOR_HEAD_MOLD.get());
            event.accept(ModItems.EXCAVATOR_HEAD_MOLD.get());
            event.accept(ModItems.UNFIRED_SLEDGEHAMMER_HEAD_MOLD.get());
            event.accept(ModItems.SLEDGEHAMMER_HEAD_MOLD.get());
        }
    }
}
