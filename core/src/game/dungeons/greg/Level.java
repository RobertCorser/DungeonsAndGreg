package game.dungeons.greg;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import game.dungeons.greg.entities.Greg;
import game.dungeons.greg.entities.Knight;
import game.dungeons.greg.entities.Platform;
import game.dungeons.greg.entities.Projectile;
import game.dungeons.greg.entities.Wizard;
import game.dungeons.greg.util.Background;
import game.dungeons.greg.util.Constant;
import game.dungeons.greg.util.Enums;

public class Level {

    private Greg greg;
    private Knight knight1;


    private Background background;

    public ExtendViewport viewport;

    private Platform wizardPlatform;

    private Wizard wizard;

    public Array<Projectile> projectiles;
    public Array<Platform> platforms;
    public Array<Knight> knights;

    public Level() {
        viewport = new ExtendViewport(Constant.WORLD_SIZE, Constant.WORLD_SIZE);
        greg = new Greg(new Vector2(0, 0), this);



        background = new Background();

        platforms = new Array<Platform>();

        platforms.add(new Platform(40, 40, 20, 20));
        platforms.add(new Platform(0, 0, 30, 20));

        platforms.add(new Platform (60, 55, 20, 20));

        knight1 = new Knight(new Vector2(40, 60), this, platforms.get(0));
        platforms.add(new Platform(60, 80, 20, 20));

        wizardPlatform = new Platform(100, 40, 20, 20);

        platforms.add(wizardPlatform);
        projectiles = new Array<Projectile>();

        wizard = new Wizard(wizardPlatform, this);


    }

    public void spawnProjectile(Greg greg){
        projectiles.add(new Projectile(greg.getPosition().cpy(), greg.getDirection(), greg));
    }

    public void spawnProjectile(Wizard wizard){
        projectiles.add(new Projectile(wizard.getPosition().cpy(), wizard.getDirection(), wizard));
    }
    //Collision method
    public void checkCollisions(){
        if(knight1.getBounds().overlaps(greg.getBounds())){
            knight1.setHit();
        }

        //after bobby finishes projectile cleanup
      //if(knight1.getBounds().overlaps(projectiles.)){

       //}
    if(greg.getBounds().overlaps(knight1.getBounds())){
        greg.setHit();
    }


    }


    public void update(float delta) {
        greg.update(delta, platforms);
        wizard.update(delta);

        knight1.update(delta, platforms);

        for (int x = 0; x < projectiles.size; x++) {
            projectiles.get(x).update(delta);
        }
    }

    public void render(SpriteBatch batch){
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);

        batch.begin();

        background.render(batch);
        // batch.draw(, 0, 0);

        for (Platform platform : platforms) {
            platform.render(batch);
        }

        for (int x = 0; x < projectiles.size; x++) {
            projectiles.get(x).render(batch);
        }

        greg.render(batch);
        knight1.render(batch);

        wizard.render(batch);

        batch.end();

    }

    public Greg getGreg(){
        return greg;
    }

}
