package zero9010.miscobjects.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import zero9010.miscobjects.client.render.item.ItemRenderTent;
import zero9010.miscobjects.init.initBlocks;
import zero9010.miscobjects.reference.ModelsID;

public class ClientProxy extends CommonProxy{

    @Override
    public void initSounds() {

    }

    @Override
    public void initRenderers() {

        ModelsID.MODELS_TENT_ID = RenderingRegistry.getNextAvailableRenderId();

        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(initBlocks.Tent), new ItemRenderTent());

    }


}
