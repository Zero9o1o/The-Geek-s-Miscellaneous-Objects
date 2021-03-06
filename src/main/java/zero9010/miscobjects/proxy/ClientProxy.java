package zero9010.miscobjects.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import zero9010.miscobjects.client.render.item.ItemRenderTent;
import zero9010.miscobjects.client.render.tileentity.RenderTileEntityTent;
import zero9010.miscobjects.init.initItem;
import zero9010.miscobjects.reference.ModelsID;
import zero9010.miscobjects.tileEntity.TileEntityTent;

import java.util.List;

public class ClientProxy extends CommonProxy {

    @Override
    public void initSounds() {

    }

    @Override
    public void initRenderers() {

        ModelsID.MODELS_TENT_ID = RenderingRegistry.getNextAvailableRenderId();

        //MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(initBlocks.Tent), new ItemRenderTent());
        MinecraftForgeClient.registerItemRenderer(initItem.ItemTent, new ItemRenderTent());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTent.class, new RenderTileEntityTent());

    }

}
