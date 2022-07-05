package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.utils.ScreenUtils;


import static com.badlogic.gdx.Gdx.gl;
import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

public class MyGdxGame extends ApplicationAdapter {

    private SpriteBatch batch;
    private Animation animation;
    private float elapsedTime = 0;
    private TextureAtlas textureAtlas;

    @Override
    public void create() {
        batch = new SpriteBatch();
        textureAtlas = new TextureAtlas(Gdx.files.internal("picturespritesheet_thumb_1.png"));
        animation = new Animation(1/15f, textureAtlas.getRegions())
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);

        batch.begin();
        elapsedTime += Gdx.graphics
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        textureAtlas.dispose();
    }
}
