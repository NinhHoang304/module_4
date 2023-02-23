import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("nhap n: ");
//        int n = Integer.parseInt(scanner.nextLine());
//
//        int k = n / 2;
//        for (int i = 1; i <= k + 1; i++) {
//            for (int j = 1; j <= i; j++) {
//                if (j == 1 || j == i) {
//                    System.out.print("*");
//                } else {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }
//
//        for (int i = k; i >= 1; i--) {
//            for (int j = i; j >= 1; j--) {
//                if (j == 1 || j == i) {
//                    System.out.print("*");
//                } else {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }

    }
    public static int solution(int[] nums) {
        int temp = 0;
        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == nums[j]){
                    break;
                }
                temp = i;
            }
        }
        return temp;
    }
}