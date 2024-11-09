package dev.backupcup.plushified.register;

import dev.backupcup.plushified.Constants;
import dev.backupcup.plushified.Triple;
import dev.backupcup.plushified.block.PlushieBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class RegisterBlocks {
    public static ArrayList<Triple> plushieList = new ArrayList<>();

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

    /**
     * Registers the Block, Block Entitu and Item
     * @param name
     * @return block, block entity, and item
     */
    private static Triple registerCustomPlushie(String name) {
        //BLOCK
        RegistryObject<Block> block = BLOCKS.register(name + "_plushie",
                () -> new PlushieBlock(
                        BlockBehaviour.Properties.of()
                                .strength(0.5f)
                                .noOcclusion()
                                .dynamicShape()
                ));

        //BLOCK ITEM
        RegistryObject<Item> item = BLOCK_ITEMS.register(name + "_plushie",
                () -> new BlockItem(block.get(), new Item.Properties()));

        plushieList.add(new Triple(name, block, item));
        return new Triple(name, block, item);
    }

    private static List<Triple> registerCustomPlushies(String[] names) {
        List<Triple> plushies = new ArrayList<>();
        for (String name : names) {
            plushies.add(registerCustomPlushie(name));
        }
        return plushies;
    }

    public static final List<Triple> PLUSHIES = registerCustomPlushies(new String[]{
            "cup", "sillvia", "crispy", "milky", "koda", "constella", "bon",
            "diansu", "will", "zaills", "yirmiri", "pixie", "scoobs", "astron", "tac",
            "wanyay", "drex", "bane", "moss", "boba", "vifi"
    });
}

