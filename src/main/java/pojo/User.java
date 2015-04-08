package pojo;

import net.sf.json.JSONObject;

public class User {
	
	private int age;
	
	private int num;

	public static void main(String[] args){
		String str  = "{\"qq\":123}";
		JSONObject jsonObject = JSONObject.fromObject(str);
		System.out.println(jsonObject.get("qqq"));
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	

}
