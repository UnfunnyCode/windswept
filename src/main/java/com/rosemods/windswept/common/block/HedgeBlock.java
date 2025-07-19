//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.rosemods.windswept.common.block;

import com.google.common.collect.ImmutableList;
import com.rosemods.windswept.core.other.tags.WindsweptBlockTags;
import com.teamabnormals.blueprint.core.other.tags.BlueprintBlockTags;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

public class HedgeBlock extends FenceBlock {
    private static final BooleanProperty EXTEND = BooleanProperty.create("extend");
    private static final VoxelShape WOOD_SHAPE = box((double)6.0F, (double)0.0F, (double)6.0F, (double)10.0F, (double)15.0F, (double)10.0F);
    private static final VoxelShape HEDGE_CENTER_SHAPE = box((double)2.0F, (double)1.0F, (double)2.0F, (double)14.0F, (double)16.0F, (double)14.0F);
    private static final VoxelShape NORTH_SHAPE = box((double)2.0F, (double)1.0F, (double)0.0F, (double)14.0F, (double)16.0F, (double)2.0F);
    private static final VoxelShape SOUTH_SHAPE = box((double)2.0F, (double)1.0F, (double)14.0F, (double)14.0F, (double)16.0F, (double)15.0F);
    private static final VoxelShape EAST_SHAPE = box((double)14.0F, (double)1.0F, (double)2.0F, (double)16.0F, (double)16.0F, (double)14.0F);
    private static final VoxelShape WEST_SHAPE = box((double)0.0F, (double)1.0F, (double)2.0F, (double)2.0F, (double)16.0F, (double)14.0F);
    private static final VoxelShape EXTEND_SHAPE = box((double)2.0F, (double)0.0F, (double)2.0F, (double)14.0F, (double)1.0F, (double)14.0F);
    private final Object2IntMap<BlockState> hedgeStateToIndex;
    private final VoxelShape[] hedgeShapes;

    public HedgeBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)this.defaultBlockState().setValue(EXTEND, false));
        this.hedgeStateToIndex = new Object2IntOpenHashMap();
        this.hedgeShapes = this.cacheHedgeShapes(this.stateDefinition.getPossibleStates());
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx) {
        return this.hedgeShapes[this.getHedgeAABBIndex(state)];
    }

    private VoxelShape[] cacheHedgeShapes(ImmutableList<BlockState> possibleStates) {
        VoxelShape[] shapes = new VoxelShape[possibleStates.size()];

        for(int i = 0; i < shapes.length; ++i) {
            BlockState state = (BlockState)possibleStates.get(i);
            int realIndex = this.getHedgeAABBIndex(state);
            VoxelShape finishedShape = Shapes.or((Boolean)state.getValue(EXTEND) ? EXTEND_SHAPE : WOOD_SHAPE, HEDGE_CENTER_SHAPE);
            if ((Boolean)state.getValue(FenceBlock.NORTH)) {
                finishedShape = Shapes.or(finishedShape, NORTH_SHAPE);
            }

            if ((Boolean)state.getValue(FenceBlock.SOUTH)) {
                finishedShape = Shapes.or(finishedShape, SOUTH_SHAPE);
            }

            if ((Boolean)state.getValue(FenceBlock.EAST)) {
                finishedShape = Shapes.or(finishedShape, EAST_SHAPE);
            }

            if ((Boolean)state.getValue(FenceBlock.WEST)) {
                finishedShape = Shapes.or(finishedShape, WEST_SHAPE);
            }

            shapes[realIndex] = finishedShape;
        }

        return shapes;
    }

    protected int getHedgeAABBIndex(BlockState curr) {
        return this.hedgeStateToIndex.computeIntIfAbsent(curr, (state) -> {
            int i = 0;
            if ((Boolean)state.getValue(FenceBlock.NORTH)) {
                i |= 1;
            }

            if ((Boolean)state.getValue(FenceBlock.SOUTH)) {
                i |= 2;
            }

            if ((Boolean)state.getValue(FenceBlock.EAST)) {
                i |= 4;
            }

            if ((Boolean)state.getValue(FenceBlock.WEST)) {
                i |= 8;
            }

            if ((Boolean)state.getValue(EXTEND)) {
                i |= 16;
            }

            return i;
        });
    }

    public boolean connectsTo(BlockState state, boolean isSideSolid, Direction direction) {
        return state.is(WindsweptBlockTags.HEDGES);
    }

    public boolean canSustainPlant(BlockState state, BlockGetter getter, BlockPos pos, Direction facing, IPlantable plantable) {
        return facing == Direction.UP && !(Boolean)state.getValue(WATERLOGGED) && plantable.getPlantType(getter, pos) == PlantType.PLAINS;
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return (BlockState)super.getStateForPlacement(context).setValue(EXTEND, context.getLevel().getBlockState(context.getClickedPos().below()).is(WindsweptBlockTags.HEDGES));
    }

    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if ((Boolean)stateIn.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return facing == Direction.DOWN ? (BlockState)stateIn.setValue(EXTEND, facingState.is(WindsweptBlockTags.HEDGES)) : super.updateShape(stateIn, facing, facingState, level, currentPos, facingPos);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{EXTEND});
    }
}
