package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Input;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.awt.*;

import static com.badlogic.gdx.Gdx.gl;
import static com.badlogic.gdx.Gdx.input;
import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

public class MyGdxGame extends ApplicationAdapter {

    OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    float bottomLeftY = 0;
    float bottomLeftX = 0;
    float rectWidth;
    float rectHeight;
    float moveSpeed = 200;

    @Override
    public void create() {
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
        camera.update();

        shapeRenderer = new ShapeRenderer();
        rectWidth = Gdx.graphics.getWidth() / 2;
        rectHeight = Gdx.graphics.getHeight() / 2;

    }

    @Override
    public void render() {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            camera.translate(0, moveSpeed * Gdx.graphics.getDeltaTime());
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            camera.translate(0, -moveSpeed * Gdx.graphics.getDeltaTime());
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            camera.translate(-moveSpeed * Gdx.graphics.getDeltaTime(), 0);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            camera.translate(moveSpeed * Gdx.graphics.getDeltaTime(), 0);
        }

        Gdx.gl.glClearColor(0.25f, 0.25f, 0.25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        shapeRenderer.setProjectionMatrix(camera.combined);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(1, 0, 0, 1);
        shapeRenderer.rect(bottomLeftX, bottomLeftY, rectWidth, rectHeight);
        shapeRenderer.setColor(0, 1, 0, 1);
        shapeRenderer.rect(bottomLeftX + rectWidth, bottomLeftY, rectWidth, rectHeight);
        shapeRenderer.setColor(0, 0, 1, 1);
        shapeRenderer.rect(bottomLeftX + rectWidth, bottomLeftY + rectHeight, rectWidth, rectHeight);
        shapeRenderer.setColor(1, 1, 0, 1);
        shapeRenderer.rect(bottomLeftX, bottomLeftY + rectHeight, rectWidth, rectHeight);
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
