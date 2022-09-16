package test;

public class Test {

    public static void main(String[] args) {
       //二分查找
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int target = 10;
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;
        while (left <= right){
            if(arr[mid] == target){
                System.out.println(mid);
                break;
            }else if(arr[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }




    }


}
