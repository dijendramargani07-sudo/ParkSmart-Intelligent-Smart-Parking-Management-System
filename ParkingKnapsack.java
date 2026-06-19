public class ParkingKnapsack {

    static int knapsack(int capacity,
                        int space[],
                        int priority[],
                        int n) {

        int dp[][] =
                new int[n + 1][capacity + 1];

        System.out.println(
        "===== Building DP Table =====\n");

        for(int i=0;i<=n;i++) {

            for(int w=0;w<=capacity;w++) {

                if(i==0 || w==0)
                    dp[i][w]=0;

                else if(space[i-1] <= w)

                    dp[i][w] =
                    Math.max(
                    priority[i-1]
                    + dp[i-1]
                    [w-space[i-1]],

                    dp[i-1][w]);

                else

                    dp[i][w] =
                    dp[i-1][w];
            }
        }

        for(int i=0;i<=n;i++) {

            for(int w=0;w<=capacity;w++) {

                System.out.print(
                dp[i][w] + "\t");
            }

            System.out.println();
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {

        int priority[] =
        {30,40,50,70};

        int space[] =
        {2,3,4,5};

        int capacity = 8;

        int n = priority.length;

        System.out.println(
        "====================================");

        System.out.println(
        "ParkSmart Parking Allocation");

        System.out.println(
        "====================================");

        int result =
        knapsack(
        capacity,
        space,
        priority,
        n);

        System.out.println(
        "\nMaximum Parking Priority = "
        + result);

        System.out.println(
        "\nOptimal Allocation Identified");

        System.out.println(
        "Parking Capacity Constraint Maintained");

        System.out.println(
        "Efficient Slot Utilization Achieved");
    }
}