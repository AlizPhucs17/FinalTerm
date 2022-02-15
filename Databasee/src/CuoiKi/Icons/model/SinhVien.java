package CuoiKi.Icons.model;

public class SinhVien {
	private String MaSV,HoTen,Email,SoDT,DiaChi;
	private int GioiTinh;
	private byte[] Hinh;
	public SinhVien() {
		super();
	}
	public SinhVien(String maSV, String hoTen, String email, String soDT, String diaChi, int gioiTinh, byte[] hinh) {
		super();
		this.MaSV = maSV;
		this.HoTen = hoTen;
		this.Email = email;
		this.SoDT = soDT;
		this.DiaChi = diaChi;
		this.GioiTinh = gioiTinh;
		this.Hinh = hinh;
	}
	public String getMaSV() {
		return MaSV;
	}
	public void setMaSV(String maSV) {
		MaSV = maSV;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSoDT() {
		return SoDT;
	}
	public void setSoDT(String soDT) {
		SoDT = soDT;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public int getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public byte[] getHinh() {
		return Hinh;
	}
	public void setHinh(byte[] hinh) {
		Hinh = hinh;
	}
	

}
