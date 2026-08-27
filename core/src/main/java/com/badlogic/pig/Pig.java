package com.badlogic.pig;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class Pig {
    Sprite pigSprite;
    Texture pigTexture;
    int limit = 1;

    public Pig(){
        pigTexture = new Texture("Pig.png");
        pigSprite = new Sprite(pigTexture);
        pigSprite.setSize(0.2f,0.2f );
        pigSprite.setPosition(1f, 1f);
    }
    
    public void input() {
        float speed = 4f;
        float delta = Gdx.graphics.getDeltaTime();

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){//右左で移動
            pigSprite.translateX(speed * delta);
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            pigSprite.translateX(-speed * delta);
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            pigSprite.translateY(speed * delta);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            pigSprite.translateY(-speed * delta);
        }
    }
    
    public void draw(SpriteBatch sb){
        pigSprite.draw(sb);
    }

    public void losic(){
        if(limit == 1){
           new PigPearl(new Vector2(pigSprite.getX(),pigSprite.getY()));
           limit--;//limit -1
        }
    }
}