package org.farook.towerofhanoi;



import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.bitmap.BitmapTexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.util.adt.io.in.IInputStreamOpener;


public class SelectMove {
	
	private static Scene scene;
	private static ITextureRegion mBackgroundTextureRegion, mButtonTextureRegion;
	
	/**
	 * Load the scene and any assets we need.
	 * @throws IOException 
	 */
	public static void load() throws IOException
	{
        ITexture backgroundTexture = new BitmapTexture(SceneManager.core.getTextureManager(), new IInputStreamOpener() {
            @Override
            public InputStream open() throws IOException {
                return SceneManager.core.getAssets().open("gfx/background.png");
            }
        });

        backgroundTexture.load();
	    
//        ITexture buttonTexture = new BitmapTexture(SceneManager.core.getTextureManager(), new IInputStreamOpener() {
//            @Override
//            public InputStream open() throws IOException {
//                return SceneManager.core.getAssets().open("gfx/button.png");
//            }
//        });
//        buttonTexture.load();
//        
        
       // mButtonTextureRegion = TextureRegionFactory.extractFromTexture(buttonTexture);
        mBackgroundTextureRegion = TextureRegionFactory.extractFromTexture(backgroundTexture);        
	}
	
	/**
	 * Return the scene for when the scene is called to become active.
	 */
	public static Scene run()
	{
		scene = new Scene();
		Sprite backgroundSprite = new Sprite(0, 0, mBackgroundTextureRegion, SceneManager.core.getVertexBufferObjectManager());
	    scene.attachChild(backgroundSprite); 
		ArrayList<Sprite> mButtons=new ArrayList<Sprite>();
		for(int i=0;i<3;i++){

	        Sprite move= new Sprite(0+(i*150), 0, mButtonTextureRegion, SceneManager.core.getVertexBufferObjectManager())
	        {
                @Override
                   public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
          
                       SceneManager.setScene(Main.run());
                       return true;
                   }
           };
         //   move.attachChild(text);
			mButtons.add(move);
            scene.attachChild(move);
            scene.registerTouchArea(move);
		}
        
		
		// now would be a good time to unload all the assets used in FirstScreen
		Main.unload();
		return scene;
	}
	
	/**
	 * Unload any assets here - to be called later.
	 */
	public static void unload()
	{
		
	}
}