package entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompleteCast implements Serializable {
    //id	movie_id	subject_id	status_id

    private int id;
    private int movie_id;
    private int subject_id;
    private int status_id;

}
