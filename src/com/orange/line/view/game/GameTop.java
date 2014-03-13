package com.orange.line.view.game;

import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.debug.Debug;

import android.R.xml;

import com.orange.line.sprite.GifSprite;
import com.orange.line.sprite.NormalButtonSprite;
import com.orange.line.sprite.NormalSprite;
import com.orange.line.view.baseview.BaseView;

public class GameTop extends BaseView {
	private int r;
	private int g;
	private int b;
	public GameTop(BaseGameActivity activity) {
		super(activity);
		init();
	}

	public GameTop(BaseGameActivity activity,int r,int g,int b) {
		super(activity);
		this.r = r;
		this.g = g;
		this.b = b;
		init();
	}
	private NormalSprite top_bg;
	private GifSprite top_gold;
	private GifSprite pay_gold;
//	private NormalButtonSprite pay_gold[];
	private NormalSprite up_level;
	private NormalSprite up_level_exp[];
	private NormalSprite up_level_exp_bg;
	private NormalButtonSprite help_up;
	private NormalButtonSprite help_down;
	private NormalButtonSprite back_up;
	private NormalButtonSprite back_down;
	
	
	private String basePath = "image/game/";
	private String common = "image/commonality/";
	int between = 10;
	protected void init() {
		
		long begin = System.currentTimeMillis();
		top_bg = new NormalSprite();
		top_bg.init(activity, basePath + "game_top_bg.png", 0, 0);
		top_bg.getSprite().setColor(r, g, b);
		
		int x = between * 2;
		top_gold = new GifSprite();
		top_gold.init(activity, common + "comm_energy_bg_", x, 0, 5,2,200);
		x += (int)(top_gold.getSprite().getWidth() + between / 2);
		
		pay_gold = new GifSprite();
		pay_gold.init(activity, common + "comm_ef_pay_", x, 0, 2,1,400);
//		initPay(x);
		
		x += pay_gold.getSprite().getWidth() + between;
		up_level = new NormalSprite();
		up_level.init(activity, common + "comm_up_ico_level.png", x, 0);
		
		//
		x += 7;
		int y = top_bg.getCenterY();
		initUpLevel(x,y - 15);
		up_level_exp_bg = new NormalSprite();
		up_level_exp_bg.init(activity, common + "comm_up_exp_bg.png", x, y - 15);
		
		x += between + up_level_exp_bg.getSprite().getWidth();
		help_up = new NormalButtonSprite();
		help_up.init(activity, common + "comm_button_help_01.png", x, 2);
//		activity.getEngine().getScene().registerTouchArea(help_up.getSprite());
		
		help_down = new NormalButtonSprite();
		help_down.init(activity, common + "comm_button_help_02.png", x, 2);
		help_down.getSprite().setVisible(false);
		help_up.getSprite().setDownButtonSprite(help_down.getSprite());
		
		
		x += between + help_down.getSprite().getWidth();
		back_up = new NormalButtonSprite();
		back_up.init(activity, common + "comm_button_back_01.png", x, 2);
		
		back_down = new NormalButtonSprite();
		back_down.init(activity, common + "comm_button_back_02.png", x, 2);
		back_down.getSprite().setVisible(false);
		
		
		attachChild(top_bg.getSprite());
		attachChild(top_gold.getSprite());
//		for (int i = 0; i < top_gold.length; i++) {
//			attachChild(top_gold[i].getSprite());
//			top_gold[i].getSprite().setVisible(false);
//			if (i == top_gold.length - 1) {
//				top_gold[i].getSprite().setVisible(true);
//				goldvisible = i;
//			}
//		}
		attachChild(pay_gold.getSprite());
//		for (int i = 0; i < pay_gold.length; i++) {
//			attachChild(pay_gold[i].getSprite());
//			pay_gold[i].getSprite().setVisible(false);
//			if (i == pay_gold.length - 1) {
//				pay_gold[i].getSprite().setVisible(true);
//				payVisible = i;
//			}
//		}
		
		
		attachChild(up_level_exp_bg.getSprite());
		
		for (int i = 0; i < up_level_exp.length; i++) {
			attachChild(up_level_exp[i].getSprite());
			if (i == up_level_exp.length - 1) {
				up_level_exp[i].getSprite().setVisible(true);
			}
		}
		attachChild(up_level.getSprite());
		
		attachChild(help_up.getSprite());
		attachChild(help_down.getSprite());
		
		attachChild(back_up.getSprite());
		attachChild(back_down.getSprite());
//		
		Debug.e("===========q" + (System.currentTimeMillis() - begin) + "===================");
		
//		activity.getEngine().getScene().registerTouchArea(startActivity.getStart().getStart_start_sprite().getSprite());
		
	}
	
	
	
	private void initUpLevel(int x,int y){
		up_level_exp = new NormalSprite[10];
		for (int i = 1; i < up_level_exp.length + 1; i++) {
			up_level_exp[i - 1] = new NormalSprite();
			if (i >= 10) {
				up_level_exp[i - 1].init(activity, common + "comm_up_exp_inner_"+ i +".png", x, y,3,1);
			}else {
				up_level_exp[i - 1].init(activity, common + "comm_up_exp_inner_0"+ i +".png", x, y,3,1);
			}
		}
	}
	
	public NormalButtonSprite getHelp_up() {
		return help_up;
	}
}
