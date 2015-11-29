package test.pint.BusinessLogic.Security;

import com.pint.BusinessLogic.Security.FailureCounterHelper;
import com.pint.BusinessLogic.Utilities.Utils;
import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by DionnyS on 11/28/2015.
 */
public class FailureCounterHelperTest {

    @Test
    public void testNormalizeCounter_failureBehindInterval() throws Exception {
        // Arrange.
        int counter = 3;
        long firstFailure = 1000;
        long now = 1500;
        long interval = 499;

        // Act.
        counter = FailureCounterHelper.normalizeCounter(counter, firstFailure, now, interval);

        // Assert.
        assertEquals(0, counter);
    }

    @Test
    public void testNormalizeCounter_failureAtInterval() throws Exception {
        // Arrange.
        int counter = 3;
        long firstFailure = 1000;
        long now = 1500;
        long interval = 500;

        // Act.
        counter = FailureCounterHelper.normalizeCounter(counter, firstFailure, now, interval);

        // Assert.
        assertEquals(3, counter);
    }

    @Test
    public void testNormalizeCounter_failureBeyondInterval() throws Exception {
        // Arrange.
        int counter = 3;
        long firstFailure = 1000;
        long now = 1500;
        long interval = 501;

        // Act.
        counter = FailureCounterHelper.normalizeCounter(counter, firstFailure, now, interval);

        // Assert.
        assertEquals(3, counter);
    }
}