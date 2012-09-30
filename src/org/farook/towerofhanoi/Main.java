
package org.farook.towerofhanoi;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.bitmap.BitmapTexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.util.adt.io.in.IInputStreamOpener;

public class Main {

    private static Scene scene;
    private static ITextureRegion mBackgroundTextureRegion, mButtonTextureRegion, mCharacterTextureRegion;

    public static Text text;
    public static ArrayList<Sprite> mButtons;
    private static Sprite mButtonActive;

    /**
     * Load the scene and any assets we need.
     * 
     * @throws IOException
     */
    public static void load() throws IOException {
        
    //    mButtons = new ArrayList<Sprite>();

        ITexture backgroundTexture = new BitmapTexture(
                SceneManager.core.getTextureManager(),
                new IInputStreamOpener() {
                    @Override public InputStream open() throws IOException {
                        return SceneManager.core.getAssets().open(
                                "gfx/background.png");
                    }
                });

//        ITexture mCharacterTexture = new BitmapTexture(
//                SceneManager.core.getTextureManager(),
//                new IInputStreamOpener() {
//                    @Override public InputStream open() throws IOException {
//                        return SceneManager.core.getAssets().open("gfx/c.png");
//                    }
//                });
//
//        ITexture buttonTexture = new BitmapTexture(
//                SceneManager.core.getTextureManager(),
//                new IInputStreamOpener() {
//                    @Override public InputStream open() throws IOException {
//                        return SceneManager.core.getAssets().open(
//                                "gfx/button.png");
//                    }
//                });

        // 2 - Load bitmap textures into VRAM
        backgroundTexture.load();
//        mCharacterTexture.load();
//        buttonTexture.load();

        // 3 - Set up texture regions
        mBackgroundTextureRegion = TextureRegionFactory.extractFromTexture(backgroundTexture);
//        mCharacterTextureRegion = TextureRegionFactory.extractFromTexture(mCharacterTexture);
//        mButtonTextureRegion = TextureRegionFactory.extractFromTexture(buttonTexture);
        
        scene = new Scene();
        Sprite backgroundSprite = new Sprite(0, 0, mBackgroundTextureRegion, SceneManager.core.getVertexBufferObjectManager());
        scene.attachChild(backgroundSprite);
//        
//        for (int i = 0; i < 3; i++) {
//
//            Sprite button = new Sprite(200 + (i * 100), 200, mButtonTextureRegion, SceneManager.core.getVertexBufferObjectManager()) {
//
//                @Override public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
//                    try {
//                        mButtonActive= this;
//                        SelectMove.load();
//                    }
//                    catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                    SceneManager.setScene(SelectMove.run());
//                    return true;
//                }
//            };
//            mButtons.add(button);
//        }
//        Sprite mCharacter = new Sprite(100, 100, mCharacterTextureRegion, SceneManager.core.getVertexBufferObjectManager());
//
//
//        for (int i = 0; i < 3; i++) {
//
//            scene.attachChild(mButtons.get(i));
//            scene.registerTouchArea(mButtons.get(i));
//
//        }
//        scene.attachChild(mCharacter);
  //      scene.setTouchAreaBindingOnActionDownEnabled(true);
    }

    /**
     * Return the scene for when the scene is called to become active.
     */
    public static Scene run() {

        return scene;
    }

    /**
     * Unload any assets here - to be called later.
     */
    public static void unload() {

    }
}