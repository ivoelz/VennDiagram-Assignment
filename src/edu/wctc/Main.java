package edu.wctc;

public class Main {

    public static void main(String[] args) {

        String even = "even";
        String prime = "prime";
        String fibonacci  = "fibonacci";

        VennDiagram<Integer> vennDiagram = new VennDiagram<>(even, prime, fibonacci);

        vennDiagram.add(1, fibonacci);
        vennDiagram.add(2, even, prime, fibonacci);
        vennDiagram.add(3, prime, fibonacci);
        vennDiagram.add(4, even);
        vennDiagram.add(5, prime, fibonacci);
        vennDiagram.add(6, even);
        vennDiagram.add(7, prime);
        vennDiagram.add(8, even, fibonacci);
        vennDiagram.add(9);
        vennDiagram.add(10, even);

        System.out.println("Using the numbers 1 through 10");

        // prime OR even
        System.out.println("The numbers that are prime OR even are: " + vennDiagram.unionOf(prime,even));
        // prime AND fibonacci
        System.out.println("The numbers that are prime AND fibonacci are: " + vennDiagram.intersectionOf(prime, fibonacci));
        // odd fibonacci numbers
        System.out.println("The numbers that are odd fibonacci numbers are: " + vennDiagram.complementOf(fibonacci, even));
        // all three
        System.out.println("The numbers that are even AND prime AND fibonacci are: " + vennDiagram.diagramCenter());
    }
}
