package DTO;

/**
 *
 * @author MeoMeo
 */
public class HeDaoTao {
    String MaHDT;
    String TenHDT;
    
public HeDaoTao(){
  
}

public HeDaoTao(String MaHDT, String TenHDT) {
        super();
        this.MaHDT = MaHDT;
        this.TenHDT = TenHDT;
}

 public String getMaHDT() {
    return MaHDT;
 }

public String getTenHDT() {
        return TenHDT;
    }

    public void setMaHDT(String MaHDT) {
        this.MaHDT = MaHDT;
    }

    public void setTenHDT(String TenHDT) {
        this.TenHDT = TenHDT;
    }

}
