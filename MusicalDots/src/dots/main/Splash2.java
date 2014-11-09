package dots.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

import dots.screens.AbstractScreen;
import dots.screens.WorldController;

public class Splash2 extends AbstractScreen {
		public SpriteBatch batch;
		public Texture texture;
		
		@Override
		public void render(float delta) {
			batch.begin();
			batch.draw(texture, 0, 0, Constants.viewportWidth, Constants.viewportHeight);
			batch.end();
			
		}

		@Override
		public void resize(int width, int height) {

		}

		@Override
		public void show() {
			batch = new SpriteBatch();
			texture = new Texture(Gdx.files.internal("data/Instructions.png"));
			Gdx.input.setInputProcessor(InputManager.inputManager);
			this.TAG = "Instructions1";

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
		
		@Override
		public boolean handleTouchInput(int screenx, int screeny, int pointer, int button){
			MyGdxGame.myGame.changeScreen(new WorldController());
			return false;
		}
		
		@Override
		public boolean handleKeyInput(int keycode){
			if(keycode == Keys.SPACE){
				MyGdxGame.myGame.changeScreen(new WorldController());
			}
			return false;
		}
	}

