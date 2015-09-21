package com.bigeebs.quantumprocessing.worldGen;

import com.bigeebs.quantumprocessing.QuantumProcessing;
import com.bigeebs.quantumprocessing.block.*;
import com.bigeebs.quantumprocessing.init.ModBlocks;
import com.bigeebs.quantumprocessing.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created by Andrew.Ebert on 9/16/2015.
 */
public class OreGeneration implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimensionId())
        {
            case 0:
                generateOverworld(world, random, chunkX, chunkZ);
                break;
            case -1:
                generateNether(world, random, chunkX, chunkZ);
                break;
            case 1:
                generateEnd(world, random, chunkX, chunkZ);
                break;
        }
    }

    public void generateOverworld(World world, Random random, int x, int z){
        LogHelper.info("Generating Overworld Ores.");
        generateOres(ModBlocks.adamantiumOre, world, random, x, z, 2, 10, 5, 0, 100, Blocks.stone);
        generateOres(ModBlocks.aluminumOre, world, random, x, z, 2, 10, 5, 0, 100, Blocks.stone);
        generateOres(ModBlocks.copperOre, world, random, x, z, 2, 10, 5, 0, 100, Blocks.stone);
        generateOres(ModBlocks.leadOre, world, random, x, z, 2, 10, 5, 0, 100, Blocks.stone);
        generateOres(ModBlocks.plutoniumOre, world, random, x, z, 2, 10, 5, 0, 100, Blocks.stone);
        generateOres(ModBlocks.uraniumOre, world, random, x, z, 2, 10, 5, 0, 100, Blocks.stone);
        generateOres(ModBlocks.vibraniumOre, world, random, x, z, 2, 10, 5, 0, 100, Blocks.stone);
    }

    public void generateNether(World world, Random random, int x, int z){

    }

    public void generateEnd(World world, Random random, int x, int z){

    }

    private void generateOres(QPBlock block, World world, Random random, int chunkX, int chunkZ, int minVienSize, int maxVienSize, int chance, int minY, int maxY, Block generateIn){
        int vienSize = minVienSize + random.nextInt(maxVienSize - minVienSize);
        int heightRange = maxY - minY;
        WorldGenMinable gen = new WorldGenMinable(block.getDefaultState(), vienSize, BlockHelper.forBlock(generateIn));

        for (int i = 0; i < chance; i++ ) {
            int xRand = chunkX * 16 + random.nextInt(16);
            int yRand = random.nextInt(heightRange) + minY;
            int zRand = chunkZ * 16 + random.nextInt(16);
            gen.generate(world, random, new BlockPos(xRand, yRand, zRand));
            LogHelper.info("Generated: " + block.getUnwrappedUnlocalizedName(block.getUnlocalizedName()) + " at - x:" + xRand + " y:" + yRand + " z:" + zRand);
        }
    }
}











