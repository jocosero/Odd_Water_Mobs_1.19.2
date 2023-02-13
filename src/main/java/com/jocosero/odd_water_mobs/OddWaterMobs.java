package com.jocosero.odd_water_mobs;

import com.jocosero.odd_water_mobs.block.ModBlocks;
import com.jocosero.odd_water_mobs.effect.ModEffects;
import com.jocosero.odd_water_mobs.entity.ModEntityTypes;
import com.jocosero.odd_water_mobs.item.ModItems;
import com.jocosero.odd_water_mobs.painting.ModPaintings;
import com.jocosero.odd_water_mobs.particle.ModParticles;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OddWaterMobs.MOD_ID)
public class OddWaterMobs {
    public static final String MOD_ID = "odd_water_mobs";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public OddWaterMobs() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModPaintings.register(eventBus);
        ModEntityTypes.register(eventBus);

        ModParticles.register(eventBus);
        ModEffects.register(eventBus);

        eventBus.addListener(this::setup);

        GeckoLib.initialize();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }


    private void setup(final FMLCommonSetupEvent event) {
    }

}
