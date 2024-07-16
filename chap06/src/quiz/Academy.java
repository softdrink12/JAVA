package quiz;

public class Academy {

	String acName;
	Student[] student = new Student[10];
	int a = 0;
	
	Academy(String acName) {
		this.acName = acName;
	}
	
	void join(Student s) {
		if ( a > 0) {
			System.out.println("정원이 찼습니다");
		} else {
			student[a] = s;
			a++;
		}
		
	}
	
	void viewList() {
		System.out.println("----------"+acName+"----------");
		for (int i = 0; i < a; i++) {
			System.out.println(student[i].name + student[i].age);
		}
	}
	

	
}
