package framework;

import java.io.Serializable;
/**
 *
 *
 */
public abstract class State implements Serializable {
	private static final long serialVersionUID = 42L;
	
	public abstract State doAction(Event event);
}
