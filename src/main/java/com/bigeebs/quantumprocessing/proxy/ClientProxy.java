package com.bigeebs.quantumprocessing.proxy;

import com.bigeebs.quantumprocessing.client.settings.Keybindings;
import com.bigeebs.quantumprocessing.init.ModBlocks;
import com.bigeebs.quantumprocessing.init.ModItems;
import com.bigeebs.quantumprocessing.utility.LogHelper;
import net.minecraftforge.fml.client.registry.ClientRegistry;

/**
 * Created by bigee_000 on 7/3/2015.
 */
public class ClientProxy extends CommonProxy {

    public ClientProxy() {

    }

    @Override
    public void registerRenders()
    {
        ModItems.registerRenders();
        ModBlocks.registerRenders();
    }

    @Override
    public void registerKeyBindings() {
        //Register any keybindings
        ClientRegistry.registerKeyBinding(Keybindings.charge);
        ClientRegistry.registerKeyBinding(Keybindings.release);
    }
}
