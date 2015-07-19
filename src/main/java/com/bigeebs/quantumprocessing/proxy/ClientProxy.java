package com.bigeebs.quantumprocessing.proxy;

import com.bigeebs.quantumprocessing.init.ModItems;

/**
 * Created by bigee_000 on 7/3/2015.
 */
public class ClientProxy extends CommonProxy {

    public ClientProxy() {
        super();
    }

    @Override
    public void registerRenders()
    {
        ModItems.registerRenders();
    }
}
