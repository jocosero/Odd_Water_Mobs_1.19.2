package com.jocosero.odd_water_mobs.block.custom;

import com.jocosero.odd_water_mobs.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GiantTubeWorm extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final BooleanProperty IS_WORM_BASE = BooleanProperty.create("is_worm_base");

    public GiantTubeWorm(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(IS_WORM_BASE, false).setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(IS_WORM_BASE, WATERLOGGED);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos,
                                  BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
            if (facing == facing.UP) {
                return state.setValue(IS_WORM_BASE, isWormBase(facingState));
            }
        }
        return !state.canSurvive(world, currentPos)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }

    public boolean isWormBase(BlockState top) {
        return top.getBlock() == ModBlocks.GIANT_TUBE_WORM.get();
    }

    @Override
    public BlockPathTypes getAiPathNodeType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
        return BlockPathTypes.WALKABLE;
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    protected static boolean isInWater(BlockState state, BlockGetter world, BlockPos pos) {
        if (state.getValue(WATERLOGGED)) {
            return true;
        } else {
            for (Direction direction : Direction.values()) {
                if (world.getFluidState(pos.relative(direction)).is(FluidTags.WATER)) {
                    return true;
                }
            }

            return false;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(WATERLOGGED, fluidstate.is(FluidTags.WATER) && fluidstate.getOwnHeight() == 8);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(world, pos);
        return box(2, 0, 2, 14, 16, 14).move(offset.x, offset.y, offset.z);
    }

    @Override
    public boolean canSurvive(BlockState blockstate, LevelReader world, BlockPos pos) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        if (((world.getBlockState(new BlockPos(x, (y - 1), z))).getBlock() == Blocks.WATER)) {
            return (false);
        }
        if (world.getBlockState(pos.above()).isAir()) {

            return (false);
        }
        return (world.getBlockState(new BlockPos(x, (y - 1), z))).getBlock() == ModBlocks.DEEP_SAND.get() ||
                (world.getBlockState(new BlockPos(x, (y - 1), z))).getBlock() == ModBlocks.GIANT_TUBE_WORM.get();
    }
}
