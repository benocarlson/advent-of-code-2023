package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    public static List<String> getLinesFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);

        Scanner scanner = new Scanner(file);

        List<String> lineList = new ArrayList<>();
        while(scanner.hasNextLine()) {
            lineList.add(scanner.nextLine());
        }
        return lineList;
    }
}
