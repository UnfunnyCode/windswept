
package com.rosemods.windswept.core.other.events;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event.HasResult;
import org.jetbrains.annotations.Nullable;

public class LivingSpawnEvent extends LivingEvent {
    private final LevelAccessor level;
    private final Mob mob;
    private final double x;
    private final double y;
    private final double z;

    public LivingSpawnEvent(Mob mob, LevelAccessor level, double x, double y, double z) {
        super(mob);
        this.mob = mob;
        this.level = level;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Mob getEntity() {
        return this.mob;
    }

    public LevelAccessor getLevel() {
        return this.level;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    @HasResult
    public static class CheckSpawn extends LivingSpawnEvent {
        private final @Nullable BaseSpawner spawner;
        private final MobSpawnType spawnReason;

        public CheckSpawn(Mob mob, LevelAccessor level, double x, double y, double z, @Nullable BaseSpawner spawner, MobSpawnType spawnReason) {
            super(mob, level, x, y, z);
            this.spawner = spawner;
            this.spawnReason = spawnReason;
        }

        public boolean isSpawner() {
            return this.spawner != null;
        }

        public @Nullable BaseSpawner getSpawner() {
            return this.spawner;
        }

        public MobSpawnType getSpawnReason() {
            return this.spawnReason;
        }
    }

    @Cancelable
    public static class SpecialSpawn extends LivingSpawnEvent {
        private final @Nullable BaseSpawner spawner;
        private final MobSpawnType spawnReason;

        public SpecialSpawn(Mob entity, LevelAccessor level, double x, double y, double z, @Nullable BaseSpawner spawner, MobSpawnType spawnReason) {
            super(entity, level, x, y, z);
            this.spawner = spawner;
            this.spawnReason = spawnReason;
        }

        public @Nullable BaseSpawner getSpawner() {
            return this.spawner;
        }

        public MobSpawnType getSpawnReason() {
            return this.spawnReason;
        }
    }

    @HasResult
    public static class AllowDespawn extends LivingSpawnEvent {
        public AllowDespawn(Mob mob) {
            super(mob, mob.level(), mob.getX(), mob.getY(), mob.getZ());
        }
    }
}
