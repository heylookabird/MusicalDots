package com.me.effects;

import dots.main.Assets;

public class RingEffect extends Effect{
	public float expansionSpeed = .2f;
	public RingEffect(float x, float y, float width, float height, float duration) {
		super(x, y, width, height, duration);
		image.setRegion(Assets.instance.textures.greenRing);
	}
	
	@Override
	public void animate(){
		scale.x += expansionSpeed;
		scale.y += expansionSpeed;
		
		bounds.setSize(dimension.x * scale.x, dimension.y * scale.y);
	}

}
