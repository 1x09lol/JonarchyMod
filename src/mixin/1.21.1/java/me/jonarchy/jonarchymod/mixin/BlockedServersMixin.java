package me.jonarchy.jonarchymod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.mojang.patchy.BlockedServers;

@Mixin(BlockedServers.class)
public abstract class BlockedServersMixin {
	@Inject(method = "isBlockedServerHostName", at = @At("HEAD"), cancellable = true, remap = false)
	private static void jonarchymod$unblockAllServers(String hostName, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(false);
	}
}