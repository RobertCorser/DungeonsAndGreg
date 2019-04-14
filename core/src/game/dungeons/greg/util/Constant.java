package game.dungeons.greg.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Constant {

    public static final Color BACKGROUND_COLOR = Color.LIGHT_GRAY;

    public static final float WORLD_SIZE = 160; //This value can change, I just put something here

    public static final String TEXTURE_ATLAS = "images/dungeonsandgreg.pack.atlas";

    //Background Constants
    public static final String BACKGROUND1 = "images/BGBack.png";
    public static final String BACKGROUND2 = "images/BGFront.png";
    public static final String BACKGROUND3= "images/CloudsBack.png";
    public static final String BACKGROUND4 = "images/CloudsFront.png";

    //World Constants
    public static final float GRAVITY_CONSTANT = 10;

    //Greg's Constants
    public static final String GREG_STANDING_RIGHT_0 = "greg-idle-right-0";
    public static final String GREG_STANDING_RIGHT_1 = "greg-idle-right-1";
    public static final String GREG_STANDING_RIGHT_2 = "greg-idle-right-2";
    public static final String GREG_STANDING_RIGHT_3 = "greg-idle-right-3";

    public static final String GREG_RUNNING_RIGHT_0 = "greg-run-right-0";
    public static final String GREG_RUNNING_RIGHT_1 = "greg-run-right-1";
    public static final String GREG_RUNNING_RIGHT_2 = "greg-run-right-2";
    public static final String GREG_RUNNING_RIGHT_3 = "greg-run-right-3";

    public static final float GREG_MOVE_SPEED = 30;
    public static final float GREG_ANIM_SPEED = 0.25f;
    public static final float GREG_JUMP_TIME = 0.1f;
    public static final float GREG_JUMP_SPEED = 200;
    public static final float GREG_STANCE_WIDTH = 14.0f;

    //Knight's Constants
    public static final float KNIGHT_F_MOVE_SPEED = 22;
    public static final float KNIGHT_ANIM_SPEED = 0.20f;
    public static final float KNIGHT_HIT_DURATION = 1.5f;
    public static final float KNIGHT_STANCE_WIDTH = 14.0f;


    public static final String KNIGHT_STANDING_RIGHT_0 = "knight_f_idle_anim_f0";
    public static final String KNIGHT_STANDING_RIGHT_1 = "knight_f_idle_anim_f1";
    public static final String KNIGHT_STANDING_RIGHT_2 = "knight_f_idle_anim_f2";
    public static final String KNIGHT_STANDING_RIGHT_3 = "knight_f_idle_anim_f3";

    public static final String KNIGHT_RUN_RIGHT_0 = "knight_f_run_anim_f0";
    public static final String KNIGHT_RUN_RIGHT_1 = "knight_f_run_anim_f1";
    public static final String KNIGHT_RUN_RIGHT_2 = "knight_f_run_anim_f2";
    public static final String KNIGHT_RUN_RIGHT_3 = "knight_f_run_anim_f3";

    public static final String KNIGHT_HIT = "knight_f_hit_anim_f0";

    //Necromancer Constants



    //Wizard Constants


    //Platform Constants
    public static final String PLATFORM_1 = "floor-1";

    // Bullet
    public static final String BULLET_SPRITE = "imp-idle-anim-0";
    public static final float BULLET_MOVE_SPEED = 150;
    public static final Vector2 BULLET_CENTER = new Vector2(3, 2);





}
