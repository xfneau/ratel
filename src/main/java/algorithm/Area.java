package algorithm;

import java.util.Scanner;

/**
 * 多边形面积
 * @author neau
 * 
 * 
 * 
 *
 */
public class Area {

	public static double det(Point a, Point b, Point c){
		return (a.getX()-c.getX())*(b.getY()-c.getY())-(a.getY()-c.getY())*(b.getX()-c.getX());
	}
	
	public static void main(String[] args) {

		int j = 0, i = 0;
		double sum = 0;
		Point[] arr = new Point[100];
		Scanner cin = new Scanner(System.in); 
		j = cin.nextInt();
		int n = j;
		while( j-- > 0 ){
			double x = cin.nextDouble();
			double y = cin.nextDouble();
			arr[i++] = new Point(x,y);
		}
		for( i = 0; i < n-1; i++ ){
			sum += det(arr[i],arr[i+1],arr[0]) ;
		}
		System.out.println(sum/2);
	}

}
class Point{
	private double x;
	private double y;
	public Point(double x, double y ){
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	
	
}
