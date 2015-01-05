package zero9010.miscobjects.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import zero9010.miscobjects.creativetab.creativeTab;
import zero9010.miscobjects.init.initBlocks;
import zero9010.miscobjects.reference.ModelsID;
import zero9010.miscobjects.reference.Names;
import zero9010.miscobjects.reference.Reference;
import zero9010.miscobjects.tileEntity.TileEntityTent;

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

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {

        if(!world.isRemote){

            if(world.isAirBlock(x,y,z) && world.isAirBlock(x,y,z + 1)){

                world.setBlock(x,y,z + 1, initBlocks.BoundingBoxFiller);

            }else{

                world.setBlock(x,y,z, Blocks.air);
                dropBlockAsItem(world,x,y,z,new ItemStack(initBlocks.Tent));

            }

        }

        return metadata;
    }

    public void onBlockHarvested(World world, int x, int y, int z, int meta_I_think, EntityPlayer player)
    {

        if(!world.isRemote){

            Block block = world.getBlock(x,y,z + 1);

            if(block != null && block instanceof BlockBoundingBoxFiller){

                world.setBlock(x,y,z + 1, Blocks.air);

            }

        }

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
