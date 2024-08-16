package emp2.service;

import java.util.List;

import emp2.dao.EmpDAO;
import emp2.dto.EmpDTO;

public class EmpService {

	public List getEmp(String empnoo, String enamee) {
		EmpDAO empdao = new EmpDAO();
		
		List result = empdao.selectEmp(empnoo, enamee);
		
		return result;
	}
	
	public int insert(EmpDTO empdto) {
		// DB에 insert
		
		EmpDAO empDAO = new EmpDAO();
		return empDAO.insert(empdto);
	}
	
}
