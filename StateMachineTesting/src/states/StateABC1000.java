package states;

import framework.*;

public class StateABC1000 extends State {
	private static final long serialVersionUID = 9L;
	
	@Override
	public State doAction(Event event) {
		if ("A".equals(event.getID())) {
			System.out.println("Seq 2");
		}
		
		// In all cases, the next state should be the machine's initial state
		return new StateStart();
	}

}
