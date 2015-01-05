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

    public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if (world.isRemote)
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

                if (world.isAirBlock(x, y,z) && world.isAirBlock(x + b0, y,z + b1))
                {
                    world.setBlock(x, y,z,initBlocks.Tent,i1,2);

                    if (world.getBlock(x, y,z) == initBlocks.Tent)
                    {
                        world.setBlock(x + b0, y,z + b1, initBlocks.BoundingBoxFiller,i1,2);
                    }

                    --itemstack.stackSize;
                    return true;
                }
                else
                {
                    return false;
                }
        }
    }

}
