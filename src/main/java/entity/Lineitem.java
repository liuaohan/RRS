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
public class Lineitem implements Serializable {
    private int l_orderkey;
    private int l_partkey;
    private int l_suppkey;
    private int l_linenumber;
    private double l_quantity;
    private double l_extendedprice;
    private double l_discount;
    private double l_tax;
    private String l_returnflag;
    private String l_linestatus;
    private String l_shipdate;
    private String l_commitdate;
    private String l_receiptdate;
    private String l_shipinstruct;
    private String l_shipmode;
    private String l_comment;



}
