package com.badlogic.drop;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.niwatori.Niwatori;
import com.badlogic.pig.Pig;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main implements ApplicationListener {
    SpriteBatch spriteBatch;
    FitViewport viewport;
    Pig pig;
    Niwatori niwatori;

    @Override
    public void create() {//素材いれてる
        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(8, 5);//ウィンドウの大きさアスペクト比
        pig = new Pig(viewport);
        niwatori = new Niwatori();
    }

    @Override
    public void resize(int width, int height) {
        // If the window is minimized on a desktop (LWJGL3) platform, width and height are 0, which causes problems.
        // In that case, we don't resize anything, and wait for the window to be a normal size before updating.
        if(width <= 0 || height <= 0) return;
        viewport.update(width,height,true);
    }

    @Override
    public void render() {
        input();
        logic();
        draw();
    }

    private void input(){
        pig.input();//pigが持ってる移動するためのコードを呼び出す
    }

    private void logic(){
        pig.logic();
        niwatori.logic(viewport.getWorldWidth());
    }

    private void draw(){//背景関連
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();
        pig.draw(spriteBatch);
        niwatori.draw(spriteBatch);
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
        spriteBatch.dispose();
        pig.dispose();
        niwatori.dispose();
    }
}