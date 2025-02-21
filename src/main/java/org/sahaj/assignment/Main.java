package org.sahaj.assignment;

import org.sahaj.assignment.io.InputFileProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            String filePath = "./testCases.txt";
            InputFileProcessor inputFileProcessor = new InputFileProcessor(filePath);
            inputFileProcessor.processInputFile();
        } catch (RuntimeException ex) {
            logger.error("Error while executing file ", ex);
        }
    }


}