package com.badlogic.pig;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Pig {
    private static final float SPEED = 4f;
    private static final float SIZE = 0.4f;
    private static final float FIRE_COOLDOWN = 0.2f;

    private final Sprite pigSprite;
    private final Texture pigTexture;
    private final Texture pearlTexture;//弾は全員で同じテクスチャを共有する
    private final Viewport viewport;
    private final Array<PigPearl> pearls = new Array<>();
    private float fireTimer;

    public Pig(Viewport viewport){
        this.viewport = viewport;
        pigTexture = new Texture("Pig.png");
        pigSprite = new Sprite(pigTexture);
        pigSprite.setSize(SIZE, SIZE);
        pigSprite.setPosition(1f, 1f);
        pearlTexture = new Texture("Sinju.png");
    }

    public void input() {
        float delta = Gdx.graphics.getDeltaTime();
        fireTimer -= delta;

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){//右左で移動
            pigSprite.translateX(SPEED * delta);
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            pigSprite.translateX(-SPEED * delta);
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            pigSprite.translateY(SPEED * delta);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            pigSprite.translateY(-SPEED * delta);
        } else if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && fireTimer <= 0){
            fire();
            fireTimer = FIRE_COOLDOWN;
        }

        clampToViewport();//画面外に出ないようにする
    }

    private void clampToViewport() {
        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();
        pigSprite.setX(MathUtils.clamp(pigSprite.getX(), 0, worldWidth - pigSprite.getWidth()));
        pigSprite.setY(MathUtils.clamp(pigSprite.getY(), 0, worldHeight - pigSprite.getHeight()));
    }

    public void logic() {
        float delta = Gdx.graphics.getDeltaTime();

        
        //弾を動かして、画面外に出たら捨てる
        for (int i = pearls.size - 1; i >= 0; i--) {
            PigPearl pearl = pearls.get(i);
            pearl.update(delta);
            if (pearl.isOffScreen(viewport.getWorldHeight())) {
                pearls.removeIndex(i);
            }
        }
    }

    private void fire() {
        Vector2 pos = new Vector2(
            pigSprite.getX() + pigSprite.getWidth() / 2 - PigPearl.SIZE / 2,//真ん中から発射
            pigSprite.getY() + pigSprite.getHeight()
        );
        pearls.add(new PigPearl(pearlTexture, pos));
    }

    public void draw(SpriteBatch sb) {
        pigSprite.draw(sb);
        for (PigPearl pearl : pearls) {
            pearl.draw(sb);
        }
    }

    public void dispose() {
        pigTexture.dispose();
        pearlTexture.dispose();
    }
}