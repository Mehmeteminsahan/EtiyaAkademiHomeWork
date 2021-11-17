package entities.concretes;

public class Color {
	private int colorId;
	private String colarName;
	public Color() {
		super();
	}
	public Color(int colorId, String colarName) {
		super();
		this.colorId = colorId;
		this.colarName = colarName;
	}
	public int getColorId() {
		return colorId;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	public String getColarName() {
		return colarName;
	}
	public void setColarName(String colarName) {
		this.colarName = colarName;
	}
	
}
