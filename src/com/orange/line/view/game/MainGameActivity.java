package com.orange.line.view.game;

import org.andengine.ui.activity.BaseGameActivity;

import com.orange.line.scene.GameScene;

public class MainGameActivity extends GameScene{

	GameTop top;
	GameCenter center;
	public MainGameActivity(BaseGameActivity activity,int sceneType){
		super(sceneType);
		top = new GameTop(activity,125,125,15);
		center = new GameCenter(activity);
		attachChild(center);
		attachChild(top);
	}
	public GameTop getTop() {
		return top;
	}

}
