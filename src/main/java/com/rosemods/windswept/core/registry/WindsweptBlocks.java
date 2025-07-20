package com.rosemods.windswept.core.registry;

import com.mojang.datafixers.util.Pair;
import com.rosemods.windswept.common.block.*;
import com.rosemods.windswept.common.block.grower.ChestnutTreeGrower;
import com.rosemods.windswept.common.block.grower.HollyTreeGrower;
import com.rosemods.windswept.common.block.grower.PineTreeGrower;
import com.rosemods.windswept.common.item.WearableBlockItem;
import com.rosemods.windswept.core.Windswept;
import com.rosemods.windswept.core.other.WindsweptConstants;
import com.rosemods.windswept.core.other.WindsweptSoundTypes;
import com.rosemods.windswept.integration.farmers_delight.WindsweptFDCompat;
import com.teamabnormals.blueprint.common.block.*;
import com.teamabnormals.blueprint.common.block.chest.BlueprintChestBlock;
import com.teamabnormals.blueprint.common.block.chest.BlueprintTrappedChestBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintStandingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintWallSignBlock;
import com.teamabnormals.blueprint.common.block.thatch.ThatchBlock;
import com.teamabnormals.blueprint.common.block.thatch.ThatchSlabBlock;
import com.teamabnormals.blueprint.common.block.thatch.ThatchStairBlock;
import com.teamabnormals.blueprint.core.util.PropertyUtil;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import org.violetmoon.quark.base.handler.WoodSetHandler;
import org.violetmoon.quark.content.building.block.LeafCarpetBlock;
import org.violetmoon.quark.content.building.block.VerticalSlabBlock;
import org.violetmoon.quark.content.building.block.WoodPostBlock;

