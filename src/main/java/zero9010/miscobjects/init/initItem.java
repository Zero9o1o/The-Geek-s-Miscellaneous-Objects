package zero9010.miscobjects.init;

import cpw.mods.fml.common.registry.GameRegistry;
import zero9010.miscobjects.item.ItemKnife;
import zero9010.miscobjects.item.ItemRation;
import zero9010.miscobjects.item.ItemSteakStrips;
import zero9010.miscobjects.item.ItemToast;
import zero9010.miscobjects.reference.Names;
import zero9010.miscobjects.reference.Reference;


@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class initItem {

    public static final ItemRation ItemRation = new ItemRation();
    public static final ItemKnife ItemKnife = new ItemKnife();
    public static final ItemToast ItemToast = new ItemToast();
    public static final ItemSteakStrips ItemSteakStrips = new ItemSteakStrips();

    public static void init(){

        GameRegistry.registerItem(ItemRation, Names.Items.RATION);
        GameRegistry.registerItem(ItemKnife, Names.Weapons.KNIFE);
        GameRegistry.registerItem(ItemToast, Names.Items.TOAST);
        GameRegistry.registerItem(ItemSteakStrips, Names.Items.STEAKSTRIPS);

    }

}
