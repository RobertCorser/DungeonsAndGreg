package game.dungeons.greg.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

import game.dungeons.greg.util.Assets;
import game.dungeons.greg.util.Constant;
import game.dungeons.greg.util.Enums.Direction;
import game.dungeons.greg.util.Enums.WalkState;
import game.dungeons.greg.util.Enums.JumpState;

public class Greg {

    private Vector2 position;

    private long walkStartTime;
    private float walkTimeSeconds;

    private long standStartTime;
    private float standTimeSeconds;

    private Direction facing;
    private WalkState walkState;

    public Greg() {
        position = new Vector2(0, 0);
        standStartTime = TimeUtils.nanoTime();
    }

    public void render(SpriteBatch batch) {
        //Default value
        TextureRegion region;

        standTimeSeconds = MathUtils.nanoToSec * (TimeUtils.nanoTime() - standStartTime);
        region = Assets.instance.gregAssets.gregStandingRight.getKeyFrame(standTimeSeconds);


        batch.draw(region, position.x, position.y);
    }

    public void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            moveLeft(delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            moveRight(delta);
        }


    }

    private void moveLeft(float delta) {
        walkState = WalkState.WALKING;
        facing = Direction.LEFT;

        walkStartTime = TimeUtils.nanoTime();
        position.x -= delta * Constant.GREG_MOVE_SPEED;
    }

    private void moveRight(float delta) {
        walkState = WalkState.WALKING;
        facing = Direction.RIGHT;

        walkStartTime = TimeUtils.nanoTime();
        position.x += delta * Constant.GREG_MOVE_SPEED;
    }

    public Vector2 getPosition() {
        return position;
    }
}
