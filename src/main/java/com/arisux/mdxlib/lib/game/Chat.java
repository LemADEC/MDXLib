package com.arisux.mdxlib.lib.game;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class Chat
{
    public static class Chars
    {
        public static final char SECTION_SIGN = '\u00A7';
        public static final char START_OF_HEADING = '\u0001';
        public static final char END_OF_TEXT = '\u0003';
        public static final char SYNCHRONUS_IDLE = '\u0016';
        public static final char CANCEL = '\u0018';
        public static final char SUBSTITUTE = '\u001a';
    }
    
    public static String unicodeEscape(char c)
    {
        return ("\\u" + Integer.toHexString(c | 0x10000).substring(1));
    }
    
    public static String string(char c)
    {
        return String.valueOf(c);
    }
    
    public static String format(String message)
    {
        return message.replaceAll("&", string(Chars.SECTION_SIGN));
    }

    public static ChatComponentText component(String message)
    {
        return new ChatComponentText(format(message));
    }

    public static void sendTo(EntityPlayer player, String message)
    {
        player.addChatMessage(component(message));
    }

    public static void sendTo(EntityPlayer player, ChatComponentText component)
    {
        player.addChatMessage(component);
    }

    public static void sendTo(ICommandSender sender, ChatComponentText component)
    {
        sender.addChatMessage(component);
    }
}
