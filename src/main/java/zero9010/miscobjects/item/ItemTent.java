package zero9010.miscobjects.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import zero9010.miscobjects.init.initBlocks;
import zero9010.miscobjects.reference.Names;

public class ItemTent extends ItemMO{

    public ItemTent(){

        super();
        this.setUnlocalizedName(Names.Items.ITEMTENT);

    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World work, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if (work.isRemote)
        {
            return true;
        }
        else if (side != 1)
        {
            return false;
        }
        else
        {
            ++y;
            int i1 = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
            byte b0 = 0;
            byte b1 = 0;

            if (i1 == 0)
            {
                b1 = 1;
            }

            if (i1 == 1)
            {
                b0 = -1;
            }

            if (i1 == 2)
            {
                b1 = -1;
            }

            if (i1 == 3)
            {
                b0 = 1;
            }

            if (player.canPlayerEdit(x, y,z, side, itemstack) && player.canPlayerEdit(x + b0, y,z + b1, side, itemstack))
            {
                if (work.isAirBlock(x, y,z) && work.isAirBlock(x + b0, y,z + b1) && World.doesBlockHaveSolidTopSurface(work, x, y - 1,z) && World.doesBlockHaveSolidTopSurface(work, x + b0, y - 1,z + b1))
                {
                    work.setBlock(x, y,z,initBlocks.Tent);

                    if (work.getBlock(x, y,z) == initBlocks.Tent)
                    {
                        work.setBlock(x + b0, y,z + b1, initBlocks.BoundingBoxFiller);
                    }

                    --itemstack.stackSize;
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
    }

}
