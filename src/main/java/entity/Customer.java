package entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer implements Serializable {
    //C_CUSTKEY C_NAME C_ADDRESS C_NATIONKEY C_PHONE C_ACCTBAL C_MKTSEGMENT C_COMMENT
    private int c_custkey;
    private String c_name;
    private String c_address;
    private int c_nationkey;
    private String c_phone;
    private double c_acctbal;
    private String c_mktsegment;
    private String c_comment;
}
