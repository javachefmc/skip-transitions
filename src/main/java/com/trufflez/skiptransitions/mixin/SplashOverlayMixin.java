package com.trufflez.skiptransitions.mixin;

import com.trufflez.skiptransitions.config.Configs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.SplashOverlay;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SplashOverlay.class)
public class SplashOverlayMixin {
    /*
    
    Splash on startup
    Change resourcepack
    - Splash screen fade out covers up buttons
    - Removes fade in for both background and logo
    
     */
	
	
	@Mutable @Shadow @Final private MinecraftClient client;	// Access the client
	@Shadow private long reloadCompleteTime;				// Checks when to do what
	
	@Inject(method = "render", at = @At("HEAD"))
	public void render2(CallbackInfo ci) {
		if(Configs.REMOVE_SPLASH_FADE) {
			if (this.reloadCompleteTime > 1) {
				this.client.setOverlay(null); // Only remove the overlay when it's unnecessary
			}
		}
	}
	
	@ModifyVariable(method = "withAlpha", at = @At("HEAD"), ordinal = 1, argsOnly = true)
	private static int alpha(int value) {
		if(Configs.REMOVE_SPLASH_FADE) {
			return 255; // This method gets called for determining background color transparency
		} else return value;
	}

	@ModifyVariable(method = "render", at = @At("STORE"), name = "h")
	private float h(float value) {
		if(Configs.REMOVE_SPLASH_FADE) {
			return 1.0f; // This parameter is used for the Mojang logo transparency
		} else return value;
	}
	
}