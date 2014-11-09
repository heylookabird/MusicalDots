package dots.main;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.me.effects.Effect;
import com.me.effects.OctogonEffect;
import com.me.effects.RingEffect;
import com.me.effects.SpinningSquareEffect;
import com.me.effects.YellowRing;

public class Squares{
	public float width;
	public float height;
	public boolean playing, silent, activeEffect;
	public TextureRegion image;
	public Sound sound;
	public Texture currentTexture, silentTexture, normalTexture, sharpTexture, flatTexture, flashTexture, spinningTexture, octTexture;
	public int yLocation, columnNumber;
	public int xLocation;
	public SpriteBatch batch;
	public ANIMATION animation;
	public Rectangle bounds;
	public float stateTime;
	private float expand, shrink, rotation;

	public enum ANIMATION{
		none(0), flash(1), shrink(2), spinning(3), flash2(4);
		
		private int stateNumber;
		private ANIMATION(int stateNumber){
			this.stateNumber = stateNumber;
		}
		
		public int getStateNumber(){
			return stateNumber;
		}
	}
	public Squares(int locationX, int locationY, float size, int columnNumber, Sound sound){
		yLocation = locationX;
		xLocation = locationY;
		batch = new SpriteBatch();
		width = size;
		height = size;
		this.columnNumber = columnNumber;
		create();
		this.sound = sound;
		playing = false;
		bounds = new Rectangle(yLocation, xLocation, width, height);
	}
	public Squares(int locationX, int locationY, float size, int soundNum, int columnNumber){
		yLocation = locationX;
		xLocation = locationY;
		batch = new SpriteBatch();
		width = size;
		height = size;
		init(soundNum);
		this.columnNumber = columnNumber;
		animation = ANIMATION.none;
		currentTexture = silentTexture;
		stateTime = 0;
		rotation = 0;
	}
	
	public void init(int soundNum){
		create();
		setSound(soundNum);
		playing = false;
		silent = true;
		bounds = new Rectangle(yLocation, xLocation, width, height);
		
	}
	
	/*public Rectangle getBounds(){
		return bounds;
	}*/
	
	public void create(){
		silentTexture = Assets.instance.textures.silentTexture;
		sharpTexture = Assets.instance.textures.sharpTexture;
		normalTexture = Assets.instance.textures.normalTexture;
		flatTexture = Assets.instance.textures.flatTexture;
		flashTexture = Assets.instance.textures.flashTexture;
		spinningTexture = Assets.instance.textures.spinningTexture;
		octTexture = Assets.instance.textures.octTexture;
		
		image = new TextureRegion(silentTexture);
		expand = width/5f;
		shrink = width/2f;
		}
	
	public void setTexture(Texture texture){
		image.setRegion(texture);
		currentTexture = texture;
	}
	
	public void activateSharp(){
		this.activeEffect = true;
		silent= false;
		setTexture(sharpTexture);
		animation = ANIMATION.spinning;
	}
	
	public void activateFlat(){
		this.activeEffect = true;
		silent = false;
		setTexture(flatTexture);
		animation = ANIMATION.shrink;
	}
	
	public void activateNormal(){
		this.activeEffect = true;
		silent = false;
		setTexture(normalTexture);
		animation = ANIMATION.flash;
	}
	
	public void activateOct(){
		this.activeEffect = true;
		silent = false;
		setTexture(octTexture);
		animation = ANIMATION.flash2;
	}
	
	public void activate(int effectNumber){
		if(effectNumber == animation.stateNumber)
			effectNumber = 0;
		
		
		switch(effectNumber){
		case 0:
			deactivate();
			break;
			
		case 1:
			activateNormal();
			break;
			
		case 2:
			activateFlat();
			break;
			
		case 3:
			activateSharp();
			break;
			
		case 4:
			activateOct();
			break;
			
		}
/*		if(animation == ANIMATION.none){
			activateNormal();
		}
		else if(animation == ANIMATION.flash){
				activateFlat();
			}
		else if(animation == ANIMATION.shrink){
			activateSharp();
		}
		else{
			deactivate();
		}*/
	}
	
	public void deactivate(){
		setTexture(silentTexture);
		animation = ANIMATION.none;
		silent = true;
		this.activeEffect = false;
	}
	
	public void dispose(){
		sound.dispose();
		silentTexture.dispose();
		flatTexture.dispose();
		normalTexture.dispose();
		sharpTexture.dispose();
		flashTexture.dispose();
		spinningTexture.dispose();
	}
	
	public void play(boolean muted){
		playing = true;
		if(!muted)
			sound.play();
	}
	
	public void setSound(int soundNum){
		
		switch(soundNum){
		
		case 1:
			sound = Assets.instance.sounds.basicA;
			break;
			
		case 2:
			sound = Assets.instance.sounds.basicB;
			break;
			
		case 3:
			sound = Assets.instance.sounds.basicC;
			break;
			
		case 4:
			sound = Assets.instance.sounds.basicD;
			break;
			
		case 5:
			sound = Assets.instance.sounds.basicE;
			break;
			
		case 6:
			sound = Assets.instance.sounds.basicF;
			break;
		
		case 7:
			sound = Assets.instance.sounds.basicG;
			break;
			
		case 8:
			sound = Assets.instance.sounds.drum1;
			break;
			
		case 9:
			sound = Assets.instance.sounds.drum2;
			break;
			
		case 10:
			sound = Assets.instance.sounds.drum3;
			break;
			
		case 11:
			sound = Assets.instance.sounds.drum4;
			break;
			
		case 12:
			sound = Assets.instance.sounds.drum5;
			break;
			
		case 13:
			sound = Assets.instance.sounds.drum6;
			break;
			
		case 14:
			sound = Assets.instance.sounds.drum7;
			break;
			
		case 15:
			sound = Assets.instance.sounds.drum8;
			break;
			
		case 16:
			sound = Assets.instance.sounds.basicA;
			break;
		}
	}
	
	public void render(SpriteBatch batch){
		stateTime++;
		if(stateTime < 15f){
			switch(animation){
			case flash:
				batch.draw(flashTexture, yLocation - expand/2f, xLocation - expand/2f, width + expand, height + expand);
				break;
			
			case shrink:
				batch.draw(image.getTexture(), yLocation + shrink/2f, xLocation + shrink/2f, width - shrink, height - shrink);
				break;
				
			case spinning:
				batch.draw(image, (float) yLocation, (float) xLocation, width/2f, height/2f, width, height, 1f, 1f, rotation);
				if(rotation < 360)
					rotation += 11.25f;
				else
					rotation = 0;
				break;
				
			case none:
				batch.draw(image.getTexture(), yLocation, xLocation, width, height);
			
				
			}
			playing = false;
		}
		else{
			batch.draw(image.getTexture(), yLocation, xLocation, width, height);
			if(playing)
				stateTime = 0;
		}

	}
	public Effect getCurrentEffect() {
		
		switch(animation){
		
		case none:
			return new RingEffect(yLocation, xLocation, height, width, 5f);
		
		case flash:
			return new RingEffect(yLocation, xLocation, height, width, 5f);
			
		case shrink:
			return new SpinningSquareEffect(yLocation, xLocation, height, width, 5f);
			
		case spinning:
			return new YellowRing(yLocation, xLocation, height, width, MathUtils.random(1f, 8f));
			
		case flash2:
			return new OctogonEffect(yLocation, xLocation, height, width, 5f, .5f);
		}
		
		return null;
		
		
		
	}

}
