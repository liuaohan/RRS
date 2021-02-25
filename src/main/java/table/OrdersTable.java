package table;

import entity.AkaName;
import entity.Orders;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.util.ArrayList;
import java.util.List;

public class OrdersTable {
    public static Dataset<Orders> GenerateTable(SparkSession session) {
        //字符串编码的模式
        String schema = "o_orderkey o_custkey o_orderstatus o_totalprice o_orderdate o_oderpriority o_clerk o_shippriority o_comment";
        Encoder<Orders> encoder = Encoders.bean(Orders.class);

        //根据模式的字符串生成模式
        List<StructField> structFieldList = new ArrayList<>();
        for (String fieldName : schema.split(" ")) {
            DataType dataType = fieldName.contains("id") ? DataTypes.IntegerType : DataTypes.StringType;
            boolean nullable = !fieldName.contains("id");
            StructField structField = DataTypes.createStructField(fieldName, dataType, nullable);
            structFieldList.add(structField);
        }

        StructType structType = DataTypes.createStructType(structFieldList);


//        Dataset<Orders> ds = session.
//                read().
//                schema(structType).
//                option("header", "false").
//                csv("hdfs://master:9000/data/10/orders.csv").   //E:\source\1\orders.csv
//                as(encoder);

        Dataset<Orders> ds = session.
                read().
                schema(structType).
                option("header", "false").
                csv("D:\\SparkResource\\tpch_dataset\\orders.csv").   //E:\source\1\orders.csv
                as(encoder);

        ds.createOrReplaceTempView("orders");
        return ds;
    }
}
