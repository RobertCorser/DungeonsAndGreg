package game.dungeons.greg.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import game.dungeons.greg.GameScreen;
import game.dungeons.greg.Level;
import game.dungeons.greg.util.Assets;
import game.dungeons.greg.util.Constant;
import game.dungeons.greg.util.Enums.Direction;
import game.dungeons.greg.util.Enums.WalkState;
import game.dungeons.greg.util.Enums.JumpState;
import game.dungeons.greg.util.Utils;

public class Greg {

    //TODO dying, ammo

    private Vector2 position;
    private Vector2 lastFramePosition;
    private Vector2 velocity;

    private long walkStartTime;
    private float walkTimeSeconds;

    private long standStartTime;
    private float standTimeSeconds;

    private long jumpStartTime;
    private float jumpTimeSeconds;

    private Direction facing;
    private WalkState walkState;
    private JumpState jumpState;

    private Level level;

    public Greg(Vector2 initPosition, Level level) {
        position = new Vector2(0, 0);
        lastFramePosition = new Vector2(0, 0);
        standStartTime = TimeUtils.nanoTime();
        velocity = new Vector2();
        jumpState = JumpState.GROUNDED;
        this.level = level;
    }

    public void render(SpriteBatch batch) {
        //Default value
        TextureRegion region;
        standTimeSeconds = MathUtils.nanoToSec * (TimeUtils.nanoTime() - standStartTime);
        region = Assets.instance.gregAssets.gregStandingRight.getKeyFrame(standTimeSeconds);
        batch.draw(region, position.x, position.y);
    }

    public void update(float delta, Array<Platform> platforms) {

        lastFramePosition.set(position);
        velocity.y -= Constant.GRAVITY_CONSTANT;
        position.mulAdd(velocity, delta);

        if (position.y < 10) {
            position.y = 10;
            jumpState = JumpState.GROUNDED;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            moveLeft(delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            moveRight(delta);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
            switch (jumpState) {
                case GROUNDED:
                    startJump();
                    break;
                case JUMPING:
                    continueJump();
                    break;
            }
        } else {
            endJump();
        }

        if (jumpState != JumpState.JUMPING) {
            //jumpState = JumpState.FALLING;


            for (Platform platform : platforms) {
                if (landedOnPlatform(platform)) {
                    jumpState = JumpState.GROUNDED;
                    velocity.y = 0;
                    velocity.x = 0;
                    position.y = platform.top;
                }
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.X)) {
            shoot();
        }

    }

    private void shoot() {
        level.spawnProjectile();
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

    private void startJump() {
        jumpState = JumpState.JUMPING;
        jumpStartTime = TimeUtils.nanoTime();
        continueJump();
    }

    private void continueJump() {
        if (jumpState == JumpState.JUMPING) {
            if (Utils.secondsSince(jumpStartTime) < Constant.GREG_JUMP_TIME) {
                velocity.y = Constant.GREG_JUMP_SPEED;
            } else {
                endJump();
            }
        }
    }

    private void endJump() {
        if (jumpState == JumpState.JUMPING) {
            jumpState = JumpState.FALLING;
        }
    }

    boolean landedOnPlatform(Platform platform) {

        boolean leftFootIn = false;
        boolean rightFootIn = false;
        boolean straddle = false;

        if (lastFramePosition.y >= platform.top &&
                position.y < platform.top) {

            float leftFoot = position.x - Constant.GREG_STANCE_WIDTH / 2;
            float rightFoot = position.x + Constant.GREG_STANCE_WIDTH / 2;

            leftFootIn = (platform.left < leftFoot && platform.right > leftFoot);
            rightFootIn = (platform.left < rightFoot && platform.right > rightFoot);
            straddle = (platform.left > leftFoot && platform.right < rightFoot);
        }
        return leftFootIn || rightFootIn || straddle;

    }

    public Vector2 getPosition() {
        return position;
    }


}
