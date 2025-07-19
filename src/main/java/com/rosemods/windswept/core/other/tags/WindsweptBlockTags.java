package com.rosemods.windswept.core.other.tags;

import com.rosemods.windswept.core.Windswept;
import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class WindsweptBlockTags {
    public static final TagKey<Block> HOLLY_LOGS = TagUtil.blockTag(Windswept.MOD_ID, "holly_logs");
    public static final TagKey<Block> CHESTNUT_LOGS = TagUtil.blockTag(Windswept.MOD_ID, "chestnut_logs");
    public static final TagKey<Block> PINE_LOGS = TagUtil.blockTag(Windswept.MOD_ID, "pine_logs");
    public static final TagKey<Block> LUNALITE = TagUtil.blockTag(Windswept.MOD_ID, "lunalite");
    public static final TagKey<Block> SNOW_BOOTS_BLOCKS = TagUtil.blockTag(Windswept.MOD_ID, "snow_boots_blocks");
    public static final TagKey<Block> DEFAULT_WHITE_TEXT = TagUtil.blockTag(Windswept.MOD_ID, "default_white_text");
    public static final TagKey<Block> PLENTY_CANNOT_PLACE = TagUtil.blockTag(Windswept.MOD_ID, "plenty_cannot_place");
    public static final TagKey<Block> HEDGES = TagUtil.blockTag(Windswept.MOD_ID, "hedges");
    public static final TagKey<Block> MINEABLE_KNIFE = TagUtil.blockTag("farmersdelight", "mineable/knife");
}
