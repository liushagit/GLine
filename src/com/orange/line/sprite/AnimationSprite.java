package com.orange.line.sprite;

import org.andengine.engine.Engine;
import org.andengine.entity.shape.IShape;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.texture.Texture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.util.modifier.IModifier;

import android.content.Context;
 
/**
 * Created with IntelliJ IDEA.
 * User: wulong
 * Date: 14-1-22
 * Time: 下午3:39
 * To change this template use File | Settings | File Templates.
 */
public class AnimationSprite {
 
    // 总的图片纹理区域
    private TiledTextureRegion tiledTextureRegion;
    // 测试用的动画精灵
    private AnimatedSprite     animatedSprite;
 
    private boolean isMultiImages = false;
 
    public AnimationSprite(Context pCtx,
                           Engine pEngine,
                           String[] pAssetsPicNameList,
                           final float pX,
                           final float pY,
                           final int pWidth,
                           final int pHeight) {
 
        int canvasWidth = 2;
        int canvasHeight = 2;
 
        while (canvasWidth < pWidth * pAssetsPicNameList.length) {
            canvasWidth = canvasWidth * 2;
        }
 
        while (canvasHeight < pHeight) {
            canvasHeight = canvasHeight * 2;
        }
 
        Texture bitmapTextureAtlas = new Texture(canvasWidth, canvasHeight, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        TextureRegion[] childTextureRegions = new TextureRegion[pAssetsPicNameList.length];
 
        for (int i = 0; i < pAssetsPicNameList.length; i++) {
            childTextureRegions<i> = TextureRegionFactory.createFromAsset(bitmapTextureAtlas,
                    pCtx,
                    pAssetsPicNameList<i>,
                    i * pWidth, 0);
        }
 
        tiledTextureRegion = new TiledTextureRegion(bitmapTextureAtlas
                , 0, 0
                , pWidth * pAssetsPicNameList.length
                , bitmapTextureAtlas.getHeight()
                , pAssetsPicNameList.length, 1);
        pEngine.getTextureManager().loadTexture(bitmapTextureAtlas);
        animatedSprite = new AnimatedSprite(pX, pY,tiledTextureRegion);
        animatedSprite.setVisible(false);
 
 
        if (pAssetsPicNameList.length > 1) {
            isMultiImages = true;
        }
    }
 
//    public void addShapeModifier(final IModifier<IShape> pShapeModifier) {
//        animatedSprite.addShapeModifier(pShapeModifier);
//    }
 
 
    public void setVisible(boolean visible) {
        animatedSprite.setVisible(visible);
    }
 
    public void animate(long pDuration) {
        if (null != animatedSprite && isMultiImages) {
            animatedSprite.animate(pDuration);
        }
    }
 
    public void setPosition(final float pX, final float pY) {
        animatedSprite.setPosition(pX, pY);
    }
 
    public void setWidth(final float pWidth) {
        animatedSprite.setWidth(pWidth);
    }
 
    public void setScale(final float pScale) {
        animatedSprite.setScale(pScale);
    }
 
    public boolean isVisible() {
        return animatedSprite.isVisible();
    }
 
    public void setHeight(final float pHeight) {
        animatedSprite.setHeight(pHeight);
    }
 
    public float getX() {
        return animatedSprite.getX();
    }
 
    public float getY() {
        return animatedSprite.getY();
    }
 
    public float getWidth() {
        return animatedSprite.getWidth();
    }
 
    public float getHeight() {
        return animatedSprite.getHeight();
    }
}