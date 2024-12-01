package com.javachef.skiptransitions;

import com.javachef.skiptransitions.config.Configs;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class SkipTransitions implements ClientModInitializer {
	public static final String MODID = "skiptransitions";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
	
	@Override
	public void onInitializeClient() {
		Configs.init();
		LOGGER.info("Skip Transitions loaded.");
	}
}
