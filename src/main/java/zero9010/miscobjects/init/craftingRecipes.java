package zero9010.miscobjects.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class craftingRecipes {

    public static void init() {

        GameRegistry.addRecipe(new ItemStack((initItem.ItemKnife), 1), new Object[]{"/  ", " x ", "   ", 'x', Items.iron_ingot, '/', Items.stick});
        GameRegistry.addRecipe(new ItemStack((initItem.ItemSteakStrips), 3), new Object[]{"/x ", "   ", "   ", 'x', Items.cooked_beef, '/', initItem.ItemKnife});
        GameRegistry.addRecipe(new ItemStack(((initItem.ITEM_STEAK_BITES)), 3), new Object[]{"/x ", "   ", "   ", 'x', initItem.ItemSteakStrips, '/', initItem.ItemKnife});

    }

}
