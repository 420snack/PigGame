package com.badlogic.pig;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Pig {
    Sprite pigSprite;
    Texture pigTexture;

    
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
    
}