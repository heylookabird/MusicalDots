package dots.buttons;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import dots.main.Assets;
import dots.screens.AbstractScreen;
import dots.screens.WorldController;

public class EyeButton extends Button{
	public boolean hidden;
	public TextureRegion hiddenImg, currentImage;
	public EyeButton(AbstractScreen screen, float x, float y, float width,
			float height) {
		super(screen, x, y, width, height, Assets.instance.buttons.eye1);
		hiddenImg = Assets.instance.buttons.eye2;
		hidden = false;
		currentImage = texture;
	}

	@Override
	public void runAction(){
		toggle();
	}
		
	private void toggle() {
		WorldController temp = (WorldController) screen;	
		if(hidden){
			hidden = false;
			currentImage = texture;//texture is the same as unmute for this object
		}
		else{
			hidden = true;
			currentImage = hiddenImg;
		}
		
		temp.hidden = hidden;
		
		}
	
	@Override
	public void render(BitmapFont font, SpriteBatch batch){
		batch.draw(currentImage.getTexture(), position.x, position.y, bounds.width, bounds.height, currentImage.getRegionX(), currentImage.getRegionY(), currentImage.getRegionWidth(), currentImage.getRegionHeight(), false, true);
	}
	
	
	

}
