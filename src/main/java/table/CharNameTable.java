package table;

import entity.CharName;
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

public class CharNameTable {
    public static Dataset<CharName> GenerateTable(SparkSession session) {
        //字符串编码的模式
        String schema = "id\tname\timdb_index\timdb_id\tname_pcode_nf\tsurname_pcode\tmd5sum";
        Encoder<CharName> encoder = Encoders.bean(CharName.class);

        //根据模式的字符串生成模式
        List<StructField> structFieldList = new ArrayList<>();
        for (String fieldName : schema.split("\t")) {
            DataType dataType = fieldName.contains("id") ? DataTypes.IntegerType : DataTypes.StringType;
            boolean nullable = !fieldName.contains("id");
            StructField structField = DataTypes.createStructField(fieldName, dataType, nullable);
            structFieldList.add(structField);
        }

        StructType structType = DataTypes.createStructType(structFieldList);
        Dataset<CharName> ds = session.
                read().
                schema(structType).
                option("header", "true").
                csv("D:\\SparkResource\\dataset\\char_name.csv").
                as(encoder);
        ds.createOrReplaceTempView("char_name");
        return ds;
    }
}
