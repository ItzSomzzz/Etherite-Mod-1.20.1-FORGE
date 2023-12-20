package org.itzsopsu.etheritemod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.itzsopsu.etheritemod.EtheriteMod;
import org.itzsopsu.etheritemod.item.custom.EtheriteFinder;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EtheriteMod.MOD_ID);

    public static final RegistryObject<Item> ETHERITE = ITEMS.register("etherite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ETHERITE_SCRAP = ITEMS.register("etherite_scrap",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ETHERITE_FINDER = ITEMS.register("etherite_finder",
            () -> new EtheriteFinder(new Item.Properties().durability(100)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}
