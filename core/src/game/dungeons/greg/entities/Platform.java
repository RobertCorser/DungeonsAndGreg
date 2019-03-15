package game.dungeons.greg.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import game.dungeons.greg.util.Assets;

public class Platform {

    public final float top;
    public final float bottom;
    public final float left;
    public final float right;

    public Platform(float left, float top, float width, float height) {
        this.top = top;
        this.bottom = top - height;
        this.left = left;
        this.right = left + width;
    }

    public void render(SpriteBatch batch) {
        float width = right - left;
        float height = top - bottom;

        batch.draw(Assets.instance.platformAssets.platform1, 10, 10, width, height);
    }

}
