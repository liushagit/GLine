package com.orange.line;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.RepeatingSpriteBackground;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.source.AssetBitmapTextureAtlasSource;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.BaseGameActivity;

import android.util.Log;

public class MoveBall extends BaseGameActivity {

	private static final int CAMERA_WIDTH = 800;
	private static final int CAMERA_HEIGHT = 480;
	private final static float BALL_VELOCITY = 100f;// ����ƶ��ٶ�

	private Camera mCamera;
	private Scene mScene;
	private RepeatingSpriteBackground background;
	private TiledTextureRegion mFaceTextureRegion;

	@Override
	public EngineOptions onCreateEngineOptions() {
		// TODO Auto-generated method stub

		mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		EngineOptions mEngineOptions = new EngineOptions(true,
				ScreenOrientation.LANDSCAPE_SENSOR, new RatioResolutionPolicy(
						CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);
		return mEngineOptions;
	}

	@Override
	public void onCreateResources(
			OnCreateResourcesCallback pOnCreateResourcesCallback)
			throws Exception {
		// TODO Auto-generated method stub
		this.background = new RepeatingSpriteBackground(CAMERA_WIDTH,
				CAMERA_HEIGHT, getTextureManager(),
				AssetBitmapTextureAtlasSource.create(this.getAssets(),
						"game/load/level_layout_n_top.png"), getVertexBufferObjectManager());

		BitmapTextureAtlas mTexture = new BitmapTextureAtlas(
				getTextureManager(), 64, 32,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		mFaceTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(mTexture, this, "game/load/1.png",
						0, 0, 2, 1);
		/**
		 * ����˵��:
		 * mTexure�����ڴ��з�����ͼ��Դ�õ�,64,32��ͼƬҪ��Ŀ�͸�,������2��n�η���С.��:2,4,8,16,32,64,
		 * 128,512,1024.... ����Ҫ��ԭͼ�Ŀ��Ҫ��
		 * 
		 * mFaceTextureRegion�൱�ڴ�mTexure�п�ͼ,��ΪmTexure���ɺܶ�ͼ����ɵ�,Ҫ���н�ȡһƬ����
		 * 0,0�����ͼ��top,right����(�������),2��1�ֱ������ͼ��һ�Ŵ���2��1��
		 * 
		 */
		mTexture.load();

		pOnCreateResourcesCallback.onCreateResourcesFinished();
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback)
			throws Exception {
		// TODO Auto-generated method stub
		mScene = new Scene();
		mScene.setBackground(background);
		final float centerX = (CAMERA_WIDTH - mFaceTextureRegion.getWidth()) / 2;// ������ͼ����������
		final float centerY = (CAMERA_HEIGHT - mFaceTextureRegion.getHeight()) / 2;
		final Ball mBall = new Ball(centerX, centerY, 32, 32,
				this.mFaceTextureRegion, getVertexBufferObjectManager());

		mScene.attachChild(mBall);
		pOnCreateSceneCallback.onCreateSceneFinished(mScene);
	}

	@Override
	public void onPopulateScene(Scene pScene,
			OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception {
		// TODO Auto-generated method stub

		pOnPopulateSceneCallback.onPopulateSceneFinished();
	}

	private static class Ball extends AnimatedSprite {

		float mVelocityX = BALL_VELOCITY;// ���x�����ٶ�
		float mVelocityY = BALL_VELOCITY;// ���y�����ٶ�

		public Ball(float pX, float pY, float pWidth, float pHeight,
				ITiledTextureRegion pTiledTextureRegion,
				VertexBufferObjectManager pVertexBufferObjectManager) {
			super(pX, pY, pWidth, pHeight, pTiledTextureRegion,
					pVertexBufferObjectManager);
			// TODO Auto-generated constructor stub
			mX = 100;
			mY = 100;
		}

//		@Override
//		protected void onManagedUpdate(float pSecondsElapsed) {
//			// TODO Auto-generated method stub
//
//			if (this.mX < 0) {
//				setVelocityX(BALL_VELOCITY);
//			} else if (this.mX + this.getWidth() > CAMERA_WIDTH) {
//				setVelocityX(-BALL_VELOCITY);
//
//			}
//
//			if (this.mY < 0) {
//				setVelocityY(BALL_VELOCITY);
//			} else if (this.mY + this.getHeight() > CAMERA_HEIGHT) {
//				setVelocityY(-BALL_VELOCITY);
//			}
//
//			mX += mVelocityX * pSecondsElapsed;
//			mY += mVelocityY * pSecondsElapsed;
//
//			this.setPosition(mX, mY);
//			Log.d("Season", pSecondsElapsed + "");
//
//			super.onManagedUpdate(pSecondsElapsed);
//
//		}

		void setVelocityX(float vx) {

			mVelocityX = vx;
		}

		void setVelocityY(float vy) {
			mVelocityY = vy;
		}

	}

}
