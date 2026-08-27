package com.badlogic.pig;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class PigPearl {
    public static final float SIZE = 0.3f;
    private static final float SPEED = 5f;//上へ飛ぶ速さ
    private static final float DAMAGE = 2f;
    private final Sprite pigPearlSprite;

    public PigPearl(Texture sharedTexture, Vector2 pos){
        //テクスチャは Pig から共有してもらう（弾ごとに読み込まない）
        pigPearlSprite = new Sprite(sharedTexture);
        pigPearlSprite.setSize(SIZE, SIZE);
        pigPearlSprite.setPosition(pos.x, pos.y);
    }

    public void update(float delta) {
        pigPearlSprite.translateY(SPEED * delta);
    }

    public boolean isOffScreen(float worldHeight) {
        return pigPearlSprite.getY() > worldHeight;
    }

    public void draw(SpriteBatch sb){
        pigPearlSprite.draw(sb);
    }
}