package com.spring.btz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.spring.btz.common.JDBCUtil;
import com.spring.btz.user.UserVO;

@Repository("userDAO")
public class UserDAO {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	private final String USER_GET = 
			" select * from test_users  " + 
			" where id=? ";
	
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		
		try {
			System.out.println("JDBC getUser()");
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(USER_GET);
			ps.setString(1, vo.getId());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("passwoard"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		
		return user;
	}
}
