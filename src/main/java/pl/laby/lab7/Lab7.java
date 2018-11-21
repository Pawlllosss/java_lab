package pl.laby.lab7;

import java.util.List;

public class Lab7 {
    public static void main(String[] args) throws Exception {
        ArgumentsParser argumentsParser = new ArgumentsParser();
        ArgumentsParser.ParsedArguments parsedArguments = argumentsParser.parseArguments();
        int nmbOfDevices = parsedArguments.getNmbOfDevices();
        int nmbOfTests = parsedArguments.getNmbOfTests();
        List<List<Integer>> deviceTesterTests = parsedArguments.getDeviceTesterTests();
        DeviceTester deviceTester = new DeviceTester();
        boolean result = deviceTester.conductTests(nmbOfDevices, nmbOfTests, deviceTesterTests);

        if (result == true) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
