package com.magancarz.MoreItemsMod.items;

import com.magancarz.MoreItemsMod.MoreItemsMod;
import com.magancarz.MoreItemsMod.blocks.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreItemsMod.MOD_ID);

    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ZIRCON_BLOCK = ITEMS.register("zircon_block", () -> new BlockItem(ModBlocks.ZIRCON_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> ZIRCON_ORE = ITEMS.register("zircon_ore", () -> new BlockItem(ModBlocks.ZIRCON_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_ZIRCON_ORE = ITEMS.register("deepslate_zircon_ore", () -> new BlockItem(ModBlocks.DEEPSLATE_ZIRCON_ORE.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.ZIRCON);
        } else if(event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ZIRCON_BLOCK);
            event.accept(ZIRCON_ORE);
            event.accept(DEEPSLATE_ZIRCON_ORE);
        }
    }
}