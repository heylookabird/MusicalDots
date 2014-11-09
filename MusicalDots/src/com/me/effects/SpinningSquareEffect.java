package com.me.effects;

import dots.main.Assets;

public class SpinningSquareEffect extends RingEffect{

	public SpinningSquareEffect(float x, float y, float width, float height,
			float duration) {
		super(x, y, width, height, duration);
		this.expansionSpeed = .1f;
		image.setRegion(Assets.instance.textures.redRing);
	}
	
	@Override
	public void animate(){
		super.animate();
		rotation += 11.25f;
	}

}
