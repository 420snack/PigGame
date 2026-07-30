package com.badlogic.niwatori;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

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
        
    }

    public void draw(SpriteBatch sb){
        niwatoriSprite.draw(sb);
    }

    public void losic(){
        float delta = Gdx.graphics.getDeltaTime();
        timer += delta;
        if (timer >= interval) {
            direction = MathUtils.randomBoolean()? 1:-1;//向き反転
            System.out.println(direction);
            timer = 0;
        }
    }

    public void input(Viewport viewport){
        float delta = Gdx.graphics.getDeltaTime();
        float nextX = niwatoriSprite.getX() + speed * direction * delta;
        if(nextX >= 0 && nextX + niwatoriSprite.getWidth() <= viewport.getWorldWidth()){
            niwatoriSprite.setX(nextX);
        }

        if(speed <= niwatoriSprite.getX() && viewport.getWorldWidth() - speed >= niwatoriSprite.getX()){
                    niwatoriSprite.translateX(speed * direction * delta);
        }
    }
}