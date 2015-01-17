package com.SEPR.game;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class MapGUI extends Game
{
	int i;
	int selectedTrain;
	int selectedJunction;
	
	SpriteDrawable stationButtonSprite;
	SpriteDrawable stationButtonCheckedSprite;
	SpriteDrawable junctionButtonSprite;
	SpriteDrawable junctionButtonCheckedSprite;
	SpriteDrawable electricTrainSprite;
	SpriteDrawable electricTrainCheckedSprite;
	SpriteDrawable dieselTrainSprite;
	SpriteDrawable dieselTrainCheckedSprite;
	SpriteDrawable flyingTrainSprite;
	SpriteDrawable flyingTrainCheckedSprite;
	
	ImageButtonStyle stationButtonStyle;
	ImageButtonStyle junctionButtonStyle;
	TextButtonStyle electricTrainButtonStyle;
	TextButtonStyle dieselTrainButtonStyle;
	TextButtonStyle flyingTrainButtonStyle;
	
	MapGraph mapGraph;
	
	int stationCount;
	
	TextButton moveTrainButton;
	TextButton nextTurn;
	
	ImageButton[] stationButton;
	Coordinates[] stationCoordinates;
	ArrayList<TextButton> trainButton;
	ArrayList<TextButton> trainButtonList;
	ArrayList<Integer> trainLocation;
	ArrayList<Boolean> trainMoved;
	Table trainListTable;
	ArrayList<Train> trainList;
	
	@Override
	public void create()
	{
		stationCount = 98;
		
		moveTrainButton = new TextButton("Move", GameEngine.textButtonStyle);
		moveTrainButton.setPosition(10, 10);
		GameEngine.mainStage.addActor(moveTrainButton);
		
		nextTurn = new TextButton("End turn", GameEngine.textButtonStyle);
		nextTurn.setPosition(70, 10);
		GameEngine.mainStage.addActor(nextTurn);
		
		stationButtonSprite = new SpriteDrawable(new Sprite(new Texture("images/stationButton.png")));
		stationButtonCheckedSprite = new SpriteDrawable(new Sprite(new Texture("images/stationButtonChecked.png")));
		
		junctionButtonSprite = new SpriteDrawable(new Sprite(new Texture("images/junctionButton.png")));
		junctionButtonCheckedSprite = new SpriteDrawable(new Sprite(new Texture("images/junctionButtonChecked.png")));
		
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
		
		junctionButtonStyle = new ImageButtonStyle();
		junctionButtonStyle.up = junctionButtonSprite;
		junctionButtonStyle.checked = junctionButtonCheckedSprite;
		
		electricTrainButtonStyle = new TextButtonStyle();
		electricTrainButtonStyle.font = GameEngine.font;
		electricTrainButtonStyle.up = electricTrainSprite;
		electricTrainButtonStyle.checked = electricTrainCheckedSprite;
		
		dieselTrainButtonStyle = new TextButtonStyle();
		dieselTrainButtonStyle.font = GameEngine.font;
		dieselTrainButtonStyle.up = dieselTrainSprite;
		dieselTrainButtonStyle.checked = dieselTrainCheckedSprite;
		
		flyingTrainButtonStyle = new TextButtonStyle();
		flyingTrainButtonStyle.font = GameEngine.font;
		flyingTrainButtonStyle.up = flyingTrainSprite;
		flyingTrainButtonStyle.checked = flyingTrainCheckedSprite;
		
		trainButton = new ArrayList<TextButton>();
		trainButtonList = new ArrayList<TextButton>();
		trainLocation = new ArrayList<Integer>();
		trainMoved = new ArrayList<Boolean>();
		trainListTable = new Table();
		
		GameEngine.mainStage.addActor(trainListTable);
		
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
		stationCoordinates[9] = new Coordinates(697, 702);
		stationCoordinates[10] = new Coordinates(722, 168);
		stationCoordinates[11] = new Coordinates(729, 471);
		stationCoordinates[12] = new Coordinates(769, 383);
		stationCoordinates[13] = new Coordinates(808, 694);
		stationCoordinates[14] = new Coordinates(818, 268);
		stationCoordinates[15] = new Coordinates(869, 479);
		stationCoordinates[16] = new Coordinates(869, 330);
		stationCoordinates[17] = new Coordinates(897, 610);
		stationCoordinates[18] = new Coordinates(913, 247);
		stationCoordinates[19] = new Coordinates(952, 388);
		stationCoordinates[20] = new Coordinates(1010, 71);
		stationCoordinates[21] = new Coordinates(1037, 277);
		stationCoordinates[22] = new Coordinates(1054, 449);
		stationCoordinates[23] = new Coordinates(1098, 647);
		stationCoordinates[24] = new Coordinates(1132, 186);
		stationCoordinates[43] = new Coordinates(513 * ((float)GameEngine.WIDTH/1680), (1050 - 398) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[46] = new Coordinates(688 * ((float)GameEngine.WIDTH/1680), (1050 - 486) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[47] = new Coordinates(704 * ((float)GameEngine.WIDTH/1680), (1050 - 495) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[26] = new Coordinates(735 * ((float)GameEngine.WIDTH/1680), (1050 - 535) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[48] = new Coordinates(703 * ((float)GameEngine.WIDTH/1680), (1050 - 627) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[25] = new Coordinates(685 * ((float)GameEngine.WIDTH/1680), (1050 - 735) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[45] = new Coordinates(575 * ((float)GameEngine.WIDTH/1680), (1050 - 817) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[41] = new Coordinates(460 * ((float)GameEngine.WIDTH/1680), (1050 - 888) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[40] = new Coordinates(471 * ((float)GameEngine.WIDTH/1680), (1050 - 835) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[39] = new Coordinates(400 * ((float)GameEngine.WIDTH/1680), (1050 - 734) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[37] = new Coordinates(347 * ((float)GameEngine.WIDTH/1680), (1050 - 860) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[38] = new Coordinates(354 * ((float)GameEngine.WIDTH/1680), (1050 - 937) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[42] = new Coordinates(446 * ((float)GameEngine.WIDTH/1680), (1050 - 932) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[49] = new Coordinates(782 * ((float)GameEngine.WIDTH/1680), (1050 - 522) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[52] = new Coordinates(858 * ((float)GameEngine.WIDTH/1680), (1050 - 607) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[51] = new Coordinates(836 * ((float)GameEngine.WIDTH/1680), (1050 - 692) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[53] = new Coordinates(903 * ((float)GameEngine.WIDTH/1680), (1050 - 631) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[56] = new Coordinates(919 * ((float)GameEngine.WIDTH/1680), (1050 - 759) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[60] = new Coordinates(979 * ((float)GameEngine.WIDTH/1680), (1050 - 777) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[58] = new Coordinates(958 * ((float)GameEngine.WIDTH/1680), (1050 - 706) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[29] = new Coordinates(1006 * ((float)GameEngine.WIDTH/1680), (1050 - 677) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[28] = new Coordinates(1001 * ((float)GameEngine.WIDTH/1680), (1050 - 645) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[34] = new Coordinates(1292 * ((float)GameEngine.WIDTH/1680), (1050 - 928) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[84] = new Coordinates(1315 * ((float)GameEngine.WIDTH/1680), (1050 - 845) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[86] = new Coordinates(1340 * ((float)GameEngine.WIDTH/1680), (1050 - 825) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[93] = new Coordinates(1416 * ((float)GameEngine.WIDTH/1680), (1050 - 824) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[35] = new Coordinates(1459 * ((float)GameEngine.WIDTH/1680), (1050 - 792) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[92] = new Coordinates(1411 * ((float)GameEngine.WIDTH/1680), (1050 - 776) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[69] = new Coordinates(1123 * ((float)GameEngine.WIDTH/1680), (1050 - 763) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[91] = new Coordinates(1409 * ((float)GameEngine.WIDTH/1680), (1050 - 723) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[44] = new Coordinates(573 * ((float)GameEngine.WIDTH/1680), (1050 - 404) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[80] = new Coordinates(1292 * ((float)GameEngine.WIDTH/1680), (1050 - 664) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[76] = new Coordinates(1186 * ((float)GameEngine.WIDTH/1680), (1050 - 661) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[87] = new Coordinates(1363 * ((float)GameEngine.WIDTH/1680), (1050 - 618) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[64] = new Coordinates(1029 * ((float)GameEngine.WIDTH/1680), (1050 - 599) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[50] = new Coordinates(820 * ((float)GameEngine.WIDTH/1680), (1050 - 408) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[54] = new Coordinates(912 * ((float)GameEngine.WIDTH/1680), (1050 - 228) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[55] = new Coordinates(941 * ((float)GameEngine.WIDTH/1680), (1050 - 197) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[59] = new Coordinates(966 * ((float)GameEngine.WIDTH/1680), (1050 - 450) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[61] = new Coordinates(980 * ((float)GameEngine.WIDTH/1680), (1050 - 400) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[30] = new Coordinates(1002 * ((float)GameEngine.WIDTH/1680), (1050 - 62) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[62] = new Coordinates(1002 * ((float)GameEngine.WIDTH/1680), (1050 - 481) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[57] = new Coordinates(945 * ((float)GameEngine.WIDTH/1680), (1050 - 650) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[79] = new Coordinates(1280 * ((float)GameEngine.WIDTH/1680), (1050 - 876) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[88] = new Coordinates(1382 * ((float)GameEngine.WIDTH/1680), (1050 - 717) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[27] = new Coordinates(879 * ((float)GameEngine.WIDTH/1680), (1050 - 408) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[31] = new Coordinates(1076 * ((float)GameEngine.WIDTH/1680), (1050 - 577) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[81] = new Coordinates(1300 * ((float)GameEngine.WIDTH/1680), (1050 - 569) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[63] = new Coordinates(1025 * ((float)GameEngine.WIDTH/1680), (1050 - 563) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[32] = new Coordinates(1139 * ((float)GameEngine.WIDTH/1680), (1050 - 559) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[71] = new Coordinates(1149 * ((float)GameEngine.WIDTH/1680), (1050 - 505) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[77] = new Coordinates(1230 * ((float)GameEngine.WIDTH/1680), (1050 - 474) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[97] = new Coordinates(1553 * ((float)GameEngine.WIDTH/1680), (1050 - 462) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[65] = new Coordinates(1029 * ((float)GameEngine.WIDTH/1680), (1050 - 401) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[66] = new Coordinates(1053 * ((float)GameEngine.WIDTH/1680), (1050 - 375) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[75] = new Coordinates(1175 * ((float)GameEngine.WIDTH/1680), (1050 - 364) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[82] = new Coordinates(1289 * ((float)GameEngine.WIDTH/1680), (1050 - 361) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[83] = new Coordinates(1311 * ((float)GameEngine.WIDTH/1680), (1050 - 341) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[96] = new Coordinates(1492 * ((float)GameEngine.WIDTH/1680), (1050 - 336) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[36] = new Coordinates(1526 * ((float)GameEngine.WIDTH/1680), (1050 - 272) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[72] = new Coordinates(1139 * ((float)GameEngine.WIDTH/1680), (1050 - 282) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[73] = new Coordinates(1147 * ((float)GameEngine.WIDTH/1680), (1050 - 234) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[95] = new Coordinates(1487 * ((float)GameEngine.WIDTH/1680), (1050 - 227) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[33] = new Coordinates(1196 * ((float)GameEngine.WIDTH/1680), (1050 - 220) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[78] = new Coordinates(1233 * ((float)GameEngine.WIDTH/1680), (1050 - 221) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[85] = new Coordinates(1310 * ((float)GameEngine.WIDTH/1680), (1050 - 208) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[89] = new Coordinates(1381 * ((float)GameEngine.WIDTH/1680), (1050 - 208) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[74] = new Coordinates(1162 * ((float)GameEngine.WIDTH/1680), (1050 - 165) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[68] = new Coordinates(1078 * ((float)GameEngine.WIDTH/1680), (1050 - 154) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[67] = new Coordinates(1049 * ((float)GameEngine.WIDTH/1680), (1050 - 31) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[70] = new Coordinates(1131 * ((float)GameEngine.WIDTH/1680), (1050 - 18) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[90] = new Coordinates(1400 * ((float)GameEngine.WIDTH/1680), (1050 - 301) * ((float)GameEngine.HEIGHT/1050));
		stationCoordinates[94] = new Coordinates(1453 * ((float)GameEngine.WIDTH/1680), (1050 - 492) * ((float)GameEngine.HEIGHT/1050));
		
		stationButton = new ImageButton[stationCount];
		for(i = 0; i < 25; i++)
		{
			stationButton[i] = new ImageButton(stationButtonStyle);
			GameEngine.mainStage.addActor(stationButton[i]);
			stationButton[i].setPosition(stationCoordinates[i].x, stationCoordinates[i].y);
		}
		
		for(i = 25; i < stationCount; i++)
		{
			stationButton[i] = new ImageButton(junctionButtonStyle);
			GameEngine.mainStage.addActor(stationButton[i]);
			stationButton[i].setPosition(stationCoordinates[i].x, stationCoordinates[i].y);
		}
		
		for(i = 0; i < stationCount; i++)
		{
			stationButton[i].addListener(new ClickListener()
			{
				final int b = i;
				public void clicked(InputEvent event, float x, float y)
				{	
					for(int c = 0; c < stationCount; c++)
					{
						stationButton[c].setChecked(false);
					}
					System.out.println(String.valueOf(b));
					selectedJunction = b;
					stationButton[b].setChecked(true);
				}
			});
		}
		
		moveTrainButton.addListener(new ClickListener()
		{
			public void clicked(InputEvent event, float x, float y)
			{
				moveTrain();
			}
		});
		
		nextTurn.addListener(new ClickListener()
		{
			public void clicked(InputEvent event, float x, float y)
			{
				
			}
		});
	}
	
	public void updateTrainList(Player player)
	{
		//This will get the list of trains owned by a player to display them on screen as buttons so that they can be moved
		trainList = new ArrayList<Train>(player.getPlayerTrains());
		trainListTable.clear();
		
		for(int i = 0; i < trainList.size(); i++)
		{
			TextButton train;
			TextButton trainText;
			switch(trainList.get(i).getEngineType())
			{
			case 1:
				train = new TextButton(String.valueOf(trainList.get(i).getTier()), electricTrainButtonStyle);
				trainButton.add(train);
				trainText = new TextButton("Electric - Tier " + trainList.get(i).getTier(), GameEngine.textButtonStyle);
				trainButtonList.add(trainText);
			case 2:
				train = new TextButton(String.valueOf(trainList.get(i).getTier()), dieselTrainButtonStyle);
				trainButton.add(train);
				trainText = new TextButton("Diesel - Tier " + trainList.get(i).getTier(), GameEngine.textButtonStyle);
				trainButtonList.add(trainText);
			case 3:
				train = new TextButton(String.valueOf(trainList.get(i).getTier()), flyingTrainButtonStyle);
				trainButton.add(train);
				trainText = new TextButton("Flying - Tier " + trainList.get(i).getTier(), GameEngine.textButtonStyle);
				trainButtonList.add(trainText);
			}
			trainLocation.add(trainList.get(i).getCurrentJunction());
			trainButtonList.get(i).setPosition(stationCoordinates[trainLocation.get(i)].x, stationCoordinates[trainLocation.get(i)].y);
			GameEngine.mainStage.addActor(trainButtonList.get(i));
			trainListTable.add(trainButtonList.get(i)).row();
			trainMoved.add(false);
		}
		
		GameEngine.mainStage.addActor(trainListTable);
		
		for(i = 0; i < trainList.size(); i++)
		{
			trainButtonList.get(i).addListener(new ClickListener()
			{
				final int b = i;
				public void clicked(InputEvent event, float x, float y)
				{	
					for(int c = 0; c < trainList.size(); c++)
					{
						trainButton.get(c).setChecked(false);
					}
					trainButton.get(b).setChecked(true);
					selectedTrain = b;
				}
			});
		}
	}
	
	protected void moveTrain()
	{
		boolean flag = true;
		if(trainMoved.get(selectedTrain) == false)
		{
			for(int i = 0; i < trainList.get(i).getSpeed(); i++)
			{
				flag = mapGraph.MoveTrain(trainList.get(selectedTrain).getTrainID(), trainLocation.get(selectedTrain), selectedJunction);
				if(selectedJunction < 37)
				{
					break;
				}
			}
			if(flag == true)
			{
				trainMoved.set(selectedTrain, false);
			}
		}
	}
	
	@Override
	public void render()
	{
		
	}
}
