package com.badlogic.niwatori;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Niwatori {
    private static final float SIZE = 1f;
    private static final float SPEED = 3f;
    private static final float TURN_INTERVAL = 2f;//向きを変える間隔（秒）

    private final Sprite niwatoriSprite;
    private final Texture niwatoriTexture;
    private float timer;
    private int direction = -1;//-1で左、1で右

    public Niwatori(){
        niwatoriTexture = new Texture("Kokekokko.png");
        niwatoriSprite = new Sprite(niwatoriTexture);
        niwatoriSprite.setSize(SIZE, SIZE);
        niwatoriSprite.setPosition(7f, 4f);
    }

    public void draw(SpriteBatch sb){
        niwatoriSprite.draw(sb);
    }

    public void logic(float worldWidth) {
        float delta = Gdx.graphics.getDeltaTime();

        //一定時間ごとに向きを変える
        timer += delta;
        if (timer >= TURN_INTERVAL) {
            direction = MathUtils.randomBoolean() ? 1 : -1;
            timer = 0;
        }

        //移動して画面端で反転する（移動は1フレーム1回だけ）
        niwatoriSprite.setX(niwatoriSprite.getX() + SPEED * direction * delta);
        if (niwatoriSprite.getX() <= 0) {
            niwatoriSprite.setX(0);
            direction = 1;
        } else if (niwatoriSprite.getX() + niwatoriSprite.getWidth() >= worldWidth) {
            niwatoriSprite.setX(worldWidth - niwatoriSprite.getWidth());
            direction = -1;
        }
    }

    public void dispose() {
        niwatoriTexture.dispose();
    }
}
