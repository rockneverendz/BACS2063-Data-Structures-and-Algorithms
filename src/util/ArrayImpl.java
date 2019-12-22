package util;

public class ArrayImpl implements IArray {

    @Override
    public void sort(Object[] a, IComparator c) {
        this.mergeSort(a, 0, a.length - 1, c);
    }

    public void mergeSort(Object[] a, int low, int high, IComparator c) {
        // the array to be sorted is a[low..high]
        if (low < high) { // base case: low >= high (0 or 1 item)
            int mid = (low + high) / 2;
            mergeSort(a, low, mid, c); // divide into two halves
            mergeSort(a, mid + 1, high, c); // then recursively sort them
            merge(a, low, mid, high, c); // conquer: the merge subroutine
        }
    }

    private void merge(Object[] a, int low, int mid, int high, IComparator c) {
        // subarray1 = a[low..mid], subarray2 = a[mid+1..high], both sorted
        int n = high - low + 1;
        Object[] temp = new Object[n]; // discuss: why do we need a temporary array b?
        int left = low;
        int right = mid + 1;
        int bIdx = 0;

        while (left <= mid && right <= high) // the merging
        {
            if (c.compare(a[left], a[right]) < 0) {
                temp[bIdx] = a[left];
                left++;
            } else {
                temp[bIdx] = a[right];
                right++;
            }
            bIdx++;
        }
        while (left <= mid) { // leftover, if any
            temp[bIdx] = a[left];
            bIdx++;
            left++;
        }
        while (right <= high) { // leftover, if any
            temp[bIdx] = a[right];
            bIdx++;
            right++;
        }
        for (int k = 0; k < n; k++) {
            a[low + k] = temp[k]; // copy back
        }
    }
    
    public static String toString(Object[] o){
        StringBuilder sb = new StringBuilder();
        for (Object object : o) {
            sb.append(object.toString());
            sb.append('\n');
        }
        return sb.toString();
    }
}
