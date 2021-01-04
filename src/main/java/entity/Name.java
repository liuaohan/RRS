package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Name implements Serializable {
    //id	name	imdb_index	imdb_id	gender	name_pcode_cf	name_pcode_nf	surname_pcode	md5sum
    private int id;
    private String name;
    private String imdb_index;
    private int imdb_id;
    private String gender;
    private String name_pcode_cf;
    private String name_pcode_nf;
    private String surname_pcode;
    private String md5sum;
}
