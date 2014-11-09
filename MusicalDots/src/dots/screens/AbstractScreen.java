package dots.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Array;

import dots.buttons.Button;
import dots.main.Constants;

public class AbstractScreen implements Screen {
	public float lineNumber;
	public Array<Button> menuButtons;
	public String TAG;
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
	
	public void addToMenu(String message, float x, float textSize, float width, float height){
		if(message != null){
			this.menuButtons.add(new Button(this, 0, Constants.viewportHeight - textSize * lineNumber, width, height, message));
			lineNumber++;
		}
		else
			lineNumber += 2;
	}
	public boolean handleTouchInput(int screenx, int screeny, int pointer, int button){
		return false;
	}
	public boolean handleKeyInput(int keycode){
		return false;
	}
}

