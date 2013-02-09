package org.concordia.kingdoms;

public interface Game {

	String getName();

	String getDescription();

	void start();

	void resume();

	void pause();

	void save();

	void finish();

}
