package dots.buttons;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import dots.screens.AbstractScreen;

public class Button {
	public Vector2 position;
	public Rectangle bounds;
	public String message;
	public AbstractScreen screen;
	public TextureRegion texture;
	private boolean flipX, flipY;
	public Button(AbstractScreen screen, float x, float y, float width, float height, String message){
		position = new Vector2(x,y);
		bounds = new Rectangle(x,y,width, height);
		this.message = message;
		this.screen = screen;
		flipY = true;
		flipX = false;
	}
	
	public Button(AbstractScreen screen, float x, float y, float width, float height, TextureRegion texture){
		position = new Vector2(x,y);
		bounds = new Rectangle(x,y,width, height);
		this.texture = texture;
		this.screen = screen;
		message = "Error: wrong constructor";
		flipY = true;
		flipX = false;
	}
	
	public Button(AbstractScreen screen, float x, float y, float width, float height, TextureRegion texture, boolean flipX, boolean flipY){
		position = new Vector2(x,y);
		bounds = new Rectangle(x,y,width, height);
		this.texture = texture;
		this.screen = screen;
		message = "Error: wrong constructor";
		this.flipX = flipX;
		this.flipY = flipY;
	}
	
	//override function
	public void runAction(){

	}
	
	
	public void render(BitmapFont font, SpriteBatch batch){
		if(texture == null)
			font.draw(batch, message, position.x, position.y);
		else
			batch.draw(texture.getTexture(), position.x, position.y, bounds.width, bounds.height, texture.getRegionX(), texture.getRegionY(), texture.getRegionWidth(), texture.getRegionHeight(), flipX, flipY);
	}
}
