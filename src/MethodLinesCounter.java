package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MethodLinesCounter {
    public static double countLinesInMethod(String filePath, String methodName) {
        double lineCount = -1;
        boolean isMethod = false;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null ) {
                line = line.trim(); // Trim the line
                if (line.isEmpty()) {
                    continue; // Check if it is empty then we skip it
                }
                if (line.contains("{")) {
                    isMethod = true;
                    continue;
                }
                if (isMethod) {
                    lineCount++;
                }
                if (isMethod && line.contains("}")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineCount;
    }
}
