package com.badlogic.pig;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class PigPearl {
    Sprite pigPearlSprite;
    Texture pigPearlTexture;

    public PigPearl(Vector2 pos){
        pigPearlTexture = new Texture("Sinju.png");
        pigPearlSprite = new Sprite(pigPearlTexture);
        pigPearlSprite.setSize(0.5f, 0.5f);
        pigPearlSprite.setPosition(pos.x,pos.y);
    }
    
    public void draw(SpriteBatch sb){
        pigPearlSprite.draw(sb);
    }
}