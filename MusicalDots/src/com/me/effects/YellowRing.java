package com.me.effects;

import com.badlogic.gdx.math.MathUtils;

import dots.main.Assets;

public class YellowRing extends RingEffect{

	public YellowRing(float x, float y, float width, float height,
			float duration) {
		super(x, y, width, height, duration);
		this.expansionSpeed = .4f;
		image.setRegion(Assets.instance.textures.yellowRing);
		System.out.println(duration);
	}
	
	@Override
	public void animate(){
		super.animate();
		rotation = MathUtils.random(180);
	}

}
