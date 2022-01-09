import com.badlogic.gdx.ApplicationAdapter; 
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer; 
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle; 
import com.badlogic.gdx.math.Circle; 
import com.badlogic.gdx.Input.Keys; 
import com.badlogic.gdx.math.Vector2; 
import com.badlogic.gdx.math.MathUtils; 
import com.badlogic.gdx.math.Intersector; 
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.*;
import com.badlogic.gdx.*; 

//NOTE: Always reset the JVM before compiling (it is the small loop arrow in the
//bottom right corner of the project window)!! 

public class FirstDrawing extends ApplicationAdapter 
{
    private OrthographicCamera camera; //the camera to our world
    private Viewport viewport; //maintains the ratios of your world
    private ShapeRenderer renderer; //used to draw textures and fonts 
    private BitmapFont font; //used to draw fonts (text)
    private SpriteBatch batch; //also needed to draw fonts (text)

    private int mouseX;
    private int mouseY;

    private Vector2 selectedSquare;
    private Vector2 mouseClick;

    private boolean isWhite;

    @Override//called once when we start the game
    public void create(){

        camera = new OrthographicCamera(); 
        viewport = new FitViewport(GLOBAL.WORLD_WIDTH, GLOBAL.WORLD_HEIGHT, camera); 
        renderer = new ShapeRenderer(); 
        font = new BitmapFont(); 
        batch = new SpriteBatch();//if you want to use images instead of using ShapeRenderer 

        mouseX = -1;
        mouseY = -1;
        isWhite = true;

        selectedSquare = new Vector2(-1,-1);
        mouseClick = new Vector2(-1,-1);
    }

    @Override//called 60 times a second
    public void render(){
        renderSetup();

        update();
        drawBoard();

        System.out.println(mouseBoard());
        //System.out.println(mouseClick);
    }

    @Override
    public void resize(int width, int height){
        viewport.update(width, height, true); 
    }

    @Override
    public void dispose(){
        renderer.dispose(); 
        batch.dispose(); 
    }

    private void renderSetup(){
        viewport.apply(); 

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        float delta = Gdx.graphics.getDeltaTime();//1/60 

        //draw everything on the screen
        renderer.setProjectionMatrix(viewport.getCamera().combined);

    }

    private void drawBoard(){
        renderer.begin(ShapeType.Filled);

        for(int y = 0; y<=8; y++){

            for(int x = 0; x<=8; x++){
                if((int)mouseClick.x/100==x && (int)mouseClick.y/100==y)
                    renderer.setColor(Color.GREEN);
                else if(isWhite)
                    renderer.setColor(Color.BLACK);
                else
                    renderer.setColor(Color.WHITE);
                renderer.rect(x*GLOBAL.SQUARE_SIZE, y*GLOBAL.SQUARE_SIZE, GLOBAL.SQUARE_SIZE, GLOBAL.SQUARE_SIZE);
                isWhite = !isWhite;
            }
        }
        isWhite = !isWhite;
        renderer.end();
    }

    private Vector2 mouseBoard(){
        int x = mouseX/GLOBAL.SQUARE_SIZE;
        int y = (-mouseY/GLOBAL.SQUARE_SIZE+7);
        Vector2 v = new Vector2(x,y);
        return v;
    }

    private Vector2 mouseSquare(){
        return viewport.unproject(new Vector2(mouseX%GLOBAL.SQUARE_SIZE,mouseY%GLOBAL.SQUARE_SIZE));
    }

    /*
    private void processInput(){
    if(Gdx.input.justTouched()){
    selectedSquare = mouseBoard();
    }
    }
     */

    private void update(){
        if(Gdx.input.justTouched()){
            mouseX = Gdx.input.getX();
            mouseY = Gdx.input.getY();
        }
        mouseClick = viewport.unproject(new Vector2(mouseX,mouseY));
    }
}
