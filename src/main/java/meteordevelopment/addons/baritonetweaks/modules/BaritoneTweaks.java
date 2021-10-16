package meteordevelopment.addons.baritonetweaks.modules;

import baritone.api.BaritoneAPI;
import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.BoolSetting;
import meteordevelopment.meteorclient.settings.IntSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;

public class BaritoneTweaks extends Module {

    private final SettingGroup sgSmartSprint = settings.createGroup("Smart Sprint");

    private final Setting<Boolean> smartSprintActive = sgSmartSprint.add(new BoolSetting.Builder()
        .name("active")
        .description("Sprint with enough food saturation only.")
        .defaultValue(true)
        .build()
    );

    private final Setting<Integer> smartSprintHunger = sgSmartSprint.add(new IntSetting.Builder()
        .name("hunger")
        .description("Smart sprint minimum food saturation level.")
        .defaultValue(8)
        .sliderMin(1)
        .sliderMax(20)
        .build()
    );

    public BaritoneTweaks() {
        super(Categories.Misc, "baritone-tweaks", "Various baritone related tweaks.");
    }

    @EventHandler
    private void onTickPost(TickEvent.Post event) {
        if (smartSprintActive.get()) {
            if (mc.player.getHungerManager().getFoodLevel() >= smartSprintHunger.get()) {
                BaritoneAPI.getSettings().allowSprint.value = true;
            } else {
                BaritoneAPI.getSettings().allowSprint.value = false;
            }
        }
    }

}
