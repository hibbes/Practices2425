class Rek {

    
    public static void main(String[] args) {
     System.out.println(power(5,5));
        System.out.println(cash(1000, 1, 2));
        System.out.println(palindrom("annb"));
    }


public static float cash(float kapital, float zins, float jahre){
    if(jahre == 0){
        return kapital;
    }else{
        return cash(kapital, zins, jahre-1) + cash(kapital, zins, jahre-1) * zins / 100;}
    }

    public static int power(int x, int n){
        int result = 1;
        for(int i = 0; i < n; i++){
            result *= x;
        }
        return result;
    }


    public static boolean palindrom(String s){
        if(s.length() == 0 || s.length() == 1){
            return true;
        }else{
            if(s.charAt(0) == s.charAt(s.length()-1)){
                return palindrom(s.substring(1, s.length()-1));
            }else{
                return false;
            }
        }
    }

    public static long fak(int n) {
        System.out.println("Dies ist Ebene: " + n);
        if (n == 0) {
            return 1;
        } else {
            System.out.print(n+" ");
            return n * fak(n - 1);
        }
    }
puv
     public static long fib(int n){
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else{
            return fib(n-1) + fib(n-2);
     }

    }
}