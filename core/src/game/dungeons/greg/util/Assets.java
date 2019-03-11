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


    public void init(AssetManager assetManager) {
        TextureAtlas atlas;

        this.assetManager = assetManager;
        assetManager.setErrorListener(this);
        assetManager.load(Constant.TEXTURE_ATLAS, TextureAtlas.class);
        assetManager.finishLoading();

        atlas = assetManager.get(Constant.TEXTURE_ATLAS);

        //SPRITE ASSETS
        gregAssets = new GregAssets(atlas);
        knightAssets = new KnightAssets(atlas);
        necroAssets = new NecroAssets(atlas);
    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset: " + asset.fileName, throwable);
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    // ASSET DECLARATIONS//
    public GregAssets gregAssets;
    public KnightAssets knightAssets;
    public NecroAssets necroAssets;

    private Assets() {
    }

    public class GregAssets{

        public final Animation gregStandingRight;

        //public final AtlasRegion gregStandingRight0;
        public final AtlasRegion gregStandingRight1;
        public final AtlasRegion gregStandingRight2;
        public final AtlasRegion gregStandingRight3;

        public GregAssets(TextureAtlas atlas){

            //gregStandingRight0 = atlas.findRegion(Constant.GREG_STANDING_RIGHT_0);
            gregStandingRight1 = atlas.findRegion(Constant.GREG_STANDING_RIGHT_1);
            gregStandingRight2 = atlas.findRegion(Constant.GREG_STANDING_RIGHT_2);
            gregStandingRight3 = atlas.findRegion(Constant.GREG_STANDING_RIGHT_3);

            Array<AtlasRegion> standingRightAnimation = new Array<AtlasRegion>();
            standingRightAnimation.addAll(gregStandingRight1, gregStandingRight2, gregStandingRight3);
            gregStandingRight = new Animation(Constant.GREG_ANIM_SPEED, standingRightAnimation, PlayMode.LOOP);

        }

    }

    public class KnightAssets{
        public final AtlasRegion knightStandingRight0;
        public final AtlasRegion knightStandingRight1;
        public final AtlasRegion knightStandingRight2;
        public final AtlasRegion knightStandingRight3;
        public final AtlasRegion knightRunningRight0;
        public final AtlasRegion knightRunningRight1;
        public final AtlasRegion knightRunningRight2;
        public final AtlasRegion knightRunningRight3;
        public final AtlasRegion knighthit0;

        public KnightAssets(TextureAtlas atlas){
            knightStandingRight0 = atlas.findRegion(Constant.KNIGHT_STANDING_RIGHT_0);
            knightStandingRight1 = atlas.findRegion(Constant.KNIGHT_STANDING_RIGHT_1);
            knightStandingRight2 = atlas.findRegion(Constant.KNIGHT_STANDING_RIGHT_2);
            knightStandingRight3 = atlas.findRegion(Constant.KNIGHT_STANDING_RIGHT_3);
            knightRunningRight0 = atlas.findRegion(Constant.KNIGHT_RUN_RIGHT_0);
            knightRunningRight1 = atlas.findRegion(Constant.KNIGHT_RUN_RIGHT_1);
            knightRunningRight2 = atlas.findRegion(Constant.KNIGHT_RUN_RIGHT_2);
            knightRunningRight3 = atlas.findRegion(Constant.KNIGHT_RUN_RIGHT_3);
            knighthit0 = atlas.findRegion(Constant.KNIGHT_HIT);
        }
    }

    //Necromancer
    public class NecroAssets {

        public NecroAssets(TextureAtlas atlas){

        }
    }

}

