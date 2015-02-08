package zero9010.miscobjects.tileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTent extends TileEntity {

    int metaData = -1;
    private boolean PlayerInTent = false;

    public TileEntityTent() {


    }

    public void onChunkUnload()
    {

        metaData = getBlockMetadata();

    }

    public int getBetterMetaData(){

        return metaData;

    }

    public boolean getPlayerInTent(){

        return PlayerInTent;

    }

    @Override
    public void writeToNBT(NBTTagCompound compound){

        super.writeToNBT(compound);

        compound.setInteger("metaData",metaData);
        compound.setBoolean("playerInTent", PlayerInTent);

    }

    @Override
    public void readFromNBT(NBTTagCompound compound){

        super.readFromNBT(compound);
        metaData = compound.getInteger("metaData");
        PlayerInTent = compound.getBoolean("playerInTent");

    }

}
