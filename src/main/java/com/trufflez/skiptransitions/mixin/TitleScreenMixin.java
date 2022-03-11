package com.trufflez.skiptransitions.mixin;

import com.trufflez.skiptransitions.SkipTransitions;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    /*
    
    Title screen
    - buttons fade in
    
     */
	
	@Mutable
	@Shadow @Final private boolean doBackgroundFade;

	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo ci) {
		
		this.doBackgroundFade = false;
		
		SkipTransitions.LOGGER.debug("Title screen mixin injected");
	}
}