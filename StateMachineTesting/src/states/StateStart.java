package states;

import framework.*;

public class StateStart extends State {
	private static final long serialVersionUID = 12L;
	
	@Override
	public State doAction(Event event) {
		switch (event.getID()) {
			case "A": return new StateA();
			case "B": return this;
			case "C": return this;
			default:  return this;
		}
	}

}
