package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieLink implements Serializable {
    //id	movie_id	linked_movie_id	link_type_id
    private int id;
    private int movie_id;
    private int linked_movie_id;
    private int link_type_id;
}
