package com.SEPR.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.SEPR.game.SEPR;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = SEPR.HEIGHT;
		config.width = SEPR.WIDTH;
		config.title = SEPR.TITLE;
		new LwjglApplication(new SEPR(), config);
	}
}
