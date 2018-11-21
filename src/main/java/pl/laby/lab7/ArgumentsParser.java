package pl.laby.lab7;

import pl.laby.lab7.exception.DuplicateDeviceException;

import java.io.IOException;
import java.util.*;

public class ArgumentsParser {
    ParsedArguments getArguments() throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        int nmbOfDevices = scanner.nextInt();
        int nmbOfTests = scanner.nextInt();

        List<List<Integer>> deviceTesterTests = new ArrayList<>(nmbOfTests);

        for(int currentLine = 0 ; currentLine < nmbOfTests ; ++currentLine) {

            if(!scanner.hasNextInt()) {
                throw new IOException();
            }

            List<Integer> test = addDevicesToTest(nmbOfDevices, scanner);
            checkDuplicateDevices(test);
            deviceTesterTests.add(test);
        }

        return new ParsedArguments();
    }

    private void checkDuplicateDevices(List<Integer> test) throws DuplicateDeviceException {
        Set<Integer> checkedDevices = new HashSet<Integer>();

        for(int device : test) {
            if(checkedDevices.contains(device) == true) {
                throw new DuplicateDeviceException("This device already exists in test");
            }
            checkedDevices.add(device);
        }
    }

    private List<Integer> addDevicesToTest(int nmbOfDevices, Scanner scanner) {
        List<Integer> test = new ArrayList<>(nmbOfDevices);

        for(int i = 0 ; i < nmbOfDevices ; ++i) {
            int deviceNumber = scanner.nextInt();
            test.add(deviceNumber);
        }

        return test;
    }



    public class ParsedArguments {
        int nmbOfDevices;
        int nmbOfTests;
        List<List<Integer>> deviceTesterTests;
    }
}
