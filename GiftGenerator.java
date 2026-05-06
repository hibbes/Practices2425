import java.util.Random;

/**
 * Würfelt aus drei Wortlisten ein zufälliges Geschenk zusammen.
 *
 * <p>Demonstriert den Umgang mit {@link Random} und das gleichzeitige
 * Sampling aus mehreren Arrays (jeder Index unabhängig zufällig gezogen).</p>
 *
 * <p>Beispielausgabe: <i>"Dein zufälliges Geschenk: kleines rotes Teddy"</i></p>
 *
 * <p><b>Hinweis zur Grammatik:</b> Die einfache String-Verkettung erzeugt
 * gelegentlich grammatisch holprige Ausgaben („kleines rotes Playstation 5").
 * Ein guter Folge-Auftrag: die Adjektivendungen passend zum Kategorie-Genus
 * (der/die/das) wählen. Ein klassisches Anwendungsfeld für ein
 * paralleles Array oder eine kleine Klasse {@code Geschenk}.</p>
 *
 * <h2>Lernziele</h2>
 * <ul>
 *   <li>Arbeiten mit Arrays als feste Wortlisten</li>
 *   <li>Pseudozufallszahlen via {@link Random#nextInt(int)}</li>
 *   <li>String-Verkettung und Limitierung naiver Konkatenation</li>
 * </ul>
 */
public class GiftGenerator {

    public static void main(String[] args) {
        String[] kategorien = {"Playstation 5", "Puppenhaus", "Bücher", "Modelleisenbahn", "Turnschuhe", "Teddy"};
        String[] farben     = {"rot", "blau", "grün", "gelb", "braunes", "lila"};
        String[] groessen   = {"klein", "mittel", "groß"};

        Random rand = new Random();

        String kategorie = kategorien[rand.nextInt(kategorien.length)];
        String farbe     = farben[rand.nextInt(farben.length)];
        String groesse   = groessen[rand.nextInt(groessen.length)];

        // Achtung: naive Konkatenation – die Grammatik wird oft schief.
        // Aufgabe: pro Kategorie das passende Genus speichern und
        // Adjektivendungen entsprechend wählen.
        String geschenk = "Eine " + groesse + "es " + farbe + "es " + kategorie;

        System.out.println("Dein zufälliges Geschenk: " + geschenk);
    }
}
