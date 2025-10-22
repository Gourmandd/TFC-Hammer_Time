package net.rtc.hammertime;

import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.rtc.hammertime.common.items.ModItemCapabilities;
import net.rtc.hammertime.common.items.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(HammerTime.MOD_ID)
public class HammerTime
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "tfc_hammer_time";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public HammerTime(IEventBus modEventBus, ModContainer modContainer)
    {

        ModItems.register(modEventBus);

        modEventBus.addListener(ModItemCapabilities::register);
        modEventBus.addListener(this::commonSetup);


        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        if (FMLEnvironment.dist == Dist.CLIENT)
        {
            ClientEventHandler.init();
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        ModCreativeModeTab.AddCreative(event);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }
}
