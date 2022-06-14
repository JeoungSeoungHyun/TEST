package site.metacoding.air.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Air {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String msrdt;
    private String msrrgn_nm;
    private String msrste_nm;
    private String pm10;
    private String pm25;
    private String o3;
    private String no2;
    private String co;
    private String so2;
    private String idex_nm;
    private String idex_mvl;
    private String arplt_main;

    @Builder
    public Air(Integer id, String msrdt, String msrrgn_nm, String pm10, String pm25, String o3, String no2, String co,
            String so2, String idex_nm, String idex_mvl, String arplt_main) {
        this.id = id;
        this.msrdt = msrdt;
        this.msrrgn_nm = msrrgn_nm;
        this.pm10 = pm10;
        this.pm25 = pm25;
        this.o3 = o3;
        this.no2 = no2;
        this.co = co;
        this.so2 = so2;
        this.idex_nm = idex_nm;
        this.idex_mvl = idex_mvl;
        this.arplt_main = arplt_main;
    }
}
