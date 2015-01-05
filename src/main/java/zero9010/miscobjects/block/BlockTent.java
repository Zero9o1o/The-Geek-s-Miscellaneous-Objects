package zero9010.miscobjects.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import zero9010.miscobjects.creativetab.creativeTab;
import zero9010.miscobjects.init.initItem;
import zero9010.miscobjects.reference.ModelsID;
import zero9010.miscobjects.reference.Names;
import zero9010.miscobjects.reference.Reference;
import zero9010.miscobjects.tileEntity.TileEntityTent;

import java.util.Random;

public class BlockTent extends BlockContainer {

    public BlockTent() {

        super(Material.iron);
        setCreativeTab(creativeTab.miscobjects);
        setHardness(2f);
        setStepSound(Block.soundTypeMetal);
        setBlockName(Names.Block.BLOCKTENT);

    }

    @Override
    public boolean renderAsNormalBlock() {

        return false;
    }

    @Override
    public int getRenderType() {

        return ModelsID.MODELS_TENT_ID;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
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

            Block block = world.getBlock(x + b0,y,z + b1);

            if(block != null && block instanceof BlockBoundingBoxFiller){

                world.setBlock(x + b0,y,z + b1, Blocks.air);

            }

        }

    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return initItem.ItemTent;
    }

    @Override
    public String getUnlocalizedName() {

        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {

        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));

    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {

        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);

    }

    @Override
    public TileEntity createNewTileEntity(World world, int yoloint) {
        return new TileEntityTent();
    }
}
