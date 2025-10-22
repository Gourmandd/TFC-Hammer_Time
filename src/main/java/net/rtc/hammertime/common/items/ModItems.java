package net.rtc.hammertime.common.items;


import net.dries007.tfc.common.TFCTags;
import net.dries007.tfc.common.items.MoldItem;
import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.util.Metal;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rtc.hammertime.HammerTime;

import java.util.Map;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(HammerTime.MOD_ID);

    public static final Map<Metal, DeferredHolder<Item, SledgeItem>> SLEDGEHAMMERS = Helpers.mapOf(Metal.class,
            Metal.ItemType.PICKAXE::has,
            metal -> ITEMS.register("metal/sledgehammer/" + metal.getSerializedName(),
                    () -> new SledgeItem(metal.toolTier(), metal.toolTier().getAttackDamageBonus(), -3.1f, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().rarity(metal.rarity()))
                )
    );

    public static final Map<Metal, DeferredHolder<Item, Item>> SLEDGEHAMMER_HEADS = Helpers.mapOf(Metal.class,
            Metal.ItemType.PICKAXE::has,
            metal -> ITEMS.register("metal/sledgehammer_head/" + metal.getSerializedName(),
                    () -> new Item(new Item.Properties().rarity(metal.rarity()))
            )
    );

    public static final Map<Metal, DeferredHolder<Item, SledgeItem>> EXCAVATORS = Helpers.mapOf(Metal.class,
            Metal.ItemType.PICKAXE::has,
            metal -> ITEMS.register("metal/excavator/" + metal.getSerializedName(),
                    () -> new SledgeItem(metal.toolTier(), metal.toolTier().getAttackDamageBonus(), -3.1f, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().rarity(metal.rarity()))
            )
    );

    public static final Map<Metal, DeferredHolder<Item, Item>> EXCAVATOR_HEADS = Helpers.mapOf(Metal.class,
            Metal.ItemType.PICKAXE::has,
            metal -> ITEMS.register("metal/excavator_head/" + metal.getSerializedName(),
                    () -> new Item(new Item.Properties().rarity(metal.rarity()))
            )
    );

    public static final DeferredHolder<Item, MoldItem> SLEDGEHAMMER_HEAD_MOLD = ITEMS.register("ceramic/sledgehammer_head_mold", () -> new MoldItem(() -> 200, TFCTags.Fluids.USABLE_IN_TOOL_HEAD_MOLD,  new Item.Properties()));
    // () -> new MoldItem(TFCConfig.SERVER.moldBellCapacity, TFCTags.Fluids.USABLE_IN_BELL_MOLD, new Properties()));
    public static final DeferredHolder<Item, MoldItem> EXCAVATOR_HEAD_MOLD = ITEMS.register("ceramic/excavator_head_mold", () -> new MoldItem(() -> 200, TFCTags.Fluids.USABLE_IN_TOOL_HEAD_MOLD,  new Item.Properties()));

    public static final DeferredHolder<Item, Item> UNFIRED_SLEDGEHAMMER_HEAD_MOLD = ITEMS.register("ceramic/unfired_sledgehammer_head_mold", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> UNFIRED_EXCAVATOR_HEAD_MOLD = ITEMS.register("ceramic/unfired_excavator_head_mold", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }}

