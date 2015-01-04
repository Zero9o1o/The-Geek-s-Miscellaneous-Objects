package zero9010.miscobjects.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import zero9010.miscobjects.creativetab.creativeTab;
import zero9010.miscobjects.reference.ModelsID;
import zero9010.miscobjects.reference.Names;
import zero9010.miscobjects.reference.Reference;
import zero9010.miscobjects.tileEntity.Tenttity;

public class BlockTent extends BlockContainer {

    public BlockTent() {

        super(Material.dragonEgg);
        setCreativeTab(creativeTab.miscobjects);
        setHardness(2f);
        setStepSound(Block.soundTypeMetal);
        setBlockName(Names.Block.TENT);

    }

    @Override
    public boolean renderAsNormalBlock()
    {

        return false;
    }

    @Override
    public int getRenderType()
    {

        return ModelsID.MODELS_TENT_ID;
    }

    @Override
    public String getUnlocalizedName(){

        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){

        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));

    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName){

        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);

    }

    @Override
    public TileEntity createNewTileEntity(World world, int yoloint) {
        return new Tenttity();
    }
}
