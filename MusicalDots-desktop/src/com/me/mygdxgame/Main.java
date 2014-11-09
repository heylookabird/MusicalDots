package com.me.mygdxgame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import dots.main.MyGdxGame;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "MusicalDots";
		cfg.useGL20 = false;
		cfg.width = 600;
		cfg.height = 400;
		//cfg.fullscreen = true;
		new LwjglApplication(new MyGdxGame(), cfg);
	}
}
