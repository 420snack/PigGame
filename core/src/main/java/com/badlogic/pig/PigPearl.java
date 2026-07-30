package com.badlogic.pig;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PigPearl {
    Sprite pigPearlSprite;
    Texture pigPearlTexture;

    public PigPearl(){
        pigPearlTexture = new Texture("Sinju.png");
        pigPearlSprite = new Sprite(pigPearlTexture);
        pigPearlSprite.setSize(0.5f, 0.5f);
        pigPearlSprite.setPosition(2f, 2f);
    }
}