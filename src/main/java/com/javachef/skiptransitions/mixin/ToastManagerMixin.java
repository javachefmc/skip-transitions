package com.javachef.skiptransitions.mixin;

import com.javachef.skiptransitions.config.Configs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.minecraft.client.gui.components.toasts.ToastManager$ToastInstance")
public class ToastManagerMixin {
    /*
    
    Toasts
    - Removes sliding animation for toasts
    
     */

	@Shadow private float visiblePortion;

	@Inject(method = "calculateVisiblePortion", at = @At("TAIL"))
	private void calculateVisiblePortion(long l, CallbackInfo ci) {
		if(Configs.REMOVE_TOASTS_SLIDE){
			this.visiblePortion = 1F;
		}
	}

	// This approach is viable but not easy to support with configuration:
	/*
	@Shadow private float visiblePortion = 1F;
	@Overwrite
	private void calculateVisiblePortion(long l) {}
	*/
}