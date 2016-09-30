package it.holls.writersutility_plugin.plugin;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;

public interface Plugin {

	public String getKey();
	public String getName();
	public String getTooltip();
	public JPanel getPanel();
	public ActionListener getAction();
	public JMenuItem getMenuItem();
	
}
