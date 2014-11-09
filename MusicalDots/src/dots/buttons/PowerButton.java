package dots.buttons;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import dots.main.Assets;
import dots.screens.AbstractScreen;
import dots.screens.WorldController;

public class PowerButton extends Button{
	public TextureRegion currentImage;
	public Animation ani;
	private boolean off, running;
	private float stateTime, duration;
	public PowerButton(AbstractScreen screen, float x, float y, float width,
			float height) {
		super(screen, x, y, width, height, Assets.instance.buttons.powerOff);
		currentImage = this.texture;
		ani = Assets.instance.buttons.powerOn;
		off = true;
		running = false;
		stateTime = 0;
		duration = ani.animationDuration;
	}
	
	@Override
	public void runAction(){
		toggle();
	}
		
	private void toggle() {
		WorldController temp = (WorldController) screen;
		temp.togglePause();
		
		
		if(off){
			runAnimation();
		}
		else{
			off = true;
			currentImage = texture;
		}
		}

	private void runAnimation() {
		stateTime = 0;
		running = true;
		off = false;
	}

	public void render(BitmapFont font, SpriteBatch batch){
		stateTime += .2f;
		if(!off){
			if(running){
				if(stateTime > duration){
					running = false;
				}
				
				currentImage = ani.getKeyFrame(stateTime);
			}
		}
		
		batch.draw(currentImage.getTexture(), position.x, position.y, bounds.width, bounds.height, currentImage.getRegionX(), currentImage.getRegionY(), currentImage.getRegionWidth(), currentImage.getRegionHeight(), false, true);
	}

}
