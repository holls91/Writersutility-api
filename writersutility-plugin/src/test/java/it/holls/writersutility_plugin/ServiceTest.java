package it.holls.writersutility_plugin;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.holls.writersutilityM.ui.GUI;
import it.holls.writersutility_plugin.service.GUIService;

public class ServiceTest {
	
	@Test
	public void checkEditability(){
		GUI gui = new GUI();
		
		GUIService guiService = GUIService.getInstance();
		guiService.setGUI(gui);
		
		assertEquals(guiService.getGUIText(), "");
		
		guiService.setGUIText("Prova prova");
		
		assertEquals(guiService.getGUIText(), "Prova prova");
		assertEquals(gui.getText(), "Prova prova");
		
		
	}
}
