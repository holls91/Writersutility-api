package it.holls.writersutility_plugin;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.holls.writersutilityM.ui.GUI;
import it.holls.writersutility_plugin.service.GUIService;

public class ServiceTest {
	
	@Test
	public void checkEditabilityForEditorPane(){
		GUI gui = new GUI();
		
		GUIService guiService = GUIService.getInstance();
		guiService.setGUI(gui);
		
		guiService.setOriginalText("Prova prova");
		
		assertEquals(guiService.getOriginalText(), "<html><head></head><body><div>Prova prova</div></body></html>");
		
		guiService.setGUIText("<html><head></head><body><p>Prova prova</p></body></html>");
		
		assertEquals(guiService.getGUIText().replaceAll("\n", "").replaceAll(">(\\s)*", ">").replaceAll("(\\s)*<", "<"), "<html><head></head><body><p>Prova prova</p></body></html>");
		assertEquals(gui.getText().replaceAll("\n", "").replaceAll(">(\\s)*", ">").replaceAll("(\\s)*<", "<"), "<html><head></head><body><p>Prova prova</p></body></html>");
		
	}
	
	@Test
	public void checkEditabilityForHTMLCode(){
		GUI gui = new GUI();
		
		GUIService guiService = GUIService.getInstance();
		guiService.setGUI(gui);
		
		guiService.setOriginalText("<html><head></head><body><p>Prova prova</p></body></html>");
		
		assertEquals(guiService.getOriginalText(), "<html><head></head><body><p>Prova prova</p></body></html>");
		
		guiService.setGUIText("<html><head></head><body><p>Prova prova 2</p></body></html>");
		
		assertEquals(guiService.getGUIText().replaceAll("\n", "").replaceAll(">(\\s)*", ">").replaceAll("(\\s)*<", "<"), "<html><head></head><body><p>Prova prova 2</p></body></html>");
		assertEquals(gui.getText().replaceAll("\n", "").replaceAll(">(\\s)*", ">").replaceAll("(\\s)*<", "<"), "<html><head></head><body><p>Prova prova 2</p></body></html>");
		assertEquals(guiService.getOriginalText(), "<html><head></head><body><p>Prova prova</p></body></html>");
	}
}
