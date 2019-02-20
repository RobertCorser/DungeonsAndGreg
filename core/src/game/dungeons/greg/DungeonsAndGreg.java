package game.dungeons.greg;

import com.badlogic.gdx.Game;

public class DungeonsAndGreg extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen());
    }
}

    /*

    OLD CODE

    SpriteBatch batch;
    TextureRegion greg;

    @Override
    public void create () {
        //TODO --Bobby-- Refactor this code into another screen class
        AssetManager am = new AssetManager();
        Assets.instance.init(am);


        batch = new SpriteBatch();
        greg = new TextureRegion(Assets.instance.gregAssets.gregStandingRight);
    }

    @Override
    public void render () {
        batch.begin();
        //TODO --Kurt-- Render some other sprites
        batch.draw(greg, 0, 0);
        batch.end();


    }

    @Override
    public void dispose () {
        batch.dispose();
    }
}
*/
