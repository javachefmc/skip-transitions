package com.trufflez.skiptransitions.mixin;

import com.trufflez.skiptransitions.SkipTransitions;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.SplashOverlay;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.resource.ResourceReload;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;
import java.util.function.Consumer;

@Mixin(SplashOverlay.class)
public class SplashOverlayMixin {
    /*
    
    Splash on startup
    Change resourcepack
    - Mojang logo fade out covers up buttons
    TODO: Mojang logo fade in
    - I really don't like the fades  
    
     */

	@Shadow @Final private MinecraftClient client;	// Access the client
	@Shadow private long reloadCompleteTime;		// Checks when to do what
	
	@Inject(at = @At("HEAD"), method = "render")
	public void render(CallbackInfo ci) { 
		if (this.reloadCompleteTime > 1) {
			this.client.setOverlay(null); // Only remove the Mojang overlay when it's unnecessary
		}
		SkipTransitions.LOGGER.debug("Splash screen mixin injected");
	}
}