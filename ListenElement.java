public class ListenElement<T> {
    public T daten; // Daten des Knotens
    public ListenElement<T> nachfolger; // Verweis auf den nächsten Knoten

    public ListenElement(T daten) {
        this.daten = daten;
        this.nachfolger = null;
    }

    public void anhaengen(ListenElement<T> x) {
        if (nachfolger == null) {
            nachfolger = x;
        } else {
            nachfolger.anhaengen(x);
        }
    }

    public void get() {
        System.out.print(daten + " ");
        if (nachfolger != null) {
            nachfolger.get();
        }

    }

    public boolean finde(T wert) {
        if (daten.equals(wert)) {
            return true;
        } else if (nachfolger != null) {
            return nachfolger.finde(wert);
        } else {
            return false;
        }
    }

        public int getlLaenge() {
            if (nachfolger == null) {
                return 1;
            } else {
                return 1 + nachfolger.getlLaenge();
            }
        }

            public void entferneBei(int index) {
                if (index == 0) {
                    nachfolger = nachfolger.nachfolger;
                } else {
                    nachfolger.entferneBei(index - 1);
                }
            }
        
        }
          