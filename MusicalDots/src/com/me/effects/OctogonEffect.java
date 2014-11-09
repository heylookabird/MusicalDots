package com.me.effects;

import com.badlogic.gdx.math.MathUtils;

import dots.main.Assets;
import dots.main.MyGdxGame;
import dots.screens.WorldController;

public class OctogonEffect extends Effect{
	private WorldController parent;
	private float expansionSpeed = .15f;
	private float multTime = .1f, chance;
	
	public OctogonEffect(float x, float y, float width, float height,
			float duration, float chance) {
		super(x, y, width, height, duration);
		
		parent = (WorldController)MyGdxGame.thisScreen;
		this.chance = chance;
		this.image = Assets.instance.textures.octogon;
	}
	
	@Override
	public void animate(){
		if(duration - stateTime < multTime){
			if(MathUtils.randomBoolean(chance)){
				spawnNewOctogon(MathUtils.random(7));
			}
		}
		scale.x += expansionSpeed;
		scale.y += expansionSpeed;
		//override method
	}

	private void spawnNewOctogon(int random) {
		switch(random){
		
		//in front
		case 0:
			parent.activeEffects.add(new OctogonEffect(this.position.x + this.dimension.x * scale.x * .6f, this.position.y, dimension.x, dimension.y, duration/2, chance/2f));
			break;
			
		//top right
		case 1:
			parent.activeEffects.add(new OctogonEffect(this.position.x + this.dimension.x * scale.x * .6f, this.position.y + this.dimension.y * scale.y * .6f, dimension.x, dimension.y, duration/2, chance/2f));
			break;
			
		//top	
		case 2:
			parent.activeEffects.add(new OctogonEffect(this.position.x, this.position.y + this.dimension.y * scale.y * .6f, dimension.x, dimension.y, duration/2, chance/2f));
			break;
		
		//top left
		case 3:
			parent.activeEffects.add(new OctogonEffect(this.position.x - this.dimension.x * scale.x * .6f, this.position.y + this.dimension.y * scale.y * .6f, dimension.x, dimension.y, duration/2, chance/2f));
			break;
			
		//left
		case 4:
			parent.activeEffects.add(new OctogonEffect(this.position.x - this.dimension.x * scale.x * .6f, this.position.y, dimension.x, dimension.y, duration/2, chance/2f));
			break;
			
		//bottom left
		case 5:
			parent.activeEffects.add(new OctogonEffect(this.position.x - this.dimension.x * scale.x * .6f, this.position.y - this.dimension.y * scale.y * .6f, dimension.x, dimension.y, duration/2, chance/2f));
			break;
			
		//bottom	
		case 6:
			parent.activeEffects.add(new OctogonEffect(this.position.x, this.position.y - this.dimension.y * scale.y * .6f, dimension.x, dimension.y, duration/2, chance/2f));
			break;
			
		//bottom right
		case 7:
			parent.activeEffects.add(new OctogonEffect(this.position.x + this.dimension.x * scale.x * .6f, this.position.y - this.dimension.y * scale.y * .6f, dimension.x, dimension.y, duration/2, chance/2f));
			break;
		}
	}

}
