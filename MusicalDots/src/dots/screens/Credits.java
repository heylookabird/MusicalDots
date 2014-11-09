package dots.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import dots.buttons.Button;
import dots.main.Assets;
import dots.main.Constants;
import dots.main.MyGdxGame;

public class Credits extends AbstractScreen {
	float textSize;
	private BitmapFont font;
	private SpriteBatch batch;
	
	public Credits(float text){
		this.textSize = text;
	}
	@Override
	public void render(float delta) {
		batch.begin();
		for(Button button: menuButtons){
			button.render(font, batch);
		}
		batch.end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		font = Assets.instance.buttons.font;
		font.setScale(1f, 1f);
		this.menuButtons = new Array<Button>();
		batch = new SpriteBatch();
		this.addToMenu("Game by Harjit", Constants.viewportWidth/3f, textSize, textSize, textSize);
		this.addToMenu(null, Constants.viewportWidth/3f, textSize, textSize, textSize);

		this.addToMenu("Contact me for comments and suggestions:", Constants.viewportWidth/3f, textSize, textSize, textSize);
		this.addToMenu("email: harjitr@mail.sfsu.edu", Constants.viewportWidth/3f, textSize, textSize, textSize);
		this.addToMenu(null, Constants.viewportWidth/3f, textSize, textSize, textSize);

		this.addToMenu("Tap to return", Constants.viewportWidth/3f, textSize, textSize, textSize);

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		batch.dispose();
	}
	
	public boolean handleTouchInput(int screenx, int screeny, int pointer, int button){
		MyGdxGame.myGame.changeScreen(MyGdxGame.myGame.mainWorld);	
		return false;
	}
	public boolean handleKeyInput(int keycode){
		MyGdxGame.myGame.changeScreen(MyGdxGame.myGame.mainWorld);	
		return false;
	}

}
