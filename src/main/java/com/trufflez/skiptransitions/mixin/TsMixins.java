package com.trufflez.skiptransitions.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TitleScreen.class)
public class TsMixins {
	/*@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		SkipTransitions.LOGGER.info("This line is printed by an example mod mixin!");
	}*/
}
