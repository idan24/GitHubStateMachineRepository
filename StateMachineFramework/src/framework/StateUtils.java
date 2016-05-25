package framework;

import exceptions.DeserializationException;

/**
 * Holds actions concerning a state machine's persistence of its current state during difference executions of the program.
 * Serves as a middle-man between the machine and the file-handling utilities.
 */
public class StateUtils {
	
	/**
	 * Loads a machine's last current state. Returns null if none was found or if the loading was not successful.
	 */
	public static State loadCurrentState(MachineConfig machineConfig) {
		State loadedState = null;
		
		try {
			Object entity = FileUtils.loadObjectFromFile(machineConfig.getCurrentStateFilePath());
			if (entity != null) {
				loadedState = (State)entity;
			}
		}
		catch (DeserializationException e){}
		catch (ClassCastException e) {}
		
		return loadedState;
	}
	
	/**
	 * Saves a machine's state to the external file specified in its configuration class
	 */
	public static void saveCurrentState(MachineConfig machineConfig, State currentState) {
		if (!FileUtils.saveObjectToFile(machineConfig.getCurrentStateFilePath(), currentState)) {
			System.out.println("Could not save current state to file. Make sure the file is not being used by other programs.");
		}
	}
}
