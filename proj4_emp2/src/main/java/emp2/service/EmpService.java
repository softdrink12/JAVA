package emp2.service;

import java.util.List;

import emp2.dao.EmpDAO;
import emp2.dto.EmpDTO;

public class EmpService {
	
	EmpDAO empDAO = new EmpDAO();

	public List getEmp(String empnoo, String enamee) {
		
		List result = this.empDAO.selectEmp(empnoo, enamee);
		
		return result;
	}
	
	public int insert(EmpDTO empdto) {
		// DB에 insert
		
		return this.empDAO.insert(empdto);
	}
	
	public EmpDTO get(int empno) {
		EmpDTO empdto = new EmpDTO();
		
		empdto = empDAO.One(empno);
		
		return empdto;
	}
	
	public int update(EmpDTO empdto) {
		
		return empDAO.update(empdto);
		
	}
	
	public int delete(EmpDTO empdto) {
		
		return empDAO.delete(empdto);
		
	}
	
	// 전달받은 EmpDTO를 EmpDAO로 보내고 
	// DAO가 return한 EmpDTO를 반환한다
	public EmpDTO loginCheck(EmpDTO empdto) {
		EmpDAO empdao = new EmpDAO();
		EmpDTO resultdto = empdao.selectLogin(empdto);
		return resultdto;
	}
	
}
