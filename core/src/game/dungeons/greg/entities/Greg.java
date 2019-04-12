package game.dungeons.greg.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.GdxBuild;
import com.badlogic.gdx.utils.TimeUtils;

import game.dungeons.greg.util.Assets;
import game.dungeons.greg.util.Constant;
import game.dungeons.greg.util.Enums.Direction;
import game.dungeons.greg.util.Enums.WalkState;
import game.dungeons.greg.util.Enums.JumpState;
import game.dungeons.greg.util.Utils;


public class Greg {

    private Vector2 position;
    private Vector2 velocity;

    private long walkStartTime;
    private float walkTimeSeconds;

    private long standStartTime;
    private float standTimeSeconds;

    private long jumpStartTime;
    private float jumtTimeSeconds;

    private Direction facing;
    private WalkState walkState;
    private JumpState jumpState;

    private int width = 16;
    private int height = 16;

    public Rectangle gregRectangle;

    public Greg() {
        position = new Vector2(0, 0);
        standStartTime = TimeUtils.nanoTime();
        velocity = new Vector2();
        jumpState = JumpState.GROUNDED;
    }

    public void render(SpriteBatch batch) {
        //Default value
        TextureRegion region;

        standTimeSeconds = MathUtils.nanoToSec * (TimeUtils.nanoTime() - standStartTime);
        region = Assets.instance.gregAssets.gregStandingRight.getKeyFrame(standTimeSeconds);


        batch.draw(region, position.x, position.y);
    }

    public void update(float delta) {
        gregRectangle = new Rectangle(getPosition().x,getPosition().y,16,16);


        velocity.y -= Constant.GRAVITY_CONSTANT;
        position.mulAdd(velocity, delta);

        //good for projectiles
/*        if(gregRectangle.overlaps(testPlaform.platformRectangle)) {
            jumpState = JumpState.GROUNDED;
            position.y = testPlaform.top +10;
            velocity.y = 0;
            Gdx.app.log("","Grounded");
        }*/

        if(position.y < 10){
            position.y = 10;
            jumpState = JumpState.GROUNDED;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            moveLeft(delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            moveRight(delta);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.Z)) {
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
        if(jumpState == JumpState.JUMPING){
            if(Utils.secondsSince(jumpStartTime) < Constant.GREG_JUMP_TIME){
                velocity.y = Constant.GREG_JUMP_SPEED;
            }
            else {
                endJump();
            }
        }
    }

    private void endJump(){
        if(jumpState == JumpState.JUMPING){
            jumpState = JumpState.FALLING;
        }
    }

    public Vector2 getPosition() {
        return position;
    }


}
