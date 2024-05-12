package com.xssssss.xsentitydrop.Listener;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftEntity;

import java.util.Objects;

import static com.xssssss.xsentitydrop.Main.config;
import static com.xssssss.xsentitydrop.Utils.dropItem.dropItem;

public class onEntityDeath implements Listener {
    @EventHandler
    public void onEntityDeath (EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        CraftEntity craftEntity = ((CraftEntity) entity);

        ConfigurationSection dropsTable = config.getConfigurationSection("DropsTable");
        if (dropsTable != null) {
            for (String key : dropsTable.getKeys(false)) {
                ConfigurationSection entityDropsData = dropsTable.getConfigurationSection(key);
                if (entityDropsData != null) {
                    String entityType = entityDropsData.getString("entity");
                    //实体有在config.yml中
                    if (Objects.equals(craftEntity.getHandle().getSaveID(), entityType)) {
                        boolean playerKill = (entityDropsData.get("onlyPlayerKill") != null ? entityDropsData.getBoolean("onlyPlayerKill") : false);
                        if (entity.getKiller() != null || !playerKill) {
                            for (String dropData : entityDropsData.getStringList("drops")) {
                                dropItem(entity, dropData);
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
}
