package it.holls.writersutility_plugin.service;

import java.util.ServiceLoader;

import it.holls.writersutilityM.iterator.WordIterator;
import it.holls.writersutilityM.ui.GUI;
import it.holls.writersutilityM.utils.Utils;
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
	
	public String getOriginalText(){
		return checkAndConvertToHTML(gui.getOriginalText());
	}
	
	public void setOriginalText(String text){
		GUIService.gui.setOriginalText(text);
	}
	
	public String getGUIText(){
		return checkAndConvertToHTML(gui.getText());
	}
	
	public void setGUIText(String text){
		GUIService.gui.setText(text);
	}
	
	public void setGUI(GUI gui){
		GUIService.gui = gui;
	}
	
	private String checkAndConvertToHTML(String inputText){
		if(inputText.startsWith("<html>") || inputText.startsWith("<!DOCTYPE"))
			return inputText;
		else
			return Utils.createHtmlFromText(inputText);
	}

}
