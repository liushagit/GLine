package com.orange.line.view.game;

import org.andengine.ui.activity.BaseGameActivity;

import com.orange.line.sprite.NormalSprite;
import com.orange.line.view.baseview.BaseView;

public class GameCenter extends BaseView{

	public GameCenter(BaseGameActivity activity) {
		super(activity);
		init();
	}

	private NormalSprite left_bg;
	private NormalSprite right_bg;
	private NormalSprite frame_bg;
	private NormalSprite left_right_frame_bg;
	private NormalSprite game_top_bg;
	private NormalSprite game_center_bg;
	private NormalSprite game_bottom_bg;
	private NormalSprite game_icon[];
	
	private String otherPaty = "image/game_bg_01/";
	private String gamePath = "image/game/";
	@Override
	protected void init() {
		left_bg = new NormalSprite();
		left_bg.init(activity, otherPaty + "level_1_bg_left.png", 0, 0);
		
		
		
		attachChild(left_bg.getSprite());
	}

}
