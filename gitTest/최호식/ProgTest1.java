package 최호식;

public class ProgTest1 {
	static public int cVar = 0;

	String iStr[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	Double iDouble;
	boolean iBool = false;
	char iChar = 'a';

	String getGugudan(int dan) { // 변수 dan
		String str = "";
		if (dan > 0) {
			for (int i = 1; i <= 9; i++) {

				str += dan + "*" + i + "=" + String.valueOf(dan * i) + "\t"; // string형으로
				// System.out.print(dan + "*" + i + "=" + String.valueOf(dan * i)); test출력
			}
		}
		return str; // String 형으로 반환
	}
}
