package kr.or.human.emp.service;

import java.util.List;

import kr.or.human.emp.dto.EmpDTO;

public interface EmpService {

	List<EmpDTO> listEmp();
	
	EmpDTO listOne(EmpDTO empDTO);
	
	int insertEmp(EmpDTO empDTO);
	
	int deleteEmp(EmpDTO empDTO);
	
	int updateEmp(EmpDTO empDTO);
	
}
