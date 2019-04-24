package game.dungeons.greg.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import game.dungeons.greg.Level;
import game.dungeons.greg.util.Assets;
import game.dungeons.greg.util.Constant;
import game.dungeons.greg.util.Enums;
import game.dungeons.greg.util.Enums.Direction;
import game.dungeons.greg.util.Utils;

public class Wizard {

    final long standStartTime;
    long lastTimeShot;
    private float standTimeSeconds;
    private final Platform platform;
    public Vector2 position;
    public int health;
    private Direction direction;
    private Level level;

    public Wizard(Platform platform, Level level) {
        this.platform = platform;
        direction = Direction.LEFT;
        position = new Vector2(platform.left, platform.top);
        standStartTime = TimeUtils.nanoTime();
        health = Constant.WIZARD_HEALTH;
        this.level = level;
        lastTimeShot = TimeUtils.nanoTime();
    }

    public void update(float delta) {

        if (Utils.secondsSince(lastTimeShot) > 2) {
            shoot();
            lastTimeShot = TimeUtils.nanoTime();
        }
    }

    public void render(SpriteBatch batch) {
        TextureRegion region;

        standTimeSeconds = MathUtils.nanoToSec * (TimeUtils.nanoTime() - standStartTime);

        region = Assets.instance.wizardAssets.wizardStandingLeft.getKeyFrame(standTimeSeconds);

        batch.draw(region, platform.left + ((platform.right - platform.left) / 2) * 2, position.y);
    }

    private void shoot() {
        level.spawnProjectile(this);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

}
