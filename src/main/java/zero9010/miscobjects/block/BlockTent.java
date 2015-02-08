package zero9010.miscobjects.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import zero9010.miscobjects.creativetab.creativeTab;
import zero9010.miscobjects.init.initItem;
import zero9010.miscobjects.reference.ModelsID;
import zero9010.miscobjects.reference.Names;
import zero9010.miscobjects.reference.Reference;
import zero9010.miscobjects.tileEntity.TileEntityTent;

import java.util.Iterator;
import java.util.Random;

public class BlockTent extends BlockContainer {

    public TileEntityTent tileEntityTent;

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

        public boolean isBed(IBlockAccess blockAccess, int x, int y, int z, EntityLivingBase player)
    {

        return true;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side_THING, float hitX_THING, float hitY_THING, float hitZ_THING){

        if (world.isRemote){

            return true;

        }else{

            if (world.provider.canRespawnHere() && world.getBiomeGenForCoords(x, z) != BiomeGenBase.hell) {

                EntityPlayer entityplayer1 = null;
                Iterator iterator = world.playerEntities.iterator();

                while (iterator.hasNext()) {

                    EntityPlayer entityplayer2 = (EntityPlayer) iterator.next();

                    if (entityplayer2.isPlayerSleeping()) {

                        ChunkCoordinates chunkcoordinates = entityplayer2.playerLocation;

                        if (chunkcoordinates.posX == x && chunkcoordinates.posY == y && chunkcoordinates.posZ == z) {

                            entityplayer1 = entityplayer2;

                        }

                    }

                    if (entityplayer1 != null) {

                        player.addChatComponentMessage(new ChatComponentTranslation("tile.bed.occupied", new Object[0]));

                        return true;

                    }

                }

                EntityPlayer.EnumStatus enumstatus = player.sleepInBedAt(x, y, z);

                if (enumstatus == EntityPlayer.EnumStatus.OK)
                {
                    return true;
                }
                else {
                    if (enumstatus == EntityPlayer.EnumStatus.NOT_POSSIBLE_NOW) {

                        player.addChatComponentMessage(new ChatComponentTranslation("tile.bed.noSleep", new Object[0]));

                    } else if (enumstatus == EntityPlayer.EnumStatus.NOT_SAFE) {

                        player.addChatComponentMessage(new ChatComponentTranslation("tile.bed.notSafe", new Object[0]));

                    }

                    return true;
                }

            }

            return true;

        }

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
