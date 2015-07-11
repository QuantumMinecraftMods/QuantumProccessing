package com.bigeebs.quantumprocessing.handler;


import com.bigeebs.quantumprocessing.reference.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;
    public static boolean configValue = false;

    public static void init(File configFile) {

        if (configuration == null) {
            //Create Config File
            configuration = new Configuration(configFile);
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)){

            //Reload Configuration
            loadConfiguration();
        }
    }

    public void loadConfiguration() {

        configValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, true, "Example config Value");

        if (configuration.hasChanged()){
            configuration.save();
        }
    }
}
