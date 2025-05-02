package Utils;

import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Screenshot {
	public static String takeScreenshot(WebDriver driver, String testName) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filename = testName + "_" + System.currentTimeMillis() + ".png";
		String path = "test-output/screenshots/" + filename;
		try {
			Files.createDirectories(Paths.get("test-output/screenshots/"));
			Files.copy(src.toPath(), Paths.get(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "./screenshots/" + filename;
	}

	public static void deleteOldScreenshots() {
		File screenshotFolder = new File("test-output/screenshots");
		if (screenshotFolder.exists() && screenshotFolder.isDirectory()) {
			File[] files = screenshotFolder.listFiles();
			if (files != null) {
				for (File file : files) {
					if (file.isFile()) {
						file.delete();
					}
				}
				System.out.println("Old screenshots deleted successfully.");
			}
		}
	}
}