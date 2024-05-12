package com.xssssss.xsentitydrop.Commands;

import com.xssssss.xsentitydrop.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandsXsEntityDrop implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            if (sender.hasPermission("XsEntityDrop.help")) {
                sender.sendMessage("§7§l=========== §3§lXsEntityDrop §7§l===========");
                sender.sendMessage("§3§lBy: XiaoShuaiOwO");
                sender.sendMessage(" ");
                sender.sendMessage("§e命令列表:");
                sender.sendMessage("§e/XsEntityDrop help §f- §7查看插件指令帮助");
                sender.sendMessage("§e/XsEntityDrop reload §f- §7重载插件");
                sender.sendMessage("§7* 可使用简拼/xsed代替/XsEntityDrop");
                return true;
            }else {
                sender.sendMessage("§7§l=========== §3§lXsEntityDrop §7§l===========");
                sender.sendMessage("§3§lBy: XiaoShuaiOwO");
                return true;
            }
        }
        if (args[0].equalsIgnoreCase("help")) {
            if (sender.hasPermission("XsEntityDrop.help")) {
                sender.sendMessage("§7§l=========== §3§lXsEntityDrop §7§l===========");
                sender.sendMessage("§3§lBy: XiaoShuaiOwO");
                sender.sendMessage(" ");
                sender.sendMessage("§e命令列表:");
                sender.sendMessage("§e/XsEntityDrop help §f- §7查看插件指令帮助");
                sender.sendMessage("§e/XsEntityDrop reload §f- §7重载插件");
                sender.sendMessage("§7* 可使用简拼/xsed代替/XsEntityDrop");
                return true;
            }else {
                sender.sendMessage("§7§l=========== §3§lXsEntityDrop §7§l===========");
                sender.sendMessage("§3§lBy: XiaoShuaiOwO");
                return true;
            }
        }
        if (args[0].equalsIgnoreCase("reload")) {
            if (sender.hasPermission("XsEntityDrop.reload")) {
                try {
                    Main.config = Main.createResource(Main.plugin,"","config.yml",false);
                    sender.sendMessage("§3§l[XsEntityDrop] §a重载成功！");
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }

            }
        }
        return false;
    }
}
