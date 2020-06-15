package com.kpi.is8106;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import static java.lang.Math.random;

public class CollectionProcessing {
    private Collection<Point> firstPoints;
    private Collection<Point> secondPoints;
    private Collection<Point> intersectionPoints;
    private Collection<Point> firstDifferencePoints;
    private Collection<Point> secondDifferencePoints;

    public void createPoints() {
        firstPoints = new HashSet<>();
        secondPoints = new HashSet<>();
        intersectionPoints = new HashSet<>();
        firstDifferencePoints = new HashSet<>();
        secondDifferencePoints = new HashSet<>();
        int pointsNumber = getPointsNumber();
        for( int i = 0; i < pointsNumber; i++){
            firstPoints.add(new Point((int) (random()*10 - 5),
                    (int) (random()*10 - 5)));
            secondPoints.add(new Point((int) (random()*10 - 5),
                    (int) (random()*10 - 5)));
        }
    }

    private int getPointsNumber(){
        Scanner scanner = new Scanner(System.in);
        int number;

        System.out.println("\nHow many points do you want to create?");
        System.out.println("Enter number of points:");
        while (true) {
            try{
                number = Integer.parseInt(scanner.nextLine().trim());
                if (number >= 1){
                    return number;
                } else {
                    System.out.println("Enter int number >= 1");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter int number >= 1");
            }
        }
    }

    public void findPoints(){
        Iterator<Point> firstIterator = firstPoints.iterator();
        Point firstPoint;
        Point secondPoint;
        Point intersectionPoint = null;
        firstDifferencePoints = firstPoints;
        secondDifferencePoints = secondPoints;

        while(firstIterator.hasNext()){
            Iterator<Point> secondIterator = secondPoints.iterator();
            firstPoint = firstIterator.next();

            while (secondIterator.hasNext()){
                secondPoint = secondIterator.next();
                if (firstPoint.equals(secondPoint)){
                    intersectionPoints.add(firstPoint);
                }
            }
        } if (intersectionPoints.isEmpty()) {

            showPoints("\nThe intersection of two sets of points is an empty set.");
            showPoints("\nThe difference of First and Second sets:\n" + firstDifferencePoints);
            showPoints("\nThe difference of Second and First sets:\n" + secondDifferencePoints);

        } else {

            Iterator<Point> firstDifferenceIterator = firstDifferencePoints.iterator();
            while(firstDifferenceIterator.hasNext()) {
                Iterator<Point> intersectionIterator = intersectionPoints.iterator();
                Point firstDifferencePoint = firstDifferenceIterator.next();

                while (intersectionIterator.hasNext()) {
                    intersectionPoint = intersectionIterator.next();
                    if (firstDifferencePoint.equals(intersectionPoint)) {
                        firstDifferenceIterator.remove();
                    }
                }
            }

            Iterator<Point> secondDifferenceIterator = secondDifferencePoints.iterator();
            while(secondDifferenceIterator.hasNext()) {
                Iterator<Point> intersectionIterator = intersectionPoints.iterator();
                Point secondDifferencePoint = secondDifferenceIterator.next();

                while (intersectionIterator.hasNext()) {
                    intersectionPoint = intersectionIterator.next();
                    if (secondDifferencePoint.equals(intersectionPoint)) {
                        secondDifferenceIterator.remove();
                    }
                }
            }

            showPoints("\nPoints of intersection of two sets:" + intersectionPoints);
            showPoints("\nThe difference of First and Second sets:\n" + firstDifferencePoints);
            showPoints("\nThe difference of Second and First sets:\n" + secondDifferencePoints);
        }
    }

    public void showAllPoints() {
        showPoints("All first points:\n" + firstPoints);
        showPoints("All second points:\n" + secondPoints);
    }

    private void showPoints(String string) {
        System.out.println(string);
    }
}
