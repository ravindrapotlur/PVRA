package org.concordia.kingdoms.board.factory;

import java.util.List;

import org.concordia.kingdoms.Player;
import org.concordia.kingdoms.board.Board;
import org.concordia.kingdoms.board.CoinBank;
import org.concordia.kingdoms.board.Entry;
import org.concordia.kingdoms.board.TileBank;
import org.concordia.kingdoms.tokens.Color;

public class KingdomBoardBuilder implements BoardBuilder {

	public Entry[][] buildEmptyBoard(int rows, int columns) {
		final Entry[][] entries = new Entry[rows][columns];
		this.initEntries(entries, rows, columns);
		return entries;
	}

	private void initEntries(Entry[][] entries, int rows, int columns) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				entries[i][j] = Entry.newEntry();
			}
		}
	}

	public TileBank buildTileBank() {
		return TileBank.newTileBank();
	}

	public CoinBank buildCoinBank() {
		return CoinBank.newCoinBank();
	}

	public void buildTiles() {
		
	}

	public void buildCastles() {
		
	}

	public Board buildBoard(final int rows, final int columns,
			final List<Player> players) {
		final Board board = new Board(this.buildEmptyBoard(rows, columns));
		board.setTileBank(this.buildTileBank());
		board.setCoinBank(this.buildCoinBank());
		board.setPlayers(players);
		return board;
	}

	public Player buildPlayer(final String name, final Color[] chosenColors) {
		return Player.newPlayer(name, chosenColors);
	}

	public Player buildPlayer(final String name, final Color chosenColor) {
		return Player.newPlayer(name, new Color[] { chosenColor });
	}

}
