# Draco Tutorial Mod 

## My first official minecraft mod 
- written with Fabric API for 1.19.3

- ### Changelog

- ### Fixed item use handler overriding normal minecraft item uses.

  - **sapphire**'s give you experience *levels* when consumed
    - plays a sound with volume and pitch relative to how many Sapphires in your hand! 
    - levels given will apply next time your experience updates from other sources (don't know what made this happen)
    only spawn in treasure chests **Maybe...**
  
  <br><br>

  - added **ruby blocks** which do a lot of crazy and harmful things when destroyed but pay off when broken.
  
    - Bring player to "one" heart, 
    - set on fire, 
    - change main hand, 
    - turn off gravity (toggles, so you **HAVE** to 
    break another ruby block to undo it), 
    - makes you glow
    - sticks 100 arrows in you... yes...
    - gives you ruby :))
    - **Generates in the same way as diamond, but more scarcely**
    
  <br><br>
  
  - Added **ruby gem**
    - ruby's when used (toggled) place blocks underneath and in front of the player while jumping and falling
    - create ruby blocks with "charged" ruby - all blocks disappear when ruby becomes uncharged
    - there is a delay when you jump, and it takes some timing (on purpose) have fun jumping absolutely everywhere!
    - places a hollow shell that will not craft more rubies
    - UNcharges consume one ruby - so you can toggle before losing your last one
    - VERY good furnace fuel
    - **Ruby Armor** - better than diamond! Comes with enchants! High enchantability!
    
  <br><br>
  
  - added **Lovely** enchantment (max level 3)
    - "silk touch" spawners 
    - when holding the enchanted **Tool**:
      - regeneration when hit by a mob (not projectiles or explosions they caused)
      - restore small amount of hunger as well
      - spawns heart particles on block break **( not working anyone know why??)**
      - gives massive regeneration to hurt mobs (undead can't regenerate)
    - Saves you from the wrath of Ruby!
  
  <br><br>
  
  - added **Afk Mine** enchantment (level 1)
  - **Makes you invisible and catches your fall while mining below y = 30**
    - ever wanted to afk mine but couldn't because of danger?
    - now you can - while below y level 30, and you have a pickaxe enchanted with afk mine 
    *(toggled on)* in your inventory!
    - Don't go above y level 30 because all blocks are removed when toggled off
    - much more responsive than the ruby "Double jumper" because this is a safety feature!!
    However, it is lacking in freedom, only for use in the caves :)
    - Remember to toggle off your AFK mine enchant when not in use to delete the blocks

  <br><br>

  - added *stats* for sapphires, rubies, silk-touched spawners, etc (more to come)!!

  <br><br>

  - added creeper spawn egg recipe

<hr>

- ### Todo
  - add blocks for mob drops to create more recipes like blaze block
  - add more spawn egg recipes 

## Setup - Mod Users 

- Download and install 1.19.3 Fabric (or place the mod right into your already prepared modpack / mods folder!)
- Download the mod from the repo (draco-tutorial-mod.<version>.jar **and sources.jar**)
- Place .jar files into your mods folder.


## Setup - Mod Developers

For setup instructions please see the [fabric wiki page](https://fabricmc.net/wiki/tutorial:setup) that relates to the IDE that you are using.

## License

[MIT License](./LICENSE)