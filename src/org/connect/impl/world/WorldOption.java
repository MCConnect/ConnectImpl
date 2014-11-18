package org.connect.impl.world;

import org.connect.api.world.IWorldOption;
import org.connect.api.world.WorldEnvironment;

public class WorldOption implements IWorldOption {

	private String name;
	private int seed;
	private WorldEnvironment worldEnv;

	public WorldOption(String name, int seed, WorldEnvironment enviornment) {
		this.name = name;
		this.seed = seed;
		this.worldEnv = enviornment;
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
	public void setSeed(int seed) {
		this.seed = seed;
	}

	@Override
	public WorldEnvironment getEnvironment() {
		return worldEnv;
	}

}
