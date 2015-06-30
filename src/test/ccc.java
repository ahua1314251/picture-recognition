package test;

import java.util.HashMap;
import java.util.Map;

public class ccc {

	public static void main(String[] args) {
	 Map map=new HashMap();
	 map.put("a", "qwe");
	 for(Object tmp : map.values().toArray())
	 {
		 System.out.println(tmp.getClass());
	 }

	}

}
