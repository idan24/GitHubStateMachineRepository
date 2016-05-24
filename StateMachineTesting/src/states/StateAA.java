package states;

import framework.*;

public class StateAA extends State {
	
	@Override
	public State doAction(Event event) {
		switch (event.getID()) {
			case "A": return this;
			case "B": return new StateAAB();
			case "C": return new StateAC();
			default:  return this;
		}
	}

}
