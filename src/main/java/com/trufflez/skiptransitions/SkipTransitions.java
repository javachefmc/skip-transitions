package com.trufflez.skiptransitions;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkipTransitions implements ModInitializer {
	public static final String MODID = "skiptransitions";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
	
	@Override
	public void onInitialize() {
		LOGGER.info("Skip Transitions loaded.");
	}
}
