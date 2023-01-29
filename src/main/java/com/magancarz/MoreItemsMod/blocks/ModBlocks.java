package com.magancarz.MoreItemsMod.blocks;

import com.magancarz.MoreItemsMod.MoreItemsMod;
import com.magancarz.MoreItemsMod.blocks.custom.TrailBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MoreItemsMod.MOD_ID);

    public static final RegistryObject<Block> ZIRCON_ORE = BLOCKS.register("zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)));

    public static final RegistryObject<Block> DEEPSLATE_ZIRCON_ORE = BLOCKS.register("deepslate_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)));

    public static final RegistryObject<Block> ZIRCON_BLOCK = BLOCKS.register("zircon_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> TRAIL_BLOCK = BLOCKS.register("trail_block",
            () -> new TrailBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.f).requiresCorrectToolForDrops()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ZIRCON_BLOCK);
            event.accept(ZIRCON_ORE);
            event.accept(DEEPSLATE_ZIRCON_ORE);
        } else if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(TRAIL_BLOCK);
        }
    }
}