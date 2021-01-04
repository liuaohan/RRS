package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonInfo implements Serializable {
    //id	person_id	info_type_id	info	note
    private int id;
    private int person_id;
    private int info_type_id;
    private String info;
    private String note;
}
