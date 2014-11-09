package dots.main;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

import dots.screens.AbstractScreen;
import dots.screens.WorldController;

public class MyGdxGame extends Game {
	public static MyGdxGame myGame = new MyGdxGame();
	public static AbstractScreen thisScreen;
	public WorldController mainWorld;
	public int level = 1;
	
	@Override
	public void create() {		
		thisScreen = new Splash();
		this.changeScreen(thisScreen);
		InputManager.inputManager.init();
		Assets.instance.init();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(0,0,0,0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		thisScreen.render(.1f);
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);

	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
	
	public void changeScreen(AbstractScreen screen){
		((Game) Gdx.app.getApplicationListener()).setScreen(thisScreen);
		this.setScreen(screen);
		thisScreen = screen;
	}
}
