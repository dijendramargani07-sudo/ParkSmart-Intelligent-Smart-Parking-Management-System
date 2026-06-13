import java.util.Arrays;

public class ParkingSorting {

    void merge(int arr[], int l, int m, int r) {

        int n1 = m-l+1;
        int n2 = r-m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i=0;i<n1;i++)
            L[i]=arr[l+i];

        for(int j=0;j<n2;j++)
            R[j]=arr[m+1+j];

        int i=0,j=0,k=l;

        while(i<n1 && j<n2) {

            if(L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while(i<n1)
            arr[k++] = L[i++];

        while(j<n2)
            arr[k++] = R[j++];
    }

    void mergeSort(int arr[], int l, int r) {

        if(l<r) {

            int m=(l+r)/2;

            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);

            merge(arr,l,m,r);
        }
    }

    int partition(int arr[], int low, int high) {

        int pivot = arr[high];

        System.out.println(
        "Pivot Selected : "
        + pivot);

        int i = low-1;

        for(int j=low;j<high;j++) {

            if(arr[j] < pivot) {

                i++;

                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }

        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        return i+1;
    }

    void quickSort(int arr[],
                   int low,
                   int high) {

        if(low<high) {

            int pi =
            partition(arr,low,high);

            System.out.println(
            "Current Array : "
            + Arrays.toString(arr));

            System.out.println(
            "-------------------------");

            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    public static void main(String[] args) {

        ParkingSorting obj =
                new ParkingSorting();

        int mergeArr[] =
        {108,102,105,101,107,103,104,106};

        int quickArr[] =
        {108,102,105,101,107,103,104,106};

        System.out.println(
        "========================================");

        System.out.println(
        "ParkSmart - Parking Slot Sorting");

        System.out.println(
        "========================================");

        System.out.println(
        "\nOriginal Slots:");

        System.out.println(
        Arrays.toString(mergeArr));

        obj.mergeSort(
        mergeArr,
        0,
        mergeArr.length-1);

        System.out.println(
        "\nMerge Sort Result:");

        System.out.println(
        Arrays.toString(mergeArr));

        System.out.println(
        "\nQuick Sort Steps:\n");

        obj.quickSort(
        quickArr,
        0,
        quickArr.length-1);

        System.out.println(
        "\nQuick Sort Result:");

        System.out.println(
        Arrays.toString(quickArr));
    }
}