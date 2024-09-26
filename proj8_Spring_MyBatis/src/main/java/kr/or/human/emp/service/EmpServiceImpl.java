package kr.or.human.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.human.emp.dao.EmpDAO;
import kr.or.human.emp.dto.EmpDTO;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	EmpDAO empDAO;

	@Override
	public List<EmpDTO> listEmp() {
		
		List<EmpDTO> list = empDAO.selectEmp();
		
		return list;
	}
	
	@Override
	public int insertEmp(EmpDTO empDTO) {
		int result = empDAO.insertEmp(empDTO);
		
		return result;
	}
	
	@Override
	public EmpDTO listOne(EmpDTO empDTO) {
		
		EmpDTO list = empDAO.selectOneEmp(empDTO);
		
		return list;
	}
	
	@Override
	public int deleteEmp(EmpDTO empDTO) {
		int result = empDAO.deleteEmp(empDTO);
		
		return result;
	}

	@Override
	public int updateEmp(EmpDTO empDTO) {
		int result = empDAO.updateEmp(empDTO);
		
		return result;
	}

}
