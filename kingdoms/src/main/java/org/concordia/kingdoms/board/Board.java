package org.concordia.kingdoms.board;

import java.util.List;

import org.concordia.kingdoms.Player;
import org.concordia.kingdoms.board.ui.Console;
import org.concordia.kingdoms.board.ui.Displayable;

import com.google.common.collect.Lists;

public class Board {

	private Entry[][] entries;

	private TileBank tileBank;

	private CoinBank coinBank;

	private List<Player> players;

	private Displayable displayable;

	public static final int MAX_ROWS = 5;

	public static final int MAX_COLUMNS = 6;

	public Board(final Entry[][] entries) {
		this.entries = entries;
		this.tileBank = null;
		this.coinBank = null;
		this.players = Lists.newArrayList();
		this.displayable = new Console(entries);
	}

	public void putComponent(Component component, int row, int column)
			throws Exception {
		if (!isValidPosition(row, column)) {
			throw new Exception("Invalid positon(" + row + "," + column + ")");
		}
		if (!this.getEntries()[row][column].isEmpty()) {
			throw new Exception("No Space available");
		}
		this.getEntries()[row][column].setComponent(component);
	}

	public boolean isValidPosition(int row, int column) {
		return row >= 0 && row < MAX_ROWS && column >= 0
				&& column < MAX_COLUMNS;
	}

	public void display() {
		this.displayable.display();
	}

	public Entry[][] getEntries() {
		return this.entries;
	}

	public TileBank getTileBank() {
		return this.tileBank;
	}

	public void setTileBank(TileBank tileBank) {
		this.tileBank = tileBank;
	}

	public CoinBank getCoinBank() {
		return this.coinBank;
	}

	public void setCoinBank(CoinBank coinBank) {
		this.coinBank = coinBank;
	}

	public List<Player> getPlayers() {
		return this.players;
	}

	public void setPlayers(final List<Player> players) {
		this.players = players;
	}

}
