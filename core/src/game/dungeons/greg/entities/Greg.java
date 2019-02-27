package game.dungeons.greg.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import game.dungeons.greg.util.Assets;
import game.dungeons.greg.util.Constant;

public class Greg {

    private Vector2 position;

    public Greg(){
        position = new Vector2(0,0);
    }

    public void render(SpriteBatch batch){
        TextureRegion region = Assets.instance.gregAssets.gregStandingRight;

        batch.draw(region, position.x, position.y);
    }

    public void update(float delta){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            moveLeft(delta);
        }
    }

    private void moveLeft(float delta){
        position.x -= delta * Constant.GREG_MOVE_SPEED;
    }

    private void moveRight(float delta){
        //TODO Implement Moving Right
    }

    public Vector2 getPosition() {
        return position;
    }
}
