package framework;

import exceptions.DeserializationException;

public class StateUtils {
	public static State loadCurrentState(MachineConfig machineConfig) {
		State loadedState = null;
		
		try {
			Object entity = FileUtils.loadObjectFromFile(machineConfig.getConfigFilePath());
			if (entity != null) {
				loadedState = (State)entity;
			}
		}
		catch (DeserializationException e){}
		catch (ClassCastException e) {}
		
		return loadedState;
	}
	
	public static void saveCurrentState(MachineConfig machineConfig, State currentState) {
		if (!FileUtils.saveObjectToFile(machineConfig.getConfigFilePath(), currentState)) {
			System.out.println("Could not save current state to file. Make sure the file is not being used by other programs.");
		}
	}
}
