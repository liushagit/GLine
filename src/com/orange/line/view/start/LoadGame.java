package com.orange.line.view.start;

import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.debug.Debug;

import com.orange.line.core.Constants;
import com.orange.line.sprite.NormalSprite;
import com.orange.line.view.baseview.BaseView;

public class LoadGame extends BaseView{

	NormalSprite loading_bg;
	NormalSprite loading;
	
	NormalSprite loading_jindu_01;
	NormalSprite loading_jindu_02;
	
	NormalSprite loading_feiji_01;
	NormalSprite loading_feiji_02;
	NormalSprite loading_feiji_03;
	
	NormalSprite loading_baiyun_01;
	NormalSprite loading_baiyun_02;
	
	String basePath = "image/loading/";
	public LoadGame(BaseGameActivity activity) {
		super(activity);
		init();
	}

	@Override
	protected void init() {
		loading_bg = new NormalSprite();
		loading_bg.init(activity,basePath+"loading_bg.png", 0, 0);
		
		int heiht = (int)loading_bg.getSprite().getHeight();
		int width = (int)loading_bg.getSprite().getWidth();
		
		int loadingjinduy = (heiht / 5) * 4 - 10;
		int loadingjindux = (width - 601) / 2;
		loading_jindu_01 = new NormalSprite();
		loading_jindu_01.init(activity,basePath+"loading_a.png", loadingjindux, loadingjinduy);
		
		loading_jindu_02 = new NormalSprite();
		loading_jindu_02.init(activity,basePath+"loading_b.png", loadingjindux + 6, loadingjinduy + 1);
		loading_jindu_02.getSprite().setWidth(2);
//		loading_jindu_02.init(activity, basePath+"loading_b.png", loadingjindux + 6, loadingjinduy + 1, 100, 1, 1024, 1024);
		
		loading_baiyun_01 = new NormalSprite();
		loading_baiyun_01.init(activity,basePath+"loading_d_01.png", 0, heiht - 216);
		
		loading_baiyun_02 = new NormalSprite();
		loading_baiyun_02.init(activity,basePath+"loading_d_02.png", 0, heiht - 216);
		
		int loadingx = (width - 128) / 2;
		loading = new NormalSprite();
		loading.init(activity,basePath+"loading_c.png", loadingx, loadingjinduy + 25);
		
		loading_feiji_01 = new NormalSprite();
		loading_feiji_01.init(activity,basePath+"loading_01.png", loadingjindux - 60, loadingjinduy - 56);
		
		loading_feiji_02 = new NormalSprite();
		loading_feiji_02.init(activity,basePath+"loading_02.png", loadingjindux - 60, loadingjinduy - 56);
		
		loading_feiji_03 = new NormalSprite();
		loading_feiji_03.init(activity,basePath+"loading_03.png", loadingjindux - 60, loadingjinduy - 56);
		
		attachChild(loading_bg.getSprite());
		
		attachChild(loading_baiyun_02.getSprite());
		attachChild(loading_baiyun_01.getSprite());
		

		attachChild(loading_jindu_01.getSprite());
		attachChild(loading_jindu_02.getSprite());
		attachChild(loading.getSprite());
		
		attachChild(loading_feiji_01.getSprite());
		attachChild(loading_feiji_02.getSprite());
		attachChild(loading_feiji_03.getSprite());
		loading_feiji_02.getSprite().setVisible(false);
		loading_feiji_03.getSprite().setVisible(false);
	}
	
	private boolean loadingEnd = false;
//	private int moveLength = 1;
	private int moveLength = 10;
	int index = 8;
	int up = 0;
	int upLength = 3;
	@Override
	protected void onManagedUpdate(float pSecondsElapsed) {
		if (loadingEnd) {
			return;
		}
		int endX = (int)(loading_jindu_01.getSprite().getX() + loading_jindu_01.getSprite().getWidth() - 80);
		if (loading_feiji_01.getSprite().getX() > endX) {
			loadingEnd = true;
			StartActivity startActivity = new StartActivity(activity,Constants.START);
			activity.getEngine().setScene(startActivity);
			activity.getEngine().getScene().registerTouchArea(startActivity.getStart().getStart_start_sprite().getSprite());
			activity.getEngine().getScene().registerTouchArea(startActivity.getStart().getStart_more_sprite().getSprite());
			activity.getEngine().getScene().registerTouchArea(startActivity.getStart().getStart_help_sprite().getSprite());
			return;
		}
		loading_feiji_01.getSprite().setX(loading_feiji_01.getSprite().getX() + moveLength);
		loading_feiji_02.getSprite().setX(loading_feiji_02.getSprite().getX() + moveLength);
		loading_feiji_03.getSprite().setX(loading_feiji_03.getSprite().getX() + moveLength);
		
		index ++;
		
		if (index == 1) {
			loading_feiji_01.getSprite().setVisible(true);
			loading_feiji_02.getSprite().setVisible(false);
			loading_feiji_03.getSprite().setVisible(false);
		}
		if (index == 2) {
			loading_feiji_01.getSprite().setVisible(false);
			loading_feiji_02.getSprite().setVisible(true);
			loading_feiji_03.getSprite().setVisible(false);
		}
		if (index >= 3) {
			loading_feiji_01.getSprite().setVisible(false);
			loading_feiji_02.getSprite().setVisible(false);
			loading_feiji_03.getSprite().setVisible(true);
			index = 0;
		}
		loading_jindu_02.getSprite().setWidth(loading_jindu_02.getSprite().getWidth() + moveLength);
		
		if (index == 1) {
			up ++;
			int res = 1;
			if (Math.abs(up) >= 10) {
				up = up * -1;
				
				up ++;
			}
			if (up < 0) {
				res = -1;
			}
			loading_baiyun_01.getSprite().setY(loading_baiyun_01.getSprite().getY() + upLength * res);
			loading_baiyun_02.getSprite().setY(loading_baiyun_02.getSprite().getY() - upLength * res);
		}
		
		super.onManagedUpdate(pSecondsElapsed);

	}

}
