package org.concordia.kingdoms.board;

import java.util.Map;

import org.concordia.kingdoms.Player;
import org.concordia.kingdoms.Winner;

public class Epoch {

	private int currentEpoch;

	private Map<Integer, Winner> winners;

	public Player winner(int epoch) {
		return this.winners.get(epoch).getPlayer();
	}

	public int getCurrentEpoch() {
		return this.currentEpoch;
	}

}
