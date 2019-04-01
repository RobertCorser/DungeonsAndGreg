package game.dungeons.greg.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class Background {

    public void render(SpriteBatch batch) {
        batch.draw(Assets.instance.backgroundAssets.background3, 0x0 , 0x0);
        batch.draw(Assets.instance.backgroundAssets.background4, 0x0 , 0x0);
        batch.draw(Assets.instance.backgroundAssets.background1, 0x0 , 0x0);
        batch.draw(Assets.instance.backgroundAssets.background2, 0x0 , 0x0);


    }


}
