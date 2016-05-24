package states;

import framework.*;

public class StateAABC extends State {
	
	@Override
	public State doAction(Event event) {
		switch (event.getID()) {
			case "A": System.out.println("Seq 1");
					  return new StateStart();
			case "B": return new StateStart();
			case "C": return new StateABCMultiple();
			default:  return this;
		}
	}

}
