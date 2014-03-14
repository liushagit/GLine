package com.orange.line;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.RepeatingSpriteBackground;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.debug.Debug;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.orange.line.core.Constants;
import com.orange.line.scene.GameScene;
import com.orange.line.util.PhoneWH;
import com.orange.line.view.game.MainGameActivity;
import com.orange.line.view.start.LoadGame;
import com.orange.line.view.start.StartGame;

public class MainActivity extends BaseGameActivity {

	private Camera mCamera;
	private RepeatingSpriteBackground background;
	private GameScene mScene;

	@Override
	protected void onCreate(final Bundle pSavedInstanceState) {
		super.onCreate(pSavedInstanceState);
		Debug.i("===onCreate");
	}

	@Override
	public EngineOptions onCreateEngineOptions() {
		if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		}
		PhoneWH.init(this);
		mCamera = new Camera(0, 0, PhoneWH.width, PhoneWH.height);
		
//		BaseResolutionPolicy�����˻�У��һ����Ļ��С�⣬ʲôҲ��������
//		FillResolutionPolicy��������Ϸ����Ϊȫ����䣬���������С��ͬ�����в�ͬ�̶ȱ��Σ���
//		FixedResolutionPolicy��ǿ�й涨��Ϸ����Ϊ�̶���С�������ò����Զ���Ӧ��Ļ��С����
//		RatioResolutionPolicy�����������������С������Ӧ��Ļ��С����
//		RelativeResolutionPolicy�����ݹ���RelativeResolutionPolicyʱ�����Ų�����������Ϸ��ĻΪָ����������
		
		
		//����������
//		RatioResolutionPolicy ratioResolutionPolicy = new RatioResolutionPolicy(
//				PhoneWH.width, PhoneWH.height);
		//ȫ������
		FillResolutionPolicy ratioResolutionPolicy = new FillResolutionPolicy();
				
		Debug.i("===onCreateEngineOptions" + "|" + PhoneWH.width + "|"
				+ PhoneWH.height);
		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED,
				ratioResolutionPolicy, mCamera);
//		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR,
//				ratioResolutionPolicy, mCamera);
	}

//	GameTop top;
	StartGame start;
	LoadGame loading;
	MainGameActivity mainGameActivity;
	@Override
	public void onCreateResources(
			OnCreateResourcesCallback pOnCreateResourcesCallback)
			throws Exception {
		Debug.i("===onCreateResources");
//		this.background = new RepeatingSpriteBackground(PhoneWH.width,
//				PhoneWH.height, getTextureManager(),
//				AssetBitmapTextureAtlasSource.create(this.getAssets(),
//						"game/load/loading_bg.jpg"),
//				getVertexBufferObjectManager());
//		top = new GameTop(this);
//		start = new StartGame(this);
//		loading = new LoadGame(this);
		mainGameActivity = new MainGameActivity(this, Constants.MAINGAME);
		pOnCreateResourcesCallback.onCreateResourcesFinished();
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback)
			throws Exception {
		Debug.i("===onCreateScene");

		mScene = new GameScene(Constants.LOADING);
		mScene.attachChild(mainGameActivity);
		mScene.registerTouchArea(mainGameActivity.getTop().getHelp_up().getSprite());

		pOnCreateSceneCallback.onCreateSceneFinished(mScene);
	}

	@Override
	public void onPopulateScene(Scene pScene,
			OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception {
		Debug.i("===onPopulateScene");
		pOnPopulateSceneCallback.onPopulateSceneFinished();
	}

	long exitTime = 0;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		GameScene scene = (GameScene) getEngine().getScene();
//		if (scene.getSceneType() == Constants.START || scene.getSceneType() == Constants.MAINGAME) {
			if (keyCode == KeyEvent.KEYCODE_BACK
					&& event.getAction() == KeyEvent.ACTION_DOWN) {
				if ((System.currentTimeMillis() - exitTime) > 2000) {
					Toast.makeText(getApplicationContext(), "�ٰ�һ���˳�����",
							Toast.LENGTH_SHORT).show();
					exitTime = System.currentTimeMillis();
				} else {
					finish();
					System.exit(0);
				}
				return true;
			}
//		}
		if (scene.getSceneType() == Constants.LOADING) {
			return false;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	
}
