package com.trufflez.skiptransitions.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

@Config(name = "skiptransitions")
public class ModConfig implements ConfigData {
    
    @ConfigEntry.Gui.Excluded
	public static ModConfig INSTANCE;

	public static void init() {
		AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
		INSTANCE = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
	}

    public boolean removeTitleScreenFade = true;
    public boolean removeSplashFade = true;
    public boolean removeToastsSlide = true;
    public boolean removeToastsSFX = true;
}
