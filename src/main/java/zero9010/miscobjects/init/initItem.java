package zero9010.miscobjects.init;

import cpw.mods.fml.common.registry.GameRegistry;
import zero9010.miscobjects.item.ItemRation;
import zero9010.miscobjects.reference.Names;
import zero9010.miscobjects.reference.Reference;


@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class initItem {

    public static final ItemRation ItemRation = new ItemRation();

    public static void init(){

        GameRegistry.registerItem(ItemRation, Names.Items.RATION);

    }

}
