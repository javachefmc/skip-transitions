package com.trufflez.skiptransitions.mixin;

import com.trufflez.skiptransitions.config.Configs;
import net.minecraft.client.toast.Toast;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.client.toast.ToastManager$Entry")
public class ToastManagerMixin {
    /*
    
    Toasts
    - Removes sliding animation for toasts
    
     */
	
	@Inject(method = "getDisappearProgress", at = @At("HEAD"), cancellable = true)
	public void getDisappearProgress(CallbackInfoReturnable<Float> cir) {
		if(Configs.REMOVE_TOASTS_SLIDE) {
			cir.setReturnValue(1.0F);
		}
	}
}