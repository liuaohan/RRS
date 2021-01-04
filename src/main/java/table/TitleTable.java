package table;

import entity.RoleType;
import entity.Title;
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

public class TitleTable {
    public static Dataset<Title> GenerateTable(SparkSession session) {
        //字符串编码的模式
        String schema = "id\ttitle\timdb_index\tkind_id\tproduction_year\timdb_id\tphonetic_code\tepisode_of_id\tseason_nr\tepisode_nr\tseries_years\tmd5sum";
        Encoder<Title> encoder = Encoders.bean(Title.class);

        //根据模式的字符串生成模式
        List<StructField> structFieldList = new ArrayList<>();
        for (String fieldName : schema.split("\t")) {
            DataType dataType = fieldName.contains("id") ? DataTypes.IntegerType : DataTypes.StringType;
            boolean nullable = !fieldName.contains("id");
            StructField structField = DataTypes.createStructField(fieldName, dataType, nullable);
            structFieldList.add(structField);
        }

        StructType structType = DataTypes.createStructType(structFieldList);
        Dataset<Title> ds = session.
                read().
                schema(structType).
                option("header", "true").
                csv("E:\\IMDB\\test_files\\test_files_open_source\\imdb_data_csv\\title.csv").
                as(encoder);
        ds.createOrReplaceTempView("title");
        return ds;
    }
}
