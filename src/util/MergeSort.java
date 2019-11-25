package util;

public class MergeSort {

    /*
     * Description  : Apply Merge Sorting algorithm to the array
     * Precondition :
     * Postcondition: Array is sorted at the given range 
     * Return       :
     */
    public void mergeSort(int a[], int low, int high) {
        // the array to be sorted is a[low..high]
        if (low < high) { // base case: low >= high (0 or 1 item)
            int mid = (low + high) / 2;
            mergeSort(a, low, mid); // divide into two halves
            mergeSort(a, mid + 1, high); // then recursively sort them
            merge(a, low, mid, high); // conquer: the merge subroutine
        }
    }

    private void merge(int a[], int low, int mid, int high) {
        // subarray1 = a[low..mid], subarray2 = a[mid+1..high], both sorted
        int n = high - low + 1;
        int[] b = new int[n]; // discuss: why do we need a temporary array b?
        int left = low, right = mid + 1, bIdx = 0;
        while (left <= mid && right <= high) // the merging
        {
            b[bIdx++] = (a[left] <= a[right]) ? a[left++] : a[right++];
        }
        while (left <= mid) {
            b[bIdx++] = a[left++]; // leftover, if any
        }
        while (right <= high) {
            b[bIdx++] = a[right++]; // leftover, if any
        }
        for (int k = 0; k < n; k++) {
            a[low + k] = b[k]; // copy back
        }
    }
}
