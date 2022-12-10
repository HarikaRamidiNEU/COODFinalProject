package edu.neu.csye6200.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	public static List<String> readFile(String fileName) {
		return readFile(fileName, true);
	}

	public static List<String> readFile(String fileName, boolean ignoreHeader) {
		List<String> fileData = new ArrayList<>();
		try {
			fileData = Files.readAllLines(Paths.get(fileName));
			if (ignoreHeader && fileData.size() > 0) {
				fileData.remove(0);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileData;
	}

	public static void writeCsv(String fileName, List<String> lines) {

		try {
			Files.write(Paths.get(fileName), lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
