# Practices2425 – Übungssammlung 2024/25

Aktuelle und umfangreiche Übungssammlung für den Informatik-Unterricht (Schuljahr 2024/25).
Enthält Aufgaben zu OOP, Rekursion, Sortieren, Datenstrukturen und grafischen Simulationen.

## Dateiübersicht

### Objektorientierung & Vererbung
| Datei | Inhalt |
|-------|--------|
| `Fahrzeug.java` | Basisklasse für Fahrzeuge |
| `Auto.java` | Unterklasse von Fahrzeug |
| `Fahrrad.java` | Unterklasse von Fahrzeug |
| `Zug.java` | Schienenfahrzeug als Unterklasse von Fahrzeug |
| `Kriechbar.java` | Interface für kriechende Objekte |
| `Rennschnecke.java` | Implementiert Kriechbar |
| `Slomoschnecke.java` | Spezialisierung von Rennschnecke |
| `Turboschnecke.java` | Spezialisierung von Rennschnecke |
| `Anwendung.java` | Testklasse für Fahrzeuge |
| `BauernhofVerwaltung.java` | Verwaltungsklasse (Generics/Listen) |
| `Bauernhof_Aufgabe.java` | Aufgabenstellung Bauernhof |
| `Stadt.java` / `Stadtliste.java` | Stadt-Objekte in einer Liste |

### Rekursion
| Datei | Inhalt |
|-------|--------|
| `Collatz.java` | Collatz-Folge (3n+1) |
| `Dez2BinRek.java` | Dezimal → Binär (rekursiv) |
| `DreieckRek.java` | Dreiecke rekursiv zeichnen |
| `fakRek.java` | Fakultät rekursiv |
| `ZaehlenRek.java` | Rekursives Zählen |
| `rek.java` | Weitere Rekursionsbeispiele |
| `Palindrom.java` | Palindrom-Test (rekursiv) |
| `HanoiStatic.java` | Türme von Hanoi (statische Methoden) |
| `HanoiDynamicRoles.java` | Türme von Hanoi (mit Rollen-Objekten) |

### Sortieren & Suchen
| Datei | Inhalt |
|-------|--------|
| `MergeSort.java` | MergeSort-Implementierung |
| `Sortieralgorithmen.java` | Bubble-, Gnome- und BogoSort im Vergleich |
| `Prime.java` / `Probedivision.java` | Primzahlen |
| `SieveOfEratosthenes.java` | Sieb des Eratosthenes |
| `Galtonbrett.java` | Galton-Brett-Simulation |

### Datenstrukturen
| Datei | Inhalt |
|-------|--------|
| `List.java` / `ListenElement.java` / `Listenknoten.java` | Verkettete Listen (verschiedene Varianten) |
| `QueueWithList.java` | Queue auf Basis einer verketteten Liste |

### Datei­system-Modell (Composite-Muster)
| Datei | Inhalt |
|-------|--------|
| `Eintrag.java` | Basisklasse: Datei oder Verzeichnis-Eintrag |
| `Verzeichnis.java` | Ordner als spezialisierter Eintrag (mit Kindern als Array) |
| `DateisystemDemo.java` | Aufbau, Umbenennen, Entfernen, Baum-Ausgabe |

### Medien­verwaltung (abstrakte Klassen + polymorphe Tarifik)
| Datei | Inhalt |
|-------|--------|
| `Medium.java` | Abstrakte Basis: Titel, ID, Ausleih-Status, Tarif-Hooks |
| `Buch.java` | Frist 28 Tage, Mahn­gebühr 0,20&nbsp;€ pro Tag |
| `DVD.java` | 1,00&nbsp;€/Tag ab Tag&nbsp;1, max. 7 Tage |
| `Zeitschrift.java` | Aktuell 1,00&nbsp;€/Tag (1 Tag) – Archiv 14 Tage gratis |
| `MediathekDemo.java` | Ausleihen, Zurückgeben, Gesamt­einnahme, Doppel-Ausleihe |

### Java-Rätsel
| Datei | Inhalt |
|-------|--------|
| `OutputQuiz2.java` | Initialisierungs­reihenfolge: was gibt das Programm aus – und warum? |

### Sonstige
| Datei | Inhalt |
|-------|--------|
| `CharIncrement.java` | Zeichen-Arithmetik |
| `GiftGenerator.java` | Zufalls­geschenke aus Wortlisten (Random, Arrays) |
| `GridSearch.java` | Pfad durch ein 2D-Gitter (Einstieg in 2D-Arrays) |
| `Weihnachtsbaum.java` | ASCII-Weihnachtsbaum (→ auch Xmas2018.java) |
| `Xmas2018.java` | ASCII-Weihnachtsbaum von 2018 (kommentierte Version) |
| `Test.java` | Allgemeine Testklasse |
