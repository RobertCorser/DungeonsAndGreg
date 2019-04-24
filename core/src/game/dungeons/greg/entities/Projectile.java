package game.dungeons.greg.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import game.dungeons.greg.Level;
import game.dungeons.greg.util.Assets;
import game.dungeons.greg.util.Constant;
import game.dungeons.greg.util.Enums;
import game.dungeons.greg.util.Utils;

public class Projectile {

    private final Enums.Direction direction;
    public boolean active;
    private Vector2 position;
    Object entity;

    public Projectile(Vector2 position, Enums.Direction direction, Object entity) {
        this.position = position;
        this.direction = direction;
        active = true;
        this.entity = entity;
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

    public void render(SpriteBatch batch) {
        //Default value
        TextureRegion region = null;

        if(entity instanceof Greg){
            region = Assets.instance.projectileAssets.bullet;
        }
        else{
            region = Assets.instance.wizardAssets.wizardWeaponLeft;
        }

        Utils.drawTextureRegion(batch, region, position, Constant.BULLET_CENTER);
    }
}