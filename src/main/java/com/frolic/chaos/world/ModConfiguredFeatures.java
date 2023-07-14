package com.frolic.chaos.world;

import com.frolic.chaos.FrolicsChaosMod;
import com.frolic.chaos.registry.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;


public class ModConfiguredFeatures {

    // create a registry key for the ore features using helper
    public static final RegistryKey<ConfiguredFeature<?,?>> RUBY_ORE_KEY = registerKey("ruby_ore");

    // bootstrap all the feature stuff
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        // define the registry entry lookup - a way for us to look into all the placed features to be referenced
        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        // define rule tests to let blocks be replaced by other blocks when generating
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES); // defines a list of replaceable blocks to be replaced by ores
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        // create a list of ore features for the overworld that replaces stone and deepslate with the ruby block
        List<OreFeatureConfig.Target> overworldRubyOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.RUBY_BLOCK.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.RUBY_BLOCK.getDefaultState()));

        // repeat this process for end and nether replaceables

        // Then register the feature using the helper [ context, key, feature type, configuration ]
        register(context, RUBY_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldRubyOres, 2));
    }

    // pass in a name and register a feature key to make it repeatable
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(FrolicsChaosMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>>
         // register a configured feature to a context with a feature and a configuration
        void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
