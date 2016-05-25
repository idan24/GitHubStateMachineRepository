package states;

import framework.*;

public class StateAA extends State {
	private static final long serialVersionUID = 4L;
	
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
