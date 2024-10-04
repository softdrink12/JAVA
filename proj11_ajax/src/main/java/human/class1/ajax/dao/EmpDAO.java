package human.class1.ajax.dao;

import java.util.List;

import human.class1.ajax.dto.EmpDTO;

public interface EmpDAO {

	List<EmpDTO> selectEmp();
	
	int deleteEmp(EmpDTO empDTO);
	
	int insertEmp(EmpDTO empDTO);
	
	EmpDTO selectOne(EmpDTO empDTO);
	
	int updateEmp(EmpDTO empDTO);
	
}
