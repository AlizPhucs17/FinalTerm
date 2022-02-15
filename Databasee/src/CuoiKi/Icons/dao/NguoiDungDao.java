package CuoiKi.Icons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import CuoiKi.Icons.helper.databaseHelper;
import CuoiKi.Icons.model.NguoiDung;

public class NguoiDungDao {
	public NguoiDung checkLogin(String tenDangNhap, String matKhau) throws Exception{
		String sql ="select tenDangNhap, matKhau, vaitro from nguoidung"
					+ " where tendangnhap=? and matKhau = ?";
		try (
			Connection connect= databaseHelper.connect();
				PreparedStatement pstmt= connect.prepareStatement(sql);
				){
			pstmt.setString(1, tenDangNhap);
			pstmt.setString(2, matKhau);
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					NguoiDung nd= new NguoiDung();
					nd.setTenDangNhap(tenDangNhap);
					nd.setVaiTro(rs.getString("vaitro"));
					return nd;
				}
				
			}
			
		}
		return null;
	}
}
