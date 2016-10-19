package it.holls.writersutility_plugin.plugin;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPanel;

import it.holls.writersutility.observer.GUIObserver;


public abstract class Plugin {

	protected List<GUIObserver> observers = new ArrayList<GUIObserver>();
	public void addObserver(GUIObserver dictObs) {
    	observers.add(dictObs);
    }
	
	public abstract String getKey();
	public abstract String getName();
	public abstract String getTooltip();
	public abstract JPanel getPanel();
	public abstract ActionListener getAction();
	public abstract JMenuItem getMenuItem();
	
}
