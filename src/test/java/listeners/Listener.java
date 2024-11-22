package listeners;
import common.MyScreenRecorder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener
{

    // Listener: Is for controlling test execution
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Case " + result.getName() + " is Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO: take screenshot on test failure
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }


    @Override
    public void onStart(ITestContext context) {
        //TODO: Start screen recorder
        try {
            MyScreenRecorder.startRecording(context.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        //TODO: Stop screen recorder
        try {
            MyScreenRecorder.stopRecording();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
