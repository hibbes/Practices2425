# Straßenzustand bestimmen (Graph-Snippet)

> **Hinweis:** Dieser Codeabschnitt ist ein **Snippet** – er gehört in eine
> Klasse, die einen Graphen mit `Knoten`- und `Kante`-Objekten verwaltet,
> und ist für sich allein nicht kompilierfähig. Er ist als
> Lehrmaterial / Klausuraufgabe gedacht.

## Aufgabe

In einem Straßennetz (Graph) sollen alle Straßen (Kanten) anhand dreier
Regeln klassifiziert werden:

| Status | Bedeutung |
|--------|-----------|
| `1`    | befahrbar |
| `2`    | nicht befahrbar |
| `3`    | unentschieden / Rest (Standardwert) |

### Regeln

1. Eine Straße wird **nicht befahrbar** (`status = 2`), wenn sie von einem
   nicht erreichbaren Dorf ausgeht.
2. Eine Straße wird **befahrbar** (`status = 1`), wenn sie von einem
   erreichbaren Dorf ausgeht und zu einem nicht erreichbaren Dorf führt.
3. Ein Dorf wird **markiert** (`istMarkiert = true`), wenn es über eine
   befahrbare Straße erreicht werden kann.

> **Annahme:** Ein Dorf gilt als erreichbar genau dann, wenn `isMarkiert()`
> `true` zurückliefert (Startdorf wird vorher gesetzt).

## Lösungsidee: Fixpunkt-Iteration

Da Regel 3 weitere Dörfer markiert, die wiederum Regel 1/2 für andere
Kanten auslösen, läuft das Verfahren **so lange, bis sich nichts mehr
ändert**:

```java
/**
 * Bestimmt den Zustand aller Straßen (Kanten) im Graphen.
 *
 * Voraussetzung: Mindestens ein Dorf wurde vorab markiert
 * (Startdorf für die Erreichbarkeit).
 */
public void bestimmeStrassenzustand(Graph g) {
    // Schritt 1: Alle Straßen zunächst auf Status 3 (unentschieden) setzen
    for (Kante k : g.getAlleKanten()) {
        k.setStatus(3);
    }

    boolean keineVeränderungen;

    // Wiederhole, bis keine Änderungen mehr auftreten (Fixpunkt erreicht)
    do {
        keineVeränderungen = true;

        for (Kante k : g.getAlleKanten()) {
            Knoten start = k.getStart();
            Knoten ziel  = k.getZiel();

            // Regel 1: Straße nicht befahrbar, wenn Start nicht erreichbar
            if (!start.isMarkiert()) {
                if (k.getStatus() != 2) {
                    k.setStatus(2);
                    keineVeränderungen = false;
                }
            }

            // Regel 2: Straße befahrbar, wenn Start erreichbar und Ziel bisher nicht
            if (start.isMarkiert() && !ziel.isMarkiert()) {
                if (k.getStatus() != 1) {
                    k.setStatus(1);
                    keineVeränderungen = false;
                }

                // Regel 3: Ziel wird markiert (über diese Straße erreichbar)
                ziel.setMarkiert(true);
            }

            // Wenn beide Knoten erreichbar sind, bleibt Status 3 (Standard).
        }
    } while (!keineVeränderungen);
}
```

## Diskussion

### Warum eine `do…while`-Schleife mit Flag?

Nach Regel 3 wird ein zuvor unerreichbares Ziel-Dorf markiert. Das ändert
die Voraussetzung für andere Kanten, die von genau diesem Dorf ausgehen.
Diese Kanten müssen im **nächsten** Durchgang neu bewertet werden. Der
Flag `keineVeränderungen` bricht ab, sobald ein vollständiger Durchgang
ohne jede Status- oder Markierungs­änderung verläuft – Fixpunkt erreicht.

### Komplexität

Im schlimmsten Fall verändert jede Iteration genau eine Kante oder einen
Knoten, also läuft die äußere Schleife bis zu O(|V| + |E|) mal. Mit der
inneren Schleife über alle Kanten ergibt sich **O((|V| + |E|) · |E|)**.
Für reine Erreichbarkeit gibt es schnellere Verfahren (BFS/DFS in
O(|V| + |E|)) – die explizite Fixpunkt-Form ist hier didaktisch gewählt,
weil sie die drei Regeln direkt abbildet.

### Was fehlt zur Lauffähigkeit?

Das Snippet setzt folgende Klassen voraus:

```java
class Knoten {
    boolean markiert;
    public boolean isMarkiert() { return markiert; }
    public void setMarkiert(boolean m) { this.markiert = m; }
}

class Kante {
    Knoten start, ziel;
    int status = 3;
    public Knoten getStart() { return start; }
    public Knoten getZiel()  { return ziel; }
    public int getStatus()   { return status; }
    public void setStatus(int s) { this.status = s; }
}

class Graph {
    java.util.List<Kante> kanten = new java.util.ArrayList<>();
    public java.util.List<Kante> getAlleKanten() { return kanten; }
}
```

Wenn diese Hilfsklassen vorhanden sind, kann die Methode in eine beliebige
Klasse eingebettet und an einem konkreten Graphen getestet werden.

## Lernziele

- Fixpunkt-Iteration als allgemeines Schema (Regeln so lange anwenden, bis
  sich nichts mehr ändert)
- Trennung von Knoten- und Kanten-Zustand (Markierung vs. Status)
- Bewusstsein für die Komplexität naiver Lösungen vs. spezialisierte
  Graph-Algorithmen (BFS/DFS)
- Lesbares Java mit klar benannten Hilfsmethoden (`setStatus`,
  `isMarkiert`, …)
