package biomesoplenty.common.block.trees;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

import java.util.Random;

public class MapleTree extends TreeDefaultConfig
{
   @Override
   protected Feature<? extends TreeConfiguration> getFeature(Random random)
   {
      return null;
// TODO:      return (random.nextInt(10) == 0 ? BOPFeatures.BIG_MAPLE_TREE : BOPFeatures.MAPLE_TREE);
   }
}