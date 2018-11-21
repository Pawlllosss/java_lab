package pl.laby.lab7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeviceTester {

    List<Set<Integer>> testedDevices;

    DeviceTester() {
        testedDevices = new ArrayList<>();
    }

    public boolean conductTests(int nmbOfDevices, int nmbOfTests, List<List<Integer>> deviceTesterTests) {
        prepareInformationAboutTestedDevices(nmbOfDevices);

        for(List<Integer> currentTest : deviceTesterTests) {
            conductTest(nmbOfDevices, currentTest);

            if(isTestFinished(nmbOfDevices) == true) {
                return true;
            }
        }

        return false;
    }

    private void conductTest(int nmbOfDevices, List<Integer> currentTest) {
        int testGroupConstraint = nmbOfDevices / 2;

        for(int i = 0 ; i < testGroupConstraint ; ++i) {
            for(int j = testGroupConstraint ; j < nmbOfDevices ; ++j) {
                int group1Device = currentTest.get(i);
                int group2Device = currentTest.get(j);

                addDevicesToTestedDevices(group1Device, group2Device);
            }
        }
    }

    private void addDeviceToTestedDevices(int device1, int device2) {
        testedDevices.get(device1 - 1).add(device2);
    }

    private void addDevicesToTestedDevices(int device1, int device2) {
        addDeviceToTestedDevices(device1, device2);
        addDeviceToTestedDevices(device2, device1);
    }

    private boolean isTestFinished(int nmbOfDevices) {
        boolean isFinished = testedDevices.stream().allMatch(testedAgainst -> testedAgainst.size() == nmbOfDevices - 1);
        return isFinished;
    }

    private void prepareInformationAboutTestedDevices(int nmbOfTests) {
        testedDevices.clear();

        for(int i = 0 ; i < nmbOfTests ; ++i) {
            testedDevices.add(new HashSet<>());
        }

    }
}
