package org.itzsopsu.etheritemod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.itzsopsu.etheritemod.EtheriteMod;
import org.itzsopsu.etheritemod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EtheriteMod.MOD_ID);

    public static final RegistryObject<Block> ETHERITE_BLOCK = registerBlock("etherite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).strength(50.0F, 1200.0F)));

    public static final RegistryObject<Block> ETHERITE_DEBRIS = registerBlock("etherite_debris",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS).strength(50.0F, 1200.0F)));
    public static final RegistryObject<Block> ECHO_SHARD_BLOCK = registerBlock("echo_shard_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)));
    public static final RegistryObject<Block> DEEPSLATE_ECHO_SHARD_ORE = registerBlock("deepslate_echo_shard_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)));
    public static final RegistryObject<Block> ECHO_SHARD_ORE = registerBlock("echo_shard_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));



    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}