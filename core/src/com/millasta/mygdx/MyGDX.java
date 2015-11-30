package com.millasta.mygdx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGDX extends ApplicationAdapter {
	SpriteBatch batch;
	MySprite mushroom;
	MyAnimation explosion;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		explosion = new MyAnimation("explosion.png", 5, 5, 0.05f, true);
		mushroom = new MySprite("mushroom.png", Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		explosion.update(Gdx.graphics.getDeltaTime());
		mushroom.setTextureRegion(explosion.getCurrentFrame());
		
		batch.begin();
			mushroom.draw(batch);
			batch.draw(explosion.getCurrentFrame(), 100, 100);
		batch.end();
	}
}
