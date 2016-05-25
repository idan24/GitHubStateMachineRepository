package framework;

import java.io.Serializable;
/**
 * State component, following the State design pattern.
 * Any subclass (any concrete machine state) should implement a doAction method that analyzes a new event and operates accordingly.
 * The class is serializable to allow serialization of the machine's current state to keep its persistence.
 */
public abstract class State implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public abstract State doAction(Event event);
}
