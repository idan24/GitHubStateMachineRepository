package states;

import framework.*;

public class StateABC extends State {

	@Override
	public State doAction(Event event) {
		switch (event.getID()) {
			case "A": return new StateA();
			case "B": return new StateStart();
			case "C": return new StateABCMultiple();
			default:  return this;
		}
	}

}
