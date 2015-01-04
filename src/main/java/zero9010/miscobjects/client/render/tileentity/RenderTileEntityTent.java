package zero9010.miscobjects.client.render.tileentity;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import zero9010.miscobjects.client.render.model.Tent;

public class RenderTileEntityTent extends TileEntitySpecialRenderer{

    private final Tent Tent = new Tent();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {

        GL11.glPushMatrix();

        GL11.glTranslatef((float)x + 0.5f, (float)y + 1.50f, (float)z + 0.50009f);

        GL11.glScalef(- 0.625F, - 0.625F, 0.625f);
        GL11.glRotatef(0f, 0, 0, 0);

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("miscobjects:textures/models/Tent.png"));

        Tent.render(1F, 1F, 1F, 1F, 1F, 0.1F);

        GL11.glPopMatrix();

    }
}
