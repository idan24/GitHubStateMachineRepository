package framework;

/**
 * A wrapper to a machine's configuration properties.
 * Currently holds only the path of the machine's external file of serialized current state.
 */
public class MachineConfig {
	
	private String currentStateFilePath;
	
	public MachineConfig(String currentStateFilePath) {
		this.currentStateFilePath = currentStateFilePath;
	}
	
	public String getCurrentStateFilePath() {
		return this.currentStateFilePath;
	}

}
