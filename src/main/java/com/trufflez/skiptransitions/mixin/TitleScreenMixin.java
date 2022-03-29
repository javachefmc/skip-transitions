package com.trufflez.skiptransitions.mixin;

import com.trufflez.skiptransitions.config.Configs;
import net.minecraft.client.gui.screens.TitleScreen;
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
    - background fades in
    
     */
	
	@Mutable
	@Shadow @Final private boolean fading;

	@Inject(at = @At("TAIL"), method = "init()V")
	private void init(CallbackInfo ci) {
		if(Configs.REMOVE_TITLE_SCREEN_FADE) {
			this.fading = false;
		}
	}
}