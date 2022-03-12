package com.trufflez.skiptransitions.mixin;

import com.trufflez.skiptransitions.config.Configs;
import net.minecraft.client.sound.SoundManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.client.toast.Toast$Visibility")
public class ToastMixin {
    /*
    
    Toasts
    - Removes sound effect for toasts
    
     */
	
	@Inject(method = "playSound", at = @At("HEAD"), cancellable = true)
	public void playSound(SoundManager soundManager, CallbackInfo ci) {
		if(Configs.REMOVE_TOASTS_SOUND_EFFECT) {
			ci.cancel();
		}
	}
}