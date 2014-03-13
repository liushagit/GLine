package com.orange.line.view.start;

import org.andengine.ui.activity.BaseGameActivity;

import com.orange.line.scene.GameScene;

public class StartActivity extends GameScene{

	StartGame start;
	public StartGame getStart() {
		return start;
	}
	public StartActivity(BaseGameActivity activity,int sceneType){
		super(sceneType);
		start = new StartGame(activity);
		attachChild(start);
	}
}
