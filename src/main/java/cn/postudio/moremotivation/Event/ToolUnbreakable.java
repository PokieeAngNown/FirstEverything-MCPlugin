package cn.postudio.moremotivation.Event;

import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;


public class ToolUnbreakable implements Listener{
    @EventHandler
    public void onEntityPickupItem(@NotNull EntityPickupItemEvent e){
        Item item = e.getItem();
        LivingEntity livingEntity = e.getEntity();

        int index = -1;

        ItemStack itemStack = item.getItemStack();
        if (livingEntity instanceof Player){
            Player player = (Player) livingEntity;
            Inventory inventory = player.getInventory();
            index = inventory.first(itemStack);
            ItemMeta itemMeta = itemStack.getItemMeta();
            if (!itemMeta.isUnbreakable()){
                itemMeta.setUnbreakable(true);
            }
            itemStack.setItemMeta(itemMeta);
            if (index != -1){
                inventory.setItem(index, itemStack);
            }
        }
    }
}
