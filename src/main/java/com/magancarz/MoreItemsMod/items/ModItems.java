package com.magancarz.MoreItemsMod.items;

import com.magancarz.MoreItemsMod.MoreItemsMod;
import com.magancarz.MoreItemsMod.blocks.ModBlocks;
import com.magancarz.MoreItemsMod.items.custom.EightBallItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
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
    public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register("raw_zircon", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ZIRCON_BLOCK = ITEMS.register("zircon_block", () -> new BlockItem(ModBlocks.ZIRCON_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> ZIRCON_ORE = ITEMS.register("zircon_ore", () -> new BlockItem(ModBlocks.ZIRCON_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_ZIRCON_ORE = ITEMS.register("deepslate_zircon_ore", () -> new BlockItem(ModBlocks.DEEPSLATE_ZIRCON_ORE.get(), new Item.Properties()));

    public static final RegistryObject<Item> EIGHT_BALL = ITEMS.register("eight_ball", () -> new EightBallItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> TRAIL = ITEMS.register("trail_block", () -> new BlockItem(ModBlocks.TRAIL_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> ZIRCON_LAMP = ITEMS.register("zircon_lamp", () -> new BlockItem(ModBlocks.ZIRCON_LAMP.get(), new Item.Properties()));

    public static final RegistryObject<Item> BLUEBERRY_SEEDS = ITEMS.register("blueberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_CROP.get(),
                    new Item.Properties()));

    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(2f).build())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ZIRCON);
            event.accept(RAW_ZIRCON);
        } else if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ZIRCON_BLOCK);
            event.accept(ZIRCON_ORE);
            event.accept(DEEPSLATE_ZIRCON_ORE);
            event.accept(TRAIL);
            event.accept(ZIRCON_LAMP);
        } else if(event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(EIGHT_BALL);
        } else if(event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(BLUEBERRY_SEEDS);
            event.accept(BLUEBERRY);
        }
    }
}