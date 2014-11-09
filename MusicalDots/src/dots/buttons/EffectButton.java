package dots.buttons;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import dots.screens.AbstractScreen;
import dots.screens.WorldController;

public class EffectButton extends Button{
	public boolean selected;
	public int effectNum;
	public EffectButton(AbstractScreen screen, float x, float y, float width,
			float height, TextureRegion texture, boolean selected, int effectNum) {
		super(screen, x, y, width, height, texture);
		this.selected = selected;
		this.effectNum = effectNum;
	}
	
	public void runAction(){		
		WorldController temp = (WorldController) screen;
		
		if(temp.activeButton != this){
			temp.activeButton.toggle();
			temp.activeButton = this;
			temp.effectNumber = effectNum;
			this.toggle();
			System.out.println("currentEffect " + effectNum);
		}
	}
	
	public void toggle() {
		if(selected){
			selected = false;
			bounds.set(position.x, position.y, bounds.width / 1.2f,  bounds.height / 1.2f);
		}
		else{
			selected = true;
			bounds.set(position.x - bounds.width *.2f, position.y - bounds.height * .2f, bounds.width * 1.2f,  bounds.height * 1.2f);
		}
	}

	public void render(BitmapFont font, SpriteBatch batch){
		batch.draw(texture.getTexture(), bounds.x, bounds.y, bounds.width, bounds.height, texture.getRegionX(), texture.getRegionY(), texture.getRegionWidth(), texture.getRegionHeight(), false, true);
	}

}
