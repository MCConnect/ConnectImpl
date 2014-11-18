package org.connect.impl.world;

import java.util.ArrayList;
import java.util.Vector;

import org.connect.api.world.IChunk;
import org.connect.api.world.ILocation;
import org.connect.api.world.IWorld;
import org.connect.api.world.Vector2f;
import org.connect.api.world.biome.IBiome;

public class Chunk implements IChunk {

	private Vector2f chunkLocation;
	private IWorld world;
	private ArrayList<ILocation> locations = new ArrayList<>();

	public Chunk(IWorld world, Vector2f chunkLocation) {
		this.world = world;
		this.chunkLocation = chunkLocation;
	}

	@Override
	public IBiome getBiome() {
		return null;
	}

	@Override
	public ArrayList<ILocation> getLocations() {
		return locations;
	}

	@Override
	public IWorld getWorld() {
		return world;
	}

	@Override
	public Vector2f getChunkLocation() {
		return chunkLocation;
	}

	@Override
	public void loadChunk() {
		
	}

}
