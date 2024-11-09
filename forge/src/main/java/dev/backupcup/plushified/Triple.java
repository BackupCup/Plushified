package dev.backupcup.plushified;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class Triple {
    private String id;
    private RegistryObject<Block> block;
    private RegistryObject<Item> item;

    public Triple(String id, RegistryObject<Block> block, RegistryObject<Item> item) {
        this.id = id;
        this.block = block;
        this.item = item;
    }

    public String getID() {return id;}
    public void setID(String id) {this.id = id;}

    public RegistryObject<Block> getBlock() {return block;}
    public void setBlock(RegistryObject<Block> block) {this.block = block;}

    public RegistryObject<Item> getItem() {return item;}
    public void setItem(RegistryObject<Item> item) {this.item = item;}
}
