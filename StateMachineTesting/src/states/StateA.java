package states;

import framework.*;

public class StateA extends State {

	@Override
	public State doAction(Event event) {
		switch (event.getID()) {
			case "A": return new StateAA();
			case "B": return new StateAB();
			case "C": return new StateAC();
			default:  return this;
		}
	}
}
