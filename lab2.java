


class FractionalSnapSack{

    static int fractionalSnapsack(int[] weight,int profit[],int maxWeight){

        int pw[] = new int[weight.length];
        int itr1 = 0;
        for(int i=0;i<pw.length;i++){
            pw[i] = profit[i]/weight[i];
            itr1++;
        }

        // for(int i=0;i<pw.length;i++){
        //     System.out.print(pw[i]+" ");
        // }

        System.out.println("P/W Iterations: "+itr1);

        int itr2 = 0;
        for(int i=0;i<weight.length;i++){

            for(int j=i+1;j<weight.length;j++){

                if(pw[i]>pw[j]){
                    int temp = pw[i];
                    pw[i] = pw[j];
                    pw[j] = temp;

                    int temp2 = profit[i];
                    profit[i] = profit[j];
                    profit[j] = temp2;

                    int temp3 = weight[i];
                    weight[i] = weight[j];
                    weight[j] = temp3;
                }

                itr2++;
            }
        }

        System.out.println("Sorting Iterations: "+itr2);

        // for(int i=0;i<pw.length;i++){
        //     System.out.print(pw[i]+" ");
        // }

        int weightSum = 0;
        int maxProfit = 0;
        int itr3 = 0;
        for(int i=pw.length-1;i>=0;i--){

            if(weightSum + weight[i]==maxWeight){
                maxProfit +=profit[i];
                break;
            }

            else if(weightSum+weight[i]<maxWeight){
                weightSum +=weight[i];
                maxProfit +=profit[i];
            }

            else{
                
                int req= maxWeight - weightSum;
                maxProfit = maxProfit + pw[i]*req;
                break;
            }

            itr3++;
        }

        System.out.println("Iterations: "+itr3);

        return maxProfit;
    }


    public static void main(String[] args) {
        
        int weigth[] = {3, 3, 2, 5, 1};
        int profit[] = {10, 15, 10, 20, 8};

        System.out.println(fractionalSnapsack(weigth, profit,10));
    }
}