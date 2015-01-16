package com.SEPR.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class MapGUI extends Game
{
	int i;
	
	SpriteDrawable stationButtonSprite;
	SpriteDrawable stationButtonCheckedSprite;
	SpriteDrawable electricTrainSprite;
	SpriteDrawable electricTrainCheckedSprite;
	SpriteDrawable dieselTrainSprite;
	SpriteDrawable dieselTrainCheckedSprite;
	SpriteDrawable flyingTrainSprite;
	SpriteDrawable flyingTrainCheckedSprite;
	
	ImageButtonStyle stationButtonStyle;
	TextButtonStyle electricTrainButtonStyle;
	TextButtonStyle dieselTrainButtonStyle;
	TextButtonStyle flyingTrainButtonStyle;
	
	//MapGraph mapGraph;
	//Player player;
	
	int stationCount;
	
	ImageButton[] stationButton;
	Coordinates[] stationCoordinates;
	List<TextButton> trainButton;
	
	@Override
	public void create()
	{
		stationCount = 25;
		
		stationButtonSprite = new SpriteDrawable(new Sprite(new Texture("images/stationButton.png")));
		stationButtonCheckedSprite = new SpriteDrawable(new Sprite(new Texture("images/stationButtonChecked.png")));
		
		electricTrainSprite = new SpriteDrawable(new Sprite(new Texture("images/electricTrain.png")));
		electricTrainCheckedSprite = new SpriteDrawable(new Sprite(new Texture("images/electricTrainChecked.png")));
		dieselTrainSprite = new SpriteDrawable(new Sprite(new Texture("images/dieselTrain.png")));
		dieselTrainCheckedSprite = new SpriteDrawable(new Sprite(new Texture("images/dieselTrainChecked.png")));
		flyingTrainSprite = new SpriteDrawable(new Sprite(new Texture("images/flyingTrain.png")));
		flyingTrainCheckedSprite = new SpriteDrawable(new Sprite(new Texture("images/flyingTrainChecked.png")));
		
		stationButtonStyle = new ImageButtonStyle();
		stationButtonStyle.up = stationButtonSprite;
		stationButtonStyle.down = stationButtonSprite;
		stationButtonStyle.checked = stationButtonCheckedSprite;
		
		electricTrainButtonStyle = new TextButtonStyle();
		electricTrainButtonStyle.font = SEPR.font;
		electricTrainButtonStyle.up = electricTrainSprite;
		electricTrainButtonStyle.checked = electricTrainCheckedSprite;
		
		dieselTrainButtonStyle = new TextButtonStyle();
		dieselTrainButtonStyle.font = SEPR.font;
		dieselTrainButtonStyle.up = dieselTrainSprite;
		dieselTrainButtonStyle.checked = dieselTrainCheckedSprite;
		
		flyingTrainButtonStyle = new TextButtonStyle();
		flyingTrainButtonStyle.font = SEPR.font;
		flyingTrainButtonStyle.up = flyingTrainSprite;
		flyingTrainButtonStyle.checked = flyingTrainCheckedSprite;
		
		stationCoordinates = new Coordinates[stationCount];
		stationCoordinates[0] = new Coordinates(241, 106);
		stationCoordinates[1] = new Coordinates(276, 172);
		stationCoordinates[2] = new Coordinates(376, 111);
		stationCoordinates[3] = new Coordinates(382, 507);
		stationCoordinates[4] = new Coordinates(490, 446);
		stationCoordinates[5] = new Coordinates(542, 341);
		stationCoordinates[6] = new Coordinates(589, 449);
		stationCoordinates[7] = new Coordinates(612, 288);
		stationCoordinates[8] = new Coordinates(660, 345);
		stationCoordinates[9] = new Coordinates(722, 168);
		stationCoordinates[10] = new Coordinates(697, 702);
		stationCoordinates[11] = new Coordinates(729, 471);
		stationCoordinates[12] = new Coordinates(769, 383);
		stationCoordinates[13] = new Coordinates(808, 694);
		stationCoordinates[14] = new Coordinates(818, 268);
		stationCoordinates[15] = new Coordinates(869, 330);
		stationCoordinates[16] = new Coordinates(869, 479);
		stationCoordinates[17] = new Coordinates(897, 610);
		stationCoordinates[18] = new Coordinates(913, 247);
		stationCoordinates[19] = new Coordinates(952, 388);
		stationCoordinates[20] = new Coordinates(1010, 71);
		stationCoordinates[21] = new Coordinates(1037, 277);
		stationCoordinates[22] = new Coordinates(1054, 449);
		stationCoordinates[23] = new Coordinates(1098, 647);
		stationCoordinates[24] = new Coordinates(1132, 186);
		
		stationButton = new ImageButton[stationCount];
		for(i = 0; i < stationCount; i++)
		{
			stationButton[i] = new ImageButton(stationButtonStyle);
			SEPR.mainStage.addActor(stationButton[i]);
			stationButton[i].setPosition(stationCoordinates[i].x, stationCoordinates[i].y);
		}
		
		for(i = 0; i < stationCount - 1; i++)
		{
			stationButton[i].addListener(new ClickListener()
			{
				final int b = i;
				public void clicked(InputEvent event, float x, float y)
				{	
					for(int c = 0; c < stationCount - 1; c++)
					{
						stationButton[c].setChecked(false);
					}
					stationButton[b].setChecked(true);
				}
			});
		}
		
		trainButton = new ArrayList<TextButton>();
		
		//mapGraph = new MapGraph();
	}
	
	public void updateTrainList(Player player)
	{
		//This will get the list of trains owned by a player to display them on screen as buttons so that they can be moved
	}
	
	@Override
	public void render()
	{
		
	}
}
