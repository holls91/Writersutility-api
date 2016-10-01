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
		
		guiService.setGUIText("<html><head></head><body><p>Prova prova</p></body></html>");
		
		assertEquals(guiService.getGUIText().replaceAll("\n", "").replaceAll(">(\\s)*", ">").replaceAll("(\\s)*<", "<"), "<html><head></head><body><p>Prova prova</p></body></html>");
		assertEquals(gui.getText().replaceAll("\n", "").replaceAll(">(\\s)*", ">").replaceAll("(\\s)*<", "<"), "<html><head></head><body><p>Prova prova</p></body></html>");
		
	}
}
