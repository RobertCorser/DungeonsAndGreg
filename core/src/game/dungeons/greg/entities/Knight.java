package game.dungeons.greg.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import game.dungeons.greg.Level;
import game.dungeons.greg.util.Assets;
import game.dungeons.greg.util.Constant;
import game.dungeons.greg.util.Enums;

public class Knight {

    //#knightgoals
    //TODO walking, killing and dying

    private Vector2 position;
    private Vector2 lastFramePosition;
    private com.badlogic.gdx.math.Vector2 velocity;

    private long walkStartTime;
    private float walkTimeSeconds;

    private long standStartTime;
    private float standTimeSeconds;

    private Enums.Direction facing;
    private Enums.WalkState walkState;

    private int width = 16;
    private int height = 16;

    private boolean movingLeft = true;

    private Level level;
    private Platform platform;

    public Knight(Vector2 initPosition , Level level, Platform platform) {
       position = initPosition;
       standStartTime = TimeUtils.nanoTime();
       velocity = new Vector2();
       lastFramePosition = new Vector2(0, 0);
       this.level = level;
       this.platform = platform;

    }
    public void render(SpriteBatch batch) {
        //Default value
        TextureRegion region;
        standTimeSeconds = MathUtils.nanoToSec * (TimeUtils.nanoTime() - standStartTime);
        region = Assets.instance.knightAssets.knightRunningRight.getKeyFrame(standTimeSeconds);
        batch.draw(region, position.x, position.y);
    }
    //Knight Rectangle
    public Rectangle getBounds() {
        return new Rectangle(position.x, position.y, 16, 16);
    }

    public void update(float delta, Array<Platform> platforms) {
        lastFramePosition.set(position);
        position.mulAdd(velocity, delta);
        moveLeft(delta);
        if(position.x < platform.left){
            velocity.y -= Constant.GRAVITY_CONSTANT;

        }

    }

    private void moveLeft(float delta) {
        walkState = Enums.WalkState.WALKING;
        facing = Enums.Direction.LEFT;
        walkStartTime = TimeUtils.nanoTime();
        position.x -= delta * Constant.KNIGHT_F_MOVE_SPEED;
    }

    private void moveRight(float delta) {
        walkState = Enums.WalkState.WALKING;
        facing = Enums.Direction.RIGHT;
        walkStartTime = TimeUtils.nanoTime();
        position.x += delta * Constant.KNIGHT_F_MOVE_SPEED;
    }

    public Vector2 getPosition() {
        return position;
    }
}