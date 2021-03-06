package com.pixelscientists.gdx.jam.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pixelscientists.gdx.jam.GdxJam;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.fullscreen = true;
		config.useHDPI = true;
		config.setFromDisplayMode(LwjglApplicationConfiguration.getDesktopDisplayMode());
		new LwjglApplication(new GdxJam(), config);
	}
}
