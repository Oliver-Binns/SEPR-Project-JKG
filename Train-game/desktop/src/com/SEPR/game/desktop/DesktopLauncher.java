package com.SEPR.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.SEPR.game.GameEngine;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = GameEngine.HEIGHT;
		config.width = GameEngine.WIDTH;
		config.title = GameEngine.TITLE;
		new LwjglApplication(new GameEngine(), config);
	}
}
