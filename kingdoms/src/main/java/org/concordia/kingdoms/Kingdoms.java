package org.concordia.kingdoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

import org.concordia.kingdoms.board.Board;
import org.concordia.kingdoms.board.Epoch;
import org.concordia.kingdoms.board.factory.BoardBuilder;
import org.concordia.kingdoms.board.factory.ComponentFactory;
import org.concordia.kingdoms.board.factory.KingdomBoardBuilder;
import org.concordia.kingdoms.board.factory.KingdomComponentFactory;
import org.concordia.kingdoms.tokens.Color;
import org.concordia.kingdoms.tokens.TileType;

import com.google.common.collect.Lists;

public class Kingdoms implements Game {

	private Board board;

	private Epoch epoch;

	private ComponentFactory componentFactory;

	public Kingdoms() throws IOException {
		this(new KingdomBoardBuilder(), new KingdomComponentFactory());
	}

	public Kingdoms(final BoardBuilder builder,
			final ComponentFactory componentFactory) throws IOException {
		this.componentFactory = componentFactory;
		this.init(builder);
	}

	public void init(BoardBuilder builder) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		System.out
				.println("Enter Number of Players(Maximum of 4 and minimum of 2)");

		final int totalPlayers = Integer.parseInt(br.readLine());

		if (totalPlayers < 2 || totalPlayers > 4) {
			throw new RuntimeException("Total Players must be between 2 and 4");
		}

		final List<Player> players = Lists.newArrayList();

		// players
		for (int i = 0; i < totalPlayers; i++) {
			System.out.println("Enter Player " + i + "name");
			final String name = br.readLine();
			System.out.println("Choose Castle Color");
			final int color = Integer.parseInt(br.readLine());
			Color colorType = null;
			switch (color) {
			case 1:
				colorType = Color.BLUE;
				break;
			case 2:
				colorType = Color.GREEN;
				break;
			case 3:
				colorType = Color.RED;
				break;
			case 4:
				colorType = Color.YELLOW;
				break;
			default:
				throw new RuntimeException("Color not available");
			}

			final Player player = Player.newPlayer(name,
					new Color[] { colorType });
			players.add(player);
		}

		this.board = builder.buildBoard(Board.MAX_ROWS, Board.MAX_COLUMNS,
				players);
		this.board.setPlayers(players);
		try {
			this.board
					.putComponent(componentFactory.createTile(
							TileType.RESOURCE, "cities", 1), 0, 0);
			this.board.putComponent(
					componentFactory.createCastle(1, Color.RED), 0, 5);
			this.board.putComponent(
					componentFactory.createCastle(1, Color.BLUE), 1, 5);
			this.board.display();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getName() {
		// get from properties file
		return "Kingdoms";
	}

	public String getDescription() {
		return "Kingdoms descritpion";
	}

	public void start() {

	}

	public void pause() {
		//
	}

	public void save() {
		//
	}

	public void resume() {

	}

	public void finish() {
		//
	}

	private Player getRandomPlayer() {
		return this.board.getPlayers().get(
				new Random().nextInt(board.getPlayers().size()));
	}

	public static void main(String[] args) throws IOException {
		final Kingdoms kingdoms = new Kingdoms();
	}

}
