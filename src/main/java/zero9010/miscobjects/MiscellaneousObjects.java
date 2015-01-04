package zero9010.miscobjects;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import zero9010.miscobjects.init.craftingRecipes;
import zero9010.miscobjects.init.initBlocks;
import zero9010.miscobjects.init.initItem;
import zero9010.miscobjects.init.initTileEntities;
import zero9010.miscobjects.proxy.CommonProxy;
import zero9010.miscobjects.reference.Reference;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION)
public class MiscellaneousObjects
{

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event){

        initItem.init();
        initBlocks.init();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

        craftingRecipes.init();
        initTileEntities.init();
        proxy.initRenderers();

    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event){
    }
}
