package zero9010.miscobjects.block;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import zero9010.miscobjects.init.initItem;
import zero9010.miscobjects.reference.Names;

import java.util.Random;

/**
 * Created by Arceusthepokemon on 1/4/2015.
 */
public class BlockBoundingBoxFiller extends BlockMO {

    public BlockBoundingBoxFiller() {

        super();
        this.setBlockName(Names.Block.BOUNDINGBOXFILLER);
        this.setHardness(2f);

    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return initItem.ItemTent;
    }

    public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player)
    {

        if(!world.isRemote){

            byte b0 = 0;
            byte b1 = 0;

            if (meta == 0) {
                b1 = 1;
            }

            if (meta == 1) {
                b0 = -1;
            }

            if (meta == 2) {
                b1 = -1;
            }

            if (meta == 3) {
                b0 = 1;
            }

            Block block = world.getBlock(x - b0, y, z - b1);

            if(block != null && block instanceof BlockTent){

                world.setBlock(x - b0, y, z - b1, Blocks.air);

            }

        }

    }

}
