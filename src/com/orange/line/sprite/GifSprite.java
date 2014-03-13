package com.orange.line.sprite;

import org.andengine.engine.Engine;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.BaseGameActivity;

public class GifSprite extends BaseSprite {
	private BitmapTextureAtlas startBgTexture;
	private TiledTextureRegion mFaceTextureRegion;
	private AnimatedSprite sprite;
	private BaseGameActivity activity;
	private int x,y;

	public AnimatedSprite getSprite() {
		return sprite;
	}

	/**
	 * 默认宽高进行初始化
	 * @param activity 所在activity
	 * @param x	左上角x坐标
	 * @param y	左上角y坐标
	 */
	public void init(BaseGameActivity activity, String imagePath,int x, int y ) {
		init(activity,imagePath, x, y, 1, 1, 1024, 1024,100);
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
			int rows,int times) {
		init(activity,imagePath, x, y, columns, rows, 1024, 1024,times);
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
	public void init(BaseGameActivity activity, String imagePath,int x, int y, int columns,
			int rows, int width, int height,int times) {
		this.activity = activity;
		this.x = x;
		this.y = y;
		startBgTexture = new BitmapTextureAtlas(activity.getTextureManager(),
				width, height);
		initGif(2, imagePath);
//		init(imagePath,columns,rows,times);
	}
	
	private void init(String imagePath,int columns, int rows,int times){
//		mFaceTextureRegion = new TiledTextureRegion(startBgTexture, childTextureRegions);
		mFaceTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(startBgTexture, activity,
						imagePath, x, y, columns, rows);
		startBgTexture.load();
		sprite = new AnimatedSprite(x, y, mFaceTextureRegion,
				activity.getVertexBufferObjectManager());
//		sprite.setCurrentTileIndex(1);
		sprite.animate(times,true);
	}
	
	private void initGif(int num , String path){
//		 childTextureRegions = new TextureRegion[num]; 
//		 startBgTexture = new BitmapTextureAtlas(activity.getTextureManager(), 1024, 1024);
//		 String realPath = "";
//	        for (int i=0; i<num; i++)  
//	        {  
//	        	if ((i + 1) < 10) {
//	        		realPath = path + "0" + (i + 1) + ".png";
//				}else {
//					realPath = path + (i + 1) + ".png";
//				}
//	        	childTextureRegions[i] = (TextureRegion) BitmapTextureAtlasTextureRegionFactory.createFromAsset(startBgTexture,  
//						activity, realPath, x, y);  
//	        }  
//	        mFaceTextureRegion = new TiledTextureRegion(startBgTexture, childTextureRegions);
//	        startBgTexture.load();
//	        sprite = new AnimatedSprite(x, y, mFaceTextureRegion,
//					activity.getVertexBufferObjectManager());
//	        sprite.animate(10,true);
//	        
		
	}
	
	private void init(Engine mEngine,Scene mMenuScene){
		sprite = new AnimationSprite(activity,
                mEngine,
                new String[]{"game_mole1.png",
                        "game_mole2.png",
                        "game_mole3.png",
                        "game_mole4.png",
                        "game_mole5.png",},
                100, 100, 85, 85);
	}
	private TextureRegion[] childTextureRegions;
	

	public int getCenterX(){
		return (int)(sprite.getWidth() / 2);
	}
	public int getCenterY(){
		return (int)(sprite.getHeight() / 2);
	}


}
