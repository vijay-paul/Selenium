package resources;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.xml.XmlSuite;

public class PDFReportWithIReporter extends PdfReport implements IReporter {

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		for (ISuite l : suites) {
			try {

				openPdfPath(); // Opening PDF Path 
				
				

				Map<String, ISuiteResult> resultSuiteMap = l.getResults();
				Set<String> mapkey = resultSuiteMap.keySet();
				for (String i : mapkey) {
					ITestContext context = resultSuiteMap.get(i).getTestContext();
					System.out.println("Suite Name- " + context.getName() + "\n Report output Directory- "
							+ context.getOutputDirectory() + "\n Suite Name- " + context.getSuite().getName()
							+ "\n Start Date Time for Execution- " + context.getStartDate()
							+ "\n End Date Time for Execution- " + context.getEndDate());

					addParagraph("Suite Name- " + context.getName() + "\n Report output Directory- "
							+ context.getOutputDirectory() + "\n Suite Name- " + context.getSuite().getName()
							+ "\n Start Date Time for Execution- " + context.getStartDate()
							+ "\n End Date Time for Execution- " + context.getEndDate());
					IResultMap resultMap = context.getFailedTests();
					Collection<ITestNGMethod> failedMethods = resultMap.getAllMethods();
					System.out.println("------Failed Test Case-----");
					for (ITestNGMethod j : failedMethods) {
						System.out.println("Failed Test Case Name- " + j.getMethodName() + "\n Description- "
								+ j.getDescription() + "\n Priority- " + j.getPriority());

						addParagraph("Failed Test Case Name- " + j.getMethodName() + "\n Description- "
								+ j.getDescription() + "\n Priority- " + j.getPriority());
					}
					IResultMap passedTest = context.getPassedTests();
					Collection<ITestNGMethod> passedMethods = passedTest.getAllMethods();
					System.out.println("------Passed Test Case-----");
					for (ITestNGMethod k : passedMethods) {
						System.out.println("Passed Test Case Name- " + k.getMethodName()

								+ "\n Priority- " + k.getPriority());

						addParagraph("Passed Test Case Name- " + k.getMethodName()

								+ "\n Priority- " + k.getPriority());
					}
				}

//Closing PDF file

				closePdf();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
