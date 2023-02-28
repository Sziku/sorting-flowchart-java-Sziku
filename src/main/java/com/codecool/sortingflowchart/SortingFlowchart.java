package com.codecool.sortingflowchart;

import java.util.ArrayList;
import java.util.Arrays;

public class SortingFlowchart {

    public static void main(String[] args) {
        int[] test1 = {1,2,56,32,51,2,8,92,15};
        System.out.println("Test1 array: "+Arrays.toString(test1));
        System.out.println("Bubble Sort algorithm: "+Arrays.toString(bubbleSort(test1)));

        int[] test2 = {1,2,4,7,11,22,38,42,43};
        System.out.println("Test2 array: "+Arrays.toString(test2));
        System.out.println("Binary Sort algorithm, index: "+binarySearch(test2, 8));

        System.out.println(primeNumbers(100));
    }

    public static int[] bubbleSort(int[] array){
        int n=array.length;
        for(int i=0;i<n-1;i++){
            for (int j=0; j<n-i-1; j++){
                if(array[j]>array[j+1]){
                    int temp = array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }

    public static int binarySearch(int[] array, int value){
        int start=0;
        int end= array.length-1;
        int mid;
        while (start<=end){
            mid=(start+end)/2;
            if(array[mid]==value){
                return mid;
            }else if(array[mid]>value){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return -1;
    }

    public static ArrayList<Integer> primeNumbers(int n){
        int[] is_prime_list = new int[n+1];
        ArrayList<Integer> primes = new ArrayList<>();

        for(int i=0; i<=n; i++){
                //is_prime_list.add(i);
                is_prime_list[i]=i;
        }

        double max = Math.sqrt(n);
        for(int i=2; i<=max; i++){
            if(is_prime_list[i]==i) {
                for (int j = i + i; j <= n; j = j + i) {
                    is_prime_list[j] = 0;
                }
            }
        }

        for(int prime = 2; prime<=n; prime++){
            if (is_prime_list[prime]!=0){
                primes.add(is_prime_list[prime]);
            }
        }

        return primes;
    }
}
