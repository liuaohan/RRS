package entity;

import com.google.flatbuffers.Struct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.arrow.vector.complex.writer.VarCharWriter;

import java.io.Serializable;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class Region implements Serializable {
    private int r_regionkey;
    private String r_name;
    private String r_comment;
    private double ps_supplycost;
    private String ps_comment;

}
