package ��ȣ��;

import java.util.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ProgTest2 {

	Map<String, MemberData> mapList = new Hashtable<>();

	void mapListadd(String memberID, String name, String tel, String gender) {
		mapList.put(memberID, new MemberData(memberID, name, tel, gender));	//�Ű����� 4���� ��� �� ����Ͽ���
	}

	void mapListRemove(String memberID) {
		mapList.remove(memberID);
		//mapList.remove(memberID.trim());
	}

	ArrayList<MemberData> getMapList() {
		ArrayList<MemberData> array = new ArrayList<>();
		Set<String> keyset = mapList.keySet();
		Iterator<String> keyiterator = keyset.iterator();
		while (keyiterator.hasNext()) {
			String k = keyiterator.next();
			MemberData v = mapList.get(k);
			array.add(v);
//			for (int i = 0; i < array.size(); i++) {
//				System.out.println(i + " : " + arry.get(i));
//			}
		}
		return array;
	}
}