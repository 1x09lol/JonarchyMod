package me.jonarchy.jonarchymod.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.jonarchy.jonarchymod.JonarchyMod;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerData.Type;
@Mixin(net.minecraft.client.multiplayer.ServerList.class)
public abstract class ServerListMixin {
	@Shadow
	@Final
	private List<ServerData> serverList;

	@Inject(method = "load", at = @At("TAIL"))
	private void jonarchymod$keepJonarchyOnTop(CallbackInfo ci) {
		ServerData existing = null;

		for (ServerData server : this.serverList) {
			if (JonarchyMod.SERVER_ADDRESS.equalsIgnoreCase(server.ip)) {
				existing = server;
				break;
			}
		}

		if (existing == null) {
			this.serverList.add(0, new ServerData(JonarchyMod.SERVER_NAME, JonarchyMod.SERVER_ADDRESS, Type.OTHER));
			JonarchyMod.LOGGER.info("Added Jonarchy to the top of the server list.");
		} else if (this.serverList.indexOf(existing) != 0) {
			this.serverList.remove(existing);
			this.serverList.add(0, existing);
			JonarchyMod.LOGGER.info("Moved Jonarchy to the top of the server list.");
		}
	}
}
