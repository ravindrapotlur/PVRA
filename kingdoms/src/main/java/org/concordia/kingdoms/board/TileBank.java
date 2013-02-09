package org.concordia.kingdoms.board;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.concordia.kingdoms.tokens.Tile;
import org.concordia.kingdoms.tokens.TileType;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class TileBank {

	private Map<TileType, List<Tile>> tiles;

	private static final String RESOURCE_CITIES = "cities";

	private static final String RESOURCE_VILLAGES = "village";

	private static final String RESOURCE_FARMS = "farms";

	public TileBank() {
		this.tiles = Maps.newHashMap();
		final List<Tile> resourceTiles = Lists.newArrayList();
		resourceTiles.add(Tile.newTile(TileType.RESOURCE, RESOURCE_CITIES, 6));
		resourceTiles.add(Tile.newTile(TileType.RESOURCE, RESOURCE_CITIES, 5));
		resourceTiles.add(Tile.newTile(TileType.RESOURCE, RESOURCE_CITIES, 4));
		resourceTiles.add(Tile.newTile(TileType.RESOURCE, RESOURCE_CITIES, 5));

		resourceTiles
				.add(Tile.newTile(TileType.RESOURCE, RESOURCE_VILLAGES, 6));
		resourceTiles
				.add(Tile.newTile(TileType.RESOURCE, RESOURCE_VILLAGES, 5));
		resourceTiles
				.add(Tile.newTile(TileType.RESOURCE, RESOURCE_VILLAGES, 1));
		resourceTiles
				.add(Tile.newTile(TileType.RESOURCE, RESOURCE_VILLAGES, 2));

		resourceTiles.add(Tile.newTile(TileType.RESOURCE, RESOURCE_FARMS, 3));
		resourceTiles.add(Tile.newTile(TileType.RESOURCE, RESOURCE_FARMS, 2));
		resourceTiles.add(Tile.newTile(TileType.RESOURCE, RESOURCE_FARMS, 1));
		resourceTiles.add(Tile.newTile(TileType.RESOURCE, RESOURCE_FARMS, 5));

		this.tiles.put(TileType.RESOURCE, resourceTiles);

	}

	public Set<Tile> getTiles() {
		return null;
	}

	public static TileBank newTileBank() {
		return new TileBank();
	}

}
