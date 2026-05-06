/**
 * Demo-Programm zum Datei­system-Modell ({@link Eintrag}, {@link Verzeichnis}).
 *
 * <p>Baut einen kleinen Verzeichnis­baum auf, fügt Dateien hinzu, benennt
 * etwas um, entfernt einen Eintrag und gibt am Ende die Struktur als
 * Baum auf der Konsole aus.</p>
 *
 * <pre>
 *  /
 *  ├── Dokumente/
 *  │   ├── Brief.txt
 *  │   └── Notizen.md
 *  ├── Bilder/
 *  │   └── Urlaub.jpg
 *  └── readme.txt
 * </pre>
 */
public class DateisystemDemo {

    public static void main(String[] args) {
        // Wurzel hat kein Eltern­verzeichnis
        Verzeichnis wurzel = new Verzeichnis("/", null);

        // Zwei Unter­verzeichnisse – melden sich automatisch in der Wurzel an
        Verzeichnis dokumente = new Verzeichnis("Dokumente", wurzel);
        Verzeichnis bilder = new Verzeichnis("Bilder", wurzel);

        // Dateien als reine Eintrag-Instanzen
        new Eintrag("Brief.txt", dokumente);
        new Eintrag("Notizen.md", dokumente);
        new Eintrag("Urlaub.jpg", bilder);
        Eintrag readme = new Eintrag("README.txt", wurzel);

        System.out.println("--- Anfangs­zustand ---");
        wurzel.listInhalt();

        System.out.println();
        System.out.println("--- Umbenennen: README.txt → readme.txt ---");
        boolean umbenannt = readme.umbenennen("readme.txt");
        System.out.println("  Erfolg: " + umbenannt);
        wurzel.listInhalt();

        System.out.println();
        System.out.println("--- Entfernen: Bilder ---");
        boolean entfernt = wurzel.entfernen(bilder);
        System.out.println("  Erfolg: " + entfernt);
        wurzel.listInhalt();

        System.out.println();
        System.out.println("Anzahl direkter Einträge in Wurzel: " + wurzel.anzahlEintraege());
    }
}
