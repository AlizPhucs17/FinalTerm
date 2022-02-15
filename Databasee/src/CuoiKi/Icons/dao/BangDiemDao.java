package CuoiKi.Icons.dao;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import CuoiKi.Icons.helper.databaseHelper;
import CuoiKi.Icons.model.BangDiem;
import CuoiKi.Icons.model.SinhVien;

public class BangDiemDao {
	public boolean insert(BangDiem bd ) throws Exception{
		
		String sql ="INSERT INTO [dbo].[BangDiem] ([MaSV],[Java],[TinDC],[CSDL]) values(?,?,?,?)";
		try (
			Connection connect= databaseHelper.connect();
				PreparedStatement pstmt= connect.prepareStatement(sql);
				){
			pstmt.setString(1, bd.getMaSV());
			pstmt.setFloat(2, bd.getJava());
			pstmt.setFloat(3, bd.getTinDC());
			pstmt.setFloat(4, bd.getCSDL());
			
			
					
					
			return pstmt.executeUpdate()>0;
			
		}
	}
	public boolean update(BangDiem bd ) throws Exception{
		
		String sql ="UPDATE [dbo].[BangDiem] "+
					" SET [Java] = ?, [TinDC] = ?, [CSDL] = ?"+
					" WHERE [MaSV] = ?";
		try (
			Connection connect= databaseHelper.connect();
				PreparedStatement pstmt= connect.prepareStatement(sql);
				){
			pstmt.setString(4, bd.getMaSV());
			pstmt.setFloat(1, bd.getJava());
			pstmt.setFloat(2, bd.getTinDC());
			pstmt.setFloat(3, bd.getCSDL());
			
			
					
					
			return pstmt.executeUpdate()>0;
			
		}
	}
	public boolean deleteByMaSV(String maSinhVien  ) throws Exception{
	
	String sql ="delete from bangdiem "+
				" WHERE [MaSV] = ?";
	try (
		Connection connect= databaseHelper.connect();
			PreparedStatement pstmt= connect.prepareStatement(sql);
			){
		pstmt.setString(1, maSinhVien);
	
		return pstmt.executeUpdate()>0;
		
	}
}
	public BangDiem findByMaSV(String maSinhVien  ) throws Exception{
		
		String sql ="select * from bangdiem WHERE [MaSV] = ?";
		try (
			Connection connect= databaseHelper.connect();
				PreparedStatement pstmt= connect.prepareStatement(sql);
				){
			pstmt.setString(1, maSinhVien);
		
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					BangDiem bd= new BangDiem();
					bd.setMa(rs.getInt("Ma"));
					bd.setMaSV(rs.getString("MaSV"));
					bd.setJava(rs.getFloat("Java"));
					bd.setTinDC(rs.getFloat("TinDC"));
					bd.setCSDL(rs.getFloat("CSDL"));
					
					return bd;
				}
			}
			return null;
		}
	}
	public ArrayList<BangDiem> findAll() throws Exception{
		
		String sql ="select from bangdiem ";
		try (
			Connection connect= databaseHelper.connect();
				PreparedStatement pstmt= connect.prepareStatement(sql);
				){
		
			try(ResultSet rs = pstmt.executeQuery();){
				ArrayList<BangDiem> list = new ArrayList<>();
				while(rs.next()) {
					BangDiem bd= new BangDiem();
					bd.setMa(rs.getInt("Ma"));
					bd.setMaSV(rs.getString("MaSV"));
					bd.setJava(rs.getFloat("Java"));
					bd.setTinDC(rs.getFloat("TinDC"));
					bd.setCSDL(rs.getFloat("CSDL"));
					
					list.add(bd);
				}
				return list;
			}
			
		}
	}
	public ArrayList<BangDiem> findTop(int top) throws Exception{
		
		String sql ="select top "+top+" *, (Java + TinDC + CSDL)/3 as DTB "+
					" from BangDiem order by dtb desc ";
		try (
			Connection connect= databaseHelper.connect();
				PreparedStatement pstmt= connect.prepareStatement(sql);
				){
		
			try(ResultSet rs = pstmt.executeQuery();){
				ArrayList<BangDiem> list = new ArrayList<>();
				while(rs.next()) {
					BangDiem bd= new BangDiem();
					bd.setMa(rs.getInt("Ma"));
					bd.setMaSV(rs.getString("MaSV"));
					bd.setJava(rs.getFloat("Java"));
					bd.setTinDC(rs.getFloat("TinDC"));
					bd.setCSDL(rs.getFloat("CSDL"));
					
					list.add(bd);
				}
				return list;
			}
			
		}
	}
}
