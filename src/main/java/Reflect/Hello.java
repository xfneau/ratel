package Reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hello {
	
	public static void main(String[] args){
		Class<?> demo1 = null;
		Class<?> demo2 = null;
		Class<?> demo3 = null;
		try{
			demo1 = Class.forName("Reflect.Demo");
			Object d = demo1.newInstance();
			Method method = demo1.getMethod("ss",String.class,int.class);
			method.invoke(d,"1",1);
			
			
			String meth = "toUpperCase";
			Object o = "efewf";
			Class s = o.getClass();
			Method m = s.getMethod(meth);
			System.out.println(m.invoke(String.class,o));
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(4);
		list.add(8);
		list.add(4);
		Collections.sort(list, new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
					int a = o1;
					int b = o2;
				return a>b?1:-1;
			}
			
		});
		for( Integer i : list ){
//			System.out.println(i);
		}
	}

}
