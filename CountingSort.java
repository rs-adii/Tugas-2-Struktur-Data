public class CountingSort {
    public static void countingsort(int[] arr) {

        // Mencari nilai maksimum dalam array
        int maxVal = findMax(arr);

        // Membuat array count untuk menyimpan frekuensi
        int[] count = new int[maxVal + 1];

        // Menghitung frekuensi setiap elemen 
        for(int num : arr) {
            count[num]++;
        }

        // Menghitung kembali array dengan elemen yang terurut
        int index = 0;
        for(int i = 0; i < count.length; i++) {
            while(count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }
    
    private static int findMax(int[]arr) {
        int maxVal = arr[0];
        for(int num : arr) {
            if(num > maxVal) {
                maxVal = num;
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        int[] data = {34, 7, 23, 32, 5, 62};
        System.out.println("Data sebelum diurutkan");
        for(int num : data) {
            System.out.print(num + " ");
        }
        countingsort(data);
        System.out.println("\nData sesudah diurutkan");
        for(int num : data) {
            System.out.print(num + " ");
        }
    }
}
