package entity;

public enum TinhTrangNCCEnum {
	DANGNHAP, NGUNGNHAP;

    @Override
    public String toString() {
        switch (this) {
            case DANGNHAP:
                return "Đang nhập";
            case NGUNGNHAP:
                return "Ngừng nhập";
            default:
                return null;
        }
    }
        
        
}
