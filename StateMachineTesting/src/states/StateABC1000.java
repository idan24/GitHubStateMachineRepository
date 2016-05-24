package states;

import framework.*;

public class StateABC1000 extends State {
	
	@Override
	public State doAction(Event event) {
		if ("A".equals(event.getID())) {
			System.out.println("Seq 2");
		}
		
		return new StateStart();
	}

}
