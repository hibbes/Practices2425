class Collatz {
    public static void main(String[] args) {
        int temp = 0;
        int final1 = 0;
        int final2 = 0;
        boolean theend = false;

        for (int i = 100; i > 1; i--) {
            theend=false;
            temp = i;
            System.out.print("Start: "+i+" ");
            while (!theend) {
                
                if (temp % 2 == 0) {
                    temp = temp / 2;
                } else {
                    temp = temp * 3 + 1;
                }
                System.out.print(temp + " ");
                if (temp == 4) {
                    final1 = temp;
                }
                if (temp == 2 && final1 == 4) {
                    final2 = temp;
                }
                if (temp == 1 && final1 == 4 && final2 == 2) {
                    theend = true;
                }
            }
            System.out.println();
        }

    }

}
