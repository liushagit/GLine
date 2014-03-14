package com.orange.line.view.baseview;

import org.andengine.entity.Entity;
import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.BaseGameActivity;

/**
 * ³¡¾°Ä£¿é»¯
 * @author guojiang
 *
 */
public class PackageView extends Entity{

	public PackageView(float pX,float pY,String filePath,BaseGameActivity activity){
		
		BitmapTextureAtlas mTexture = new BitmapTextureAtlas(
				activity.getTextureManager(), 1024, 1024,
				TextureOptions.DEFAULT);
//		TiledTextureRegion mFaceTextureRegion = BitmapTextureAtlasTextureRegionFactory
//				.createTiledFromAsset(mTexture, activity, "game/load/1.png",
//						0, 0, 2, 1);
		TiledTextureRegion mFaceTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(mTexture, activity, filePath,
						0, 0, 1, 1);
		
		mTexture.load();

	}
}
