package com.bigeebs.quantumprocessing.item;

import net.minecraft.item.Item;

/**
 * Created by Andrew.Ebert on 7/11/2015.
 */
public class QPItem extends Item {

    public QPItem() {
        super();
    }

    public String getUnlocalizedName() {
        return String.format("item.%s%s", "", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    public String getUnwrappedUnlocalizedName(String unlocalizedName) {

        return unlocalizedName.substring(unlocalizedName.indexOf(".")+1);
    }
}
