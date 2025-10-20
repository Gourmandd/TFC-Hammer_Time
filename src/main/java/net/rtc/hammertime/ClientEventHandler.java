package net.rtc.hammertime;

import net.dries007.tfc.client.model.ContainedFluidModel;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.rtc.hammertime.common.items.ModItems;

public class ClientEventHandler {
    public static void init(){
        final IEventBus bus = ModLoadingContext.get().getActiveContainer().getEventBus();
        bus.addListener(ClientEventHandler::registerColorHandlerItems);
    }

    private static void registerColorHandlerItems(RegisterColorHandlersEvent.Item event) {
        event.register(ContainedFluidModel.COLOR, ModItems.EXCAVATOR_HEAD_MOLD.get(), ModItems.SLEDGEHAMMER_HEAD_MOLD.get());
    }
}
