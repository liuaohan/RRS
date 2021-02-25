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
public class Supplier implements Serializable {
    private int s_suppkey;
    private String s_name;
    private String s_address;
    private int s_nationkey;
    private String s_phone;
    private double s_acctbal;
    private String s_comment;
}
