package org.itzsopsu.etheritemod.item;

import net.minecraft.world.item.ArmorItem;
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

    public static final RegistryObject<Item> ETHERITE_HELMET = ITEMS.register("etherite_helmet",
            () -> new ArmorItem(ModArmorMaterials.ETHERITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ETHERITE_CHESTPLATE = ITEMS.register("etherite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ETHERITE_LEGGINGS = ITEMS.register("etherite_leggings",
            () -> new ArmorItem(ModArmorMaterials.ETHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ETHERITE_BOOTS = ITEMS.register("etherite_boots",
            () -> new ArmorItem(ModArmorMaterials.ETHERITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}
