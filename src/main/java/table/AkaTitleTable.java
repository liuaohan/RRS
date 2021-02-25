package table;

import entity.AkaName;
import entity.AkaTitle;
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

public class AkaTitleTable {

    public static Dataset<AkaTitle> GenerateTable(SparkSession session) {
        //字符串编码的模式
        String schema = "id\tmovie_id\ttitle\timdb_index\tkind_id\tproduction_year\tphonetic_code\tepisode_of_id\tseason_nr\tepisode_nr\tnote\tmd5sum";
        Encoder<AkaTitle> encoder = Encoders.bean(AkaTitle.class);

        //根据模式的字符串生成模式
        List<StructField> structFieldList = new ArrayList<>();
        for (String fieldName : schema.split("\t")) {
            DataType dataType = fieldName.contains("id") ? DataTypes.IntegerType : DataTypes.StringType;
            boolean nullable = !fieldName.contains("id");
            StructField structField = DataTypes.createStructField(fieldName, dataType, nullable);
            structFieldList.add(structField);
        }

        StructType structType = DataTypes.createStructType(structFieldList);
        Dataset<AkaTitle> ds = session.
                read().
                schema(structType).
                option("header", "true").
                csv("D:\\SparkResource\\dataset\\aka_title.csv").
                as(encoder);
        ds.createOrReplaceTempView("aka_title");
        return ds;
    }
}
