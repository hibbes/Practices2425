import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Abstrakte Basisklasse für ausleihbare Medien (Buch, DVD, Zeitschrift, …).
 *
 * <p>Jedes Medium hat einen Titel, eine eindeutige ID und einen
 * Verleih-Zustand. Konkrete Unter­klassen legen die <b>Tarif­logik</b>
 * fest – {@link #berechneGebuehr()} und {@link #getMaxAusleihdauer()}
 * sind abstrakt, weil sich Bibliotheken in genau diesen Punkten
 * unterscheiden (Bücher kostenlos / DVDs teuer / Zeitschriften je nach
 * Aktualität).</p>
 *
 * <h2>Lernziele</h2>
 * <ul>
 *   <li>Abstrakte Klassen und abstrakte Methoden</li>
 *   <li>Vorlagen-Methoden ({@link #ausleihen()}, {@link #zurueckgeben()})
 *       arbeiten generisch, der Tarif ist je Subtyp anders</li>
 *   <li>Datums­arithmetik mit {@link LocalDate} und {@link ChronoUnit}</li>
 * </ul>
 *
 * @see Buch
 * @see DVD
 * @see Zeitschrift
 */
public abstract class Medium {
    protected final String titel;
    protected final String id;
    protected LocalDate ausleihdatum;
    protected boolean istVerliehen;

    public Medium(String titel, String id) {
        this.titel = titel;
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public String getId() {
        return id;
    }

    public LocalDate getAusleihdatum() {
        return ausleihdatum;
    }

    public boolean istVerfuegbar() {
        return !istVerliehen;
    }

    /** Markiert das Medium als verliehen und merkt sich das Ausleih­datum. */
    public void ausleihen() {
        if (!istVerliehen) {
            istVerliehen = true;
            ausleihdatum = LocalDate.now();
        }
    }

    /**
     * Gibt das Medium zurück und liefert die <b>fällige Gebühr</b> für die
     * abgelaufene Ausleihzeit.
     *
     * @return Gebühr in EUR (0.0, wenn das Medium gar nicht ausgeliehen war)
     */
    public double zurueckgeben() {
        if (!istVerliehen) return 0.0;
        double gebuehr = berechneGebuehr();
        istVerliehen = false;
        ausleihdatum = null;
        return gebuehr;
    }

    /** Liefert die Anzahl Tage seit dem Ausleih­datum (0, wenn nicht verliehen). */
    public long ausgelieheneTage() {
        if (!istVerliehen || ausleihdatum == null) return 0;
        return ChronoUnit.DAYS.between(ausleihdatum, LocalDate.now());
    }

    /** True, wenn das Medium über die Maximal­dauer hinaus verliehen ist. */
    public boolean istUeberzogen() {
        return ausgelieheneTage() > getMaxAusleihdauer();
    }

    /** Tarif-Logik je Medien­typ. */
    public abstract double berechneGebuehr();

    /** Maximale Ausleih­dauer in Tagen. */
    public abstract int getMaxAusleihdauer();

    @Override
    public String toString() {
        return titel + " [" + id + "]" + (istVerliehen ? " (verliehen seit " + ausleihdatum + ")" : "");
    }
}
