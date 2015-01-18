package com.SEPR.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class PlayerInfo extends Game {
	Stage playerInfoStage;
	Table playerInfoTable;
	
	
	@Override
	public void create() {
		playerInfoTable = new Table();
		
		playerInfoStage = new Stage();
		playerInfoStage.addActor(playerInfoTable);
	}
	
	public void render() {
		playerInfoStage.draw();
	}
}
