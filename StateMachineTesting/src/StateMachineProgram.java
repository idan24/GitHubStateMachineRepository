import java.util.Scanner;
import framework.*;
import states.StateStart;
import events.*;

/**
 * Main program of the state machine framework's tester client
 */
public class StateMachineProgram {
	
	// Path of the external file to hold the machine's serialized current state (varies from client to client)
	private static final String CURRENT_STATE_FILE_PATH = System.getenv("APPDATA") + "\\stateMachineCurrentState.ser";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("File path of machine's serialized current state: " + CURRENT_STATE_FILE_PATH);
		
		// Creating an instance of the framework's machine class, with StateStart as its default current state and with
		// a corresponding MachineConfig class.
		MachineConfig machineConfig = new MachineConfig(CURRENT_STATE_FILE_PATH);
		State defaultState = new StateStart();
		Machine machine = new Machine(machineConfig, defaultState);
		
		// Forever await new events for the state machine, as long as the process is running
		while (true) {
			Event newEvent = readEvent(scanner);
			
			if (newEvent != null) {
				machine.handleEvent(newEvent);
			} else {
				System.out.println("Invalid event type - ignoring input.");
			}
		}
	}
	
	/**
	 * Reads an input from the user and returns the corresponding event class, or null if input event is not in the
	 * predefined machine's alphabet.
	 */
	private static Event readEvent(Scanner scanner) {
		System.out.println("Enter new event:");
		String input = scanner.nextLine();
		
		switch (input) {
			case "A": return new EventA();
			case "B": return new EventB();
			case "C": return new EventC();
			default:  return null;
		}
	}

}
