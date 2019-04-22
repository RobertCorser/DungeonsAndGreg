package game.dungeons.greg.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import game.dungeons.greg.Level;
import game.dungeons.greg.util.Assets;
import game.dungeons.greg.util.Constant;
import game.dungeons.greg.util.Enums;
import game.dungeons.greg.util.Utils;

public class Projectile {

    private final Enums.Direction direction;
    private final Level level;
    public boolean active;
    private Vector2 position;

    public Projectile(Level level, Vector2 position, Enums.Direction direction) {
        this.level = level;
        this.position = position;
        this.direction = direction;
        active = true;
    }

    public void update(float delta) {
        switch (direction) {
            case LEFT:
                position.x -= delta * Constant.BULLET_MOVE_SPEED;
                break;
            case RIGHT:
                position.x += delta * Constant.BULLET_MOVE_SPEED;
                break;
        }
    }
    public Rectangle getBounds() {
        return new Rectangle(position.x, position.y, 3, 3);
    }
    public void render(SpriteBatch batch) {
        TextureRegion region = Assets.instance.projectileAssets.bullet;
        Utils.drawTextureRegion(batch, region, position, Constant.BULLET_CENTER);
    }
}