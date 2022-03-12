package com.trufflez.skiptransitions;

import com.trufflez.skiptransitions.config.Configs;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkipTransitions implements ModInitializer {
	public static final String MODID = "skiptransitions";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
	
	@Override
	public void onInitialize() {
		Configs.init();
		LOGGER.info("Skip Transitions loaded.");
	}
}
