package pl.laby.lab7;

import org.junit.jupiter.api.Test;
import pl.laby.lab7.exception.DuplicateDeviceException;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArgumentParserTest {

    @Test
    void argumentParserShouldThrowRepeatedDevicesException() {
        ArgumentsParser argumentsParser = new ArgumentsParser();

        String firstLine = "4 1\n";
        String testLine = "1 2 1 3 ";
        String inputData = firstLine + testLine;
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));

        assertThrows(DuplicateDeviceException.class, () -> argumentsParser.parseArguments());
    }

    @Test
    void argumentParserShouldThrowIOException() {
        ArgumentsParser argumentsParser = new ArgumentsParser();
        String firstLine = "4 2\n";
        String testLine = "1 2 4 3 ";

        String inputData = firstLine + testLine;
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));

        assertThrows(IOException.class, () -> argumentsParser.parseArguments());

        firstLine = "4 2\n";
        testLine = "1 2 4 3";

        inputData = firstLine + testLine;
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));

        assertThrows(IOException.class, () -> argumentsParser.parseArguments());

        firstLine = "4 2\n";
        testLine = "1 2 4 3\n";

        inputData = firstLine + testLine;
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));

        assertThrows(IOException.class, () -> argumentsParser.parseArguments());
    }

    //TODO: check if devices are numerated from 1 to nmbOfDevices
}
