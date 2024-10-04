package human.class1.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import human.class1.ajax.dao.EmpDAO;
import human.class1.ajax.dto.EmpDTO;

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
	public int deleteEmp(EmpDTO empDTO) {
		
		int result = empDAO.deleteEmp(empDTO);
		
		return result;
	}

	@Override
	public EmpDTO selectOne(EmpDTO empDTO) {
		
		EmpDTO dto = empDAO.selectOne(empDTO);
		
		return dto;
	}

	@Override
	public int insert(EmpDTO empDTO) {
		
		int result = empDAO.insertEmp(empDTO);
		
		return result;
	}

	@Override
	public int updateEmp(EmpDTO empDTO) {
		
		int result = empDAO.updateEmp(empDTO);
		
		return result;
	}

}
