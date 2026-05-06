/**
 * Verzeichnis (Ordner) im Datei­system – ein {@link Eintrag}, der
 * weitere Einträge enthalten kann.
 *
 * <p>Setzt das <b>Composite-Muster</b> um: ein Verzeichnis behandelt
 * Dateien und Unter­verzeichnisse einheitlich über die gemeinsame
 * Oberklasse {@link Eintrag}. Innen­drin hält es ein einfaches
 * Array fester Größe – realistischer wäre {@link java.util.List},
 * aber das Array zwingt zum bewussten Umgang mit Belegung und
 * Kapazität.</p>
 *
 * <h2>Lernziele</h2>
 * <ul>
 *   <li>Composite-Muster (Container ist selbst Element)</li>
 *   <li>Array mit dynamischer Belegung statt {@link java.util.ArrayList}</li>
 *   <li>Schreib- vs. Lese-Methoden ({@link #einfuegen(Eintrag)},
 *       {@link #entfernen(Eintrag)}, {@link #listInhalt()})</li>
 * </ul>
 */
public class Verzeichnis extends Eintrag {

    /** Maximale Anzahl direkter Kinder pro Verzeichnis. */
    public static final int MAX_EINTRAEGE = 99;

    private final Eintrag[] eintraege;

    public Verzeichnis(String name, Verzeichnis elternVerz) {
        super(name, elternVerz);
        this.eintraege = new Eintrag[MAX_EINTRAEGE];
    }

    /**
     * Fügt einen Eintrag in den ersten freien Slot ein.
     *
     * @param e neuer Eintrag (nicht {@code null})
     * @return {@code true}, wenn eingefügt; {@code false}, wenn das
     *         Verzeichnis voll ist
     */
    public boolean einfuegen(Eintrag e) {
        if (e == null) return false;
        for (int i = 0; i < eintraege.length; i++) {
            if (eintraege[i] == null) {
                eintraege[i] = e;
                return true;
            }
        }
        return false; // voll
    }

    /**
     * Entfernt einen konkreten Eintrag aus dem Verzeichnis (über
     * Referenz­vergleich).
     *
     * @return {@code true}, wenn der Eintrag gefunden und entfernt wurde
     */
    public boolean entfernen(Eintrag e) {
        for (int i = 0; i < eintraege.length; i++) {
            if (eintraege[i] == e) {
                eintraege[i] = null;
                return true;
            }
        }
        return false;
    }

    /** Anzahl tatsächlich belegter Einträge (überspringt {@code null}-Slots). */
    public int anzahlEintraege() {
        int n = 0;
        for (Eintrag e : eintraege) {
            if (e != null) n++;
        }
        return n;
    }

    /** Gibt eine eingerückte Inhalts­übersicht auf {@code System.out} aus. */
    public void listInhalt() {
        listInhalt(0);
    }

    private void listInhalt(int tiefe) {
        String einrueckung = "  ".repeat(tiefe);
        System.out.println(einrueckung + "[" + name + "]");
        for (Eintrag e : eintraege) {
            if (e == null) continue;
            if (e instanceof Verzeichnis) {
                ((Verzeichnis) e).listInhalt(tiefe + 1);
            } else {
                System.out.println(einrueckung + "  " + e.getName());
            }
        }
    }
}
