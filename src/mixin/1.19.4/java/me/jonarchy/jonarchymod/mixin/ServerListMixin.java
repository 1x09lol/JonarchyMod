package me.jonarchy.jonarchymod.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.jonarchy.jonarchymod.JonarchyMod;
import net.minecraft.client.network.ServerInfo;
@Mixin(net.minecraft.client.option.ServerList.class)
public abstract class ServerListMixin {
	@Shadow
	@Final
	private List<net.minecraft.client.network.ServerInfo> servers;

	@Inject(method = "loadFile", at = @At("TAIL"))
	private void jonarchymod$keepJonarchyOnTop(CallbackInfo ci) {
		net.minecraft.client.network.ServerInfo existing = null;

		for (net.minecraft.client.network.ServerInfo server : this.servers) {
			if (JonarchyMod.SERVER_ADDRESS.equalsIgnoreCase(server.address)) {
				existing = server;
				break;
			}
		}

		if (existing == null) {
			this.servers.add(0, new net.minecraft.client.network.ServerInfo(JonarchyMod.SERVER_NAME, JonarchyMod.SERVER_ADDRESS, false));
			JonarchyMod.LOGGER.info("Added Jonarchy to the top of the server list.");
		} else if (this.servers.indexOf(existing) != 0) {
			this.servers.remove(existing);
			this.servers.add(0, existing);
			JonarchyMod.LOGGER.info("Moved Jonarchy to the top of the server list.");
		}
	}
}
