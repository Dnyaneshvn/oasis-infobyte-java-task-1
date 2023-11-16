public class lab03 {
    
    static int ZeroOneSnapsack(int[] weight,int profit[],int maxWeight){
        int maxProfit = 0;

        int itr1 = 0;
        for(int i=0;i<weight.length;i++){

            for(int j=i+1;j<weight.length;j++){

                if(weight[i]>weight[j]){
                    int temp = weight[i];
                    weight[i] = weight[j];
                    weight[j] = temp;

                    int temp1 = profit[i];
                    profit[i] = profit[j];
                    profit[j] = temp1;
                }

                itr1++;
            }
        }
        
        System.out.println("Sorting Iterations: "+(itr1+1));

        int itr2= 0;
        int weightSum = 0;
        for(int i=weight.length-1;i>=0;i--){
            if(weightSum+weight[i]==maxWeight){
                maxProfit +=profit[i];
                break;
            }
            
            else if(weightSum+weight[i]<maxWeight){
                weightSum +=weight[i];
                maxProfit +=profit[i];
            }

            else{
                break;
            }

            itr2++;
        }

        System.out.println("Final Iterations: "+(itr2+1));

        return maxProfit;
    }

    public static void main(String[] args) {
        
        int weigth[] = {10,20,30};
        int profit[] = {60,100,120};

        System.out.println(ZeroOneSnapsack(weigth, profit, 50));
    }
}
