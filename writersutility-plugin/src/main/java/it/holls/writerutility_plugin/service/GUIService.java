package it.holls.writerutility_plugin.service;

import java.util.ServiceLoader;

import it.holls.writersutilityM.iterator.WordIterator;
import it.holls.writersutilityM.ui.GUI;
import it.holls.writersutility_plugin.plugin.Plugin;

public final class GUIService {
	private static GUIService service;
	private ServiceLoader<Plugin> loader;
	
	private static GUI gui;
	
	private GUIService() {
		loader = ServiceLoader.load(Plugin.class);
	}

	public static synchronized GUIService getInstance() {
		if (service == null) {
			service = new GUIService();
		}
		return service;
	}
	
	public WordIterator getWordIterator(){
		return gui.getWordIterator();
	}
	
	public String getGUIText(){
		return gui.getText();
	}
	
	public void setGUI(GUI gui){
		this.gui = gui;
	}
	
	public void setGUIText(String text){
		this.gui.setText(text);
	}
}
