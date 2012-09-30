package org.farook.towerofhanoi;

import java.io.IOException;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontManager;
import org.andengine.opengl.texture.Texture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;

import android.graphics.Color;
import android.graphics.Typeface;

/**
 * SceneManager
 * 
 * This SceneManager class is designed to handle the switching of scenes (or
 * 'screens') within our game. Given that this class has access to the core game
 * activity, we're also going to use it for the loading and unloading of our
 * assets, however you may wish to do this in a separate class in your own code.
 */

public class SceneManager {

    public static Game core;


    public static void init(Game base) throws IOException {
        core = base;
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
    }

    /**
     * setScene() is the function we'll be using to switch from one screen to
     * another.
     */
    public static void setScene(Scene scene) {
        core.getEngine().setScene(scene);
    }

    public static void loadTexture(Texture texture) {
        core.getEngine().getTextureManager().loadTexture(texture);
    }

    public static void loadFont(Font font) {
        core.getEngine().getFontManager().loadFont(font);
    }
}