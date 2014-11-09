package dots.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

public class InputManager extends InputAdapter {
	public static InputManager inputManager= new InputManager();
	public InputManager(){

	}
	
	public void init(){
		Gdx.input.setInputProcessor(this);
	}
		// TODO Auto-generated method stub
		
	@Override
	public boolean keyDown(int keycode) {
		if(!MyGdxGame.thisScreen.handleKeyInput(keycode))
			return false;
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		
			return false;
		
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(!MyGdxGame.thisScreen.handleTouchInput(screenX, screenY, pointer, button))
			return false;
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}

