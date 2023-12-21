package org.itzsopsu.etheritemod.worldgen;

import org.itzsopsu.etheritemod.EtheriteMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import org.itzsopsu.etheritemod.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHERITE_DEBRIS_KEY = registerKey("etherite_debris");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ECHO_SHARD_ORE_KEY = registerKey("echo_shard_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest netherrackReplacables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldEchoShardOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.ECHO_SHARD_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ECHO_SHARD_ORE.get().defaultBlockState()));

        register(context, ETHERITE_DEBRIS_KEY, Feature.ORE, new OreConfiguration(netherrackReplacables,
                ModBlocks.ETHERITE_DEBRIS.get().defaultBlockState(), 5));
        register(context, OVERWORLD_ECHO_SHARD_ORE_KEY, Feature.ORE, new OreConfiguration(overworldEchoShardOres, 999));


    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(EtheriteMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}