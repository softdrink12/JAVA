package kr.or.human.emp.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//@EqualsAndHashCode
@Data
public class MemberDTO {
	
	private String userID;
	
	private String userPW;
	
	private int age;
	
	private String userName;

}
