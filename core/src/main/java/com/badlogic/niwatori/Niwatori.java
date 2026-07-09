package com.badlogic.niwatori;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Niwatori{
    Sprite niwatoriSprite;
    Texture niwatoriTexture;
    float timer = 0f;
    int direction = -1;//-1で左、1で右
    float speed = 3;

    public int interval = 2;


    public Niwatori(){
        niwatoriTexture = new Texture("Kokekokko.png");
        niwatoriSprite = new Sprite(niwatoriTexture);
        niwatoriSprite.setSize(1f,1f );
        niwatoriSprite.setPosition(7f, 4f);
        //TODO 途中で止めるかランダム２秒おきぐらい
    }

    public void draw(SpriteBatch sb){
        niwatoriSprite.draw(sb);
    }

    public void losic(){
        float delta = Gdx.graphics.getDeltaTime();
        timer += delta;
        niwatoriSprite.translateX(speed * direction * delta);
        if (timer >= interval) {
            direction = direction * -1;//向き反転
            timer = 0;
        }else{

        }
    }

}