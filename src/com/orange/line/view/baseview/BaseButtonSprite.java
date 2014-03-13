package com.orange.line.view.baseview;

import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

public class BaseButtonSprite extends ButtonSprite{

	public BaseButtonSprite(float pX, float pY,
			ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			OnClickListener pOnClickListener) {
		super(pX, pY, pTiledTextureRegion, pVertexBufferObjectManager, pOnClickListener);
	}

	
	public BaseButtonSprite(float pX, float pY,
			ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pX, pY, pTiledTextureRegion, pVertexBufferObjectManager);
	}
	public BaseButtonSprite(float pX, float pY,
			ITextureRegion pNormalTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			OnClickListener pOnClickListener) {
		super(pX, pY, pNormalTextureRegion, pVertexBufferObjectManager,
				pOnClickListener);
	}
	public BaseButtonSprite(float pX, float pY,
			ITextureRegion pNormalTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pX, pY, pNormalTextureRegion, pVertexBufferObjectManager);
	}
	public BaseButtonSprite(float pX, float pY,
			ITextureRegion pNormalTextureRegion,
			ITextureRegion pPressedTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			OnClickListener pOnClickListener) {
		super(pX, pY, pNormalTextureRegion, pPressedTextureRegion,
				pVertexBufferObjectManager, pOnClickListener);
		// TODO Auto-generated constructor stub
	}
	public BaseButtonSprite(float pX, float pY,
			ITextureRegion pNormalTextureRegion,
			ITextureRegion pPressedTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pX, pY, pNormalTextureRegion, pPressedTextureRegion,
				pVertexBufferObjectManager);
	}

	
	public BaseButtonSprite(float pX, float pY,
			ITextureRegion pNormalTextureRegion,
			ITextureRegion pPressedTextureRegion,
			ITextureRegion pDisabledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pX, pY, pNormalTextureRegion, pPressedTextureRegion,
				pDisabledTextureRegion, pVertexBufferObjectManager);
	}
	public BaseButtonSprite(float pX, float pY,
			ITextureRegion pNormalTextureRegion,
			ITextureRegion pPressedTextureRegion,
			ITextureRegion pDisabledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			OnClickListener pOnClickListener) {
		super(pX, pY, pNormalTextureRegion, pPressedTextureRegion,
				pDisabledTextureRegion, pVertexBufferObjectManager, pOnClickListener);
	}

	
	private BaseButtonSprite downButtonSprite;

	public BaseButtonSprite getDownButtonSprite() {
		return downButtonSprite;
	}


	public void setDownButtonSprite(BaseButtonSprite downButtonSprite) {
		this.downButtonSprite = downButtonSprite;
	}


	@Override
	public boolean onAreaTouched(TouchEvent pSceneTouchEvent,
			float pTouchAreaLocalX, float pTouchAreaLocalY) {
		super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
		if (downButtonSprite == null) {
			return true;
		}
		if (pSceneTouchEvent.isActionDown()) {
			Debug.e("====================isActionDown==========");
			downButtonSprite.setVisible(true);
		}
		if (pSceneTouchEvent.isActionUp()) {
			Debug.e("====================isActionUp==========");
			downButtonSprite.setVisible(false);
		}
		if (pSceneTouchEvent.getX() < downButtonSprite.getX() 
				|| pSceneTouchEvent.getX() > downButtonSprite.getX() + downButtonSprite.getWidth()
				|| pSceneTouchEvent.getY() < downButtonSprite.getY()
				|| pSceneTouchEvent.getY() > downButtonSprite.getY() + downButtonSprite.getHeight()) {
			downButtonSprite.setVisible(false);
			Debug.e("====================isActionOutside==========");
		}
		Debug.e("xxxxxxxxxx" +  pSceneTouchEvent.getX() + "xxxxxxxxxxxx" + downButtonSprite.getX() + "xxxx" + downButtonSprite.getWidth());
		Debug.e("YYYYYYYYYYYY" +  pSceneTouchEvent.getY() + "YYYYYYYYY" + downButtonSprite.getY() + "YYYY" + downButtonSprite.getHeight());
		return true;
//		
//		return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
//		
	}


	
}
