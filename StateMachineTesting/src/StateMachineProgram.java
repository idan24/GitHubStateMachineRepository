import java.util.Scanner;
import framework.*;
import states.StateStart;
import events.*;

public class StateMachineProgram {
	
	private static final String MACHINE_CONFIG_FILE_PATH = System.getenv("APPDATA") + "\\lastSavedState.ser";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		MachineConfig machineConfig = new MachineConfig(MACHINE_CONFIG_FILE_PATH);
		State defaultState = new StateStart();
		Machine machine = new Machine(machineConfig, defaultState);
		
		while (true) {
			Event newEvent = readEvent(scanner);
			
			if (newEvent != null) {
				machine.handleEvent(newEvent);
			}
			else {
				System.out.println("Invalid event type - ignoring input.");
			}
		}
	}
	
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
