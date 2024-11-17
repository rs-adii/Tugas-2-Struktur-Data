public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Mengurutkan bagian kiri
            mergeSort(arr, left, mid);
            // Mengurutkan bagian kanan
            mergeSort(arr, mid + 1, right);

            // Menggabungkan kedua bagian
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // Ukuran dari dua sub-array
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Array sementara
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Menyalin data ke array sementara
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        // Menggabungkan kembali ke array asli
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Menyalin elemen yang tersisa dari L jika ada
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Menyalin elemen yang tersisa dari R jika ada
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] data = {34, 7, 23, 32, 5, 62};
        System.out.println("Data sebelum diurutkan:");
        for (int num : data) {
            System.out.print(num + " ");
        }
        
        mergeSort(data, 0, data.length - 1);
        
        System.out.println("\nData setelah diurutkan:");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}
