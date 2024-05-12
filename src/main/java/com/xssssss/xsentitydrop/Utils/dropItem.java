package com.xssssss.xsentitydrop.Utils;

import com.xssssss.xsentitydrop.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import javax.naming.InsufficientResourcesException;

public class dropItem {
    public static void dropItem(LivingEntity livingEntity, String dropData) {
        Location loc = livingEntity.getLocation();
        String[] dropDataArgs = dropData.split(" ");
        double probability = Double.parseDouble(dropDataArgs[2]);
        if (Rand.checkProbability(probability)) {
            ItemStack dropItem;
            int amount;
            if (dropDataArgs[1].contains("-")) {
                int min = Integer.parseInt(dropDataArgs[1].split("-")[0]);
                int max = Integer.parseInt(dropDataArgs[1].split("-")[1]);
                if (min > max) {
                    int temp = max;
                    max = min;
                    min = temp;
                }
                amount = Rand.randInt(min, max);
            } else {
                amount = Integer.parseInt(dropDataArgs[1]);
            }
            try {
                if (dropDataArgs[0].contains(":")) {
                    int itemId = Integer.parseInt(dropDataArgs[0].split(":")[0]);
                    short subId = Short.parseShort(dropDataArgs[0].split(":")[1]);
                    dropItem = new ItemStack(itemId, amount, subId);
                } else if (dropDataArgs[0].matches("\\d+")) {
                    int itemId = Integer.parseInt(dropDataArgs[0]);
                    dropItem = new ItemStack(itemId, amount);
                } else{
                    dropItem = new ItemStack(Material.getMaterial(dropDataArgs[0]),amount);
                }
                World world = livingEntity.getWorld();
                world.dropItem(loc,dropItem);
            }catch (NullPointerException e) {
                Main.logger.warning("空指针错误，可能是掉落物物品名填写有误！");
            }
        }
    }
}
