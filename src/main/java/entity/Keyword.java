package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Keyword implements Serializable {
    //id	keyword	phonetic_code
    private int id;
    private String keyword;
    private String phonetic_code;

}
