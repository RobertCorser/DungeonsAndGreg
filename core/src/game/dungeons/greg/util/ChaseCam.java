package game.dungeons.greg.util;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;

import game.dungeons.greg.entities.Greg;

public class ChaseCam {

    public static final String TAG = ChaseCam.class.getName();

    public Camera camera;
    public Greg target;
    private Boolean following;

    public ChaseCam() {
    }


    public void update(float delta) {
        camera.position.x = target.getPosition().x;
        camera.position.y = target.getPosition().y;


    }
}
