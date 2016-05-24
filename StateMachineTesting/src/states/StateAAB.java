package states;

import framework.*;

public class StateAAB extends State {
	
	@Override
	public State doAction(Event event) {
		switch (event.getID()) {
			case "A": return new StateA();
			case "B": return new StateStart();
			case "C": return new StateAABC();
			default:  return this;
		}
	}

}
