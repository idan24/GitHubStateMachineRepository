package framework;
import java.io.*;

import exceptions.DeserializationException;

public class FileUtils {
	public static Object loadObjectFromFile(String filePath) throws DeserializationException {
		try (FileInputStream fileIn = new FileInputStream(filePath)) {
			try (ObjectInputStream in = new ObjectInputStream(fileIn)) {
				return in.readObject();
			}
			catch(Exception e) {
				throw new DeserializationException();
			}
		}
		catch(Exception e) {
			throw new DeserializationException();
		}
	}
	
	public static boolean saveObjectToFile(String filePath, Object entity) {
		boolean isSaved = false;
		
		File file = getFile(filePath);
		if (file != null) {
			try (FileOutputStream fileOut = new FileOutputStream(file, false)) {
				try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
					out.writeObject(entity);
					isSaved = true;
				}
				catch(Exception e) {}
			}
			catch(Exception e) {}
		}
		
		return isSaved;
	}
	
	private static File getFile(String filePath) {
		File file = null;
		
		try {
			file = new File(filePath);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			return file;
		}
		catch(IOException i) {}
		
		return file;
	}
}
