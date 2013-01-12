package com.badlogic.gdx.graphics.g3d.xoppa;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g3d.xoppa.utils.ExclusiveTextures;

public class RenderContext {
	public final ExclusiveTextures textures;
	
	private boolean blending;
	private int blendSFactor;
	private int blendDFactor;
	private boolean depthTest;
	private int depthFunc;
	
	public RenderContext(ExclusiveTextures textures) {
		this.textures = textures;
	}
	
	public final void begin() {
		Gdx.gl.glDisable(GL10.GL_DEPTH_TEST);
		depthTest = false;
		Gdx.gl.glDisable(GL10.GL_BLEND);
		blending = false;
		blendSFactor = blendDFactor = depthFunc = 0;
	}
	
	public final void end() {
		
	}
	
	public final void enableDepthTest(final int depthFunction) {
		if (!depthTest) {
			Gdx.gl.glEnable(GL10.GL_DEPTH_TEST);
			depthTest = true;
		}
		if (depthFunc != depthFunction) {
			Gdx.gl.glDepthFunc(depthFunction);
			depthFunc = depthFunction;
		}
	}
	
	public final void disableDepthTest() {
		if (depthTest) {
			Gdx.gl.glDisable(GL10.GL_DEPTH_TEST);
			depthTest = false;
		}
	}
	
	public final void enableBlending(final int sFactor, final int dFactor) {
		if (!blending) {
			Gdx.gl.glEnable(GL10.GL_BLEND);
			blending = true;
		}
		if (blendSFactor != sFactor || blendDFactor != dFactor) {
			Gdx.gl.glBlendFunc(sFactor, dFactor);
			blendSFactor = sFactor;
			blendDFactor = dFactor;
		}
	}
	
	public final void disableBlending() {
		if (blending) {
			Gdx.gl.glDisable(GL10.GL_BLEND);
			blending = false;
		}
	}
}