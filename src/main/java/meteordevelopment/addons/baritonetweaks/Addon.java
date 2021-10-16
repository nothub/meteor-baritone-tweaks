package meteordevelopment.addons.baritonetweaks;

import meteordevelopment.addons.baritonetweaks.modules.BaritoneTweaks;
import meteordevelopment.meteorclient.MeteorAddon;
import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

public class Addon extends MeteorAddon {

	public static final Logger LOG = LogManager.getLogger();

	@Override
	public void onInitialize() {
        LOG.info("Initializing Baritone Tweaks Addon");

		// Required when using @EventHandler
        MeteorClient.EVENT_BUS.registerLambdaFactory("meteordevelopment.addons.baritonetweaks", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));

		// Modules
		Modules.get().add(new BaritoneTweaks());
	}

}
