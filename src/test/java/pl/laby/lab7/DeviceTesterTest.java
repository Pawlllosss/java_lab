package pl.laby.lab7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DeviceTesterTest {

    @Test
    void shouldReturnTrue() {
        int nmbOfDevices = 4;
        int nmbOfTests = 2;
        List<List<Integer>> deviceTesterTests = new ArrayList<List<Integer>>(nmbOfTests);
        deviceTesterTests.add(Arrays.asList(1, 2, 3, 4));
        deviceTesterTests.add(Arrays.asList(1, 3, 2, 4));

        DeviceTester deviceTester = new DeviceTester();
        boolean testResult = deviceTester.conductTests(nmbOfDevices, nmbOfTests, deviceTesterTests);
        assertTrue(testResult);
    }

    @Test
    void shouldReturnFalse() {
        int nmbOfDevices = 6;
        int nmbOfTests = 3;
        List<List<Integer>> deviceTesterTests = new ArrayList<List<Integer>>(nmbOfTests);
        deviceTesterTests.add(Arrays.asList(3, 5, 2, 4, 6, 1));
        deviceTesterTests.add(Arrays.asList(1, 4, 5, 2, 3, 6));
        deviceTesterTests.add(Arrays.asList(4, 5, 6, 1, 2, 3));

        DeviceTester deviceTester = new DeviceTester();
        boolean testResult = deviceTester.conductTests(nmbOfDevices, nmbOfTests, deviceTesterTests);
        assertFalse(testResult);
    }
}
