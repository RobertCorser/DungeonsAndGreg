package game.dungeons.greg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import game.dungeons.greg.entities.Greg;
import game.dungeons.greg.entities.Platform;
import game.dungeons.greg.entities.Projectile;
import game.dungeons.greg.util.Assets;
import game.dungeons.greg.util.Background;
import game.dungeons.greg.util.Constant;
import game.dungeons.greg.util.Enums;

public class GameScreen extends ScreenAdapter {

    private SpriteBatch batch;
    private Level level;


    @Override
    public void show() {
        AssetManager assetManager = new AssetManager();
        Assets.instance.init(assetManager);
        batch = new SpriteBatch();
        level = new Level();
    }

    @Override
    public void render(float delta) {
        update(delta);
       /* Gdx.gl.glClearColor(Constant.BACKGROUND_COLOR.r,
                Constant.BACKGROUND_COLOR.g,
                Constant.BACKGROUND_COLOR.b,
                Constant.BACKGROUND_COLOR.a);
                */
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        level.render(batch);

    }

    private void update(float delta) {
        level.update(delta);
    }

    @Override
    public void resize(int width, int height) {
        level.viewport.update(width, height, true);
    }

}
