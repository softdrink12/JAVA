package emp2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import emp2.dto.EmpDTO;

public class EmpDAO {

	public List selectEmp(String empnoo, String enamee) {
		List list = new ArrayList();

		try {
			Context ctx = new InitialContext();
			DataSource dateSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			Connection con = dateSource.getConnection();

			String query = null;
			PreparedStatement ps = null;

//			if (empnoo != null) {
//				query = "SELECT * from emp2 where empno = ?";
//				ps = con.prepareStatement(query);
//				ps.setInt(1, Integer.parseInt(empnoo));
//			} else if (enamee != null) {
//				query = "SELECT * from emp2 where ename = ?";
//				ps = con.prepareStatement(query);
//				ps.setString(1, enamee);
//			} else {
//				query = "SELECT * from emp2";
//				ps = con.prepareStatement(query);
//			}
			
			if ( empnoo != null && enamee != null ) {
				query = "select * from emp2 where empno = ? or ename = ?";
				ps = con.prepareStatement(query);
				ps.setString (1, empnoo) ;
				ps.setString(2, enamee);
			} else {
				query = "SELECT * from emp2";
				ps = con.prepareStatement(query);
			}

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				EmpDTO empDTO = new EmpDTO();

				int empno = rs.getInt("empno");
				empDTO.setEmpno(empno);

				String ename = rs.getString("ename");
				empDTO.setEname(ename);

				String job = rs.getString("job");
				empDTO.setJob(job);

				int mgr = rs.getInt("mgr");
				empDTO.setMgr(mgr);

				java.sql.Date hireDate = rs.getDate("hireDate");
				empDTO.setHireDate(hireDate);

				int sal = rs.getInt("sal");
				empDTO.setSal(sal);

				int comm = rs.getInt("comm");
				empDTO.setComm(comm);

				int deptno = rs.getInt("deptno");
				empDTO.setDeptno(deptno);

				list.add(empDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public int insert(EmpDTO empdto) {
		
		int result = -1;
		
		try {
			
			// Servers 폴더의 context.xml에서
			// name이 jdbc/oracle인 resource를 가져와서 dataSource로 저장하기 
			Context ctx = new InitialContext();
            DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// DB접속 : 커넥션풀을 사용해서
            Connection con = dataFactory.getConnection();
            
            // SQL 준비
            String query = " INSERT INTO tbl_todo (empno, ename, job, mgr, hireDate, sal, comm, deptno)";
            		 query += " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt( 1, empdto.getEmpno() );
            
            ps.setString( 2, empdto.getEname() );
            
            ps.setString( 3, empdto.getJob() );
            
            ps.setInt( 4, empdto.getMgr() );
            
            ps.setDate( 5, empdto.getHireDate() );
            
            ps.setInt( 6, empdto.getSal() );
            
            ps.setInt( 7, empdto.getComm() );
            
            ps.setInt( 8, empdto.getDeptno() );
            
            
            // SQL 실행
            result = ps.executeUpdate();
            
            ps.close();
            con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
