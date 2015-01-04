package zero9010.miscobjects.client.render.item;


import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import zero9010.miscobjects.client.render.model.Tent;

public class ItemRenderTent implements IItemRenderer{

    private final Tent modelTent;

    public ItemRenderTent()
    {
        modelTent = new Tent();
    }

    @Override
    public boolean handleRenderType(ItemStack itemStack, ItemRenderType itemRenderType)
    {

        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType itemRenderType, ItemStack itemStack, ItemRendererHelper itemRendererHelper)
    {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType itemRenderType, ItemStack itemStack, Object... data)
    {
        switch (itemRenderType)
        {
            case ENTITY:
            {
                renderTent(0.0F, 1.5F, 0.5F, 180F);
                return;
            }
            case EQUIPPED:
            {
                renderTent(1.0F, 3.5F, 1F, 180F);
                return;
            }
            case EQUIPPED_FIRST_PERSON:
            {
                renderTent(1.0F, 3.50F, 1.0F, 180F);
                return;
            }
            case INVENTORY:
            {
                renderTent(-0.6f, 1.4f, 0.1F, 180F);
                return;
            }
            default:
            {
            }
        }
    }

    private void renderTent(float x, float y, float z,float rotatae1)
    {
        GL11.glPushMatrix();

        GL11.glScalef(.4F, .4F, .4F);
        GL11.glTranslatef(x, y, z);
        GL11.glRotatef(rotatae1, 0, 0, 0);

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("miscobjects:textures/models/Tent.png"));

        modelTent.render(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1F);

        GL11.glPopMatrix();
    }

}
