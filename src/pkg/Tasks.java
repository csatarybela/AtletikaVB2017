package pkg;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Tasks {
    static List<Result> results = new ArrayList<>();
    static private String inputCountry;
    static private int inputPlace;

    public static void t2() throws IOException {
        FileReader fr = new FileReader("atletikaVB2017.csv");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] tmp = line.split(";");
            Result tmpResult = new Result(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5],
                    Integer.parseInt(tmp[6]));
            results.add(tmpResult);
        }
        br.close();
        fr.close();
    }

    public static void t3() {
        System.out.println("3. feladat:");
        System.out.println("\tA 2017-es londoni VB-n összesen " + results.size()
                + " érmet osztottak ki a " + (results.size() - 1) / 3 + " versenyszámban.");
    }

    public static void t4() {
        long countOfMedals = results.stream()
                .filter(r -> r.getCountry().equalsIgnoreCase("Egyesült Államok")).count();
        long countOfGoldMedal = results.stream()
                .filter(r -> r.getCountry().equalsIgnoreCase("Egyesült Államok")
                        && r.getPlace() == 1).count();
        double percentGold = ((double) countOfGoldMedal / countOfMedals) * 100;
        System.out.println("4. feladat:");
        System.out.printf("\tAz amerikai érmek %.1f", percentGold);
        System.out.println("%-a arany.");
    }

    public static void t5() {
        System.out.println("5. feladat:");
        Scanner sc = new Scanner(System.in);
        System.out.print("\tAdja meg a nemzet nevét: ");
        inputCountry = sc.nextLine();
        System.out.print("\tAdja meg a helyezést (1-3 egész szám): ");
        inputPlace = sc.nextInt();
        sc.close();
    }

    public static void t6() {
        String[] medals = new String[]{"", "arany", "ezüst", "bronz"};
        long countOfCountryMedals = results.stream()
                .filter(r -> r.getCountry().equalsIgnoreCase(inputCountry) &&
                        r.getPlace() == inputPlace).count();
        System.out.println("6. feladat:");
        if (countOfCountryMedals == 0) {
            System.out.println("\t" + inputCountry + " nem szerzett " + medals[inputPlace] +
                    "érmet a VB-n.");
        } else {
            System.out.println("\t" + inputCountry + " egyik " + medals[inputPlace] +
                    "érmet szerző versenyzője:");
            Optional<Result> athlete = results.stream()
                    .filter(r -> r.getCountry().equalsIgnoreCase(inputCountry) &&
                            r.getPlace() == inputPlace).findFirst();
            if (athlete.isPresent()) {
                System.out.println("\t" + athlete.orElseThrow().getName() + " " +
                        athlete.orElseThrow().getEvent() + " versenyszámban.");
            }
        }

    }

    public static void t7() throws IOException {
        FileWriter fw = new FileWriter("noi_csucsok.txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.println("név\tversenyszám\tnemzet");
        for (Result r : results) {
            if (r.getGender().equals("N") && !r.getRecord().isEmpty()) {
                pw.println(r.getName() + "\t" + r.getEvent() + "\t" + r.getCountry());
            }
        }
        pw.close();
        fw.close();
        System.out.println("7. feladat:");
        System.out.println("\tNői csúcsok a fájlba írva.");
    }
}
