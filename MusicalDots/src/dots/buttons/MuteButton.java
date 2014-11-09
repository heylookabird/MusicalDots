package dots.buttons;


import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import dots.main.Assets;
import dots.screens.AbstractScreen;
import dots.screens.WorldController;

public class MuteButton extends Button {
	public boolean muted;
	public TextureRegion mute, currentImage;
	public MuteButton(AbstractScreen screen, float x, float y, float width,
			float height) {
		super(screen, x, y, width, height, Assets.instance.buttons.unmute);
		mute = Assets.instance.buttons.mute;
		muted = true;
		currentImage = mute;
	}

	@Override
	public void runAction(){
		toggle();
	}
		
	private void toggle() {
		WorldController temp = (WorldController) screen;	
		if(muted){
			muted = false;
			currentImage = texture;//texture is the same as unmute for this object
		}
		else{
			muted = true;
			currentImage = mute;
		}
		
		temp.muted = muted;
		
		}
	
	@Override
	public void render(BitmapFont font, SpriteBatch batch){
		batch.draw(currentImage.getTexture(), position.x, position.y, bounds.width, bounds.height, currentImage.getRegionX(), currentImage.getRegionY(), currentImage.getRegionWidth(), currentImage.getRegionHeight(), false, true);
	}
	
}
