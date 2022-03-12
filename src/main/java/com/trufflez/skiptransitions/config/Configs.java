package com.trufflez.skiptransitions.config;

import com.mojang.datafixers.util.Pair;

public class Configs {
    public static SimpleConfig CONFIG;
    private static ConfigProvider configs;
    
    public static boolean REMOVE_SPLASH_FADE;
    public static boolean REMOVE_TITLE_SCREEN_FADE;
    public static boolean REMOVE_TOASTS_SLIDE;
    public static boolean REMOVE_TOASTS_SOUND_EFFECT;
    
    public static void init() {
        configs = new ConfigProvider();
        createConfigs();
        
        CONFIG = SimpleConfig.of("SkipTransitions").provider(configs).request();
        
        assignConfigs();
    }

    private static void createConfigs() {
        configs.append("\n# Skip Transitions\n# by TrufflezMC\n");
        configs.append("\n# Remove fade animations on the title screen (default=true)");
        configs.addKeyValuePair(new Pair<>("removeTitleScreenFade", true));
        configs.append("\n# Remove fade animation for Mojang logo when applying resourcepack changes (default=true)");
        configs.addKeyValuePair(new Pair<>("removeSplashFade", true));
        configs.append("\n# Remove slide animation for advancements, recipes, etc (default=true)");
        configs.addKeyValuePair(new Pair<>("removeToastsSlide", true));
        configs.append("\n# Remove the associated \"whoosh\" sound effect (default=true)");
        configs.addKeyValuePair(new Pair<>("removeToastsSFX", true));
    }
    
    private static void assignConfigs() {
        REMOVE_SPLASH_FADE = CONFIG.getOrDefault("removeSplashFade", true);
        REMOVE_TITLE_SCREEN_FADE = CONFIG.getOrDefault("removeTitleScreenFade", true);
        REMOVE_TOASTS_SLIDE = CONFIG.getOrDefault("removeToastsSlide", true);
        REMOVE_TOASTS_SOUND_EFFECT = CONFIG.getOrDefault("removeToastsSFX", true);
    }
}
