package biomesoplenty.blocks;

import java.util.List;

import biomesoplenty.mod_BiomesOPlenty;
import biomesoplenty.blocks.renderers.FoliageRenderer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBOPFlower extends BlockFlower
{
    private static final String[] plants = new String[] {"tinyflower", "swampflower", "deadbloom", "glowflower", "hydrangea", "orangeflower", "pinkflower", "purpleflower", "violet", "whiteflower", "toadstool", "cactus"};
    @SideOnly(Side.CLIENT)
    private Icon[] textures;
    
    protected BlockBOPFlower(int blockID, Material material)
    {
        super(blockID, material);
        this.setTickRandomly(true);
        float var4 = 0.2F;
        this.setBlockBounds(0.5F - var4, 0.0F, 0.5F - var4, 0.5F + var4, var4 * 3.0F, 0.5F + var4);
        this.setCreativeTab(mod_BiomesOPlenty.tabBiomesOPlenty);
    }

    public BlockBOPFlower(int blockID)
    {
        this(blockID, Material.plants);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        textures = new Icon[plants.length];
        
        for (int i = 0; i < plants.length; ++i)
            textures[i] = iconRegister.registerIcon("BiomesOPlenty:" + plants[i]);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getBlockTextureFromSideAndMetadata(int side, int meta)
    {
        if (meta < 0 || meta >= textures.length)
            meta = 0;

        return textures[meta];
    }
    
    public int getRenderType ()
    {
        return FoliageRenderer.render;
    }
    
    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z)
    {
        int meta = world.getBlockMetadata(x, y, z);
        if (meta == 3)
            return 9;
        else
            return 0;
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess world, int par2, int par3, int par4)
    {
        int meta = world.getBlockMetadata(par2, par3, par4);
        
        switch (meta)
        {
            case 0:
                this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.015625F, 1.0F);
                break;
                
            default:
                this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.8F, 0.9F);
                break;
        }
    }
    
    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        int meta = world.getBlockMetadata(x, y, z);
        if (meta == 11)
            entity.attackEntityFrom(DamageSource.cactus, 1);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int blockID, CreativeTabs creativeTabs, List list) {
        for (int i = 0; i < plants.length; ++i)
            list.add(new ItemStack(blockID, 1, i));
    }
    
    @Override
    public int damageDropped(int meta)
    {
        return meta & 15;
    }
}
