package cn.postudio.moremotivation.Event;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class ToolUnbreakable implements Listener{

    List<ItemStack> tools = new ArrayList<>();

    @EventHandler
    public void onEntityPickupItem(@NotNull EntityPickupItemEvent e){
        initializeToolList();
        Item item = e.getItem();
        LivingEntity livingEntity = e.getEntity();

        int index;

        ItemStack itemStack = item.getItemStack();
        if (tools.contains(itemStack)) {
            if (livingEntity instanceof Player) {
                Player player = (Player) livingEntity;
                Inventory inventory = player.getInventory();
                index = inventory.first(itemStack);
                ItemMeta itemMeta = itemStack.getItemMeta();
                //检测是否不可破坏
                if (!itemMeta.isUnbreakable()) {
                    itemMeta.setUnbreakable(true);
                }
                //隐藏不必要的标签
                itemMeta.addItemFlags(ItemFlag.HIDE_ARMOR_TRIM, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_DYE, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_UNBREAKABLE);

                itemStack.setItemMeta(itemMeta);
                if (index != -1) {
                    inventory.setItem(index, itemStack);
                }
            }
        }
    }

    public void initializeToolList(){
        //工具&武器
        tools.add(new ItemStack(Material.WOODEN_AXE));
        tools.add(new ItemStack(Material.WOODEN_HOE));
        tools.add(new ItemStack(Material.WOODEN_PICKAXE));
        tools.add(new ItemStack(Material.WOODEN_SHOVEL));
        tools.add(new ItemStack(Material.WOODEN_SWORD));
        tools.add(new ItemStack(Material.STONE_AXE));
        tools.add(new ItemStack(Material.STONE_HOE));
        tools.add(new ItemStack(Material.STONE_PICKAXE));
        tools.add(new ItemStack(Material.STONE_SHOVEL));
        tools.add(new ItemStack(Material.STONE_SWORD));
        tools.add(new ItemStack(Material.IRON_AXE));
        tools.add(new ItemStack(Material.IRON_HOE));
        tools.add(new ItemStack(Material.IRON_PICKAXE));
        tools.add(new ItemStack(Material.IRON_SHOVEL));
        tools.add(new ItemStack(Material.IRON_SWORD));
        tools.add(new ItemStack(Material.GOLDEN_AXE));
        tools.add(new ItemStack(Material.GOLDEN_HOE));
        tools.add(new ItemStack(Material.GOLDEN_PICKAXE));
        tools.add(new ItemStack(Material.GOLDEN_SHOVEL));
        tools.add(new ItemStack(Material.GOLDEN_SWORD));
        tools.add(new ItemStack(Material.DIAMOND_AXE));
        tools.add(new ItemStack(Material.DIAMOND_HOE));
        tools.add(new ItemStack(Material.DIAMOND_PICKAXE));
        tools.add(new ItemStack(Material.DIAMOND_SHOVEL));
        tools.add(new ItemStack(Material.DIAMOND_SWORD));
        tools.add(new ItemStack(Material.NETHERITE_AXE));
        tools.add(new ItemStack(Material.NETHERITE_HOE));
        tools.add(new ItemStack(Material.NETHERITE_PICKAXE));
        tools.add(new ItemStack(Material.NETHERITE_SHOVEL));
        tools.add(new ItemStack(Material.NETHERITE_SWORD));
        tools.add(new ItemStack(Material.FISHING_ROD));
        tools.add(new ItemStack(Material.SHEARS));
        tools.add(new ItemStack(Material.FLINT_AND_STEEL));
        tools.add(new ItemStack(Material.BRUSH));
        tools.add(new ItemStack(Material.BOW));
        tools.add(new ItemStack(Material.CARROT_ON_A_STICK));
        tools.add(new ItemStack(Material.WARPED_FUNGUS_ON_A_STICK));
        tools.add(new ItemStack(Material.TRIDENT));
        tools.add(new ItemStack(Material.CROSSBOW));
        //防具
        tools.add(new ItemStack(Material.LEATHER_HELMET));
        tools.add(new ItemStack(Material.LEATHER_CHESTPLATE));
        tools.add(new ItemStack(Material.LEATHER_LEGGINGS));
        tools.add(new ItemStack(Material.LEATHER_BOOTS));
        tools.add(new ItemStack(Material.CHAINMAIL_HELMET));
        tools.add(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
        tools.add(new ItemStack(Material.CHAINMAIL_LEGGINGS));
        tools.add(new ItemStack(Material.CHAINMAIL_BOOTS));
        tools.add(new ItemStack(Material.IRON_HELMET));
        tools.add(new ItemStack(Material.IRON_CHESTPLATE));
        tools.add(new ItemStack(Material.IRON_LEGGINGS));
        tools.add(new ItemStack(Material.IRON_BOOTS));
        tools.add(new ItemStack(Material.GOLDEN_HELMET));
        tools.add(new ItemStack(Material.GOLDEN_CHESTPLATE));
        tools.add(new ItemStack(Material.GOLDEN_LEGGINGS));
        tools.add(new ItemStack(Material.GOLDEN_BOOTS));
        tools.add(new ItemStack(Material.DIAMOND_HELMET));
        tools.add(new ItemStack(Material.DIAMOND_CHESTPLATE));
        tools.add(new ItemStack(Material.DIAMOND_LEGGINGS));
        tools.add(new ItemStack(Material.DIAMOND_BOOTS));
        tools.add(new ItemStack(Material.NETHERITE_HELMET));
        tools.add(new ItemStack(Material.NETHERITE_CHESTPLATE));
        tools.add(new ItemStack(Material.NETHERITE_LEGGINGS));
        tools.add(new ItemStack(Material.NETHERITE_BOOTS));
        tools.add(new ItemStack(Material.SHIELD));
    }
}
