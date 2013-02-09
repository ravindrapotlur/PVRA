package org.concordia.kingdoms.tokens;

public class Coin {

	private CoinType type;

	private int value;

	private int count;

	private Coin(CoinType type, int value, int count) {
		this.type = type;
		this.value = value;
		this.count = count;
	}

	public int getValue() {
		return this.value;
	}

	public CoinType getType() {
		return this.type;
	}

	public int getCount() {
		return count;
	}

	public static Coin newCoin(CoinType type, int count) {
		return new Coin(type, type.getValue(), count);
	}

	public void setCount(int count) {
		this.count = count;
	}

}
