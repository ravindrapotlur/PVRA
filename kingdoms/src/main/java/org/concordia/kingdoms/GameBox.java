package org.concordia.kingdoms;

import java.util.List;
import java.util.Map;

import org.concordia.kingdoms.tokens.Castle;
import org.concordia.kingdoms.tokens.Coin;
import org.concordia.kingdoms.tokens.CoinType;
import org.concordia.kingdoms.tokens.Color;
import org.concordia.kingdoms.tokens.Tile;
import org.concordia.kingdoms.tokens.TileType;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class GameBox {

	private static final GameBox GAME_BOX = new GameBox();

	private Map<TileType, List<Tile>> tiles = Maps.newHashMap();

	private Map<CoinType, List<Coin>> coins = Maps.newHashMap();

	private Map<Integer, Map<Color, List<Castle>>> castles = Maps.newHashMap();

	private static final String RESOURCE_CITIES = "cities";

	private static final String RESOURCE_VILLAGES = "village";

	private static final String RESOURCE_FARMS = "farms";

	private static final String HAZARD_BEAR = "BEAR";

	private static final String HAZARD_LION = "LION";

	private static final String HAZARD_TIGER = "TIGER";

	private static final String HAZARD_HYNA = "HYNA";

	private static final String HAZARD_VULTURE = "VULTURE";

	private static final String HAZARD_THUNDER = "THUNDER";

	private static final String MOUNTAIN_EVEREST = "EVEREST";

	private static final String MOUNTAIN_ALPES = "ALPES";

	private static final String DRAGON_RED = "RED_DRAGON";

	private static final String GOLDMINE = "GOLDMINE";

	private static final String WIZARD = "WIZARD";

	public GameBox() {
		// tiles
		fillTiles();
		// coins
		fillCoins();
		// castles
		fillCastles();

	}

	private void fillTiles() {

		// resource tiles
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

		// hazard tiles
		final List<Tile> hazardTiles = Lists.newArrayList();

		hazardTiles.add(Tile.newTile(TileType.HAZARD, HAZARD_BEAR, -6));
		hazardTiles.add(Tile.newTile(TileType.HAZARD, HAZARD_HYNA, -5));
		hazardTiles.add(Tile.newTile(TileType.HAZARD, HAZARD_LION, -4));
		hazardTiles.add(Tile.newTile(TileType.HAZARD, HAZARD_TIGER, -3));
		hazardTiles.add(Tile.newTile(TileType.HAZARD, HAZARD_VULTURE, -2));
		hazardTiles.add(Tile.newTile(TileType.HAZARD, HAZARD_THUNDER, -1));

		this.tiles.put(TileType.HAZARD, hazardTiles);

		// mountain tile
		final List<Tile> mountainTiles = Lists.newArrayList();

		mountainTiles.add(Tile.newTile(TileType.MOUNTAIN, MOUNTAIN_EVEREST, 0));
		mountainTiles.add(Tile.newTile(TileType.MOUNTAIN, MOUNTAIN_ALPES, 0));

		this.tiles.put(TileType.MOUNTAIN, mountainTiles);

		// dragon tile
		this.tiles.put(TileType.DRAGON, Lists.newArrayList(Tile.newTile(
				TileType.DRAGON, DRAGON_RED, 0)));
		// goldmine tile
		this.tiles.put(TileType.GOLDMINE, Lists.newArrayList(Tile.newTile(
				TileType.GOLDMINE, GOLDMINE, 0)));
		// wizard tile
		this.tiles.put(TileType.WIZARD,
				Lists.newArrayList(Tile.newTile(TileType.WIZARD, WIZARD, 0)));
	}

	private void fillCoins() {
		this.coins.put(CoinType.COPPER_1, Coin.newCoins(CoinType.COPPER_1, 19));
		this.coins.put(CoinType.COPPER_5, Coin.newCoins(CoinType.COPPER_5, 12));
		this.coins.put(CoinType.SILVER_10,
				Coin.newCoins(CoinType.SILVER_10, 20));
		this.coins.put(CoinType.GOLD_50, Coin.newCoins(CoinType.GOLD_50, 8));
		this.coins.put(CoinType.GOLD_100, Coin.newCoins(CoinType.GOLD_100, 4));
	}

	private void fillCastles() {
		// 40 Plastic Castles, including
		for (final Color color : Color.values()) {
			// 16 Rank 1 Castles (4 per color)
			loadCastles(1, color, 4);
			// 12 Rank 2 Castles (3 per color)
			loadCastles(2, color, 3);
			// 8 Rank 3 Castles (2 per color)
			loadCastles(3, color, 2);
			// 4 Rank 4 Castles (1 per color)
			loadCastles(4, color, 1);
		}
	}

	private void loadCastles(int rank, Color color, int size) {
		if (this.castles.containsKey(rank)) {
			this.castles.get(rank).put(color, newCastles(1, color, 4));
		} else {
			final Map<Color, List<Castle>> colorCastles = Maps.newHashMap();
			colorCastles.put(color, newCastles(rank, color, size));
			this.castles.put(rank, colorCastles);
		}
	}

	private List<Castle> newCastles(int rank, Color color, int size) {
		final List<Castle> castles = Lists.newArrayList();
		for (int i = 0; i < size; i++) {
			castles.add(Castle.newCastle(rank, color));
		}
		return castles;
	}

	public List<Coin> takeCoins(CoinType type, int size) {
		final List<Coin> coinList = this.coins.get(type);
		if (size > coinList.size()) {
			throw new RuntimeException(size + " coins of type " + type
					+ " are not available");
		}
		final List<Coin> retCoins = Lists.newArrayList();
		for (int i = 0; i < size; i++) {
			retCoins.add(coinList.remove(i));
		}
		return retCoins;
	}

	public void assignCastles(Player player, int totalPlayers) {
		final Color[] playerColors = player.getChosenColors();
		for (final Color color : playerColors) {
			for (int rank = 2; rank <= 4; rank++) {
				
			}
		}
	}

	public List<Tile> getTiles(TileType type) {
		return this.tiles.get(type);
	}

	public static GameBox getGameBox() {
		return GAME_BOX;
	}
}
