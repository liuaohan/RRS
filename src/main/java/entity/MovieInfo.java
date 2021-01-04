package entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieInfo implements Serializable {
    //id	movie_id	info_type_id	info	note
    private int id;
    private int movie_id;
    private int info_type_id;
    private String info;
    private String note;
}
