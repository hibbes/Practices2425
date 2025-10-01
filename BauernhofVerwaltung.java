import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class BauernhofVerwaltung {
    public static void main(String[] args) {
        List<String> tierListe = new ArrayList<>();
        Stack<String> beobachtungskamera = new Stack<>();
        Queue<String> futterausgabe = new LinkedList<>();
        // 1. Erstelle die Datenstrukturen
        tierListe.add("Kuh");
        tierListe.add("Schwein");
        tierListe.add("Huhn");
        // 2. Tiere zur Liste hinzufügen
        System.out.println("Tierliste:");
        for (String tier : tierListe) {
            System.out.println("- " + tier);
        }
        System.out.println("Tierliste:");
        beobachtungskamera.push("Huhn");
        beobachtungskamera.push("Kuh");
        beobachtungskamera.push("Schwein");
        // 4. Tiere in den Stack legen
        String zuletztGesehen = beobachtungskamera.pop();
        System.out.println("\nZuletzt gesehenes Tier (Stack): " + zuletztGesehen);
        // beobachtungskamera.("Schwein"); // Ungültige Zeile entfernt
        futterausgabe.add("Schwein");
        futterausgabe.add("Huhn");
        futterausgabe.add("Kuh");
        // 6. Tiere zur Queue hinzufügen
        String zuerstGefüttert = futterausgabe.poll();
        System.out.println("Zuerst gefüttertes Tier (Queue): " + zuerstGefüttert);
        // futterausgabe.("Kuh"); // Ungültige Zeile entfernt
        // 7. Vorderstes Tier aus der Queue entfernen
        String zweitesGefüttert = futterausgabe.poll();
        System.out.println("Zuerst gefüttertes Tier (Queue): " + zweitesGefüttert);
    }
}
