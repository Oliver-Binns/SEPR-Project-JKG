package com.SEPR.game;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameEngine extends ApplicationAdapter {
	TextButton quit;
	
	SpriteBatch batch;
	static BitmapFont font;
	Texture map;
	
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
		
		quit = new TextButton("Quit", textButtonStyle);
		quit.setPosition(150, 10);
		mainStage.addActor(quit);
		
		player = new Player[2];
		player[0] = new Player(0, 22);
		player[1] = new Player(0, 10);
		player[0].buyNewTrain(0, 1, 0, 0, 0);
		player[1].buyNewTrain(0, 1, 1, 1, 0);
		
		playerTrain = new ArrayList<Train>();
		playerTrain = player[0].getPlayerTrains();
		playerTrain = player[1].getPlayerTrains();
		
		currentPlayer = player[0];
		
		goalEngine = new GoalEngine();
		
		mapGUI = new MapGUI(this);
		mapGUI.create();
		
		mapGraph = new MapGraph(mapGUI.stationCount);
		
		mapGraph.AddTrain(player[0].getPlayerTrains().get(0).getTrainID(), player[0].getPlayerTrains().get(0).getCurrentJunction());
		mapGraph.AddTrain(player[1].getPlayerTrains().get(0).getTrainID(), player[1].getPlayerTrains().get(0).getCurrentJunction());
		
		playerInfo = new PlayerInfo(this);
		playerInfo.create();
		
		mainStage.addActor(playerInfo.goalTable);
		
		playerShop = new PlayerShop();
		//playerShop.create();
		//mainStage.addActor(playerShop.showShopButton);
		
		mapGUI.updateTrainList(currentPlayer);
		
		quit.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				mainStage.dispose();
				map.dispose();
				if(player[0].getPlayerScore() == player[1].getPlayerScore()){
					JOptionPane.showMessageDialog(null, "Well done! You both earned " + player[0].getPlayerScore() + " points.", "Draw!", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(player[0].getPlayerScore() > player[1].getPlayerScore()){
					JOptionPane.showMessageDialog(null, "Well done Player 1, you earned " + player[0].getPlayerScore() + " points!", "Player 1 Wins!", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "Well done Player 2, you earned " + player[1].getPlayerScore() + " points!", "Player 2 Wins!", JOptionPane.INFORMATION_MESSAGE);
				}
				Gdx.app.exit();
			}
		});
		
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
		playerInfo.playerInfoTable.clear();
		playerInfo.playerInfoTable.add(new Label("Player " + (currentPlayerInt + 1), GameEngine.labelStyle)).size(50, 15).row();
		playerInfo.playerInfoTable.add(new Label("Wealth: " + currentPlayer.getPlayerWealth(), labelStyle)).size(50, 15).row();
		playerInfo.playerInfoTable.add(new Label("Score: " + currentPlayer.getPlayerScore(), labelStyle)).size(50, 15);
	}
	
	public void incrementTurn() {
		mapGUI.updateTrainList(currentPlayer);
		goalEngine.endTurn(player);
		playerInfo.goalTable.clear();
		
		String[] goalDescriptors = new String[goalEngine.getGoalDescriptors().length];
		goalDescriptors = goalEngine.getGoalDescriptors();
		for(int i = 0; i < goalEngine.getGoalDescriptors().length; i++){
			playerInfo.goalTable.add(new Label(goalDescriptors[i], GameEngine.labelStyle)).size(150, 15).row();
		}
		playerInfo.goalTable.setPosition(85, 700);	
	}
}
