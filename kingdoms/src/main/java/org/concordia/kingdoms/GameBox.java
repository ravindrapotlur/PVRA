package org.concordia.kingdoms;

import java.util.List;
import java.util.Map;

import org.concordia.kingdoms.tokens.Castle;
import org.concordia.kingdoms.tokens.Coin;
import org.concordia.kingdoms.tokens.CoinType;
import org.concordia.kingdoms.tokens.Tile;

public class GameBox {

	private List<? extends Tile> tiles;

	private List<? extends Castle> castles;

	private Map<CoinType, Coin> coins;
	
}
