package org.connect.impl.world;

import java.util.ArrayList;
import java.util.UUID;

import org.connect.api.block.IBlock;
import org.connect.api.world.IChunk;
import org.connect.api.world.ILocation;
import org.connect.api.world.IWorld;
import org.connect.api.world.IWorldOption;
import org.connect.api.world.WorldEnvironment;

public class World implements IWorld {

	private int seed;
	private String name;
	private WorldEnvironment worldEnv;
	private ArrayList<IChunk> chunks = new ArrayList<>();
	private IWorldOption worldOption;
	private UUID uuid;

	public World(IWorldOption worldOption) {
		this.seed = worldOption.getSeed();
		this.name = worldOption.getName();
		this.worldEnv = worldOption.getEnvironment();
		this.worldOption = worldOption;
	}

	@Override
	@Deprecated
	/**
	 * Use World.getBlockManager().getBlock();
	 */
	public IBlock getBlock(ILocation location) {
		for (IChunk chunk : getChunks()) {
			for (ILocation chunkLocation : chunk.getLocations()) {
				if (location.getWorld().getName() == name
						&& location.getX() == chunkLocation.getX()
						&& location.getY() == chunkLocation.getY()
						&& location.getZ() == chunkLocation.getZ()) {
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public IChunk getChunk(ILocation location) {
		for (IChunk chunk : getChunks()) {
			if (chunk.getLocations().contains(location)) {
				return chunk;
			}
		}
		return null;
	}

	@Override
	public WorldEnvironment getEnviroment() {
		return worldEnv;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getSeed() {
		return seed;
	}

	@Override
	public ArrayList<IChunk> getChunks() {
		return chunks;
	}

	@Override
	public IWorldOption getWorldOption() {
		return worldOption;
	}

	@Override
	public ILocation getSpawn() {
		return new Location(this, 0, 64, 0);
	}

	@Override
	public UUID getUniqueId() {
		return uuid;
	}

}