@Mod.EventBusSubscriber(modid = Windswept.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WindsweptBlocks {
    public static final BlockSubRegistryHelper HELPER = Windswept.REGISTRY_HELPER.getBlockSubHelper();

    // Holly //
    public static final RegistryObject<Block> HOLLY_LOG = HELPER.createBlock("holly_log", () -> new LogBlock(WindsweptBlocks.STRIPPED_HOLLY_LOG, Properties.HOLLY.log()));
    public static final RegistryObject<Block> HOLLY_WOOD = HELPER.createBlock("holly_wood", () -> new WoodBlock(WindsweptBlocks.STRIPPED_HOLLY_WOOD, Properties.HOLLY.log()));
    public static final RegistryObject<Block> STRIPPED_HOLLY_LOG = HELPER.createBlock("stripped_holly_log", () -> new LogBlock(HOLLY_LOG, Properties.HOLLY.log()));
    public static final RegistryObject<Block> STRIPPED_HOLLY_WOOD = HELPER.createBlock("stripped_holly_wood", () -> new WoodBlock(HOLLY_WOOD, Properties.HOLLY.log()));
    public static final RegistryObject<Block> HOLLY_PLANKS = HELPER.createBlock("holly_planks", () -> new Block(Properties.HOLLY.planks()));
    public static final RegistryObject<Block> HOLLY_STAIRS = HELPER.createBlock("holly_stairs", () -> new StairBlock(HOLLY_PLANKS.get().defaultBlockState(), Properties.HOLLY.planks()));
    public static final RegistryObject<Block> HOLLY_SLAB = HELPER.createBlock("holly_slab", () -> new SlabBlock(Properties.HOLLY.planks())     );
    public static final RegistryObject<Block> HOLLY_VERTICAL_SLAB = HELPER.createFuelBlock(   "holly_vertical_slab", () -> new VerticalSlabBlock(HOLLY_PLANKS, Properties.HOLLY.planks()), 150);
    public static final RegistryObject<Block> HOLLY_FENCE = HELPER.createFuelBlock("holly_fence", () -> new FenceBlock(Properties.HOLLY.planks()), 300);
    public static final RegistryObject<Block> HOLLY_FENCE_GATE = HELPER.createFuelBlock("holly_fence_gate", () -> new FenceGateBlock(Properties.HOLLY.planks(), WoodType.SPRUCE), 300);
    public static final RegistryObject<Block> HOLLY_PRESSURE_PLATE = HELPER.createBlock("holly_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.HOLLY.pressurePlate(),BlockSetType.SPRUCE));
    public static final RegistryObject<Block> HOLLY_BUTTON = HELPER.createBlock("holly_button", () -> new ButtonBlock(Properties.HOLLY.button(), BlockSetType.SPRUCE, (int) 1.5,true));
    public static final RegistryObject<Block> HOLLY_DOOR = HELPER.createBlock("holly_door", () -> new DoorBlock(Properties.HOLLY.door(),BlockSetType.SPRUCE));
    public static final RegistryObject<Block> HOLLY_TRAPDOOR = HELPER.createBlock("holly_trapdoor", () -> new TrapDoorBlock(Properties.HOLLY.trapdoor(),BlockSetType.SPRUCE));
    public static final Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> HOLLY_SIGNS = HELPER.createSignBlock("holly", WoodType.SPRUCE, Properties.HOLLY.sign());
    public static final RegistryObject<Block> HOLLY_SAPLING = HELPER.createBlock("holly_sapling", () -> new HollySaplingBlock(new HollyTreeGrower(), PropertyUtil.sapling()));
    public static final RegistryObject<Block> POTTED_HOLLY_SAPLING = HELPER.createBlockNoItem("potted_holly_sapling", () -> new FlowerPotBlock(HOLLY_SAPLING.get(), PropertyUtil.flowerPot()));

    public static final RegistryObject<Block> VERTICAL_HOLLY_PLANKS = HELPER.createBlock (   "vertical_holly_planks", () -> new Block(Properties.HOLLY.planks()));
    public static final RegistryObject<Block> HOLLY_BEEHIVE = HELPER.createBlock ("holly_beehive", () -> new BlueprintBeehiveBlock(Properties.HOLLY.beehive()));
    public static final RegistryObject<Block> HOLLY_LADDER = HELPER.createFuelBlock("holly_ladder", () -> new LadderBlock(Properties.HOLLY.ladder()), 300);
    public static final RegistryObject<Block> HOLLY_BOOKSHELF = HELPER.createFuelBlock("holly_bookshelf", () -> new Block(Properties.HOLLY.bookshelf()), 300);
    public static final RegistryObject<Block> HOLLY_BOARDS = HELPER.createBlock("holly_boards", () -> new RotatedPillarBlock(Properties.HOLLY.planks()));
    public static final RegistryObject<Block> HOLLY_CABINET = HELPER.createFuelBlock("holly_cabinet", ItemSubRegistryHelper.areModsLoaded(WindsweptConstants.FARMERSDELIGHT) ? WindsweptFDCompat.CABINET_SUPPLIER : () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)), 300);
    public static final RegistryObject<Block> HOLLY_POST = HELPER.createFuelBlock("holly_post", () -> new WoodPostBlock(WindsweptBlocks.STRIPPED_HOLLY_POST, Properties.HOLLY.post()), 300);
    public static final RegistryObject<Block> STRIPPED_HOLLY_POST = HELPER.createFuelBlock("stripped_holly_post", () -> new WoodPostBlock(Properties.HOLLY.post()), 300);
    public static final RegistryObject<BlueprintChestBlock> HOLLY_CHEST = HELPER.createChestBlock("holly", Properties.HOLLY.chest());
    public static final RegistryObject<BlueprintTrappedChestBlock> HOLLY_TRAPPED_CHEST = HELPER.createTrappedChestBlock("holly", Properties.HOLLY.chest());

    public static final RegistryObject<Block> HOLLY_LEAVES = HELPER.createBlock("holly_leaves", () -> new HollyLeavesBlock(Properties.HOLLY.leaves()));
    public static final RegistryObject<Block> HOLLY_HEDGE = HELPER.createFuelBlock(   "holly_hedge", () -> new HollyHedgeBlock(Properties.HOLLY.planks()), 300);
    public static final RegistryObject<Block> HOLLY_LEAF_CARPET = HELPER.createBlock (   "holly_leaf_carpet", () -> new LeafCarpetBlock(Properties.HOLLY.leafCarpet()));
    public static final RegistryObject<Block> HOLLY_LEAF_PILE = HELPER.createBlock ("holly_leaf_pile", () -> new LeafPileBlock(Properties.HOLLY.leafPile()));

    // Chestnut //
    public static final RegistryObject<Block> CHESTNUT_LOG = HELPER.createBlock("chestnut_log", () -> new LogBlock(WindsweptBlocks.STRIPPED_CHESTNUT_LOG, Properties.CHESTNUT.log()));
    public static final RegistryObject<Block> CHESTNUT_WOOD = HELPER.createBlock("chestnut_wood", () -> new WoodBlock(WindsweptBlocks.STRIPPED_CHESTNUT_WOOD, Properties.CHESTNUT.log()));
    public static final RegistryObject<Block> STRIPPED_CHESTNUT_LOG = HELPER.createBlock("stripped_chestnut_log", () -> new LogBlock(CHESTNUT_LOG, Properties.CHESTNUT.log()));
    public static final RegistryObject<Block> STRIPPED_CHESTNUT_WOOD = HELPER.createBlock("stripped_chestnut_wood", () -> new WoodBlock(CHESTNUT_WOOD, Properties.CHESTNUT.log()));
    public static final RegistryObject<Block> CHESTNUT_PLANKS = HELPER.createBlock("chestnut_planks", () -> new Block(Properties.CHESTNUT.planks()));
    public static final RegistryObject<Block> CHESTNUT_STAIRS = HELPER.createBlock("chestnut_stairs", () -> new StairBlock(CHESTNUT_PLANKS.get().defaultBlockState(), Properties.CHESTNUT.planks()));
    public static final RegistryObject<Block> CHESTNUT_SLAB = HELPER.createBlock("chestnut_slab", () -> new SlabBlock(Properties.CHESTNUT.planks()));
    public static final RegistryObject<Block> CHESTNUT_VERTICAL_SLAB = HELPER.createFuelBlock(   "chestnut_vertical_slab", () -> new VerticalSlabBlock(CHESTNUT_PLANKS, Properties.CHESTNUT.planks()), 150     );
    public static final RegistryObject<Block> CHESTNUT_FENCE = HELPER.createFuelBlock("chestnut_fence", () -> new FenceBlock(Properties.CHESTNUT.planks()), 300     );
    public static final RegistryObject<Block> CHESTNUT_FENCE_GATE = HELPER.createFuelBlock("chestnut_fence_gate", () -> new FenceGateBlock(Properties.CHESTNUT.planks(),WoodType.SPRUCE), 300);
    public static final RegistryObject<Block> CHESTNUT_PRESSURE_PLATE = HELPER.createBlock("chestnut_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.CHESTNUT.pressurePlate(), WoodType.SPRUCE.setType()));
    public static final RegistryObject<Block> CHESTNUT_BUTTON = HELPER.createBlock("chestnut_button", () -> new ButtonBlock(Properties.CHESTNUT.button(),BlockSetType.SPRUCE,2,true));
    public static final RegistryObject<Block> CHESTNUT_DOOR = HELPER.createBlock("chestnut_door", () -> new DoorBlock(Properties.CHESTNUT.door(), BlockSetType.SPRUCE));
    public static final RegistryObject<Block> CHESTNUT_TRAPDOOR = HELPER.createBlock("chestnut_trapdoor", () -> new TrapDoorBlock(Properties.CHESTNUT.trapdoor(), BlockSetType.SPRUCE));
    public static final Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> CHESTNUT_SIGNS = HELPER.createSignBlock("chestnut", WoodType.SPRUCE, Properties.CHESTNUT.sign());
    public static final RegistryObject<Block> CHESTNUT_SAPLING = HELPER.createBlock("chestnut_sapling", () -> new SaplingBlock(new ChestnutTreeGrower(), PropertyUtil.sapling())     );
    public static final RegistryObject<Block> POTTED_CHESTNUT_SAPLING = HELPER.createBlockNoItem("potted_chestnut_sapling", () -> new FlowerPotBlock(CHESTNUT_SAPLING.get(), PropertyUtil.flowerPot()));

    public static final RegistryObject<Block> VERTICAL_CHESTNUT_PLANKS = HELPER.createBlock (   "vertical_chestnut_planks", () -> new Block(Properties.CHESTNUT.planks())     );
    public static final RegistryObject<Block> CHESTNUT_BEEHIVE = HELPER.createBlock ("chestnut_beehive", () -> new BlueprintBeehiveBlock(Properties.CHESTNUT.beehive())     );
    public static final RegistryObject<Block> CHESTNUT_LADDER = HELPER.createFuelBlock("chestnut_ladder", () -> new LadderBlock(Properties.CHESTNUT.ladder()), 300);
    public static final RegistryObject<Block> CHESTNUT_BOOKSHELF = HELPER.createFuelBlock("chestnut_bookshelf", () -> new Block(Properties.CHESTNUT.bookshelf()), 300);
    public static final RegistryObject<Block> CHESTNUT_BOARDS = HELPER.createBlock ("chestnut_boards", () -> new RotatedPillarBlock(Properties.CHESTNUT.planks())     );
    public static final RegistryObject<Block> CHESTNUT_CABINET = HELPER.createFuelBlock("chestnut_cabinet", ItemSubRegistryHelper.areModsLoaded(WindsweptConstants.FARMERSDELIGHT) ? WindsweptFDCompat.CABINET_SUPPLIER : () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)), 300     );
    public static final RegistryObject<Block> CHESTNUT_POST = HELPER.createFuelBlock(   "chestnut_post", () -> new WoodPostBlock(WindsweptBlocks.STRIPPED_CHESTNUT_POST, Properties.CHESTNUT.post()), 300     );
    public static final RegistryObject<Block> STRIPPED_CHESTNUT_POST = HELPER.createFuelBlock(   "stripped_chestnut_post", () -> new WoodPostBlock(Properties.CHESTNUT.post()), 300     );
    public static final RegistryObject<BlueprintChestBlock> CHESTNUT_CHEST = HELPER.createChestBlock("chestnut", Properties.CHESTNUT.chest());
    public static final RegistryObject<BlueprintTrappedChestBlock> CHESTNUT_TRAPPED_CHEST = HELPER.createTrappedChestBlock("chestnut", Properties.CHESTNUT.chest());

    public static final RegistryObject<Block> CHESTNUT_LEAVES = HELPER.createBlock("chestnut_leaves", () -> new LeavesBlock(Properties.CHESTNUT.leaves())     );
    public static final RegistryObject<Block> CHESTNUT_HEDGE = HELPER.createFuelBlock(   "chestnut_hedge", () -> new HedgeBlock(Properties.CHESTNUT.planks()), 300     );
    public static final RegistryObject<Block> CHESTNUT_LEAF_CARPET = HELPER.createBlock (   "chestnut_leaf_carpet", () -> new LeafCarpetBlock(Properties.CHESTNUT.leafCarpet())     );
    public static final RegistryObject<Block> CHESTNUT_LEAF_PILE = HELPER.createBlock ("chestnut_leaf_pile", () -> new LeafPileBlock(Properties.CHESTNUT.leafPile())     );

    // Pine //
    public static final RegistryObject<Block> PINE_LOG = HELPER.createBlock("pine_log", () -> new LogBlock(WindsweptBlocks.WEATHERED_PINE_LOG, Properties.PINE.log())     );
    public static final RegistryObject<Block> PINE_WOOD = HELPER.createBlock("pine_wood", () -> new WoodBlock(WindsweptBlocks.WEATHERED_PINE_WOOD, Properties.PINE.log())     );
    public static final RegistryObject<Block> WEATHERED_PINE_LOG = HELPER.createBlock("weathered_pine_log", () -> new LogBlock(WindsweptBlocks.STRIPPED_PINE_LOG, Properties.PINE.log())     );
    public static final RegistryObject<Block> WEATHERED_PINE_WOOD = HELPER.createBlock("weathered_pine_wood", () -> new WoodBlock(WindsweptBlocks.STRIPPED_PINE_WOOD, Properties.PINE.log())     );
    public static final RegistryObject<Block> STRIPPED_PINE_LOG = HELPER.createBlock("stripped_pine_log", () -> new LogBlock(PINE_LOG, Properties.PINE.log())     );
    public static final RegistryObject<Block> STRIPPED_PINE_WOOD = HELPER.createBlock("stripped_pine_wood", () -> new WoodBlock(PINE_WOOD, Properties.PINE.log())     );
    public static final RegistryObject<Block> PINE_PLANKS = HELPER.createBlock("pine_planks", () -> new Block(Properties.PINE.planks())     );
    public static final RegistryObject<Block> PINE_STAIRS = HELPER.createBlock("pine_stairs", () -> new StairBlock(PINE_PLANKS.get().defaultBlockState(), Properties.PINE.planks())     );
    public static final RegistryObject<Block> PINE_SLAB = HELPER.createBlock("pine_slab", () -> new SlabBlock(Properties.PINE.planks())     );
    public static final RegistryObject<Block> PINE_VERTICAL_SLAB = HELPER.createFuelBlock(   "pine_vertical_slab", () -> new VerticalSlabBlock(PINE_PLANKS, Properties.PINE.planks()), 150     );
    public static final RegistryObject<Block> PINE_FENCE = HELPER.createFuelBlock("pine_fence", () -> new FenceBlock(Properties.PINE.planks()), 300     );
    public static final RegistryObject<Block> PINE_FENCE_GATE = HELPER.createFuelBlock("pine_fence_gate", () -> new FenceGateBlock(Properties.PINE.planks(), WoodType.SPRUCE), 300);
    public static final RegistryObject<Block> PINE_PRESSURE_PLATE = HELPER.createBlock("pine_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.PINE.pressurePlate(), WoodType.SPRUCE.setType()));
    public static final RegistryObject<Block> PINE_BUTTON = HELPER.createBlock("pine_button", () -> new ButtonBlock(Properties.PINE.button(), WoodType.SPRUCE.setType(),3,true));
    public static final RegistryObject<Block> PINE_DOOR = HELPER.createBlock("pine_door", () -> new DoorBlock(Properties.PINE.door(), WoodType.SPRUCE.setType()));
    public static final RegistryObject<Block> PINE_TRAPDOOR = HELPER.createBlock("pine_trapdoor", () -> new TrapDoorBlock(Properties.PINE.trapdoor(), WoodType.SPRUCE.setType()));
    public static final Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> PINE_SIGNS = HELPER.createSignBlock("pine", WoodType.SPRUCE, Properties.PINE.sign());
    public static final RegistryObject<Block> PINE_SAPLING = HELPER.createBlock("pine_sapling", () -> new SaplingBlock(new PineTreeGrower(), PropertyUtil.sapling())     );
    public static final RegistryObject<Block> POTTED_PINE_SAPLING = HELPER.createBlockNoItem("potted_pine_sapling", () -> new FlowerPotBlock(PINE_SAPLING.get(), PropertyUtil.flowerPot()));

    public static final RegistryObject<Block> VERTICAL_PINE_PLANKS = HELPER.createBlock("vertical_pine_planks", () -> new Block(Properties.PINE.planks())     );
    public static final RegistryObject<Block> PINE_BEEHIVE = HELPER.createBlock("pine_beehive", () -> new BlueprintBeehiveBlock(Properties.PINE.beehive())     );
    public static final RegistryObject<Block> PINE_LADDER = HELPER.createFuelBlock("pine_ladder", () -> new LadderBlock(Properties.PINE.ladder()), 300);
    public static final RegistryObject<Block> PINE_BOOKSHELF = HELPER.createFuelBlock("pine_bookshelf", () -> new Block(Properties.PINE.bookshelf()), 300);
    public static final RegistryObject<Block> PINE_BOARDS = HELPER.createBlock("pine_boards", () -> new RotatedPillarBlock(Properties.PINE.planks()));
    public static final RegistryObject<Block> PINE_CABINET = HELPER.createFuelBlock("pine_cabinet", ItemSubRegistryHelper.areModsLoaded(WindsweptConstants.FARMERSDELIGHT) ? WindsweptFDCompat.CABINET_SUPPLIER : () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)), 300     );
    public static final RegistryObject<Block> PINE_POST = HELPER.createFuelBlock("pine_post", () -> new WoodPostBlock(WindsweptBlocks.WEATHERED_PINE_POST, Properties.PINE.post()), 300     );
    public static final RegistryObject<Block> WEATHERED_PINE_POST = HELPER.createFuelBlock("weathered_pine_post", () -> new WoodPostBlock(WindsweptBlocks.STRIPPED_PINE_POST, Properties.PINE.post()), 300     );
    public static final RegistryObject<Block> STRIPPED_PINE_POST = HELPER.createFuelBlock("stripped_pine_post", () -> new WoodPostBlock(Properties.PINE.post()), 300     );
    public static final RegistryObject<BlueprintChestBlock> PINE_CHEST = HELPER.createChestBlock("pine", Properties.PINE.chest());
    public static final RegistryObject<BlueprintTrappedChestBlock> PINE_TRAPPED_CHEST = HELPER.createTrappedChestBlock("pine", Properties.PINE.chest());

    public static final RegistryObject<Block> PINE_LEAVES = HELPER.createBlock("pine_leaves", () -> new LeavesBlock(Properties.PINE.leaves())     );
    public static final RegistryObject<Block> PINE_HEDGE = HELPER.createBlock("pine_hedge", () -> new HedgeBlock(Properties.PINE.planks()));
    public static final RegistryObject<Block> PINE_LEAF_CARPET = HELPER.createBlock (   "pine_leaf_carpet", () -> new LeafCarpetBlock(PINE_LEAVES, Properties.PINE.leafCarpet(),)     );
    public static final RegistryObject<Block> PINE_LEAF_PILE = HELPER.createBlock ("pine_leaf_pile", () -> new LeafPileBlock(Properties.PINE.leafPile())     );

    // Moss //
    public static final RegistryObject<Block> MOSSY_SPROUTS = HELPER.createBlock("mossy_sprouts", () -> new SproutsBlock(Properties.SPROUTS)     );
    public static final RegistryObject<Block> DRY_MOSSY_SPROUTS = HELPER.createBlock("dry_mossy_sprouts", () -> new SproutsBlock(Properties.SPROUTS)     );
    public static final RegistryObject<Block> DRY_MOSS_CARPET = HELPER.createBlock("dry_moss_carpet", () -> new CarpetBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_CARPET))     );
    public static final RegistryObject<Block> DRY_MOSS_BLOCK = HELPER.createBlock("dry_moss_block", () -> new DryMossBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK))     );

    // Gelisol Blocks //
    public static final RegistryObject<Block> GELISOL_SPROUTS = HELPER.createBlock("gelisol_sprouts", () -> new SproutsBlock(Properties.SPROUTS)     );
    public static final RegistryObject<Block> GELISOL = HELPER.createBlock("gelisol", () -> new GelisolBlock(BlockBehaviour.Properties.copy(Blocks.PODZOL))     );
    public static final RegistryObject<Block> GELISOL_PATH = HELPER.createBlock("gelisol_path", () -> new DirtPathBlock(BlockBehaviour.Properties.copy(Blocks.DIRT_PATH))     );

    // Plants //
    public static final RegistryObject<Block> RED_ROSE = HELPER.createBlock("red_rose", () -> new RoseFlowerBlock(WindsweptBlocks.RED_ROSE_BUSH, () -> MobEffects.WITHER, 5, PropertyUtil.flower())     );
    public static final RegistryObject<Block> BLUE_ROSE = HELPER.createBlock("blue_rose", () -> new RoseFlowerBlock(WindsweptBlocks.BLUE_ROSE_BUSH, () -> MobEffects.WITHER, 5, PropertyUtil.flower())     );
    public static final RegistryObject<Block> WHITE_ROSE = HELPER.createBlock("white_rose", () -> new RoseFlowerBlock(WindsweptBlocks.WHITE_ROSE_BUSH, () -> MobEffects.WITHER, 5, PropertyUtil.flower())     );
    public static final RegistryObject<Block> YELLOW_ROSE = HELPER.createBlock("yellow_rose", () -> new RoseFlowerBlock(WindsweptBlocks.YELLOW_ROSE_BUSH, () -> MobEffects.WITHER, 5, PropertyUtil.flower())     );
    public static final RegistryObject<Block> FOXGLOVE = HELPER.createBlock("foxglove", () -> new FlowerBlock(() -> MobEffects.MOVEMENT_SPEED, 5, PropertyUtil.flower())     );
    public static final RegistryObject<Block> BLUEBELLS = HELPER.createBlock("bluebells", () -> new FlowerBlock(() -> MobEffects.SLOW_FALLING, 5, PropertyUtil.flower())     );
    public static final RegistryObject<Block> SNOWY_SPROUTS = HELPER.createBlock("snowy_sprouts", () -> new SproutsBlock(Properties.SPROUTS)     );
    public static final RegistryObject<Block> SNOWDROP = HELPER.createBlock("snowdrop", () -> new SnowdropBlock(WindsweptEffects.FROST_RESISTANCE, 5, PropertyUtil.flower().sound(SoundType.NETHER_SPROUTS))     );
    public static final RegistryObject<Block> MOSS_CAMPION = HELPER.createBlock("moss_campion", () -> new MossCampionBlock(WindsweptEffects.THORNS, 5, PropertyUtil.flower().sound(SoundType.AZALEA))     );
    public static final RegistryObject<Block> WILD_GINGER = HELPER.createBlock("wild_ginger", () -> new FlowerBlock(WindsweptEffects.PLENTY, 5, PropertyUtil.flower())     );
    public static final RegistryObject<Block> NIGHTSHADE = HELPER.createBlock("nightshade", () -> new NightshadeFlowerBlock(() -> MobEffects.NIGHT_VISION, 5, BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).lightLevel(state -> 9))     );

    // Tall Flowers//
    public static final RegistryObject<Block> LUPINE = HELPER.createBlock("lupine", () -> new TallFlowerBlock(PropertyUtil.flower()));
    public static final RegistryObject<Block> RED_ROSE_BUSH = HELPER.createBlock("red_rose_bush", () -> new TallFlowerBlock(PropertyUtil.flower())     );
    public static final RegistryObject<Block> BLUE_ROSE_BUSH = HELPER.createBlock("blue_rose_bush", () -> new TallFlowerBlock(PropertyUtil.flower())     );
    public static final RegistryObject<Block> WHITE_ROSE_BUSH = HELPER.createBlock("white_rose_bush", () -> new TallFlowerBlock(PropertyUtil.flower())     );
    public static final RegistryObject<Block> YELLOW_ROSE_BUSH = HELPER.createBlock("yellow_rose_bush", () -> new TallFlowerBlock(PropertyUtil.flower())     );

    // Lavender //
    public static final RegistryObject<Block> LAVENDER = HELPER.createBlock("lavender", () -> new LavenderBlock(PropertyUtil.flower().sound(SoundType.AZALEA).randomTicks())     );
    public static final RegistryObject<Block> LAVENDER_BALE = HELPER.createBlock("lavender_bale", () -> new LavenderBaleBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK))     );
    public static final RegistryObject<Block> LAVENDER_THATCH = HELPER.createBlock("lavender_thatch", () -> new ThatchBlock(Properties.LAVENDER_THATCH)     );
    public static final RegistryObject<Block> LAVENDER_THATCH_STAIRS = HELPER.createBlock("lavender_thatch_stairs", () -> new ThatchStairBlock(LAVENDER_THATCH.get().defaultBlockState(), Properties.LAVENDER_THATCH)     );
    public static final RegistryObject<Block> LAVENDER_THATCH_SLAB = HELPER.createBlock("lavender_thatch_slab", () -> new ThatchSlabBlock(Properties.LAVENDER_THATCH)     );
    public static final RegistryObject<Block> LAVENDER_THATCH_VERTICAL_SLAB = HELPER.createBlock( "lavender_thatch_vertical_slab", () -> new ThatchVerticalSlabBlock(Properties.LAVENDER_THATCH)     );

    // Decoration Blocks //
    public static final RegistryObject<Block> HOLLY_WREATH = HELPER.createBlockWithItem("holly_wreath", () -> new WallDecorationBlock(Block.Properties.of().instabreak().sound(SoundType.AZALEA).noCollission()), () -> new WearableBlockItem(WindsweptBlocks.HOLLY_WREATH.get(), new Item.Properties()));
    public static final RegistryObject<Block> PINECONE_WREATH = HELPER.createBlockWithItem("pinecone_wreath", () -> new WallDecorationBlock(Block.Properties.of().instabreak().sound(SoundType.AZALEA).noCollission()), () -> new WearableBlockItem(WindsweptBlocks.PINECONE_WREATH.get(), new Item.Properties()));
    public static final RegistryObject<Block> VINE_WREATH = HELPER.createBlockWithItem("vine_wreath", () -> new WallDecorationBlock(Block.Properties.of().instabreak().sound(SoundType.AZALEA).noCollission()), () -> new WearableBlockItem(WindsweptBlocks.VINE_WREATH.get(), new Item.Properties()));
    public static final RegistryObject<Block> CHERRY_WREATH = HELPER.createBlockWithItem("cherry_wreath", () -> new WallDecorationBlock(Block.Properties.of().instabreak().sound(SoundType.AZALEA).noCollission()), () -> new WearableBlockItem(WindsweptBlocks.CHERRY_WREATH.get(), new Item.Properties()));
    public static final RegistryObject<Block> CHRISTMAS_PUDDING = HELPER.createBlock("christmas_pudding", () -> new ChristmasPuddingBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).noOcclusion()));
    public static final RegistryObject<Block> FROSTBITER_TROPHY = HELPER.createBlock("frostbiter_trophy", () -> new WallDecorationBlock(Properties.HOLLY.ladder().sound(SoundType.WOOD))     );
    public static final RegistryObject<Block> ICE_SHEET = HELPER.createBlock("ice_sheet", () -> new IceSheetBlock(BlockBehaviour.Properties.of().strength(.3f).sound(SoundType.GLASS).noOcclusion().friction(.98f))     );

    // Pinecone Blocks //
    public static final RegistryObject<Block> PINECONE = HELPER.createBlock("pinecone", () -> new PineconeBlock(Block.Properties.of().strength(.25f).offsetType(BlockBehaviour.OffsetType.XZ).dynamicShape().noOcclusion().sound(WindsweptSoundTypes.PINECONE))     );

    public static final RegistryObject<Block> PINECONE_JAM_BLOCK = HELPER.createBlock("pinecone_jam_block", () -> new PineconeJamBlock(Block.Properties.of().noOcclusion().sound(SoundType.HONEY_BLOCK))     );

    public static final RegistryObject<Block> FAIRY_LIGHT = HELPER.createBlock("fairy_light", () -> new PineconeBlock(BlockBehaviour.Properties.copy(PINECONE.get()).lightLevel(s -> 14))     );
    public static final RegistryObject<Block> SOUL_FAIRY_LIGHT = HELPER.createBlock("soul_fairy_light", () -> new PineconeBlock(BlockBehaviour.Properties.copy(PINECONE.get()).lightLevel(s -> 10))     );
    public static final RegistryObject<Block> CUPRIC_FAIRY_LIGHT = HELPER.createBlock ("cupric_fairy_light", () -> new PineconeBlock(BlockBehaviour.Properties.copy(PINECONE.get()).lightLevel(s -> 10))     );
    public static final RegistryObject<Block> ENDER_FAIRY_LIGHT = HELPER.createBlock ("ender_fairy_light", () -> new PineconeBlock(BlockBehaviour.Properties.copy(PINECONE.get()).lightLevel(s -> 14))     );

    public static final RegistryObject<Block> FEATHER_WING = HELPER.createBlock("feather_wing", () -> new FeatherWingBlock(Block.Properties.of().strength(.1f).noOcclusion().noCollission().sound(WindsweptSoundTypes.PINECONE))     );
    public static final RegistryObject<Block> FEATHER_ORNAMENT = HELPER.createBlock("feather_ornament", () -> new FeatherOrnamentBlock(Properties.FEATHER_ORNAMENT)     );
    public static final RegistryObject<Block> DREAM_CATCHER = HELPER.createBlock("dream_catcher", () -> new DreamCatcherBlock(Properties.FEATHER_ORNAMENT)     );

    public static final RegistryObject<Block> PINECONE_BLOCK = HELPER.createBlock("pinecone_block", () -> new PineconeBlockBlock(Properties.PINECONE_BLOCK)     );
    public static final RegistryObject<Block> CARVED_PINECONE_BLOCK = HELPER.createBlockWithItem("carved_pinecone_block", () -> new CarvedPineconeBlock(BlockBehaviour.Properties.copy(PINECONE_BLOCK.get()).randomTicks()), () -> new WearableBlockItem(WindsweptBlocks.CARVED_PINECONE_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Block> WILL_O_THE_WISP = HELPER.createBlock("will_o_the_wisp", () -> new WillOTheWispBlock(BlockBehaviour.Properties.copy(PINECONE_BLOCK.get()).lightLevel(s -> 10))     );

    public static final RegistryObject<Block> PINECONE_SHINGLES = HELPER.createBlock("pinecone_shingles", () -> new Block(Properties.PINECONE_BLOCK)     );
    public static final RegistryObject<Block> PINECONE_SHINGLE_STAIRS = HELPER.createBlock("pinecone_shingle_stairs", () -> new StairBlock(PINECONE_SHINGLES.get()::defaultBlockState, Properties.PINECONE_BLOCK)     );
    public static final RegistryObject<Block> PINECONE_SHINGLE_SLAB = HELPER.createBlock("pinecone_shingle_slab", () -> new SlabBlock(Properties.PINECONE_BLOCK)     );
    public static final RegistryObject<Block> PINECONE_SHINGLE_WALL = HELPER.createBlock("pinecone_shingle_wall", () -> new WallBlock(Properties.PINECONE_BLOCK)     );
    public static final RegistryObject<Block> PINECONE_SHINGLE_VERTICAL_SLAB = HELPER.createBlock("pinecone_shingle_vertical_slab", () -> new VerticalSlabBlock(PINECONE_BLOCK, Properties.PINECONE_BLOCK)     );

    // Icicle Blocks //
    public static final RegistryObject<Block> ICICLES = HELPER.createBlock("icicles", () -> new IciclesBlock(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE).noOcclusion())     );
    public static final RegistryObject<Block> ICICLE_BLOCK = HELPER.createBlock("icicle_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE).strength(2f))     );
    public static final RegistryObject<Block> CHISELED_ICICLE_BLOCK = HELPER.createBlock("chiseled_icicle_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE).strength(2f))     );
    public static final RegistryObject<Block> ICICLE_DOOR = HELPER.createBlock("icicle_door", () -> new DoorBlock(Block.Properties.of().strength(3f).sound(SoundType.GLASS).noOcclusion(), BlockSetType.SPRUCE));
    public static final RegistryObject<Block> ICICLE_TRAPDOOR = HELPER.createBlock("icicle_trapdoor", () -> new TrapDoorBlock(Block.Properties.of().strength(3f).sound(SoundType.GLASS).noOcclusion().isValidSpawn(PropertyUtil::never), WoodType.SPRUCE.setType());
    public static final RegistryObject<Block> ICICLE_BARS = HELPER.createBlock("icicle_bars", () -> new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE).strength(2f))     );
    public static final RegistryObject<Block> ICE_LANTERN = HELPER.createBlock("ice_lantern", () -> new IceLanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN).lightLevel(s -> 13))     );

    // Shale //
    public static final RegistryObject<Block> SHALE = HELPER.createBlock("shale", () -> new Block(Properties.SHALE));
    public static final RegistryObject<Block> SHALE_STAIRS = HELPER.createBlock("shale_stairs", () -> new StairBlock(SHALE.get()::defaultBlockState, Properties.SHALE)     );
    public static final RegistryObject<Block> SHALE_SLAB = HELPER.createBlock("shale_slab", () -> new SlabBlock(Properties.SHALE));
    public static final RegistryObject<Block> SHALE_WALL = HELPER.createBlock("shale_wall", () -> new WallBlock(Properties.SHALE));
    public static final RegistryObject<Block> SHALE_VERTICAL_SLAB = HELPER.createBlock (   "shale_vertical_slab", () -> new VerticalSlabBlock(SHALE,Properties.SHALE));

    public static final RegistryObject<Block> POLISHED_SHALE = HELPER.createBlock("polished_shale", () -> new Block(Properties.SHALE));
    public static final RegistryObject<Block> POLISHED_SHALE_STAIRS = HELPER.createBlock("polished_shale_stairs",  () -> new StairBlock(POLISHED_SHALE.get()::defaultBlockState, Properties.SHALE)     );
    public static final RegistryObject<Block> POLISHED_SHALE_SLAB = HELPER.createBlock("polished_shale_slab",  () -> new SlabBlock(Properties.SHALE));
    public static final RegistryObject<Block> POLISHED_SHALE_WALL = HELPER.createBlock("polished_shale_wall",  () -> new WallBlock(Properties.SHALE));
    public static final RegistryObject<Block> POLISHED_SHALE_VERTICAL_SLAB = HELPER.createBlock (   "polished_shale_vertical_slab", () -> new VerticalSlabBlock(SHALE, Properties.SHALE));

    public static final RegistryObject<Block> POLISHED_SHALE_BRICKS = HELPER.createBlock("polished_shale_bricks", () -> new Block(Properties.SHALE)     );
    public static final RegistryObject<Block> ICY_POLISHED_SHALE_BRICKS = HELPER.createBlock("icy_polished_shale_bricks", () -> new Block(Properties.SHALE)     );
    public static final RegistryObject<Block> CHISELED_POLISHED_SHALE_BRICKS = HELPER.createBlock("chiseled_polished_shale_bricks", () -> new Block(Properties.SHALE)     );
    public static final RegistryObject<Block> POLISHED_SHALE_BRICK_STAIRS = HELPER.createBlock("polished_shale_brick_stairs", () -> new StairBlock(POLISHED_SHALE_BRICKS.get()::defaultBlockState, Properties.SHALE)     );
    public static final RegistryObject<Block> POLISHED_SHALE_BRICK_SLAB = HELPER.createBlock("polished_shale_brick_slab", () -> new SlabBlock(Properties.SHALE)     );
    public static final RegistryObject<Block> POLISHED_SHALE_BRICK_WALL = HELPER.createBlock("polished_shale_brick_wall", () -> new WallBlock(Properties.SHALE)     );
    public static final RegistryObject<Block> POLISHED_SHALE_BRICK_VERTICAL_SLAB = HELPER.createBlock (   "polished_shale_brick_vertical_slab", () -> new VerticalSlabBlock(SHALE, Properties.SHALE)     );

    public static final RegistryObject<Block> POLISHED_SHALE_PRESSURE_PLATE = HELPER.createBlock("polished_shale_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().noCollission().strength(.5f).sound(SoundType.DRIPSTONE_BLOCK), BlockSetType.STONE));
    public static final RegistryObject<Block> POLISHED_SHALE_BUTTON = HELPER.createBlock("polished_shale_button", () -> new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(.5f).sound(SoundType.DRIPSTONE_BLOCK)));

    // Deepslate //
    public static final RegistryObject<Block> POLISHED_DEEPSLATE_PRESSURE_PLATE = HELPER.createBlock("polished_deepslate_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().noCollission().strength(.5f).sound(SoundType.POLISHED_DEEPSLATE), BlockSetType.STONE));
    public static final RegistryObject<Block> POLISHED_DEEPSLATE_BUTTON = HELPER.createBlock("polished_deepslate_button", () -> new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(.5f).sound(SoundType.POLISHED_DEEPSLATE)));

    // Packed Ice Blocks //
    public static final RegistryObject<Block> PACKED_ICE_STAIRS = HELPER.createBlock("packed_ice_stairs", () -> new StairBlock(Blocks.PACKED_ICE::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.PACKED_ICE)));
    public static final RegistryObject<Block> PACKED_ICE_SLAB = HELPER.createBlock("packed_ice_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE)));
    public static final RegistryObject<Block> PACKED_ICE_VERTICAL_SLAB = HELPER.createBlock("packed_ice_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE)));

    public static final RegistryObject<Block> PACKED_ICE_BRICKS = HELPER.createBlock("packed_ice_bricks", () -> new Block(Properties.ICE_BRICKS));
    public static final RegistryObject<Block> CHISELED_PACKED_ICE_BRICKS = HELPER.createBlock("chiseled_packed_ice_bricks", () -> new Block(Properties.ICE_BRICKS));
    public static final RegistryObject<Block> PACKED_ICE_BRICK_STAIRS = HELPER.createBlock("packed_ice_brick_stairs", () -> new StairBlock(PACKED_ICE_BRICKS.get()::defaultBlockState, Properties.ICE_BRICKS));
    public static final RegistryObject<Block> PACKED_ICE_BRICK_SLAB = HELPER.createBlock("packed_ice_brick_slab", () -> new SlabBlock(Properties.ICE_BRICKS));
    public static final RegistryObject<Block> PACKED_ICE_BRICK_WALL = HELPER.createBlock("packed_ice_brick_wall", () -> new WallBlock(Properties.ICE_BRICKS)     );
    public static final RegistryObject<Block> PACKED_ICE_BRICK_VERTICAL_SLAB = HELPER.createBlock("packed_ice_brick_vertical_slab", () -> new VerticalSlabBlock(PACKED_ICE_BRICKS,Properties.ICE_BRICKS));

    // Blue Ice Blocks //
    public static final RegistryObject<Block> BLUE_ICE_STAIRS = HELPER.createBlock("blue_ice_stairs", () -> new StairBlock(Blocks.BLUE_ICE::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.BLUE_ICE)));
    public static final RegistryObject<Block> BLUE_ICE_SLAB = HELPER.createBlock("blue_ice_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_ICE)));
    public static final RegistryObject<Block> BLUE_ICE_VERTICAL_SLAB = HELPER.createBlock("blue_ice_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_ICE)));

    public static final RegistryObject<Block> BLUE_ICE_BRICKS = HELPER.createBlock("blue_ice_bricks", () -> new Block(Properties.ICE_BRICKS));
    public static final RegistryObject<Block> CHISELED_BLUE_ICE_BRICKS = HELPER.createBlock("chiseled_blue_ice_bricks", () -> new Block(Properties.ICE_BRICKS));
    public static final RegistryObject<Block> BLUE_ICE_BRICK_STAIRS = HELPER.createBlock("blue_ice_brick_stairs", () -> new StairBlock(BLUE_ICE_BRICKS.get()::defaultBlockState, Properties.ICE_BRICKS));
    public static final RegistryObject<Block> BLUE_ICE_BRICK_SLAB = HELPER.createBlock("blue_ice_brick_slab", () -> new SlabBlock(Properties.ICE_BRICKS));
    public static final RegistryObject<Block> BLUE_ICE_BRICK_WALL = HELPER.createBlock("blue_ice_brick_wall", () -> new WallBlock(Properties.ICE_BRICKS)     );
    public static final RegistryObject<Block> BLUE_ICE_BRICK_VERTICAL_SLAB = HELPER.createBlock("blue_ice_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.ICE_BRICKS));

    // Snow Blocks //
    public static final RegistryObject<Block> SNOW_STAIRS = HELPER.createBlock("snow_stairs", () -> new StairBlock(Blocks.SNOW_BLOCK::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.SNOW_BLOCK)));
    public static final RegistryObject<Block> SNOW_SLAB = HELPER.createBlock("snow_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SNOW_BLOCK))     );
    public static final RegistryObject<Block> SNOW_VERTICAL_SLAB = HELPER.createBlock ("snow_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.SNOW_BLOCK)));

    public static final RegistryObject<Block> SNOW_BRICKS = HELPER.createBlock("snow_bricks", () -> new Block(Properties.SNOW_BRICKS)     );
    public static final RegistryObject<Block> SNOW_BRICK_STAIRS = HELPER.createBlock("snow_brick_stairs", () -> new StairBlock(SNOW_BRICKS.get()::defaultBlockState, Properties.SNOW_BRICKS));
    public static final RegistryObject<Block> SNOW_BRICK_SLAB = HELPER.createBlock("snow_brick_slab", () -> new SlabBlock(Properties.SNOW_BRICKS)     );
    public static final RegistryObject<Block> SNOW_BRICK_WALL = HELPER.createBlock("snow_brick_wall", () -> new WallBlock(Properties.SNOW_BRICKS)     );
    public static final RegistryObject<Block> SNOW_BRICK_VERTICAL_SLAB = HELPER.createBlock ("snow_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.SNOW_BRICKS)     );

    // Candy Cane Blocks //
    public static final RegistryObject<Block> CANDY_CANE_BLOCK = HELPER.createBlock("candy_cane_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_PILLAR))     );

    // Ginger Blocks //
    public static final RegistryObject<Block> GINGER_SOIL = HELPER.createBlock("ginger_soil", () -> new GingerSoilBlock(BlockBehaviour.Properties.of().strength(.5f).sound(SoundType.GRAVEL))     );
    public static final RegistryObject<Block> GINGER = HELPER.createBlockNoItem("ginger", () -> new GingerCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> GINGERBREAD_BLOCK = HELPER.createBlock("gingerbread_block", () -> new Block(Properties.GINGERBREAD)     );
    public static final RegistryObject<Block> GLAZED_GINGERBREAD_BLOCK = HELPER.createBlock("glazed_gingerbread_block", () -> new Block(Properties.GINGERBREAD)     );
    public static final RegistryObject<Block> GINGERBREAD_COOKIE_BLOCK = HELPER.createBlock("gingerbread_cookie_block", () -> new Block(Properties.GINGERBREAD)     );

    public static final RegistryObject<Block> GINGERBREAD_DOOR = HELPER.createBlock("gingerbread_door", () -> new DoorBlock(Properties.PINE.door(), WoodType.SPRUCE.setType()));
    public static final RegistryObject<Block> GINGERBREAD_TRAPDOOR = HELPER.createBlock("gingerbread_trapdoor", () -> new TrapDoorBlock(Properties.PINE.trapdoor(), WoodType.SPRUCE.setType()));

    public static final RegistryObject<Block> GINGERBREAD_BRICKS = HELPER.createBlock("gingerbread_bricks", () -> new Block(Properties.GINGERBREAD)     );
    public static final RegistryObject<Block> GINGERBREAD_BRICK_STAIRS = HELPER.createBlock("gingerbread_brick_stairs", () -> new StairBlock(GINGERBREAD_BRICKS.get()::defaultBlockState, Properties.GINGERBREAD)     );
    public static final RegistryObject<Block> GINGERBREAD_BRICK_SLAB = HELPER.createBlock("gingerbread_brick_slab", () -> new SlabBlock(Properties.GINGERBREAD)     );
    public static final RegistryObject<Block> GINGERBREAD_BRICK_WALL = HELPER.createBlock("gingerbread_brick_wall", () -> new WallBlock(Properties.GINGERBREAD)     );
    public static final RegistryObject<Block> GINGERBREAD_BRICK_VERTICAL_SLAB = HELPER.createBlock (   "gingerbread_brick_vertical_slab", () -> new VerticalSlabBlock(GINGERBREAD_BLOCK, Properties.GINGERBREAD)     );

    public static final RegistryObject<Block> GLAZED_GINGERBREAD_BRICKS = HELPER.createBlock("glazed_gingerbread_bricks", () -> new Block(Properties.GINGERBREAD)     );
    public static final RegistryObject<Block> GLAZED_GINGERBREAD_BRICK_STAIRS = HELPER.createBlock("glazed_gingerbread_brick_stairs", () -> new StairBlock(GLAZED_GINGERBREAD_BRICKS.get()::defaultBlockState, Properties.GINGERBREAD)     );
    public static final RegistryObject<Block> GLAZED_GINGERBREAD_BRICK_SLAB = HELPER.createBlock("glazed_gingerbread_brick_slab", () -> new SlabBlock(Properties.GINGERBREAD)     );
    public static final RegistryObject<Block> GLAZED_GINGERBREAD_BRICK_WALL = HELPER.createBlock("glazed_gingerbread_brick_wall", () -> new WallBlock(Properties.GINGERBREAD)     );
    public static final RegistryObject<Block> GLAZED_GINGERBREAD_BRICK_VERTICAL_SLAB = HELPER.createBlock (   "glazed_gingerbread_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.GINGERBREAD)     );

    // Lunalite //
    public static final RegistryObject<Block> LUNALITE = HELPER.createBlock("lunalite", () -> new LunaliteBlock(Properties.LUNALITE)     );
    public static final RegistryObject<Block> LUNALITE_STAIRS = HELPER.createBlock("lunalite_stairs", () -> new StairBlock(LUNALITE.get()::defaultBlockState, Properties.LUNALITE)     );
    public static final RegistryObject<Block> LUNALITE_SLAB = HELPER.createBlock("lunalite_slab", () -> new LunaliteSlabBlock(Properties.LUNALITE)     );
    public static final RegistryObject<Block> LUNALITE_WALL = HELPER.createBlock("lunalite_wall", () -> new WallBlock(Properties.LUNALITE)     );
    public static final RegistryObject<Block> LUNALITE_VERTICAL_SLAB = HELPER.createBlock (   "lunalite_vertical_slab", () -> new VerticalSlabBlock(Properties.LUNALITE)     );

    public static final RegistryObject<Block> CUT_LUNALITE = HELPER.createBlock("cut_lunalite", () -> new Block(Properties.LUNALITE)     );
    public static final RegistryObject<Block> CUT_LUNALITE_STAIRS = HELPER.createBlock("cut_lunalite_stairs", () -> new StairBlock(CUT_LUNALITE.get()::defaultBlockState, Properties.LUNALITE)     );
    public static final RegistryObject<Block> CUT_LUNALITE_SLAB = HELPER.createBlock("cut_lunalite_slab", () -> new SlabBlock(Properties.LUNALITE)     );
    public static final RegistryObject<Block> CUT_LUNALITE_WALL = HELPER.createBlock("cut_lunalite_wall", () -> new WallBlock(Properties.LUNALITE)     );
    public static final RegistryObject<Block> CUT_LUNALITE_VERTICAL_SLAB = HELPER.createBlock (   "cut_lunalite_vertical_slab", () -> new VerticalSlabBlock(LUNALITE,Properties.LUNALITE));

    public static final RegistryObject<Block> CUT_LUNALITE_BRICKS = HELPER.createBlock("cut_lunalite_bricks", () -> new Block(Properties.LUNALITE)     );
    public static final RegistryObject<Block> CHISELED_CUT_LUNALITE_BRICKS = HELPER.createBlock("chiseled_cut_lunalite_bricks", () -> new Block(Properties.LUNALITE)     );
    public static final RegistryObject<Block> CUT_LUNALITE_BRICK_STAIRS = HELPER.createBlock("cut_lunalite_brick_stairs", () -> new StairBlock(CUT_LUNALITE_BRICKS.get()::defaultBlockState, Properties.LUNALITE)     );
    public static final RegistryObject<Block> CUT_LUNALITE_BRICK_SLAB = HELPER.createBlock("cut_lunalite_brick_slab", () -> new SlabBlock(Properties.LUNALITE)     );
    public static final RegistryObject<Block> CUT_LUNALITE_BRICK_WALL = HELPER.createBlock("cut_lunalite_brick_wall", () -> new WallBlock(Properties.LUNALITE)     );
    public static final RegistryObject<Block> CUT_LUNALITE_BRICK_VERTICAL_SLAB = HELPER.createBlock (   "cut_lunalite_brick_vertical_slab", () -> new VerticalSlabBlock(CUT_LUNALITE_BRICKS,Properties.LUNALITE)     );

    public static final RegistryObject<Block> SMOOTH_LUNALITE = HELPER.createBlock("smooth_lunalite", () -> new Block(Properties.LUNALITE)     );
    public static final RegistryObject<Block> SMOOTH_LUNALITE_STAIRS = HELPER.createBlock("smooth_lunalite_stairs", () -> new StairBlock(SMOOTH_LUNALITE.get()::defaultBlockState, Properties.LUNALITE)     );
    public static final RegistryObject<Block> SMOOTH_LUNALITE_SLAB = HELPER.createBlock("smooth_lunalite_slab", () -> new SlabBlock(Properties.LUNALITE)     );
    public static final RegistryObject<Block> SMOOTH_LUNALITE_VERTICAL_SLAB = HELPER.createBlock (   "smooth_lunalite_vertical_slab", () -> new VerticalSlabBlock(SMOOTH_LUNALITE, Properties.LUNALITE)     );

    // Dry Mossy Blocks //
    public static final RegistryObject<Block> DRY_MOSSY_COBBLESTONE = HELPER.createBlock("dry_mossy_cobblestone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE))     );
    public static final RegistryObject<Block> DRY_MOSSY_COBBLESTONE_STAIRS = HELPER.createBlock("dry_mossy_cobblestone_stairs",() -> new StairBlock(DRY_MOSSY_COBBLESTONE.get()::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE))     );
    public static final RegistryObject<Block> DRY_MOSSY_COBBLESTONE_SLAB = HELPER.createBlock("dry_mossy_cobblestone_slab",  () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE))     );
    public static final RegistryObject<Block> DRY_MOSSY_COBBLESTONE_WALL = HELPER.createBlock("dry_mossy_cobblestone_wall",  () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE))     );
    public static final RegistryObject<Block> DRY_MOSSY_COBBLESTONE_VERTICAL_SLAB = HELPER.createBlock (   "dry_mossy_cobblestone_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(DRY_MOSSY_COBBLESTONE))     );

    public static final RegistryObject<Block> DRY_MOSSY_STONE_BRICKS = HELPER.createBlock("dry_mossy_stone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS))     );
    public static final RegistryObject<Block> DRY_MOSSY_STONE_BRICK_STAIRS = HELPER.createBlock("dry_mossy_stone_brick_stairs",  () -> new StairBlock(DRY_MOSSY_STONE_BRICKS.get()::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS))     );
    public static final RegistryObject<Block> DRY_MOSSY_STONE_BRICK_SLAB = HELPER.createBlock("dry_mossy_stone_brick_slab",() -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS))     );
    public static final RegistryObject<Block> DRY_MOSSY_STONE_BRICK_WALL = HELPER.createBlock("dry_mossy_stone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS))     );
    public static final RegistryObject<Block> DRY_MOSSY_STONE_BRICK_VERTICAL_SLAB = HELPER.createBlock (   "dry_mossy_stone_brick_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS))     );

    public static final RegistryObject<Block> DRY_MOSSY_COBBLESTONE_BRICKS = HELPER.createBlock("dry_mossy_cobblestone_bricks",  () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));
    public static final RegistryObject<Block> DRY_MOSSY_COBBLESTONE_BRICK_STAIRS = HELPER.createBlock("dry_mossy_cobblestone_brick_stairs",  () -> new StairBlock(DRY_MOSSY_COBBLESTONE_BRICKS.get()::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));
    public static final RegistryObject<Block> DRY_MOSSY_COBBLESTONE_BRICK_SLAB = HELPER.createBlock("dry_mossy_cobblestone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));
    public static final RegistryObject<Block> DRY_MOSSY_COBBLESTONE_BRICK_WALL = HELPER.createBlock("dry_mossy_cobblestone_brick_wall",  () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));
    public static final RegistryObject<Block> DRY_MOSSY_COBBLESTONE_BRICK_VERTICAL_SLAB = HELPER.createBlock("dry_mossy_cobblestone_brick_vertical_slab", () -> new VerticalSlabBlock(Blocks.MOSSY_STONE_BRICKS, Properties.)     ,    WindsweptConstants.CAVERNS_AND_CHASMS);

    public static final RegistryObject<Block> DRY_MOSSY_COBBLESTONE_TILES = HELPER.createBlock("dry_mossy_cobblestone_tiles",  () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));
    public static final RegistryObject<Block> DRY_MOSSY_COBBLESTONE_TILE_STAIRS = HELPER.createBlock("dry_mossy_cobblestone_tile_stairs",  () -> new StairBlock(DRY_MOSSY_COBBLESTONE_TILES.get()::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));
    public static final RegistryObject<Block> DRY_MOSSY_COBBLESTONE_TILE_SLAB = HELPER.createBlock("dry_mossy_cobblestone_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));
    public static final RegistryObject<Block> DRY_MOSSY_COBBLESTONE_TILE_WALL = HELPER.createBlock("dry_mossy_cobblestone_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));
    public static final RegistryObject<Block> DRY_MOSSY_COBBLESTONE_TILE_VERTICAL_SLAB = HELPER.createBlock ("dry_mossy_cobblestone_tile_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));

    // Compressed Blocks //
    public static final RegistryObject<Block> CHESTNUT_CRATE = HELPER.createFuelBlock("chestnut_crate", () -> new WindsweptCompressedBlock(Properties.CRATE), 300     );
    public static final RegistryObject<Block> ROASTED_CHESTNUT_CRATE = HELPER.createFuelBlock( "roasted_chestnut_crate", () -> new WindsweptCompressedBlock(Properties.CRATE), 300     );
    public static final RegistryObject<Block> GINGER_ROOT_CRATE = HELPER.createFuelBlock("ginger_root_crate", () -> new WindsweptCompressedBlock(Properties.CRATE), 300);
    public static final RegistryObject<Block> HOLLY_BERRY_BASKET = HELPER.createFuelBlock("holly_berry_basket", () -> new WindsweptCompressedBlock(Properties.CRATE), 300);
    public static final RegistryObject<Block> WILD_BERRY_BASKET = HELPER.createFuelBlock("wild_berry_basket", () -> new WindsweptCompressedBlock(Properties.CRATE), 300);
    public static final RegistryObject<Block> RED_MUSHROOM_BASKET = HELPER.createFuelBlock("red_mushroom_basket", () -> new WindsweptCompressedBlock(Properties.CRATE), 300);
    public static final RegistryObject<Block> BROWN_MUSHROOM_BASKET = HELPER.createFuelBlock("brown_mushroom_basket", () -> new WindsweptCompressedBlock(Properties.CRATE), 300);
    public static final RegistryObject<Block> GLOW_SHROOM_BASKET = HELPER.createFuelBlock("glow_shroom_basket", () -> new WindsweptCompressedBlock(BlockBehaviour.Properties.of().strength(1.5f).sound(SoundType.WOOD).lightLevel(s -> 12)), 300     );
    public static final RegistryObject<Block> FROZEN_FLESH_BLOCK = HELPER.createBlock("frozen_flesh_block", () -> new Block(BlockBehaviour.Properties.of().strength(.8f).sound(SoundType.CORAL_BLOCK)));

    // Pots //
    public static final RegistryObject<Block> POTTED_RED_ROSE = HELPER.createBlockNoItem("potted_red_rose", () -> new FlowerPotBlock(RED_ROSE.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_BLUE_ROSE = HELPER.createBlockNoItem("potted_blue_rose", () -> new FlowerPotBlock(BLUE_ROSE.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_WHITE_ROSE = HELPER.createBlockNoItem("potted_white_rose", () -> new FlowerPotBlock(WHITE_ROSE.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_YELLOW_ROSE = HELPER.createBlockNoItem("potted_yellow_rose", () -> new FlowerPotBlock(YELLOW_ROSE.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_FOXGLOVE = HELPER.createBlockNoItem("potted_foxglove", () -> new FlowerPotBlock(FOXGLOVE.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_BLUEBELLS = HELPER.createBlockNoItem("potted_bluebells", () -> new FlowerPotBlock(BLUEBELLS.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_SNOWDROP = HELPER.createBlockNoItem("potted_snowdrop", () -> new FlowerPotBlock(SNOWDROP.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_MOSS_CAMPION = HELPER.createBlockNoItem("potted_moss_campion", () -> new FlowerPotBlock(MOSS_CAMPION.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_WILD_GINGER = HELPER.createBlockNoItem("potted_wild_ginger", () -> new FlowerPotBlock(WILD_GINGER.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_NIGHTSHADE = HELPER.createBlockNoItem("potted_nightshade", () -> new NightShadeFlowerPotBlock(NIGHTSHADE.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().lightLevel(state -> 9)));
    public static final RegistryObject<Block> POTTED_SNOWY_SPROUTS = HELPER.createBlockNoItem("potted_snowy_sprouts", () -> new FlowerPotBlock(SNOWY_SPROUTS.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_GELISOL_SPROUTS = HELPER.createBlockNoItem("potted_gelisol_sprouts", () -> new FlowerPotBlock(GELISOL_SPROUTS.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_DRY_MOSSY_SPROUTS = HELPER.createBlockNoItem("potted_dry_mossy_sprouts", () -> new FlowerPotBlock(DRY_MOSSY_SPROUTS.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_MOSSY_SPROUTS = HELPER.createBlockNoItem("potted_mossy_sprouts", () -> new FlowerPotBlock(MOSSY_SPROUTS.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_LAVENDER = HELPER.createBlockNoItem("potted_lavender", () -> new FlowerPotBlock(LAVENDER.get(), PropertyUtil.flowerPot()));

    // Misc //
    public static final RegistryObject<Block> WILD_BERRY_BUSH = HELPER.createBlockNoItem("wild_berry_bush", () -> new WildBerryBushBlock(BlockBehaviour.Properties.of().randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH).offsetType(BlockBehaviour.OffsetType.XZ)));

    public static class Properties {
        // Wood Sets //
        public static final PropertyUtil.WoodSetProperties HOLLY = PropertyUtil.WoodSetProperties.builder(MapColor.COLOR_PURPLE).build();
        public static final PropertyUtil.WoodSetProperties CHESTNUT = PropertyUtil.WoodSetProperties.builder(MapColor.COLOR_BROWN).build();
        public static final PropertyUtil.WoodSetProperties PINE = PropertyUtil.WoodSetProperties.builder(MapColor.COLOR_BLACK).build();

        // Blocks //
        public static final BlockBehaviour.Properties SNOW_BRICKS = BlockBehaviour.Properties.of().strength(.85f).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties ICE_BRICKS = BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(2.8f).sound(SoundType.STONE);
        public static final BlockBehaviour.Properties CRATE = BlockBehaviour.Properties.of().strength(1.5f).sound(SoundType.WOOD);
        public static final BlockBehaviour.Properties SPROUTS = BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.NETHER_SPROUTS).offsetType(BlockBehaviour.OffsetType.XZ);
        public static final BlockBehaviour.Properties PINECONE_BLOCK = Block.Properties.of().strength(2f, 3f).sound(WindsweptSoundTypes.PINECONE);
        public static final BlockBehaviour.Properties SHALE = BlockBehaviour.Properties.of().sound(SoundType.DRIPSTONE_BLOCK).requiresCorrectToolForDrops().strength(1.5f, 1f);
        public static final BlockBehaviour.Properties LUNALITE = BlockBehaviour.Properties.of().sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(.8f);
        public static final BlockBehaviour.Properties GINGERBREAD = Block.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD);
        public static final BlockBehaviour.Properties FEATHER_ORNAMENT = Block.Properties.of().strength(.1f).noOcclusion().noCollission().sound(SoundType.AZALEA);
        public static final BlockBehaviour.Properties LAVENDER_THATCH = BlockBehaviour.Properties.of().strength(.5f).sound(SoundType.NETHER_SPROUTS).noOcclusion();
    }

}
