import java.util.*;

public class subarrayPalindrom {
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 2, 1};

        // Map to store palindromes by their length, preserving insertion order within each length
        Map<Integer, List<List<Integer>>> palindromes = new TreeMap<>();

        // Find all palindromic subarrays
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr.length; j++) {
                if(isPalindrome(arr, i, j)) {
                    int length = j - i + 1;
                    List<Integer> subarray = new ArrayList<>();
                    for(int k = i; k <= j; k++) {
                        subarray.add(arr[k]);
                    }
                    palindromes.putIfAbsent(length, new ArrayList<>());
                    palindromes.get(length).add(subarray);
                }
            }
        }

        // Print palindromic subarrays grouped by length in order
        for(int length : palindromes.keySet()) {
            List<List<Integer>> group = palindromes.get(length);
            for(List<Integer> subarray : group) {
                for(int num : subarray) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }

    // Check if subarray is palindrome
    public static boolean isPalindrome(int[] arr, int start, int end) {
        while(start < end) {
            if(arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
