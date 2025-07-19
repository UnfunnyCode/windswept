//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.rosemods.windswept.core.registry.util;

import java.util.function.Supplier;

import com.teamabnormals.blueprint.core.util.registry.AbstractSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public class BiomeSubRegistryHelper extends AbstractSubRegistryHelper<Biome> {
    public BiomeSubRegistryHelper(RegistryHelper parent, DeferredRegister<Biome> deferredRegister) {
        super(parent, deferredRegister);
    }

    public BiomeSubRegistryHelper(RegistryHelper parent) {
        super(parent, DeferredRegister.create(ForgeRegistries.BIOMES, parent.getModId()));
    }

    public KeyedBiome createBiome(String name, Supplier<Biome> biome) {
        return new KeyedBiome(this.deferredRegister.register(name, biome));
    }

    public static final class KeyedBiome {
        private static final ForgeRegistry<Biome> BIOME_REGISTRY;
        private final RegistryObject<Biome> biome;
        private final LazyLoadedValue<ResourceKey<Biome>> lazyKey;

        public KeyedBiome(RegistryObject<Biome> biome) {
            this.biome = biome;
            this.lazyKey = new LazyLoadedValue(() -> BIOME_REGISTRY.getKey(BIOME_REGISTRY.getID((Biome)this.biome.get())));
        }

        public Biome get() {
            return (Biome)this.biome.get();
        }

        public RegistryObject<Biome> getObject() {
            return this.biome;
        }

        public ResourceKey<Biome> getKey() {
            return (ResourceKey)this.lazyKey.get();
        }

        static {
            BIOME_REGISTRY = (ForgeRegistry)ForgeRegistries.BIOMES;
        }
    }
}
