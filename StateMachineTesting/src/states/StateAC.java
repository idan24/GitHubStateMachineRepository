package states;

import framework.*;

public class StateAC extends State {
	private static final long serialVersionUID = 11L;
	
	@Override
	public State doAction(Event event) {
		// Don't need to examine the event for this state - as long as "any event" has arrived, the 3rd sequence is achieved
		// and the next state to be the machine's initial state
		System.out.println("Seq 3");
		return new StateStart();
	}

}
