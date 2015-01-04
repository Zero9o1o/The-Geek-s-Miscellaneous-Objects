package zero9010.miscobjects.init;

import cpw.mods.fml.common.registry.GameRegistry;
import zero9010.miscobjects.tileEntity.TileEntityTent;

/**
 * Created by Arceusthepokemon on 1/4/2015.
 */
public class initTileEntities {

    public static void init(){


        GameRegistry.registerTileEntity(TileEntityTent.class, "TileEntityTent");

    }

}
