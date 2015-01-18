package com.SEPR.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class PlayerInfo extends Game {
	Table goalTable;
	GameEngine gameEngine;
	
	public PlayerInfo(GameEngine engine) {
		gameEngine = engine;
	}
	
	@Override
	public void create() {
		goalTable = new Table();
		String[] goalDescriptors = new String[gameEngine.goalEngine.getGoalDescriptors().length];
		goalDescriptors = gameEngine.goalEngine.getGoalDescriptors();
		for(int i = 0; i < goalDescriptors.length; i++){
			goalTable.add(new Label(goalDescriptors[i], GameEngine.labelStyle)).size(150, 15).row();
		}
		goalTable.setPosition(85, 700);
	}
	
	public void render() {
	}
}
