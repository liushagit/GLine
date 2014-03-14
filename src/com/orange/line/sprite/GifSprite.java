package com.orange.line.sprite;

import org.andengine.entity.sprite.AnimatedSprite;
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
	private int x, y;

	public AnimatedSprite getSprite() {
		return sprite;
	}

	/**
	 * Ĭ�Ͽ�߽��г�ʼ��
	 * 
	 * @param activity
	 *            ����activity
	 * @param x
	 *            ���Ͻ�x����
	 * @param y
	 *            ���Ͻ�y����
	 */
	public void init(BaseGameActivity activity, String imagePath, int x, int y,
			int time, int num) {
		init(activity, imagePath, x, y, 1, 1, 1024, 1024, time, num);
	}

	/**
	 * Ĭ�Ͽ�߽��г�ʼ��
	 * 
	 * @param activity
	 *            ����activity
	 * @param x
	 *            ���Ͻ�x����
	 * @param y
	 *            ���Ͻ�y����
	 * @param columns
	 *            �ָ�ɵ�����
	 * @param rows
	 *            �ָ�ɵ�����
	 */
	public void init(BaseGameActivity activity, String imagePath, int x, int y,
			int columns, int rows, int times, int num) {
		init(activity, imagePath, x, y, columns, rows, 1024, 1024, times, num);
	}

	/**
	 * Ĭ�Ͽ�߽��г�ʼ��
	 * 
	 * @param activity
	 *            ����activity
	 * @param x
	 *            ���Ͻ�x����
	 * @param y
	 *            ���Ͻ�y����
	 * @param columns
	 *            �ָ�ɵ�����
	 * @param rows
	 *            �ָ�ɵ�����
	 * @param width
	 *            ָ����
	 * @param height
	 *            ָ����
	 */
	public void init(BaseGameActivity activity, String imagePath, int x, int y,
			int columns, int rows, int width, int height, int times, int num) {
		this.activity = activity;
		this.x = x;
		this.y = y;
		startBgTexture = new BitmapTextureAtlas(activity.getTextureManager(),
				width, height);
		initGif(num, imagePath, times);
	}

	private void initGif(int num, String path, int times) {
		childTextureRegions = new TextureRegion[num];
		startBgTexture = new BitmapTextureAtlas(activity.getTextureManager(),
				1024, 1024);
		String realPath = "";
		for (int i = 0; i < num; i++) {
			if ((i + 1) < 10) {
				realPath = path + "0" + (i + 1) + ".png";
			} else {
				realPath = path + (i + 1) + ".png";
			}
			childTextureRegions[i] = (TextureRegion) BitmapTextureAtlasTextureRegionFactory
					.createFromAsset(startBgTexture, activity, realPath,
							i * x, y);
		}
		mFaceTextureRegion = new TiledTextureRegion(startBgTexture,
				childTextureRegions);
		startBgTexture.load();
		sprite = new AnimatedSprite(x, y, mFaceTextureRegion,
				activity.getVertexBufferObjectManager());
		sprite.animate(times);

	}

	private TextureRegion[] childTextureRegions;

	public int getCenterX() {
		return (int) (sprite.getWidth() / 2);
	}

	public int getCenterY() {
		return (int) (sprite.getHeight() / 2);
	}

}
