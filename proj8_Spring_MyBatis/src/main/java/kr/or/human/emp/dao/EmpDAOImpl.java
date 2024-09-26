package kr.or.human.emp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.human.emp.dto.EmpDTO;

//@Repository
public class EmpDAOImpl implements EmpDAO {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<EmpDTO> selectEmp() {
		
		List<EmpDTO> result = sqlSession.selectList("mapper.emp.selectEmp");
		
		return result;
	}
	
	@Override
	public int insertEmp(EmpDTO empDTO) {
		
		int result = sqlSession.insert("mapper.emp.insertEmp", empDTO);
		
		return result;
	}
	
	@Override
	public EmpDTO selectOneEmp(EmpDTO empDTO) {
		
		EmpDTO result = sqlSession.selectOne("mapper.emp.selectOneEmp", empDTO);
		
		return result;
	}
	
	@Override
	public int deleteEmp(EmpDTO empDTO) {
		
		int result = sqlSession.delete("mapper.emp.deleteEmp", empDTO);
		
		return result;
	}
	
	@Override
	public int updateEmp(EmpDTO empDTO) {
		
		int result = sqlSession.update("mapper.emp.updateEmp", empDTO);
		
		return result;
	}

}
