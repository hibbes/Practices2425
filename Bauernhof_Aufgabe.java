import java.util.*;
// import java.util.ArrayList;
import java.util.List;

public class Bauernhof_Aufgabe {
    public static void main(String[] args) {
        // 1. Erstelle die Datenstrukturen
        List<String> tierListe = new ArrayList<>();
        Stack<String> beobachtungskamera = new Stack<>();
        Queue<String> futterausgabe = new LinkedList<>();
        // 2. Tiere zur Liste hinzufügen
        tierListe.add("Kuh");
        tierListe.add("Schwein");
        tierListe.add("Huhn");
        // 3. Tierliste ausgeben
        System.out.println("Tierliste:");
        for (String tier : tierListe) {
            System.out.println("- " + tier);
        }
        // 4. Tiere in den Stack legen
        beobachtungskamera.push("Huhn");
        beobachtungskamera.push("Kuh");
        beobachtungskamera.push("Schwein");
        // 5. Oberstes Tier vom Stack entfernen
        String zuletztGesehen = beobachtungskamera.pop();
        System.out.println("\nZuletzt gesehenes Tier (Stack): " + zuletztGesehen);
        // 6. Tiere zur Queue hinzufügen
        futterausgabe.add("Schwein");
        futterausgabe.add("Huhn");
        futterausgabe.add("Kuh");
        // 7. Vorderstes Tier aus der Queue entfernen
        String zuerstGefüttert = futterausgabe.poll();
        System.out.println("Zuerst gefüttertes Tier (Queue): " + zuerstGefüttert);
    }
}