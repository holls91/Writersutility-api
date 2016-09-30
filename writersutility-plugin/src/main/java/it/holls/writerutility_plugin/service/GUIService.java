package it.holls.writerutility_plugin.service;

import java.util.ServiceLoader;

import it.holls.writersutilityM.iterator.WordIterator;
import it.holls.writersutilityM.ui.GUI;
import it.holls.writersutility_plugin.plugin.Plugin;

public final class GUIService {
	private static GUIService service;
	private ServiceLoader<Plugin> loader;
	
	private static GUI gui;
	
	private GUIService(GUI gui) {
		this.gui = gui;
		loader = ServiceLoader.load(Plugin.class);
	}

	public static synchronized GUIService getInstance() {
		if (service == null) {
			service = new GUIService(gui);
		}
		return service;
	}
	
	public WordIterator getWordIterator(){
		return gui.getWordIterator();
	}
	
	public String getGUIText(){
		return gui.getText();
	}
}
