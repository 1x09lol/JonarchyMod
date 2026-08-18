package me.jonarchy.jonarchymod;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JonarchyMod implements ClientModInitializer {
	public static final String MOD_ID = "jonarchymod";
	public static final String SERVER_NAME = "Jonarchy";
	public static final String SERVER_ADDRESS = "jonarchy.com";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
		LOGGER.info("JonarchyMod loaded! Jonarchy will always be at the top of your server list.");
	}
}
