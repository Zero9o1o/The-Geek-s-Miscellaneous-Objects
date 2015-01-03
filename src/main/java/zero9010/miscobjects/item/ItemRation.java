package zero9010.miscobjects.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;
import zero9010.miscobjects.creativetab.creativeTab;
import zero9010.miscobjects.reference.Names;

public class ItemRation  extends ItemFood{
    public ItemRation()
    {
        super(2, 0.3F,false);
        this.setUnlocalizedName(Names.Items.RATION);
        setCreativeTab(creativeTab.miscobjects);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

}
