package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyName implements Serializable {
    //id	name	country_code	imdb_id	name_pcode_nf	name_pcode_sf	md5sum
    private int id;
    private String name;
    private String country_code;
    private int imdb_id;
    private String name_pcode_nf;
    private String name_pcode_sf;
    private String md5sum;

}
