package framework;
/**
 * 
 *
 */
public class Machine {
	
	private State state;
	private MachineConfig config;
	
	public Machine(MachineConfig config, State defaultState) {
		this.config = config;
		this.state = getCurrentState(defaultState);
	}
	
	public void handleEvent(Event event) {
		this.state = this.state.doAction(event);
		saveCurrentState();
	}
	
	private State getCurrentState(State defaultState) {
		State loadedState = StateUtils.loadCurrentState(this.config);
		if (loadedState != null) {
			return loadedState;
		} else {
			System.out.println("Could not load last saved state to a valid state object. Defining current state as default state.");
			return defaultState;
		}
	}
	
	private void saveCurrentState() {
		StateUtils.saveCurrentState(this.config, this.state);
	}
}