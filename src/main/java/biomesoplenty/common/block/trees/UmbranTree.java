package biomesoplenty.common.block.trees;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

import java.util.Random;

public class UmbranTree extends BigTreeDefaultConfig
{
   @Override
   protected Feature<? extends TreeConfiguration> getFeature(Random random)
   {
      return null;
      // TODO: return BOPFeatures.UMBRAN_TREE;
   }

   @Override
   protected Feature<? extends TreeConfiguration> getBigFeature(Random random)
   {
      return null;
      // TODO: return BOPFeatures.TALL_UMBRAN_TREE;
   }
}