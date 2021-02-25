package entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Orders implements Serializable {
    //O_ORDERKEY O_CUSTKEY O_ORDERSTATUS O_TOTALPRICE O_ORDERDATE O_ORDERPRIORITY O_CLERK O_SHIPPRIORITY O_COMMENT
    private int o_orderkey;
    private int o_custkey;
    private String o_orderstatus;
    private double o_totalprice;
    private int o_orderdate;
    private String o_oderpriority;
    private String o_clerk;
    private int o_shippriority;
    private String o_comment;
}
