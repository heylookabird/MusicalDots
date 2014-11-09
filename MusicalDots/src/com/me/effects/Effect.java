package com.me.effects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Effect {
	public TextureRegion image;
	public Vector2 position, dimension, scale;
	public Rectangle bounds;
	public float rotation;
	public float duration, stateTime;
	public Effect(float x, float y, float width, float height, float duration){
		image = new TextureRegion();
		scale = new Vector2(1,1);
		position = new Vector2(x, y);
		dimension = new Vector2(width, height);
		rotation = 0;
		stateTime = 0;
		this.duration = duration;
		
		bounds = new Rectangle(x,y, width, height);
	}
	
	public void render(SpriteBatch batch){
		batch.draw(image, position.x, position.y, dimension.x/2, dimension.y/2, dimension.x, dimension.y, scale.x, scale.y, rotation, true);
	}
	
	public void update(float deltaTime){
		stateTime += deltaTime;
		animate();
	}
	
	public void animate(){
		//override method
	}
	
	public boolean finished(){
		return stateTime > duration;
	}
	
}
