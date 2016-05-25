package framework;

/**
 * Event component, following the State design pattern.
 * Any subclass (any concrete event type) should specify its own ID and additionalData.
 */
public abstract class Event {
	
	public abstract String getID();
	public abstract String getAdditionalData();
}
