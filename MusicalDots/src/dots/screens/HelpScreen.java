package dots.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import dots.buttons.Button;
import dots.main.Assets;
import dots.main.Constants;
import dots.main.MyGdxGame;

public class HelpScreen extends AbstractScreen{
	float textSize;
	private BitmapFont font;
	private SpriteBatch batch;
	
	public HelpScreen(float text){
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
		lineNumber = 1;
		font = Assets.instance.buttons.font;
		font.setScale(.75f, .75f);
		this.menuButtons = new Array<Button>();
		batch = new SpriteBatch();
		
		
		this.addToMenu("At the top right of the screen are the ", 0, textSize, textSize, textSize);
		this.addToMenu("A white box will appear behind the box you picked.", 0, textSize, textSize, textSize);
		this.addToMenu(null, 0, textSize, textSize, textSize);
		
		this.addToMenu("Next, have fun making patterns!", 0, textSize, textSize, textSize);
		this.addToMenu("Bring it to life with the power button!", 0, textSize, textSize, textSize);
		this.addToMenu(null, 0, textSize, textSize, textSize);
		
		this.addToMenu("For sounds, press the unmute.", 0, textSize, textSize, textSize);
		this.addToMenu("Change how fast it goes with the arrows!", 0, textSize, textSize, textSize);
		this.addToMenu(null, 0, textSize, 0, 0);

		this.addToMenu("Don't like what you see?", 0, textSize, textSize, textSize);
		this.addToMenu("Touch with 2 fingers to start over!", 0, textSize, textSize, textSize);
		this.addToMenu(null, 0, textSize, textSize, textSize);
		
		this.addToMenu("Touch the eyeball to make the squares disappear!", 0, textSize, textSize, textSize);
		//this.addToMenu(null, 0, textSize, textSize, textSize);
		
		this.addToMenu("Tap to Go Back.", 0, textSize, textSize, textSize);




		//menuButtons.add(new Button(this, 0, Constants.viewportHeight - textSize * lineNumber, textSize, textSize, "At the top right of the screen are the "));
		/*menuButtons.add(new Button(this, 0, Constants.viewportHeight - textSize, textSize , textSize, "different shape options to pick from."));
		menuButtons.add(new Button(this, 0, Constants.viewportHeight - textSize * 2, textSize, textSize, "A white box will appear behind the box you picked."));

		menuButtons.add(new Button(this, 0, Constants.viewportHeight -  textSize * 4, textSize, textSize, "Next, have fun making patterns!"));
		menuButtons.add(new Button(this, 0, Constants.viewportHeight -  textSize * 5, textSize, textSize, "Bring it to life with the power button!"));
		
		menuButtons.add(new Button(this, 0, Constants.viewportHeight -  textSize * 7, textSize, textSize, "For sounds, press the unmute."));
		
		menuButtons.add(new Button(this, 0, Constants.viewportHeight -  textSize * 9, textSize, textSize, "Change how fast it goes with the arrows!"));

		menuButtons.add(new Button(this, 0, Constants.viewportHeight -  textSize * 11, textSize, textSize, "Touch with 2 fingers to start over!"));

		menuButtons.add(new Button(this, 0, Constants.viewportHeight - textSize * 13, textSize, textSize, "Touch the eyeball to make the squares disappear!"));
		
		
		
		menuButtons.add(new Button(this, 0, Constants.viewportHeight -  textSize * 15, textSize, textSize, "Tap to Go Back."));*/



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
