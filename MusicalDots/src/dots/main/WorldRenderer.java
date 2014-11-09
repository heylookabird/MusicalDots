package dots.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.me.effects.Effect;

import dots.buttons.Button;
import dots.screens.WorldController;

public class WorldRenderer implements Disposable {
	private OrthographicCamera camera;
	private BitmapFont font;
	private SpriteBatch batch;
	private OrthographicCamera GUIcamera;
	private WorldController controller;
	public boolean credits;
	private Vector2 creditsLoc;
	private float panSpeed;
	public WorldRenderer(WorldController controller){
		this.controller = controller;
		init();
	}
	
	public void init(){
		credits = false;
		creditsLoc = new Vector2(Constants.viewportWidth, 0);
		//regular camera
		camera = new OrthographicCamera(Constants.viewportWidth, Constants.viewportHeight);
		camera.position.set(0, 0, 0);
		camera.setToOrtho(true);
		camera.zoom = 1f;
		camera.update();
		
		
		//GUIcamera so that the GUI can follow the 
		GUIcamera = new OrthographicCamera(creditsLoc.x, creditsLoc.y);
		GUIcamera.position.set(creditsLoc.x,0,0);
		GUIcamera.setToOrtho(true);
		GUIcamera.update();
		
		batch = new SpriteBatch();
		
		font = Assets.instance.buttons.font;
		font.setScale(1f, -1f);		

		panSpeed = camera.viewportWidth/20f;

		
	}
	
	public void reset(){
		credits = false;
		camera.setToOrtho(true);
		font.setScale(1,  -1);
	}
	
	public void moveToCredits(){
		credits = true;
		System.out.println("move");
	}
	public void moveBackFromCredits(){
		credits = false;
	}
	
	public void render(boolean hidden){
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		if(!hidden){
			controller.drawMarker(batch);
			for(Squares dis: controller.array){
					dis.render(batch);
			}
			for(Button buttons: controller.menuButtons){
				buttons.render(font, batch);
			}
		}else{
			controller.eyeButton.render(font, batch);
		}
		
		for(Effect effects: controller.activeEffects){
			effects.render(batch);
		}
		

		
		batch.end();
	}
	
	private void renderGUI(SpriteBatch batch){
	}

	public void resize(int width, int height){
		System.out.println("resize");
		
		camera.viewportHeight = Gdx.graphics.getHeight();
		camera.viewportWidth = Gdx.graphics.getWidth();
		camera.update();
		
		controller.resizeSquares(camera.viewportWidth, camera.viewportHeight);

	}

	@Override
	public void dispose() {
		batch.dispose();
	}
	
	public void moveCamera(float deltax, float deltay){
		/*camera.position.set(camera.position.x + deltax, camera.position.y + deltay, camera.position.z);
		controller.moveSquares(deltax, deltay);
		camera.update();*/
	}

}
