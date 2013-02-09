package org.concordia.kingdoms;

import java.util.List;
import java.util.Map;

import org.concordia.kingdoms.board.Board;
import org.concordia.kingdoms.tokens.Castle;
import org.concordia.kingdoms.tokens.Coin;
import org.concordia.kingdoms.tokens.CoinType;
import org.concordia.kingdoms.tokens.Color;
import org.concordia.kingdoms.tokens.Tile;
import org.concordia.kingdoms.tokens.TileType;

import com.google.common.collect.Maps;

public class Player {

	private String name;

	private Color[] chosenColors;

	private int score;

	private Tile startingTile;

	private Map<CoinType, Coin> coins;

	private Map<Integer, List<Castle>> castles;

	private Map<TileType, List<Tile>> tiles;

	private Board board;

	private Player(String name, final Color[] chosenColors) {
		this.name = name;
		this.chosenColors = chosenColors;
		this.score = 0;
		this.startingTile = null;
		this.coins = Maps.newHashMap();
		this.castles = Maps.newHashMap();
	}

	public void putTile(Tile tile, int row, int column) throws Exception {
		if (!this.tiles.get(tile.getType()).contains(tile)) {
			throw new RuntimeException("Tile not available with this player");
		}
		this.board.putComponent(tile, row, column);
		this.tiles.get(tile.getType()).remove(tile);
	}

	public void putCastle(Castle castle, int row, int column) throws Exception {
		if (!this.castles.get(castle.getRank()).contains(castle)) {
			throw new RuntimeException("Castle not available with this player");
		}
		this.board.putComponent(castle, row, column);
		this.castles.get(castle.getRank()).remove(castle);
	}

	public static Player newPlayer(String name, final Color[] chosenColors) {
		return new Player(name, chosenColors);
	}

}
