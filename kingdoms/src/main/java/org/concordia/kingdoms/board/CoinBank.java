package org.concordia.kingdoms.board;

import java.util.Map;

import org.concordia.kingdoms.tokens.Coin;
import org.concordia.kingdoms.tokens.CoinType;

import com.google.common.collect.Maps;

public class CoinBank {

	private Map<CoinType, Coin> coins;

	public CoinBank() {
		this.coins = Maps.newHashMap();
		this.coins.put(CoinType.COPPER_1, Coin.newCoin(CoinType.COPPER_1, 19));
		this.coins.put(CoinType.COPPER_5, Coin.newCoin(CoinType.COPPER_5, 12));
		this.coins
				.put(CoinType.SILVER_10, Coin.newCoin(CoinType.SILVER_10, 20));
		this.coins.put(CoinType.GOLD_50, Coin.newCoin(CoinType.GOLD_50, 8));
		this.coins.put(CoinType.GOLD_100, Coin.newCoin(CoinType.GOLD_100, 4));
	}

	public static CoinBank newCoinBank() {
		return new CoinBank();
	}
}
