package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Miscellaneous;
import com.revature.util.ConnectionFactory;

public class MiscellaneousDAO {
	
	public List<Miscellaneous> getMiscellaneous() {
		try(Connection conn = ConnectionFactory.getConnection()){ 
			ResultSet rs = null;
			String misc = "SELECT * FROM misc;";
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(misc);
			List<Miscellaneous> miscList = new ArrayList<>();
	
			while(rs.next()) {
				Miscellaneous m = new Miscellaneous(
					rs.getInt("employee_id"),
					rs.getInt("misc_id"),
					rs.getString("misc_cost"),
					rs.getString("misc_info"),
					rs.getInt("status")
					);			
				miscList.add(m);
			}
			return miscList;
		}
		catch(SQLException e){
			System.out.println("There was an error in selecting Miscellaneous");
		}
		return null; 
	}   
	public List<Miscellaneous> getSingleMiscellaneous() {
		try(Connection conn = ConnectionFactory.getConnection()){
			ResultSet rs = null;
			String misc = "SELECT * FROM misc WHERE status IS NULL LIMIT 1;";
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(misc);			
			List<Miscellaneous> miscList = new ArrayList<>();
			
			while(rs.next()) {
				Miscellaneous m = new Miscellaneous(
					rs.getInt("employee_id"),
					rs.getInt("misc_id"),
					rs.getString("misc_cost"),
					rs.getString("misc_info"),
					rs.getInt("status")				
					);			
				miscList.add(m);
			}
			return miscList;
		}
		catch(SQLException e){
			System.out.println("There was an error in selecting Miscellaneous");
		}
		return null;
	}   	
	public List<Miscellaneous> getEmployeeMiscellaneous(int e_id) { 
		try(Connection conn = ConnectionFactory.getConnection()){
			ResultSet rs = null;
			String misc = "SELECT * FROM misc WHERE employee_id = ?;";
			PreparedStatement ps = conn.prepareStatement(misc);
			ps.setInt(1, e_id);
			rs = ps.executeQuery();
			List<Miscellaneous> miscList = new ArrayList<>();
			
			while(rs.next()) {
				Miscellaneous m = new Miscellaneous(
					rs.getInt("employee_id"),
					rs.getInt("misc_id"),
					rs.getString("misc_cost"),
					rs.getString("misc_info"),
					rs.getInt("status")				
					);
				miscList.add(m);
			}
			return miscList;
		}
		catch(SQLException e){
			System.out.println("There was an error in selecting Miscellaneous");
		}
		return null; 
	}   	
	public int submitMiscellaneous(Miscellaneous newMiscellaneous) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String misc = "INSERT INTO misc (employee_id, misc_cost,  misc_info ) " 
						+ "VALUES (?,?,?); "; 
			PreparedStatement ps = conn.prepareStatement(misc);
			ps.setInt(1, newMiscellaneous.getE_id());
			ps.setString(2, newMiscellaneous.getMisc_cost());
			ps.setString(3, newMiscellaneous.getMisc_info());
			ps.executeUpdate();
			System.out.println("Miscellaneous Information Sucessfully Inputted");
			return 1;
		}
		catch(SQLException e) {
			System.out.println("There was an error while attempting to input Miscellaneous information");
			return 0;
		}
	}
	public int updateMiscStatus(Miscellaneous Misc) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String misc = "UPDATE misc SET status = ? WHERE misc_id = ?;";
			PreparedStatement ps = conn.prepareStatement(misc);
			ps.setInt(1, Misc.getStatus());
			ps.setInt(2, Misc.getMisc_id());
			ps.executeUpdate();
			System.out.println("The status of this request has been set to: " + Misc.getStatus());
			return 1;
		} catch (SQLException e) {
			System.out.println("Something went wrong during the update");
			return 0;
		}
	}
	public int updateMiscStatus(int decision, int misc_id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String misc = "UPDATE misc SET status = ? WHERE misc_id = ?;";
			PreparedStatement ps = conn.prepareStatement(misc);
			ps.setInt(1, decision);
			ps.setInt(2, misc_id);
			ps.executeUpdate();
			System.out.println("The status of this request has been set to: " + decision);
			return 1;
		} catch (SQLException e) {
			System.out.println("Something went wrong during the update");
			return 0;
		}
	}
}
