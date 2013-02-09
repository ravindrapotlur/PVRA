package org.concordia.kingdoms.tokens;

import java.io.Serializable;

import org.concordia.kingdoms.board.Component;

public class Castle implements Component, Serializable {

	private static final long serialVersionUID = 1L;

	private Integer rank;

	private Color color;

	public Castle(final Integer rank, Color color) {
		this.rank = rank;
		this.color = color;
	}

	public int getRank() {
		return this.rank;
	}

	public Color getColor() {
		return this.color;
	}

	public Integer getValue() {
		return rank;
	}

	public String getName() {
		return "C(" + color.getCode() + ")";
	}

}
