package zero9010.miscobjects.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.StatCollector;

import zero9010.miscobjects.reference.Reference;
import zero9010.miscobjects.init.initItem;

public class creativeTab {

    public static  final CreativeTabs miscobjects = new CreativeTabs(Reference.MOD_ID) {
        @Override
        public Item getTabIconItem() {

            return initItem.ItemRation;

        }

        @Override
        @SideOnly(Side.CLIENT)
        public String getTranslatedTabLabel()
        {
            return StatCollector.translateToLocal("key.categories.miscobjects");
        }

    };

}
