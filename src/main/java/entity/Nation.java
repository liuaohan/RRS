package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Nation implements Serializable {
    private int n_nationkey;
    private String n_name;
    private int n_regionkey;
    private String n_comment;
}
