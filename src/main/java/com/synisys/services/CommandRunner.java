package com.synisys.services;

import com.synisys.securityUtil.NumbersNotFoundException;
import com.synisys.securityUtil.ResourcesNotFoundException;
import com.synisys.utilities.CommandType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Garik Kalashyan on 2/16/2017.
 */
public class CommandRunner {
    private static final String FILE_PATH = "srrc\\main\\resources\\data.txt";
    private static final String FILE_NUMBERS_PATH = "src\\main\\resources\\dataForNumbers.txt";

    private static final Logger LOGGER = Logger.getLogger(CommandRunner.class.getName());
    private static boolean isExited = false;
    public static void runCommands() {
        LOGGER.log(Level.INFO,"Is called runCommands()");
        while (!isExited) {
            System.out.println("Pass command:");
            System.out.print(">> ");
            Scanner scanner = new Scanner(System.in);
            String currentCommand = scanner.next();
            try {
                handleCommand(CommandType.valueOff(currentCommand));
            } catch (ResourcesNotFoundException e) {
                e.printStackTrace();
            }
        }
    }



    private static void handleCommand(CommandType commandType) throws ResourcesNotFoundException {
        switch (commandType) {
            case READ_ALL_DATA:
                readAllData();
                break;
            case READ_ONLY_LETTERS:
                readOnlyLetters();
                break;
            case READ_ONLY_NUMBERS:
                readOnlyNumbers();
                break;
            case EXIT:
                LOGGER.log(Level.INFO,"The program is existed.");
                isExited = true;

        }
    }

    private static void readAllData() throws ResourcesNotFoundException {
        File file = new File(FILE_PATH);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            ResourcesNotFoundException resourcesNotFoundException = new ResourcesNotFoundException("There is not resource with path: " + FILE_PATH);
            resourcesNotFoundException.initCause(e);
            resourcesNotFoundException.printStackTrace();
            throw resourcesNotFoundException;

        }

    }

    private static void readOnlyLetters() {

    }

    private static void readOnlyNumbers() throws ResourcesNotFoundException {
        File file = new File(FILE_NUMBERS_PATH);
        Scanner scanner = null;
        boolean foundInt = false;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.println("Found Int:" + scanner.nextInt());
                    foundInt = true;
                } else{
                    scanner.next();
                }


            }
            if (!foundInt) {
                throw new NumbersNotFoundException("There is not numbers in file: " + FILE_NUMBERS_PATH);
            }

        }catch (FileNotFoundException e) {
            ResourcesNotFoundException resourcesNotFoundException = new ResourcesNotFoundException();
            resourcesNotFoundException.initCause(e);
            resourcesNotFoundException.printStackTrace();
            throw resourcesNotFoundException;
        } finally {
            scanner.close();
        }
    }


}
