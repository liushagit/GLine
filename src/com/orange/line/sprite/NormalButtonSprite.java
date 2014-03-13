package com.orange.line.sprite;

import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.BaseGameActivity;

import com.orange.line.view.baseview.BaseButtonSprite;


public class NormalButtonSprite {

	private BitmapTextureAtlas startBgTexture;
	private TiledTextureRegion mFaceTextureRegion;
	private BaseButtonSprite buttonSprite;
	public NormalButtonSprite(){
	}
	public BaseButtonSprite getSprite() {
		return buttonSprite;
	}

	/**
	 * 默认宽高进行初始化
	 * @param activity 所在activity
	 * @param x	左上角x坐标
	 * @param y	左上角y坐标
	 */
	public void init(BaseGameActivity activity, String imagePath,int x, int y ) {
		init(activity,imagePath, x, y, 1, 1, 1024, 1024);
	}
	/**
	 * 默认宽高进行初始化
	 * @param activity 所在activity
	 * @param x	左上角x坐标
	 * @param y	左上角y坐标
	 * @param columns	分割成的行数
	 * @param rows	分割成的列数
	 */
	public void init(BaseGameActivity activity, String imagePath, int x, int y, int columns,
			int rows) {
		init(activity,imagePath, x, y, columns, rows, 1024, 1024);
	}

	/**
	 * 默认宽高进行初始化
	 * @param activity 所在activity
	 * @param x	左上角x坐标
	 * @param y	左上角y坐标
	 * @param columns	分割成的行数
	 * @param rows	分割成的列数
	 * @param width	指定宽
	 * @param height	指定高
	 */
	public void init(final BaseGameActivity activity, String imagePath,int x, int y, int columns,
			int rows, int width, int height) {
		startBgTexture = new BitmapTextureAtlas(activity.getTextureManager(),
				width, height, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		mFaceTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(startBgTexture, activity,
						imagePath, x, y, columns, rows);
		buttonSprite = new BaseButtonSprite(x, y, mFaceTextureRegion, activity.getVertexBufferObjectManager());
		startBgTexture.load();
	}

}
