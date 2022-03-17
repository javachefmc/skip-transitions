package com.trufflez.skiptransitions.mixin;

import com.trufflez.skiptransitions.config.Configs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.client.gui.components.toasts.ToastComponent$ToastInstance")
public class ToastComponentMixin {
    /*
    
    Toasts
    - Removes sliding animation for toasts
    
     */
	
	@Inject(method = "getVisibility", at = @At("HEAD"), cancellable = true)
	public void getVisibility(CallbackInfoReturnable<Float> cir) {
		if(Configs.REMOVE_TOASTS_SLIDE) {
			cir.setReturnValue(1.0F);
		}
	}
}