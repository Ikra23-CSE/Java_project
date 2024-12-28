package File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOS {
    public static int checkUser(String username, String password, String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); 
                if (parts.length >= 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return 1; 
                } else if (parts.length >= 1 && parts[0].equals(username)) {
                    return 2; 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0; 
    }

    public static boolean registerUser(String username, String password, String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(username + "," + password + "\n"); 
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
