package framework;
/**
 * Machine component, following the State design pattern.
 * A client of the framework should create an instance of this class and use it as its specific state machine. 
 */
public class Machine {
	
	private State state;
	private MachineConfig config;
	
	/**
	 * @param config A MachineConfig instance holding configuration settings for the machine
	 * @param defaultState A fallback state to be used as machine's initial current state in case loading was not successful
	 */
	public Machine(MachineConfig config, State defaultState) {
		this.config = config;
		this.state = getCurrentState(defaultState);
		System.out.println("Machine's current state: " + this.state.getClass().getSimpleName());
	}
	
	/**
	 * Main functionality of the machine: should be called whenever a new event is being received. 
	 * Passes the given event to the machine's current state for it to handle it specifically.
	 * Also updates its next state after the event handling is done, and saves the new state in a file for persistence.
	 */
	public void handleEvent(Event event) {
		this.state = this.state.doAction(event);
		saveCurrentState();
	}
	
	/**
	 * Determines the machine's current state - loaded from StateUtils, or uses the defaultState if no state was loaded.
	 */
	private State getCurrentState(State defaultState) {
		State loadedState = StateUtils.loadCurrentState(this.config);
		if (loadedState != null) {
			return loadedState;
		} else {
			System.out.println("Could not load machine's last saved state. Defining current state as default state.");
			return defaultState;
		}
	}
	
	/**
	 * Saves the machine's current state to the external file specified in its configuration class
	 */
	private void saveCurrentState() {
		StateUtils.saveCurrentState(this.config, this.state);
	}
}