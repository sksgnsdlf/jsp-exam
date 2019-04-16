package DBPKG;

import java.beans.Beans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Memdao {
	Connection conn = null;
	PreparedStatement psmt;
	ResultSet rs = null;
	
	static Memdao instance;
	public static Memdao getInstance() {
		if(instance == null)
			instance = new Memdao();
		return instance;
	}
	//등록
		public int insert(bean dto) {
			int r = 0;
			try {
			//1. DB연결
			conn = db.getConnection();
			
			//트랜잭션 처리
			conn.setAutoCommit(false);
			
			//2. SQL구문 준비
			String sql = "insert into member_tbl_02 (custno,custname, phone, "
					+ "address,joindate,grade,city) values(?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			
			//3. 실행
			psmt.setString(1, dto.getCustno());
			psmt.setString(2, dto.getCustname());
			psmt.setString(3, dto.getPhone());
			psmt.setString(4, dto.getAddress());
			psmt.setString(5, dto.getJoindate());
			psmt.setString(6, dto.getGrade());
			psmt.setString(7, dto.getCity());
			r = psmt.executeUpdate();
			conn.commit();		
			
			//4. 결과처리
			System.out.println(r + " 건이 등록됨");
			} catch(Exception e) { 
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
					} 
				}
			finally {
				//5. 연결해제
				db.close(conn);
			}
			return r;
		}
		//수정
		public void update(bean beans) {		
			try {
			conn = db.getConnection();/*
										 * String sql = " UPDATE member_tbl_02 set" + " custname = ?," + " phone = ?" +
										 * " address = ?" + " joindate = ?" + " grade = ?" + " city = ?" +
										 * "  WHERE custno = ?    ";
										 */
				String sql = " UPDATE member_tbl_02 \r\n" + 
						"set custname=? ,"
						+ "phone=?,"
						+ "address=? ,"
						+ "joindate=?,"
						+ "grade=?,"
						+ "city=?\r\n" + 
						" WHERE custno = ?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, beans.getCustname());
				psmt.setString(2, beans.getPhone());
				psmt.setString(3, beans.getAddress());
				psmt.setString(4, beans.getJoindate());
				psmt.setString(5, beans.getGrade());
				psmt.setString(6, beans.getCity());
				psmt.setString(7, beans.getCustno());
				psmt.executeUpdate();			
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				//5. 연결해제 
				db.close(conn);
			}
		}
		
		
		//전체조회
		public List<bean> selectAll(){
			List<bean> datas = new ArrayList<bean>();
			try {
				conn = db.getConnection();
				String sql = "select custno,custname,phone,address,to_char(joindate,'yyyy-MM-dd')joindate,\r\n" + 
						"decode(grade, 'A', 'VIP',\r\n" + 
						"              'B', '일반',\r\n" + 
						"              '직원')as grade,\r\n" + 
						"city from member_tbl_02 order by custno";
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				while(rs.next()) {
					bean emp = new bean();
					emp.setCustno(rs.getString("custno"));
					emp.setCustname(rs.getString("custname"));
					emp.setPhone(rs.getString("phone"));
					emp.setAddress(rs.getString("address"));
					emp.setJoindate(rs.getString("joindate"));
					emp.setGrade(rs.getString("grade"));
					emp.setCity(rs.getString("city"));
					datas.add(emp);			//dto를 리스트에 추가
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				db.close(conn);
			}
			return datas;
		}
		
		//단건
		public bean getMember(String custno) {
			bean emp = null;
			try {
				conn = db.getConnection();
				String sql = "select custno, custname, phone, address, to_char(joindate,'YYYY-MM-DD') joindate, grade, city from member_tbl_02 where custno=? ";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, custno);

				ResultSet rs = psmt.executeQuery();
				if (rs.next()) {
					emp = new bean();
					emp.setCustno(rs.getString("custno"));
					emp.setCustname(rs.getString("custname"));
					emp.setPhone(rs.getString("phone"));
					emp.setAddress(rs.getString("address"));
					emp.setJoindate(rs.getString("joindate"));
					emp.setGrade(rs.getString("grade"));
					emp.setCity(rs.getString("city"));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.close(conn);
			}
			return emp;
		}
}
