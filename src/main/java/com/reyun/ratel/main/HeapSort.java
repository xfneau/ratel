package com.reyun.ratel.main;

public class HeapSort {
	
	private static int[] arr = new int[10000000];
	
	public static void heapAdjust( int[] array, int ant, int n ){
		int temp = arr[ant];
		for( int i = ant*2+1; i < n; i<<=1 ){
			if( i+1 < n && arr[i] < arr[i+1] ){
				i++;
			}
			if( temp < arr[i] ){
				arr[ant] = arr[i];
				ant = i;
			}
		}
		arr[ant] = temp;
	}
	
	public static void heapSort(int [] array, int n ){
		//建立堆
		for( int i = n/2-1; i >= 0; i-- ){
			heapAdjust(array,i,n);
		}
		//堆排序
		for( int i = n-1; i > 0; i-- ){
			arr[0] = arr[i]+arr[0];
			arr[i] = arr[0]-arr[i];
			arr[0] = arr[0]-arr[i];
			heapAdjust(arr,0,i);
		}
	}
	
	public static void main(String[] args){
		for( int i = 0; i < 10000000; i++ ){
			arr[i] = (int)(Math.random()*1000);
		}
		long time = System.currentTimeMillis();
		heapSort(arr,10000000);
		System.out.println((System.currentTimeMillis()-time)*1.0/1000);
//		for( int i = 0; i < 100000; i++ ){
//			System.out.print(arr[i]+",");
//		}
		System.out.println();
	}

}
