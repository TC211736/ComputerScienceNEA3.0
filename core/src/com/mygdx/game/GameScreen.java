package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
    HelloWorldGame game;
    public GameScreen(HelloWorldGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        game.setScreen(new LoginScreen(game));
    }
}
