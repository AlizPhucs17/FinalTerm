package CuoiKi.Icons.model;

public class BangDiem {
	private int ma;
	private String MaSV;
	private float Java,TinDC,CSDL;
	
	public BangDiem() {
		super();
	}

	public BangDiem(int ma, String maSV, float java, float tinDC, float cSDL) {
		super();
		this.ma = ma;
		MaSV = maSV;
		Java = java;
		TinDC = tinDC;
		CSDL = cSDL;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public String getMaSV() {
		return MaSV;
	}

	public void setMaSV(String maSV) {
		MaSV = maSV;
	}

	public float getJava() {
		return Java;
	}

	public void setJava(float java) {
		Java = java;
	}

	public float getTinDC() {
		return TinDC;
	}

	public void setTinDC(float tinDC) {
		TinDC = tinDC;
	}

	public float getCSDL() {
		return CSDL;
	}

	public void setCSDL(float cSDL) {
		CSDL = cSDL;
	}
	
}
