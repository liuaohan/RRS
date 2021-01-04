package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieKeyword implements Serializable {
    //id	movie_id	keyword_id
    private int id;
    private int movie_id;
    private int keyword_id;
}
