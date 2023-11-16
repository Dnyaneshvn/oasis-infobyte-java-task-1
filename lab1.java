


class Fibonacii{

    static void fibonaciiSeries(int N){

        int n1 = 0;
        int n2 = 1;

        System.out.println(n1);
        System.out.println(n2);

        int itr1 = 0;

        for(int i=2;i<=N;i++){
            int c1 = n1 +n2;
            n1 = n2;
            n2 = c1;
            // System.out.println(c1);

            itr1++;
        }

        System.out.println("Iterations: "+itr1);
    }

    public static void main(String[] args) {
        
        fibonaciiSeries(10);
    }
}