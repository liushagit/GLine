package com.orange.line.view.start;

import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.debug.Debug;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.orange.line.sprite.NormalButtonSprite;
import com.orange.line.sprite.NormalSprite;
import com.orange.line.view.baseview.BaseView;

public class StartGame extends BaseView {

	public StartGame(BaseGameActivity activity) {
		super(activity);
		init();
	}

	NormalSprite start_bg_sprite;
	NormalSprite start_logo_sprite;
	NormalButtonSprite start_start_sprite;
	NormalButtonSprite start_help_sprite;
	NormalButtonSprite start_more_sprite;
	String basePath = "image/start/";

	@Override
	protected void init() {
		start_bg_sprite = new NormalSprite();
		start_bg_sprite.init(activity, basePath + "start_bg.png", 0, 0);

		int x = (int) (start_bg_sprite.getSprite().getWidth() / 4 * 3);
		int y = 0;
		start_logo_sprite = new NormalSprite();
		start_logo_sprite.init(activity, basePath + "start_logo.png", x - 190,
				y);

		y += (int) (start_logo_sprite.getSprite().getHeight() + 10);
		start_start_sprite = new NormalButtonSprite();
		start_start_sprite.init(activity, basePath + "start_start_01.png",
				x - 141, y);

		y += (int) (start_start_sprite.getSprite().getHeight() + 10);
		start_help_sprite = new NormalButtonSprite();
		start_help_sprite.init(activity, basePath + "start_help_01.png",
				x - 141, y);

		y += (int) (start_help_sprite.getSprite().getHeight() + 10);
		start_more_sprite = new NormalButtonSprite();
		start_more_sprite.init(activity, basePath + "start_more_01.png",
				x - 141, y);

		attachChild(start_bg_sprite.getSprite());
		attachChild(start_logo_sprite.getSprite());
		attachChild(start_start_sprite.getSprite());
		attachChild(start_help_sprite.getSprite());
		attachChild(start_more_sprite.getSprite());

		start_start_sprite.getSprite().setOnClickListener(linster);
		 start_help_sprite.getSprite().setOnClickListener(linster);
		 start_more_sprite.getSprite().setOnClickListener(linster);

	}

	OnClickListener linster = new OnClickListener() {
		
		@Override
		public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX,
				float pTouchAreaLocalY) {

			if (pButtonSprite == start_start_sprite.getSprite()) {
				Message msg = new Message();
				Bundle bundle = msg.getData();
				bundle.putString("button", "start_start_sprite");
				startHandler.sendMessage(msg);
				Debug.e("=====start_start_sprite====");
			}
			if (pButtonSprite == start_help_sprite.getSprite()) {
				Message msg = new Message();
				Bundle bundle = msg.getData();
				bundle.putString("button", "start_help_sprite");
				startHandler.sendMessage(msg);
				Debug.e("=====start_help_sprite====");
			}
			if (pButtonSprite == start_more_sprite.getSprite()) {
				Message msg = new Message();
				Bundle bundle = msg.getData();
				bundle.putString("button", "start_more_sprite");
				startHandler.sendMessage(msg);
				Debug.e("=====start_more_sprite====");
			}
		}
	};

	
	Handler startHandler = new Handler(activity.getMainLooper()){

		@Override
		public void handleMessage(Message msg) {
			Bundle b = msg.getData();
			String message = b.getString("button");
			Toast.makeText(activity.getApplicationContext(), message,
					Toast.LENGTH_SHORT).show();
		}
		
	};
	
	public NormalButtonSprite getStart_start_sprite() {
		return start_start_sprite;
	}

	public NormalButtonSprite getStart_more_sprite() {
		return start_more_sprite;
	}

	public NormalButtonSprite getStart_help_sprite() {
		return start_help_sprite;
	}

}
