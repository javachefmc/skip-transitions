package com.trufflez.skiptransitions.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "skiptransitions")
public class ModConfig implements ConfigData {
    @ConfigEntry.Gui.Excluded
	public static ModConfig INSTANCE;

	public static void init() {
		AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
		INSTANCE = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
	}

    
    @Comment("\n Skip Transitions\n by TrufflezMC\n\n\n Remove fade animations on the title screen (default=true)")
    public boolean removeTitleScreenFade = true;

    @Comment("\n\n Remove fade animation for Mojang logo when applying resourcepack changes (default=true)")
    public boolean removeSplashFade = true;

    @Comment("\n\n Remove slide animation for advancements, recipes, etc (default=true)")
    public boolean removeToastsSlide = true;

    @Comment("\n\n Remove the associated \"whoosh\" sound effect (default=true)")
    public boolean removeToastsSFX = true;
}
