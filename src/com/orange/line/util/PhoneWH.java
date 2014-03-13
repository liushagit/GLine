package com.orange.line.util;

import org.andengine.util.debug.Debug;

import android.app.Activity;
import android.util.DisplayMetrics;

public class PhoneWH {

	public static int width = 800;
	public static int height = 480;
//	public static int width = 0;
//	public static int height = 0;
	public static float density = 0;
	private PhoneWH(){}
	public static void init(Activity activity){
		if (width <= 0 || height <= 0) {
			DisplayMetrics dm = new DisplayMetrics();  
			activity.getWindowManager().getDefaultDisplay().getMetrics(dm);  
			width = (int)dm.widthPixels;
			height = (int)dm.heightPixels;
			density = dm.density;
			Debug.i("width1===========" + width);
			Debug.i("height1===========" + height);
			
			
			width = (int)(width * density);
			height = (int)(height * density);
			Debug.i("width2===========" + width);
			Debug.i("height2===========" + height);
			Debug.i("density===========" + density);
			
		}
	}
}
