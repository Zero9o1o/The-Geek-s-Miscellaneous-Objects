package zero9010.miscobjects.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import zero9010.miscobjects.block.BlockBoundingBoxFiller;
import zero9010.miscobjects.block.BlockTent;
import zero9010.miscobjects.reference.Names;
import zero9010.miscobjects.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class initBlocks {

    public static final Block Tent = new BlockTent();
    public static final Block BoundingBoxFiller = new BlockBoundingBoxFiller();

    public static void init() {

        GameRegistry.registerBlock(Tent, Names.Block.BLOCKTENT);
        GameRegistry.registerBlock(BoundingBoxFiller, Names.Block.BOUNDINGBOXFILLER);

    }

}
