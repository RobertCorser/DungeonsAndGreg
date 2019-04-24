package game.dungeons.greg.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
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

    // ASSET DECLARATIONS//
    public GregAssets gregAssets;
    public KnightAssets knightAssets;
    public NecroAssets necroAssets;
    public PlatformAssets platformAssets;
    public BackgroundAssets backgroundAssets;
    public ProjectileAssets projectileAssets;
    public WizardAssets wizardAssets;

    private Assets() {
    }

    public void init(AssetManager assetManager) {
        TextureAtlas atlas;


        this.assetManager = assetManager;
        assetManager.setErrorListener(this);
        assetManager.load(Constant.TEXTURE_ATLAS, TextureAtlas.class);

        assetManager.load(Constant.BACKGROUND1, Texture.class);
        assetManager.load(Constant.BACKGROUND2, Texture.class);
        assetManager.load(Constant.BACKGROUND3, Texture.class);
        assetManager.load(Constant.BACKGROUND4, Texture.class);

        assetManager.finishLoading();

        atlas = assetManager.get(Constant.TEXTURE_ATLAS);

        //SPRITE ASSETS
        gregAssets = new GregAssets(atlas);
        knightAssets = new KnightAssets(atlas);
        necroAssets = new NecroAssets(atlas);
        wizardAssets = new WizardAssets(atlas);

        platformAssets = new PlatformAssets(atlas);

        backgroundAssets = new BackgroundAssets();

        projectileAssets = new ProjectileAssets(atlas);




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

        public final Animation gregStandingRight;

        public final AtlasRegion gregStandingRight1;
        public final AtlasRegion gregStandingRight2;
        public final AtlasRegion gregStandingRight3;

        public GregAssets(TextureAtlas atlas){

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

    public class WizardAssets{

        public final AtlasRegion wizardStandingRight0;
        public final AtlasRegion wizardStandingRight1;
        public final AtlasRegion wizardStandingRight2;
        public final AtlasRegion wizardStandingRight3;

        public final AtlasRegion wizardStandingLeft0;
        public final AtlasRegion wizardStandingLeft1;
        public final AtlasRegion wizardStandingLeft2;
        public final AtlasRegion wizardStandingLeft3;

        public final AtlasRegion wizardWeaponLeft;
        public final AtlasRegion wizardWeaponRight;

        public final Animation wizardStandingRight;
        public final Animation wizardStandingLeft;

        public WizardAssets(TextureAtlas atlas){

            wizardWeaponLeft = atlas.findRegion(Constant.WIZARD_WEAPON_LEFT);
            wizardWeaponRight = atlas.findRegion(Constant.WIZARD_WEAPON_RIGHT);

            wizardStandingRight0 = atlas.findRegion(Constant.WIZARD_STANDING_RIGHT_0);
            wizardStandingRight1 = atlas.findRegion(Constant.WIZARD_STANDING_RIGHT_1);
            wizardStandingRight2 = atlas.findRegion(Constant.WIZARD_STANDING_RIGHT_2);
            wizardStandingRight3 = atlas.findRegion(Constant.WIZARD_STANDING_RIGHT_3);

            wizardStandingLeft0 = atlas.findRegion(Constant.WIZARD_STANDING_LEFT_0);
            wizardStandingLeft1 = atlas.findRegion(Constant.WIZARD_STANDING_LEFT_1);
            wizardStandingLeft2 = atlas.findRegion(Constant.WIZARD_STANDING_LEFT_2);
            wizardStandingLeft3 = atlas.findRegion(Constant.WIZARD_STANDING_LEFT_3);

            Array<AtlasRegion> standingRightAnimation = new Array<AtlasRegion>();
            standingRightAnimation.addAll(wizardStandingRight0, wizardStandingRight1, wizardStandingRight2, wizardStandingRight3);
            wizardStandingRight = new Animation(Constant.WIZARD_ANIM_SPEED, standingRightAnimation, PlayMode.LOOP);

            Array<AtlasRegion> standingLeftAnimation = new Array<AtlasRegion>();
            standingLeftAnimation.addAll(wizardStandingLeft0, wizardStandingLeft1, wizardStandingLeft2, wizardStandingLeft3);
            wizardStandingLeft = new Animation(Constant.WIZARD_ANIM_SPEED, standingLeftAnimation, PlayMode.LOOP);

        }

    }

    public class PlatformAssets{

        public AtlasRegion platform1;

        public PlatformAssets(TextureAtlas atlas){

            platform1 = atlas.findRegion(Constant.PLATFORM_1);
        }
    }
    public class BackgroundAssets{
        public Texture background1;
        public Texture background2;
        public Texture background3;
        public Texture background4;

        public BackgroundAssets(){
            background1 = new Texture(Constant.BACKGROUND1);
            background2 = new Texture(Constant.BACKGROUND2);
            background3 = new Texture(Constant.BACKGROUND3);
            background4 = new Texture(Constant.BACKGROUND4);
        }
    }

    public class ProjectileAssets {

        public final AtlasRegion bullet;

        public ProjectileAssets(TextureAtlas atlas) {
            bullet = atlas.findRegion(Constant.BULLET_SPRITE);
        }

    }

}

