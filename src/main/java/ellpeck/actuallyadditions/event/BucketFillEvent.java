package ellpeck.actuallyadditions.event;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import ellpeck.actuallyadditions.blocks.InitBlocks;
import ellpeck.actuallyadditions.items.InitItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class BucketFillEvent{

    @SubscribeEvent
    public void onBucketFilled(FillBucketEvent event){
        this.fillBucket(event, InitItems.itemBucketOil, InitBlocks.blockOil);
        this.fillBucket(event, InitItems.itemBucketCanolaOil, InitBlocks.blockCanolaOil);
    }

    private void fillBucket(FillBucketEvent event, Item item, Block fluid){
        Block block = event.world.getBlock(event.target.blockX, event.target.blockY, event.target.blockZ);
        if(block == fluid){
            event.world.setBlockToAir(event.target.blockX, event.target.blockY, event.target.blockZ);
            event.result = new ItemStack(item);
            event.setResult(Event.Result.ALLOW);
        }
    }
}
