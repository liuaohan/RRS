package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieCompanies implements Serializable {
    //id	movie_id	company_id	company_type_id	note
    private int id;
    private int movie_id;
    private int company_id;
    private int company_type_id;
    private String note;
}
