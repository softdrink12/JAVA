package emp2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import emp2.dto.EmpDTO;

public class EmpDAO {

	private Connection getConnection() {
		
		Connection con = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
        String user = "scott2_16";
        String password = "tiger";
        
        	try {
        	
        	// Class.forName : String을 이용해서 class를 생성한다
        	// driver : 서로 다른 것들 (java, oracle)이 소통할 수 있게 도와줌
        	// 오라클 드라이버 로딩
        	Class.forName(driver);
        	
        	// DB 접속
        	con = DriverManager.getConnection(url, user, password);
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        	return con;
	}
	
	public List selectEmp(String empnoo, String enamee) {
		List list = new ArrayList();

		try {
			Context ctx = new InitialContext();
			DataSource dateSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			Connection con = dateSource.getConnection();

			String query = null;
			PreparedStatement ps = null;
			
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
            String query = " INSERT INTO emp2 (empno, ename, job, mgr, hireDate, sal, comm, deptno)";
            		 query += " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
//            PreparedStatement ps = con.prepareStatement(query);
            // 원래 실행되는 걸 LoggableStatement가 가로채서 
            PreparedStatement ps = new LoggableStatement(con, query);
            
            
            ps.setInt( 1, empdto.getEmpno() );
            
            ps.setString( 2, empdto.getEname() );
            
            ps.setString( 3, empdto.getJob() );
            
            ps.setInt( 4, empdto.getMgr() );
            
            ps.setDate( 5, empdto.getHireDate() );
            
            ps.setInt( 6, empdto.getSal() );
            
            ps.setInt( 7, empdto.getComm() );
            
            ps.setInt( 8, empdto.getDeptno() );
            
            // 실제 실행되는 sql을 출력해볼 수 있다
            System.out.println( ( (LoggableStatement)ps ).getQueryString() );
            
            
            // SQL 실행
            result = ps.executeUpdate();
            
            ps.close();
            con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public EmpDTO One(int empno) {
		EmpDTO empdto = null;
		
		Connection con = getConnection();
		
		// 접속이 안되었다면 null을 바로 리턴
		if(con == null) return null;
		
		try {
			
			// sql 준비
			String sql = "select * from emp2 where empno = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, empno);
			
			// sql 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() ) {
				empdto = new EmpDTO();
				empdto.setEmpno( rs.getInt("empno") );
				empdto.setEname( rs.getString("ename") );
				empdto.setJob( rs.getString("job") );
				empdto.setMgr( rs.getInt("mgr") );
				empdto.setHireDate( rs.getDate("hireDate") );
				empdto.setSal( rs.getInt("sal") );
				empdto.setComm( rs.getInt("comm") );
				empdto.setDeptno( rs.getInt("deptno") );
			}
		
	}catch (Exception e) {
		e.printStackTrace();
	}
		return empdto;
		
	}
	
	public int update(EmpDTO empdto) {
		
		int result = -1;
		
		try {
			
			// Servers 폴더의 context.xml에서
			// name이 jdbc/oracle인 resource를 가져와서 dataSource로 저장하기 
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// DB접속 : 커넥션풀을 사용해서
			Connection con = dataFactory.getConnection();
			
			// SQL 준비
			String query = " UPDATE emp2";
					query += " SET ename = ? , job = ? , mgr = ? , hiredate = ? , sal = ? , comm = ? , deptno = ? ";
					query += " WHERE empno = ?";
			
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString( 1, empdto.getEname() );
			
			ps.setString( 2, empdto.getJob() );
			
			ps.setInt( 3, empdto.getMgr() );
			
			java.sql.Date hiredate =  empdto.getHireDate();
			ps.setDate( 4, hiredate );
			
			ps.setInt( 5, empdto.getSal() );
			
			ps.setInt( 6, empdto.getComm() );
			
			ps.setInt( 7, empdto.getDeptno() );
			
			ps.setInt( 8, empdto.getEmpno() );
			
			
			// SQL 실행
			result = ps.executeUpdate();
			
			ps.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public int delete(EmpDTO empdto) {
		int result = -1;
		
		try {
			
			// Servers 폴더의 context.xml에서
			// name이 jdbc/oracle인 resource를 가져와서 dataSource로 저장하기 
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// DB접속 : 커넥션풀을 사용해서
			Connection con = dataFactory.getConnection();
			
			// SQL 준비
			String query = " delete emp2 where empno = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt( 1, empdto.getEmpno() );
			
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
