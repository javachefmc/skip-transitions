package com.trufflez.skiptransitions;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trufflez.skiptransitions.config.ModConfig;

@Environment(EnvType.CLIENT)
public class SkipTransitions implements ClientModInitializer {
	public static final String MODID = "skiptransitions";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
	
	@Override
	public void onInitializeClient() {
		ModConfig.init();
		LOGGER.info("Skip Transitions loaded.");
	}
}
