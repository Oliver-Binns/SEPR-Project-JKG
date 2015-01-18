package com.SEPR.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameEngine extends ApplicationAdapter {
	SpriteBatch batch;
	static BitmapFont font;
	Texture map;
	
	Table goalTable;
	
	int turnCount = 0;
	
	public static final String TITLE = "SEPR Game";
	public static final int HEIGHT = 800, WIDTH = 1280;
	public static float x, y = 0;
	
	public static Stage mainStage;
	public static FitViewport viewport;
	
	public static LabelStyle labelStyle;
	public static TextButtonStyle textButtonStyle;
	
	PlayerShop playerShop;
	PlayerInfo playerInfo;
	MapGUI mapGUI;
	
	Player[] player;
	Player currentPlayer;
	ArrayList<Train> playerTrain;
	
	MapGraph mapGraph;
	GoalEngine goalEngine;
	
	int currentPlayerInt = 0;
	
	@Override
	public void create () {
		mainStage = new Stage();
		
		batch = new SpriteBatch();
		
		font = new BitmapFont();
		font.setColor(Color.RED);
		
		textButtonStyle = new TextButtonStyle();
		textButtonStyle.font = font;
		
		labelStyle = new LabelStyle();
		labelStyle.font = font;
		
		map = new Texture("images/SEPRMap.jpg");
		
		player = new Player[2];
		player[0] = new Player(0, 9);
		player[1] = new Player(0, 10);
		player[0].buyNewTrain(0, 1, 0, 0, 0);
		player[1].buyNewTrain(0, 1, 1, 1, 0);
		
		playerTrain = new ArrayList<Train>();
		playerTrain = player[0].getPlayerTrains();
		playerTrain.get(0).moveTrain(0);
		playerTrain = player[1].getPlayerTrains();
		playerTrain.get(0).moveTrain(6);
		
		currentPlayer = player[0];
		
		goalEngine = new GoalEngine();
		
		goalTable = new Table();
		String[] goalDescriptors = new String[goalEngine.getGoalDescriptors().length];
		goalDescriptors = goalEngine.getGoalDescriptors();
		for(int i = 0; i < goalDescriptors.length; i++){
			goalTable.add(new Label(goalDescriptors[i], labelStyle)).row();
		}
		goalTable.setPosition(180, 700);
		
		mainStage.addActor(goalTable);
		
		mapGUI = new MapGUI(this);
		mapGUI.create();
		
		mapGraph = new MapGraph(mapGUI.stationCount);
		
		mapGraph.AddTrain(player[0].getPlayerTrains().get(0).getTrainID(), player[0].getPlayerTrains().get(0).getCurrentJunction());
		mapGraph.AddTrain(player[1].getPlayerTrains().get(0).getTrainID(), player[1].getPlayerTrains().get(0).getCurrentJunction());
		
		playerInfo = new PlayerInfo();
		playerInfo.create();
		
		playerShop = new PlayerShop();
		playerShop.create();
		mainStage.addActor(playerShop.showShopButton);
		
		mapGUI.updateTrainList(currentPlayer);
		
		Gdx.input.setInputProcessor(mainStage);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(map, 0, 0, WIDTH, HEIGHT);
		batch.end();
		
		playerInfo.render();
		playerShop.render();
		mainStage.draw();
	}
	
	public void nextPlayer() {
		turnCount++;
		currentPlayerInt = 1 - currentPlayerInt;
		currentPlayer = player[currentPlayerInt];
		mapGUI.updateTrainList(currentPlayer);
		if(currentPlayerInt == 0)
		{
			incrementTurn();
		}
	}
	
	public void incrementTurn() {
		mapGUI.updateTrainList(currentPlayer);
		goalEngine.endTurn(player, ((int)Math.random()*3));
		goalTable.clear();
		for(int i = 0; i < goalEngine.getGoalDescriptors().length; i++){
			goalTable.add(new Label(goalEngine.getGoalDescriptors()[i], labelStyle)).row();
		}
	}
}
