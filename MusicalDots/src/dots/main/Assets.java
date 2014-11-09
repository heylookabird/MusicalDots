package dots.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable {
	public final static String TAG = Assets.class.getName();
	public static Assets instance = new Assets();
	private AssetManager assetManager;
	public Sounds sounds;
	public Textures textures;
	public Buttons buttons;
	
	private Assets(){

	}
	
	public void init(){
		assetManager = new AssetManager();
		assetManager.load("images/images.pack", TextureAtlas.class);
		assetManager.update();
		assetManager.finishLoading();
		
		Gdx.app.debug(TAG, " # of assets loaded: " + assetManager.getAssetNames().size);
		for(String a : assetManager.getAssetNames()){
			Gdx.app.debug(TAG, "asset: " + a);
		}
		
		TextureAtlas atlas = assetManager.get("images/images.pack");
		for (Texture t: atlas.getTextures()){
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}
		
		sounds = new Sounds();
		textures = new Textures(atlas);
		buttons = new Buttons(atlas);
	}
	@Override
	public void dispose() {
		sounds.dispose();
		textures.dispose();
		buttons.dispose();
	}
	
	
public class Sounds{
	public final Sound basicA, basicB, basicC, basicD, basicE, basicF, basicG, drum1, drum2, drum3, drum4, drum5, drum6, drum7, drum8;
	
	public Sounds(){
		basicA = Gdx.audio.newSound(Gdx.files.internal("music/BasicA.mp3"));
		basicB = Gdx.audio.newSound(Gdx.files.internal("music/BasicB.mp3"));
		basicC = Gdx.audio.newSound(Gdx.files.internal("music/BasicC.mp3"));
		basicD = Gdx.audio.newSound(Gdx.files.internal("music/BasicD.mp3"));
		basicE = Gdx.audio.newSound(Gdx.files.internal("music/BasicE.mp3"));
		basicF = Gdx.audio.newSound(Gdx.files.internal("music/BasicF.mp3"));
		basicG = Gdx.audio.newSound(Gdx.files.internal("music/BasicG.mp3"));

		drum1 = Gdx.audio.newSound(Gdx.files.internal("music/Drum11.mp3"));
		drum2 = Gdx.audio.newSound(Gdx.files.internal("music/Drum21.mp3"));
		drum3 = Gdx.audio.newSound(Gdx.files.internal("music/Drum31.mp3"));
		drum4 = Gdx.audio.newSound(Gdx.files.internal("music/Drum41.mp3"));
		drum5 = Gdx.audio.newSound(Gdx.files.internal("music/Drum51.mp3"));
		drum6 = Gdx.audio.newSound(Gdx.files.internal("music/Drum61.mp3"));
		drum7 = Gdx.audio.newSound(Gdx.files.internal("music/Drum71.mp3"));
		drum8 = Gdx.audio.newSound(Gdx.files.internal("music/Drum81.mp3"));

	}
	
	public void dispose(){
		basicA.dispose();
		basicB.dispose();
		basicC.dispose();
		basicD.dispose();
		basicE.dispose();
		basicF.dispose();
		basicG.dispose();
		drum1.dispose();
		drum2.dispose();
		drum3.dispose();
		drum4.dispose();
		drum5.dispose();
		drum6.dispose();
		drum7.dispose();
		drum8.dispose();


	}
}

public class Textures{
	public final Texture silentTexture, flatTexture, normalTexture, spinningTexture, sharpTexture, flashTexture, octTexture;
	public final AtlasRegion redRing, greenRing, yellowRing, octogon;
	public Textures(TextureAtlas atlas){
		redRing = new AtlasRegion(atlas.findRegion("RedRing"));
		greenRing = new AtlasRegion(atlas.findRegion("GreenRing"));
		yellowRing = new AtlasRegion(atlas.findRegion("YellowRing"));
		octogon = new AtlasRegion(atlas.findRegion("octogon"));


		Pixmap pixmap = new Pixmap(32, 32, Format.RGB888);
		pixmap.setColor(200, 0, 100, 200);
		pixmap.fill();
		silentTexture = new Texture(pixmap);
		
		pixmap.setColor(0, 255, 0, 255);
		pixmap.fill();
		sharpTexture = new Texture(pixmap);
		
		pixmap.setColor(200, 150, 100, 50);
		pixmap.fill();
		flatTexture = new Texture(pixmap);
		
		pixmap.setColor(50,100,150,200);
		pixmap.fill();
		normalTexture = new Texture(pixmap);
		
		pixmap.setColor(255, 255, 255, 255);
		pixmap.fill();
		flashTexture = new Texture(pixmap);
		
		pixmap.setColor(255, 0, 0, 255);
		pixmap.fill();
		spinningTexture = new Texture(pixmap);
		
		pixmap.setColor(122, 0, 255f, 0);
		pixmap.fill();
		octTexture = new Texture(pixmap);
		
		pixmap.dispose();
	}

	public void dispose(){
		silentTexture.dispose();
		flatTexture.dispose();
		normalTexture.dispose();
		spinningTexture.dispose();
		sharpTexture.dispose();
		flashTexture.dispose();
	}
}

public class Buttons{
	public final AtlasRegion exit, mute, unmute, downTempo, /*upTempo,*/ powerOff,  eye1, eye2;
	public final Array<AtlasRegion> powerAnimationTextures;
	public final Animation powerOn;
	public final BitmapFont font;
	
	public Buttons(TextureAtlas atlas){
		font = new BitmapFont(Gdx.files.internal("Font/white.fnt"));
		
		exit = new AtlasRegion(atlas.findRegion("close-button"));
		mute = new AtlasRegion(atlas.findRegion("mute"));
		unmute = new AtlasRegion(atlas.findRegion("unmuted"));
		powerOff = new AtlasRegion(atlas.findRegion("PowerOff"));
		downTempo = new AtlasRegion(atlas.findRegion("TempoChange"));
		eye1 = new AtlasRegion(atlas.findRegion("eye1"));
		eye2 = new AtlasRegion(atlas.findRegion("eye2"));
		
		//upTempo = new AtlasRegion(atlas.findRegion("TempoChange"));
		//upTempo.flip(false, true);
		
		powerAnimationTextures = new Array<AtlasRegion>();
		powerAnimationTextures.add(atlas.findRegion("PowerOn1"));
		powerAnimationTextures.add(atlas.findRegion("PowerOn2"));
		powerAnimationTextures.add(atlas.findRegion("PowerOn3"));
		powerAnimationTextures.add(atlas.findRegion("PowerOn4"));
		powerAnimationTextures.add(atlas.findRegion("PowerOn5"));
		powerAnimationTextures.add(atlas.findRegion("PowerOn6"));
		powerAnimationTextures.add(atlas.findRegion("PowerOn7"));
		powerAnimationTextures.add(atlas.findRegion("PowerOn8"));
		powerAnimationTextures.add(atlas.findRegion("PowerOn9"));
		powerAnimationTextures.add(atlas.findRegion("PowerOn10"));

		
		powerOn = new Animation(1/2f, powerAnimationTextures, Animation.NORMAL);
		
		
		
	}

	public void dispose(){
		
	}
}


	
}
