package com.StudentApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.StudentApp.connector.Connector;
import com.StudentApp.dto.Student;

public class StudentDAOImplementation implements StudentDAOInterface{

	public Connection con;
	public StudentDAOImplementation() {
		this.con=Connector.requestConnection();
	}
	
	
	
	
	@Override
	public boolean insertStudent(Student s) {
		PreparedStatement ps=null;
		int rs=0;
		String query="INSERT INTO STUDENT VALUES(?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1,s.getId());
			ps.setString(2,s.getName());
			ps.setString(3, s.getEmail());
			ps.setLong(4,s.getPhone());
			ps.setString(5,s.getBranch());
			ps.setString(6, s.getPassword());
			rs=ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		if(rs>0) {
			return true;
		}
		else {
			return false;
		}
		

	}
	
	

	@Override
	public boolean updateStudent(Student s) {
		PreparedStatement ps=null;
		int res=0;

		String query="UPDATE STUDENT SET ID=?, NAME=?, EMAIL=?, PHONE=?, BRANCH=?, PASSWORD=? WHERE ID=?";
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, s.getId());
			ps.setString(2,s.getName());
			ps.setString(3, s.getEmail());
			ps.setLong(4, s.getPhone());
			ps.setString(5,s.getBranch());
			ps.setString(6, s.getPassword());
		    ps.setInt(7, s.getId()); 
			res=ps.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		if(res>0) {
			return true;
		}
		else {
			return false;
		}
	
	}
	
	

	@Override
	public boolean deleteStudent(Student s) {
	PreparedStatement ps=null;
	int res=0;
	String query="DELETE FROM STUDENT WHERE ID=? AND ID!=1";
	
	try {
		ps=con.prepareStatement(query);
		ps.setInt(1, s.getId());
		res=ps.executeUpdate();
		
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	if(res>0) {
		return true;
	}
	else {
		return false;
	}
	}
	
	

	@Override
	public Student getStudent(String mail, String password) {
		PreparedStatement ps=null;
		Student s=null;
		ResultSet rs=null;
		String query="SELECT *FROM STUDENT WHERE EMAIL=? AND PASSWORD=?";
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, mail);
			ps.setString(2, password);
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setPhone(rs.getLong("phone"));
				s.setBranch(rs.getString("branch"));
				s.setPassword(rs.getString("password"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	
	
		return s;
	}

	@Override
	public Student getStudent(long phone, String mail) {
	
		PreparedStatement ps=null;
		ResultSet rs=null;
		Student s=null;
		String query="SELECT *FROM STUDENT WHERE PHONE=? AND EMAIL=?";
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1, phone);
			ps.setString(2, mail);
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setPhone(rs.getLong("phone"));
				s.setBranch(rs.getString("branch"));
				s.setPassword(rs.getString("password"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	

	@Override
	public ArrayList<Student> getStudent() {
		PreparedStatement ps=null;
		ResultSet rs=null;
		Student s=null;
		String query="SELECT *FROM STUDENT";
		ArrayList<Student> list=new ArrayList<>();
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setPhone(rs.getLong("phone"));
				s.setBranch(rs.getString("branch"));
				s.setPassword(rs.getString("password"));
				list.add(s);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return list;
	}
	
	

	@Override
	public ArrayList<Student> getStudent(String name) {
		PreparedStatement ps=null;
		Student s=null;
		ResultSet rs=null;
		String query="SELECT *FROM STUDENT WHERE NAME=?";
		ArrayList<Student> list=new ArrayList<>();
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, name);
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setPhone(rs.getLong("phone"));
				s.setBranch(rs.getString("branch"));
				s.setPassword(rs.getString("password"));
				list.add(s);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
