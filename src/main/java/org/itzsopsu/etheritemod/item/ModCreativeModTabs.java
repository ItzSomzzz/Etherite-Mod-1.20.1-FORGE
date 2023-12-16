package org.itzsopsu.etheritemod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.itzsopsu.etheritemod.EtheriteMod;
import org.itzsopsu.etheritemod.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EtheriteMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ETHERITE_TAB = CREATIVE_MODE_TABS.register("etherite_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ETHERITE_SCRAP.get()))
                    .title(Component.translatable("creativetab.etherite_tab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ETHERITE.get());
                        pOutput.accept(ModItems.ETHERITE_SCRAP.get());
                        pOutput.accept(ModBlocks.ETHERITE_BLOCK.get());
                        pOutput.accept(ModBlocks.ETHERITE_DEBRIS.get());

                    }))
                    .build());

    public static void reqister(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
