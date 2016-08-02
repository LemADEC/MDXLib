package com.arisux.amdxlib;

import com.arisux.amdxlib.lib.game.Game;
import com.arisux.amdxlib.lib.game.IdentityRemapModule;
import com.arisux.amdxlib.lib.world.StructureGenerationHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = AMDXLib.MODID, version = AMDXLib.VERSION)
public class ForgeModule
{
    private static AMDXLib amdxlib = new AMDXLib();
    
    public static AMDXLib amdxlib()
    {
        return amdxlib;
    }
    
    @EventHandler
    public void pre(FMLPreInitializationEvent event)
    {
       Console.preInit();
       Game.registerEventHandler(StructureGenerationHandler.instance);
       Game.registerEventHandler(IdentityRemapModule.instance);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        Console.copyright();
        Console.init();
    }
    
    @EventHandler
    public void post(FMLPostInitializationEvent event)
    {
        Console.postInit();
        Console.postInitComplete();
    }
}