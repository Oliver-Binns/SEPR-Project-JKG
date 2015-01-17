package com.SEPR.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class PlayerShop extends Game
{
	public final int cellWidth = 50, cellHeight = 30;
	
	BitmapFont font;
	Texture shopBackground;
	SpriteBatch batch;
	Sprite sprite;
	
	TextButton showShopButton;
	
	TextButton electricT1;
	TextButton electricT2;
	TextButton electricT3;
	TextButton dieselT1;
	TextButton dieselT2;
	TextButton dieselT3;
	TextButton flyingT1;
	TextButton flyingT2;
	
	Label engines;
	Label electric;
	Label diesel;
	Label flying;
	Label maintenance;
	
	FitViewport viewport;
	Stage shopStage;
	
	Table shopTable;
	
	boolean showShop = false;
	
	@Override
	public void create()
	{
		batch = new SpriteBatch();
		shopBackground = new Texture("images/shopBackground.png");
		sprite = new Sprite(shopBackground);
		sprite.setSize(GameEngine.WIDTH / 5, GameEngine.HEIGHT);
		sprite.setColor(1f, 1f, 1f, 0.3f);
		
		showShopButton = new TextButton("Shop", GameEngine.textButtonStyle);
		showShopButton.setPosition(10, GameEngine.HEIGHT - 20);
		
		electricT1 = new TextButton("Tier 1", GameEngine.textButtonStyle);
		electricT2 = new TextButton("Tier 2", GameEngine.textButtonStyle);
		electricT3 = new TextButton("Tier 3", GameEngine.textButtonStyle);
		dieselT1 = new TextButton("Tier 1", GameEngine.textButtonStyle);
		dieselT2 = new TextButton("Tier 2", GameEngine.textButtonStyle);
		dieselT3 = new TextButton("Tier 3", GameEngine.textButtonStyle);
		flyingT1 = new TextButton("Tier 1", GameEngine.textButtonStyle);
		flyingT2 = new TextButton("Tier 2", GameEngine.textButtonStyle);
		
		engines = new Label("Engines", GameEngine.labelStyle);
		electric = new Label("Electric", GameEngine.labelStyle);
		diesel = new Label("Diesel", GameEngine.labelStyle);
		flying = new Label("Flying", GameEngine.labelStyle);
		maintenance = new Label("Maintenance", GameEngine.labelStyle);
		
		shopTable = new Table();
		
		shopTable.add(engines).row();
		
		shopTable.add(electric).size(cellWidth, cellHeight);
		shopTable.add(electricT1).size(cellWidth, cellHeight);
		shopTable.add(electricT2).size(cellWidth, cellHeight);
		shopTable.add(electricT3).size(cellWidth, cellHeight).row();
		
		shopTable.add(diesel).size(cellWidth, cellHeight);
		shopTable.add(dieselT1).size(cellWidth, cellHeight);
		shopTable.add(dieselT2).size(cellWidth, cellHeight);
		shopTable.add(dieselT3).size(cellWidth, cellHeight).row();
		
		shopTable.add(flying).size(cellWidth, cellHeight);
		shopTable.add(flyingT1).size(cellWidth, cellHeight);
		shopTable.add(flyingT2).size(cellWidth, cellHeight).row();
		
		shopTable.add(maintenance).size(cellWidth, cellHeight);
		
		shopTable.setPosition(115, (GameEngine.HEIGHT - 95));
		
		GameEngine.mainStage.addActor(showShopButton);
		
		shopStage = new Stage();
		//shopStage.setViewport(GameEngine.viewport);
		shopStage.addActor(shopTable);
		
		showShopButton.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor)
			{
				showShop = !showShop;
				if (showShop)
				{
					Gdx.input.setInputProcessor(shopStage);
					shopStage.addActor(showShopButton);
				}
				else
				{
					Gdx.input.setInputProcessor(GameEngine.mainStage);
					GameEngine.mainStage.addActor(showShopButton);
				}
			}
		});
		
		electricT1.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor)
			{
				// TODO Auto-generated method stub
			}	
		});
		
		electricT2.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor)
			{
				// TODO Auto-generated method stub
			}	
		});
		
		electricT3.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor)
			{
				// TODO Auto-generated method stub
			}	
		});
		
		dieselT1.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor)
			{
				// TODO Auto-generated method stub
			}
		});
		
		dieselT2.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor)
			{
				// TODO Auto-generated method stub
			}
		});
		
		dieselT3.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor)
			{
				// TODO Auto-generated method stub
			}
		});
		
		flyingT1.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor)
			{
				// TODO Auto-generated method stub
			}
		});
		
		flyingT2.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor)
			{
				// TODO Auto-generated method stub
			}
		});
	}
	
	@Override
	public void render()
	{		
		if (showShop)
		{
			batch.enableBlending();
			batch.begin();
			sprite.draw(batch);
			batch.end();
			shopStage.draw();
		}
	}
}
