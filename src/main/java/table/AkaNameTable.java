package table;

import entity.AkaName;
import org.apache.spark.sql.*;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.util.ArrayList;
import java.util.List;

public class AkaNameTable {
    public static Dataset<AkaName> GenerateTable(SparkSession session) {
        //字符串编码的模式
        String schema = "id person_id name imdb_index name_pcode_cf name_pcode_nf surname_pcode md5sum";
        Encoder<AkaName> encoder = Encoders.bean(AkaName.class);

        //根据模式的字符串生成模式
        List<StructField> structFieldList = new ArrayList<>();
        for (String fieldName : schema.split(" ")) {
            DataType dataType = fieldName.contains("id") ? DataTypes.IntegerType : DataTypes.StringType;
            boolean nullable = !fieldName.contains("id");
            StructField structField = DataTypes.createStructField(fieldName, dataType, nullable);
            structFieldList.add(structField);
        }

        StructType structType = DataTypes.createStructType(structFieldList);
        Dataset<AkaName> ds = session.
                read().
                schema(structType).
                option("header", "true").
                csv("E:\\IMDB\\test_files\\test_files_open_source\\imdb_data_csv\\aka_name.csv").
                as(encoder);
        ds.createOrReplaceTempView("aka_name");
        return ds;
    }
}
