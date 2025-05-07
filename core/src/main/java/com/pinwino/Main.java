package com.pinwino;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
    
	private SpriteBatch batch;
    private Texture bg;
    private Texture pinwis;
    private Animation<TextureRegion> anim;
    private Array<TextureRegion> frames;
    
    private Texture pinwino;
    private Sprite pinwiSprite;
    
    private TextureRegion[][] t;
    private TextureRegion[] te;
    
    float time;

    @Override
    public void create() {
    	
    	pinwino = new Texture("pinwino.png");
    	pinwiSprite = new Sprite(pinwino);
    	
        batch = new SpriteBatch();
        bg = new Texture("bgCampo.png");
        pinwis = new Texture("pinwinoA.png");
        frames = new Array<TextureRegion>();
        frames.add(new TextureRegion(pinwis, 50, 100), new TextureRegion(pinwis, 50, 0,50, 100));
        
        t = TextureRegion.split(pinwis, 50, 100);
        
        te = new TextureRegion[2];
        
        for(int i=0; i<2;i++) te[i] = t[0][i]; 
        
        anim = new Animation<TextureRegion>(1f, te);
        
        time = 0;
    }

    @Override
    public void render() {
    	logic();
    	
    	time += Gdx.graphics.getDeltaTime();
    	TextureRegion current = anim.getKeyFrame(time, true);
    	System.out.println(time);
    	
    	
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(bg, 0, 0, 800, 500);
        batch.draw(current,0,0);
        pinwiSprite.draw(batch);
        batch.end();
    }
    
    @Override
    public void dispose() {
        batch.dispose();
        bg.dispose();
    }
    
    public void logic() {
    	
    	float delta = Gdx.graphics.getDeltaTime();
    	
    	float velocidad = 160.3f;
    	
    	if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
    		pinwiSprite.translateX(velocidad * delta);
    	}
    	if(Gdx.input.isKeyPressed(Keys.LEFT)) {
    		pinwiSprite.translateX(-velocidad * delta);
    	}
    	if(Gdx.input.isKeyPressed(Keys.UP)) {
    		pinwiSprite.translateY(velocidad * delta);
    	}
    	if(Gdx.input.isKeyPressed(Keys.DOWN)) {
    		pinwiSprite.translateY(-velocidad * delta);
    	}
    	
    }
    
}
