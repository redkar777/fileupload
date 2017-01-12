package grammer03;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class grammer03_YJ {
	
	/*
		실행시 결과는?
		다른방법으로 정렬하는 메서드 하나 만들어오기
	*/
	public static void main(String[] args) {
		String[] arr = { "1", "2", "9", "7", "4", "6", "1", "7", "0" };
		//HashSet을 이용하여 중복값을 제거
		Set set = new HashSet();
		//for 문을 이용해 arr을 s변수에 하나씩 담음
		for (String s : arr) {
			set.add(s);	// 여기서 set에 담기는 값은 {1, 2, 9, 7, 4, 6, 0}
		}

		List list = new LinkedList(set); 
		Collections.sort(list);      //list에 담긴 값을 오름차순으로 정렬한다. ->{0, 1, 4, 6, 7, 9}

		Iterator it = list.iterator();  //list 담긴 값을 하나씩 가져와서 it에 대입한다.
		//이동할 값이 있다면 true을 리턴하고 그렇지 않으면 false을 리턴합니다.								
		while (it.hasNext()) {
			System.out.print(it.next());
		}
	}
	
	
		
	

}
