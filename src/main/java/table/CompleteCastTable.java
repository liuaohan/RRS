package table;

import entity.CompCastType;
import entity.CompleteCast;
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

public class CompleteCastTable {
    public static Dataset<CompleteCast> GenerateTable(SparkSession session) {
        //字符串编码的模式
        String schema = "id\tmovie_id\tsubject_id\tstatus_id";
        Encoder<CompleteCast> encoder = Encoders.bean(CompleteCast.class);

        //根据模式的字符串生成模式
        List<StructField> structFieldList = new ArrayList<>();
        for (String fieldName : schema.split("\t")) {
            DataType dataType = fieldName.contains("id") ? DataTypes.IntegerType : DataTypes.StringType;
            boolean nullable = !fieldName.contains("id");
            StructField structField = DataTypes.createStructField(fieldName, dataType, nullable);
            structFieldList.add(structField);
        }

        StructType structType = DataTypes.createStructType(structFieldList);
        Dataset<CompleteCast> ds = session.
                read().
                schema(structType).
                option("header", "true").
                csv("D:\\SparkResource\\dataset\\complete_cast.csv").
                as(encoder);
        ds.createOrReplaceTempView("complete_cast");
        return ds;
    }
}
