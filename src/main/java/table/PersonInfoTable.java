package table;

import entity.Name;
import entity.PersonInfo;
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

public class PersonInfoTable {
    //id	person_id	info_type_id	info	note
    public static Dataset<PersonInfo> GenerateTable(SparkSession session) {
        //字符串编码的模式
        String schema = "id\tperson_id\tinfo_type_id\tinfo\tnote";
        Encoder<PersonInfo> encoder = Encoders.bean(PersonInfo.class);

        //根据模式的字符串生成模式
        List<StructField> structFieldList = new ArrayList<>();
        for (String fieldName : schema.split("\t")) {
            DataType dataType = fieldName.contains("id") ? DataTypes.IntegerType : DataTypes.StringType;
            boolean nullable = !fieldName.contains("id");
            StructField structField = DataTypes.createStructField(fieldName, dataType, nullable);
            structFieldList.add(structField);
        }

        StructType structType = DataTypes.createStructType(structFieldList);
        Dataset<PersonInfo> ds = session.
                read().
                schema(structType).
                option("header", "true").
                csv("E:\\IMDB\\test_files\\test_files_open_source\\imdb_data_csv\\person_info.csv").
                as(encoder);
        ds.createOrReplaceTempView("person_info");
        return ds;
    }
}
