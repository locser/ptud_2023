package entity;

public enum MauSacEnum {

	TRANG, DEN, XAM;
	
	@Override
	public String toString() {
		switch(this) {
			case TRANG: return "Trắng";
			case DEN: return "Đen";
			case XAM: return "Xám";
                        default: return null;
		}
	}
}
