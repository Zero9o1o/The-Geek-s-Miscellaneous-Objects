package zero9010.miscobjects;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import zero9010.miscobjects.reference.Reference;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION)
public class MiscellaneousObjects
{

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event){
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event){
    }
}
