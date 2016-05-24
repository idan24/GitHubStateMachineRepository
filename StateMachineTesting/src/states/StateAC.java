package states;

import framework.*;

public class StateAC extends State {
	
	@Override
	public State doAction(Event event) {
		System.out.println("Seq 3");
		return new StateStart();
	}

}
