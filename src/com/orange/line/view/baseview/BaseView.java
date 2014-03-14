package com.orange.line.view.baseview;

import org.andengine.entity.Entity;
import org.andengine.ui.activity.BaseGameActivity;

public abstract class BaseView extends Entity{
	public BaseGameActivity activity;
	public BaseView(BaseGameActivity activity){
		this.activity = activity;
	}
	
	protected abstract void init();
}
