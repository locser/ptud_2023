package entity;

public class TauEnum {
    public enum LoaiTau {
        CHO_NGUOI,
        CHO_HANG,
        KHAC;

        public static String convertLoaiTauToString(int loai) {
            switch (loai) {
                case 0:
                    return "Chở người";
                case 1:
                    return "Chở hàng";
                default:
                    return "Khác";
            }
        }
    }

    public enum TinhTrangTau {
        TAM_NGUNG,
        DANG_SU_DUNG,
        KHAC;

        public static String convertTinhTrangTauToString(int tinhTrang) {
            switch (tinhTrang) {
                case 0:
                    return "Tạm ngưng";
                case 1:
                    return "Đang sử dụng";
                default:
                    return "Khác";
            }
        }
    }


    public enum LoaiToa {
        KHAC,
        TOA_CHO_NGUOI,
        TOA_KI_GUI;

        public static String convertLoaiToaToString(int tinhTrang) {
            switch (tinhTrang) {
                case 0:
                    return "Khác";
                case 1:
                    return "Toa chở người";
                    case 2:
                    return "Toa kí gửi";
                default:
                    return "Khác";
            }
        }
    }




}
