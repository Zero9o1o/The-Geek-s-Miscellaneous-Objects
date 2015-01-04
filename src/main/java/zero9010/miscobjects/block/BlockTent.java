package zero9010.miscobjects.block;

import net.minecraft.block.Block;
import zero9010.miscobjects.reference.ModelsID;
import zero9010.miscobjects.reference.Names;

public class BlockTent extends BlockMO{

    public BlockTent() {

        super();
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

}
