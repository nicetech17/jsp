package jsp;

public class Exam {
	String str;
	
	public static void main(String[] args) {
		Exam e = new Exam();
		// Exam e;	// 생성자 조차도 X
		// Exam e = new Exam(); // 어딘가에서 쓰일 생성자가 쓰일 수 있기 때문에 에러X
		// e.str = "asdf";
		// System.out.println(e.str =="asdf");	// 주소 값 비교
		// System.out.println(e.str.equals("asdf")); // 값 비교
	
		System.out.println(e.str);
		try {
			System.out.println(e.str.toUpperCase());
		} catch (Exception e1) {
			System.out.println("뭔지는 모르겠지만 에러가 났을 겁니다.");
		}

	}
}