package org.cli;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSV {
    public static void writeMetrics(String filePath, String[] headers, String[][] data) {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs();

            try (FileWriter writer = new FileWriter(filePath)) {
                writer.append(String.join(",", headers));
                writer.append("\n");
                for (String[] row : data) {
                    if (row == null || row.length == 0) continue;
                    writer.append(String.join(",", row));
                    writer.append("\n");
                }
            }
        } catch (IOException e) {
            System.err.println("error writing CSV file: " + e.getMessage());
        }
    }
}
