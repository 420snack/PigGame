package com.badlogic.drop;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.niwatori.Niwatori;
import com.badlogic.pig.Pig;
/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main implements ApplicationListener {
    Texture backgroundTexture;
    // Texture pigTexture;
    Texture bulletTexture;
    Texture niwatoriTexture;
    //Sound dropSound;
    //Music music;
    SpriteBatch spriteBatch;
    FitViewport viewport;
    Vector2 touchPos;
    Array<Sprite> barrageSprites;
    Sprite niwatoriSprite;
    float dropTimer;
    Rectangle pigRectangle;
    Rectangle dropRectangle;
    Pig pig;
    Niwatori niwatori;

    @Override
    public void create() {//素材いれてる
        pig = new Pig();
        niwatori = new Niwatori();
        //backgroundTexture = new Texture
        // pigTexture = new Texture("Pig.png");
        // dropSound = Gdx.audio.newSound(Gdx.files.internal("sounds/drop.mp3"));
        // music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        // pigSprite = new Sprite(pigTexture);
        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(8, 5);//ウィンドウの大きさアスペクト比
        touchPos = new Vector2();
        //dropSprites = new Array<Sprite>();
    }

    @Override
    public void resize(int width, int height) {
        // If the window is minimized on a desktop (LWJGL3) platform, width and height are 0, which causes problems.
        // In that case, we don't resize anything, and wait for the window to be a normal size before updating.
        if(width <= 0 || height <= 0) return;
        viewport.update(width,height,true);
        // Resize your application here. The parameters represent the new window size.
    }

    @Override
    public void render() {
        input();
        losic();
        draw();
    }

    private void input(){
        pig.input();//pigが持ってる移動するためのコードを呼び出す
        niwatori.input(viewport);
    }
    private void losic(){
        niwatori.losic();
    }
    private void draw(){//背景関連
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();
        pig.draw(spriteBatch);
        niwatori.draw(spriteBatch);
        //dropSprites.draw(spriteBatch);

        //float worldWidth = viewport.getWorldWidth();
        //float worldHeight = viewport.getWorldHeight();

        //spriteBatch.draw(backgroundTexture,0,0,worldWidth,worldHeight);
        //spriteBatch.draw(bucketTexture,0,0,1,1);
        //bucketSprite.draw(spriteBatch);
        
        
        spriteBatch.end();
    }
    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void dispose() {
        // Destroy application's resources here.
    }
    // private void createDroplet(){
    //     float dropWidth = 1;
    //     float dropHeight = 1;
    //     float worldWidth = viewport.getWorldWidth();
    //     float worldHeight = viewport.getWorldHeight();
        
    //     Sprite dropSprite = new Sprite(bulletTexture);
    //     dropSprite.setSize(dropWidth, dropHeight);
    //     dropSprite.setX(MathUtils.random(0f, worldWidth - dropWidth));//雨のx座標がランダムになる
    //     dropSprite.setY(worldHeight);
    //     dropSprites.add(dropSprite);//list に入れる
    // }
}