package table;
import entity.Customer;
import entity.Region;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
public class RegionTable {
    public static Dataset<Region> GenerateTable(SparkSession session) {
        //字符串编码的模式
        //String schema = "C_CUSTKEY C_NAME C_ADDRESS C_NATIONKEY C_PHONE C_ACCTBAL C_MKTSEGMENT C_COMMENT";
        String schema = "r_regionkey r_name r_comment ps_supplycost ps_comment";
        Encoder<Region> encoder = Encoders.bean(Region.class);

        //根据模式的字符串生成模式
        List<StructField> structFieldList = new ArrayList<>();
        for (String fieldName : schema.split(" ")) {
            DataType dataType = fieldName.contains("id") ? DataTypes.IntegerType : DataTypes.StringType;
            boolean nullable = !fieldName.contains("id");
            StructField structField = DataTypes.createStructField(fieldName, dataType, nullable);
            structFieldList.add(structField);
        }

        StructType structType = DataTypes.createStructType(structFieldList);


//        Dataset<Customer> ds = session.
//                read().
//                schema(structType).
//                option("header", "false").
//                csv("hdfs://master:9000/data/10/customer.csv").
//                as(encoder);


        Dataset<Region> ds = session.
                read().
                schema(structType).
                option("header", "false").
                csv("D:\\SparkResource\\tpch_dataset\\region.csv").  //E:\source\1\customer.csv
                as(encoder);

        ds.createOrReplaceTempView("region");
        return ds;
    }
}
