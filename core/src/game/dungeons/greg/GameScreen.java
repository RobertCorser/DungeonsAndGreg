package game.dungeons.greg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import game.dungeons.greg.entities.Greg;
import game.dungeons.greg.entities.Platform;
import game.dungeons.greg.util.Assets;
import game.dungeons.greg.util.Background;
import game.dungeons.greg.util.Constant;

public class GameScreen extends ScreenAdapter {

    private SpriteBatch batch;
    private ExtendViewport viewport;
    private Greg greg;
    private Platform testPlatform;
    private Background background;
    private Texture background1, background2, background3, background4;



    @Override
    public void show() {
        AssetManager assetManager = new AssetManager();
        Assets.instance.init(assetManager);

        greg = new Greg();
        background = new Background();

        testPlatform = new Platform(45,2, 20, 5);


        batch = new SpriteBatch();
        viewport = new ExtendViewport(Constant.WORLD_SIZE, Constant.WORLD_SIZE);
    }

    @Override
    public void render(float delta) {
        update(delta);

       Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        background.render(batch);

        greg.render(batch);
        testPlatform.render(batch);

        batch.end();

    }

    private void update(float delta){
        greg.update(delta);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    public SpriteBatch getBatch() {
        return batch;
    }


}
