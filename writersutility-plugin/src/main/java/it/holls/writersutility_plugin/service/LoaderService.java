package it.holls.writersutility_plugin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import it.holls.writersutility_plugin.plugin.Plugin;

public final class LoaderService {
	private static LoaderService service;
	private ServiceLoader<Plugin> loader;
	
	private LoaderService() {
		loader = ServiceLoader.load(Plugin.class);
	}

	public static synchronized LoaderService getInstance() {
		if (service == null) {
			service = new LoaderService();
		}
		return service;
	}
	
	public List<Plugin> getPlugins(){
		List<Plugin> plugins = new ArrayList<Plugin>();
		loader.forEach(plugin -> plugins.add(plugin));
		return plugins;
	}
	
	public void addObserver(GUIObserver dictObs) {
		loader.iterator().forEachRemaining(d->d.addObserver(dictObs));
	}
	

}
