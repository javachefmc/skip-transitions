package com.trufflez.skiptransitions.mixin;

import com.trufflez.skiptransitions.config.ModConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.LoadingOverlay;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LoadingOverlay.class)
public class LoadingOverlayMixin {
    /*
    
    Splash on startup
    Change resourcepack
    - Splash screen fade out covers up buttons
    - Removes fade in for both background and logo
    
     */
	
	
	@Mutable @Shadow @Final private Minecraft minecraft;	// Access the client
	@Shadow private long fadeOutStart;				// Checks when to do what
	
	@Inject(method = "render", at = @At("HEAD"))
	public void render2(CallbackInfo ci) {
		if(ModConfig.INSTANCE.removeSplashFade) {
			if (this.fadeOutStart > 1) {
				this.minecraft.setOverlay(null); // Only remove the overlay when it's unnecessary
			}
		}
	}
	
	@ModifyVariable(method = "replaceAlpha", at = @At("HEAD"), ordinal = 1, argsOnly = true)
	private static int alpha(int value) {
		if(ModConfig.INSTANCE.removeSplashFade) {
			return 255; // This method gets called for determining background color transparency
		} else return value;
	}

	@ModifyVariable(method = "render", at = @At("STORE"), ordinal = 3)
	private float o(float value) {
		if(ModConfig.INSTANCE.removeSplashFade) {
			return 1.0f; // This parameter is used for the Mojang logo transparency
		} else return value;
	}
	
}