package zero9010.miscobjects.tileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTent extends TileEntity {

    int metaData = -1;

    public TileEntityTent() {


    }

    public void onChunkUnload()
    {

        metaData = getBlockMetadata();

    }

    public int getBetterMetaData(){

        return metaData;

    }

    @Override
    public void writeToNBT(NBTTagCompound compound){

        super.writeToNBT(compound);

        compound.setInteger("metaData",metaData);

    }

    @Override
    public void readFromNBT(NBTTagCompound compound){

        super.readFromNBT(compound);
        metaData = compound.getInteger("metaData");

    }

}
