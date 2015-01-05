package zero9010.miscobjects.client.render.tileentity;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import zero9010.miscobjects.client.render.model.Tent;
import zero9010.miscobjects.tileEntity.TileEntityTent;

public class RenderTileEntityTent extends TileEntitySpecialRenderer {

    private final Tent Tent = new Tent();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {

        GL11.glPushMatrix();

        GL11.glTranslatef((float) x + 0.5f, (float) y + 1.50f, (float) z + 0.50009f);

        GL11.glScalef(-0.625F, -0.624F, 0.625f);

        TileEntityTent tileEntityTent = (TileEntityTent)tileEntity;

        GL11.glRotatef(GL_DONT_HATE_ME(tileEntityTent), 0, 1, 0);

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("miscobjects:textures/models/Tent.png"));

        Tent.render(1F, 1F, 1F, 1F, 1F, 0.1F);

        GL11.glPopMatrix();

    }

    private float GL_DONT_HATE_ME(TileEntityTent tileEntityTent){

        switch (tileEntityTent.getBlockMetadata()) {
            case 0: {
                return 0f;
            }
            case 1: {
                return 90f;
            }
            case 2: {
                return 180f;
            }
            case 3: {
                return 270f;
            }
            default: {

                switch (tileEntityTent.getBetterMetaData()) {
                    case 0: {
                        return 0f;
                    }
                    case 1: {
                        return 90f;
                    }
                    case 2: {
                        return 180f;
                    }
                    case 3: {
                        return 270f;
                    }
                    default: {
                        return 45f;
                    }
                }

            }
        }

    }
}
