package com.orange.line.scene;

import org.andengine.entity.scene.Scene;

public class GameScene extends Scene{

	public GameScene(int sceneType){
		this.sceneType = sceneType;
	}
	private int sceneType;
	public int getSceneType() {
		return sceneType;
	}
	public void setSceneType(int sceneType) {
		this.sceneType = sceneType;
	}
}
