package org.connect.impl.world;

import java.util.ArrayList;

import org.connect.api.world.IWorld;
import org.connect.api.world.IWorldManager;
import org.connect.api.world.IWorldOption;

public class WorldManager implements IWorldManager {

	private ArrayList<IWorld> loadedWorlds = new ArrayList<>();
	private ArrayList<IWorld> worlds = new ArrayList<>();

	@Override
	public IWorld createWorld(IWorldOption worldOption) {
		World world = new World(worldOption);
		worlds.add(world);
		loadWorld(world);
		return world;
	}

	@Override
	public ArrayList<IWorld> getLoadedWorlds() {
		return loadedWorlds;
	}

	@Override
	public IWorld getWorld(String name) {
		for (IWorld world : getWorlds()) {
			if (world.getName().equalsIgnoreCase(name)) {
				return world;
			}
		}
		return null;
	}

	@Override
	public ArrayList<IWorld> getWorlds() {
		return worlds;
	}

	@Override
	public boolean isLoaded(IWorld world) {
		return loadedWorlds.contains(world);
	}

	@Override
	public void loadWorld(IWorld world) {
		loadedWorlds.add(world);
	}

	@Override
	public void unloadWorld(IWorld world) {
		loadedWorlds.remove(world);
	}

}
