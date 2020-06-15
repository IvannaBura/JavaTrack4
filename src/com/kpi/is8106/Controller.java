package com.kpi.is8106;
import java.util.Scanner;

public class Controller {

    public static void run() {
        CollectionProcessing processing = new CollectionProcessing();
        Scanner scanner = new Scanner(System.in);

        do {
            processing.createPoints();
            processing.showAllPoints();
            processing.findPoints();

            System.out.println("\nDo you want to continue? If 'Yes' press 1, if 'No' press any other key.");
        } while (scanner.nextLine().trim().equals("1"));
    }
}
