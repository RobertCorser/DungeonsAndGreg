package game.dungeons.greg.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;


public class Assets implements Disposable, AssetErrorListener {

    public static final String TAG = Assets.class.getName();
    public static final Assets instance = new Assets();

    private AssetManager assetManager;

    //Subclass declarations
    public GregAssets gregAssets;
    public KnightAssets knightAssets;


    private Assets() {
    }

    public void init(AssetManager assetManager) {
        TextureAtlas atlas;

        this.assetManager = assetManager;
        assetManager.setErrorListener(this);
        assetManager.load(Constant.TEXTURE_ATLAS, TextureAtlas.class);
        assetManager.finishLoading();

        atlas = assetManager.get(Constant.TEXTURE_ATLAS);
        gregAssets = new GregAssets(atlas);
        knightAssets = new KnightAssets(atlas);
    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset: " + asset.fileName, throwable);
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    public class GregAssets{

        public final AtlasRegion gregStandingRight;

        public GregAssets(TextureAtlas atlas){
            gregStandingRight = atlas.findRegion(Constant.GREG_STANDING_RIGHT);
        }

    }

    public class KnightAssets{
        public final AtlasRegion knightStandingRight;

        public KnightAssets(TextureAtlas atlas){
            knightStandingRight = atlas.findRegion(Constant.KNIGHT_STANDING_RIGHT);

        }
    }

}
