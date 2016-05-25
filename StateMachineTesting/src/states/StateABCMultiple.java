package states;

import framework.*;

/**
 * As described in attached doc file, this class represents several logical states all in one. It distinguishes between the
 * different states using the cCounter field. Only after a 1000 appearance of C, it indicates a transition to the next state.
 */
public class StateABCMultiple extends State {
	private static final long serialVersionUID = 10L;
	
	// the required C count is 997 - see finite state automaton sketch in attached doc, the machine moves to this state
	// after exactly 2 sequential appearances and in the last (1000th) appearance already indicates transition to StateABC1000.
	private static final int REQUIRED_C_COUNT = 997;
	private int cCounter = 0;
	
	@Override
	public State doAction(Event event) {
		switch (event.getID()) {
			case "A": return new StateA();
			case "B": return new StateStart();
			case "C":
				cCounter++;
				return (cCounter > REQUIRED_C_COUNT) ? new StateABC1000() : this;
			default:  return this;
		}
	}

}
