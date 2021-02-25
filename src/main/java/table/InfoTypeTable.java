package table;

import entity.CompleteCast;
import entity.InfoType;
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

public class InfoTypeTable {
    public static Dataset<InfoType> GenerateTable(SparkSession session) {
        //字符串编码的模式
        String schema = "id\tinfo";
        Encoder<InfoType> encoder = Encoders.bean(InfoType.class);

        //根据模式的字符串生成模式
        List<StructField> structFieldList = new ArrayList<>();
        for (String fieldName : schema.split("\t")) {
            DataType dataType = fieldName.contains("id") ? DataTypes.IntegerType : DataTypes.StringType;
            boolean nullable = !fieldName.contains("id");
            StructField structField = DataTypes.createStructField(fieldName, dataType, nullable);
            structFieldList.add(structField);
        }

        StructType structType = DataTypes.createStructType(structFieldList);
        Dataset<InfoType> ds = session.
                read().
                schema(structType).
                option("header", "true").
                csv("D:\\SparkResource\\dataset\\info_type.csv").
                as(encoder);
        ds.createOrReplaceTempView("info_type");
        return ds;
    }
}
