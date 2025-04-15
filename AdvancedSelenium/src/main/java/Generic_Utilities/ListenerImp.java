package Generic_Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImp implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {

		TakesScreenshot src = (TakesScreenshot) BaseClass.sdriver;
		File source = src.getScreenshotAs(OutputType.FILE);
		File dest = new File("/FailedScripts.png");
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {

			System.out.println("Failed");
		}

	}

}
