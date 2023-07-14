# Frolic's Chaos

## Download [On curseforge](https://legacy.curseforge.com/minecraft/mc-mods/frolics-chaos)

## My first official minecraft mod

- Written with Fabric API for 1.19.3
- Open Source - more details below
- Mod version 1.9.0 - Rebrand update!

- ### Changelog

- ### Fixed item use handler overriding normal minecraft item uses.
- ### Fixed afk enchantment not activating in 1.8.1

  - **sapphire**'s give you experience _levels_ when consumed
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
    - **Ruby Armor** - better than diamond! Comes with enchants! Very High enchantability!
    - **Ruby Tools** - Better than Netherite! Comes with enchants ooooo! Very High Enchantability
      <br><br>

  - added **Lovely** enchantment (max level 3)
    - "silk touch" spawners, sculk sensors
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
      _(toggled on)_ in your inventory!
    - Don't go above y level 30 because all blocks are removed when toggled off
    - much more responsive than the ruby "Double jumper" because this is a safety feature!!
      However, it is lacking in freedom, only for use in the caves :)
    - Remember to toggle off your AFK mine enchant when not in use to delete the blocks
    - now saves from lava and water above and around the player
      <br><br>

  - added _stats_ for sapphires, rubies, silk-touched spawners, etc (more to come)!!

  <br><br>

  - added creeper and skeleton spawn egg recipe

<hr>

- ### Todo

  - add blocks for mob drops to create more recipes like blaze block
  - add more spawn egg recipes - for use with silk-touched spawners
  - add more tools, stats, silk-touchable items
  - add more/updated textures
  - update to new fabric versions (1.20)

## Setup - Mod Users

- Download and install 1.19.3 Fabric (or place the mod right into your already prepared modpack / mods folder!)
- Download the mod from the repo (frolics-chaos.<version>.jar)
- Place .jar files into your mods folder.
- Play!
  
## Setup - Mod Developers

For setup instructions please see the [fabric wiki page](https://fabricmc.net/wiki/tutorial:setup) that relates to the IDE that you are using.

Please feel free to communicate with me and and treat this project as an open source project!
(Documentation is a good place to start perhaps?)
The vision and documentation are not set up for open source, _this is not entirely beginner friendly. But any interested developers please feel free to fork it, clone it, and make a PR!_

**Please give credit to original creator [ShadowDraco](https://github.com/ShadowDraco) if you use this mod for other purposes** Otherwise treat this as MIT

## License

[MIT License](./LICENSE)
