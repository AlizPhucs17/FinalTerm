package CuoiKi.Icons.dao;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.swing.*;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;

import CuoiKi.Icons.helper.databaseHelper;
import CuoiKi.Icons.model.NguoiDung;
import CuoiKi.Icons.model.SinhVien;

public class SinhVienDao {
	public boolean insert(SinhVien sv ) throws Exception{
		
		String sql ="INSERT INTO [dbo].[SinhVien]([MaSV],[HoTen],[Email],[SoDT],[GioiTinh],[DiaChi],[Hinh])"+
		" values(?,?,?,?,?,?,?)";
		try (
			Connection connect= databaseHelper.connect();
				PreparedStatement pstmt= connect.prepareStatement(sql);
				){
			pstmt.setString(1, sv.getMaSV());
			pstmt.setString(2, sv.getHoTen());
			pstmt.setString(3, sv.getEmail());
			pstmt.setString(4, sv.getSoDT());
			pstmt.setInt(5, sv.getGioiTinh());
			pstmt.setString(6, sv.getDiaChi());
			
			if(sv.getHinh()!=null) {
				Blob hinh= new SerialBlob(sv.getHinh());
		
				pstmt.setBlob(7, hinh);
			}
			else {
				Blob hinh=null;
				pstmt.setBlob(7,hinh);
			}
			return pstmt.executeUpdate()>0;
			
		}
	}
public boolean update(SinhVien sv ) throws Exception{
	
		
		String sql ="UPDATE dbo.SinhVien"
				+ "	SET HoTen = ?,Email = ?,SoDT = ?,GioiTinh = ?,DiaChi = ?,Hinh = ?"+
				" where MaSV=?";
		try (
			Connection connect= databaseHelper.connect();
				PreparedStatement pstmt= connect.prepareStatement(sql);
				){
			pstmt.setString(7, sv.getMaSV());
			pstmt.setString(1, sv.getHoTen());
			pstmt.setString(2, sv.getEmail());
			pstmt.setString(3, sv.getSoDT());
			pstmt.setInt(4, sv.getGioiTinh());
			pstmt.setString(5, sv.getDiaChi());
			
			if(sv.getHinh()!=null) {
				Blob hinh= new SerialBlob(sv.getHinh());
				pstmt.setBlob(6, hinh);
			}
			else {
				Blob hinh=null;
				pstmt.setBlob(6,hinh);
			}
			return pstmt.executeUpdate()>0;
			
		}
	}
public boolean delete(String maSinhVien ) throws Exception{
	
	
	String sql ="delete from sinhvien"+
	" where MaSV = ?";
	try (
		Connection connect= databaseHelper.connect();
			PreparedStatement pstmt= connect.prepareStatement(sql);
			){
		pstmt.setString(1, maSinhVien);
		
		
		return pstmt.executeUpdate()>0;
		
	}
}
public SinhVien findById(String maSinhVien ) throws Exception{
	
	
	String sql ="select * from sinhvien where MaSV = ?";
	try (
		Connection connect= databaseHelper.connect();
			PreparedStatement pstmt= connect.prepareStatement(sql);
			){
		pstmt.setString(1, maSinhVien);
		try(ResultSet rs = pstmt.executeQuery();){
			if(rs.next()) {
				SinhVien sv = new SinhVien();
				sv.setMaSV(rs.getString("maSV"));
				sv.setHoTen(rs.getString("HoTen"));
				sv.setEmail(rs.getString("Email"));
				sv.setSoDT(rs.getString("soDT"));
				sv.setDiaChi(rs.getString("diachi"));
				sv.setGioiTinh(rs.getInt("gioitinh"));
				Blob blob= rs.getBlob("hinh");
				if(blob!=null)
				sv.setHinh(blob.getBytes(1,(int) blob.length()));
				return sv;
			}
		}
		
		return null;
		
	}
}
public ArrayList <SinhVien> findAll() throws Exception{
	
	
	String sql ="select * from sinhvien";
	try (
		Connection connect= databaseHelper.connect();
			PreparedStatement pstmt= connect.prepareStatement(sql);
			){
		try( ResultSet rs = pstmt.executeQuery();){
			ArrayList<SinhVien> list = new ArrayList<>();
			while(rs.next()) {
				SinhVien sv = new SinhVien();
				sv.setMaSV(rs.getString("maSV"));
				sv.setHoTen(rs.getString("HoTen"));
				sv.setEmail(rs.getString("Email"));
				sv.setSoDT(rs.getString("soDT"));
				sv.setDiaChi(rs.getString("diachi"));
				sv.setGioiTinh(rs.getInt("gioitinh"));
				Blob blob= rs.getBlob("hinh");
				if(blob !=null)
				sv.setHinh(blob.getBytes(1,(int) blob.length()));
				list.add(sv);
			}
			return list;
		}
		
		
		
	}
}
}
