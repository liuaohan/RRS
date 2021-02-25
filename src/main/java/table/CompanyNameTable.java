package table;

import entity.CharName;
import entity.CompanyName;
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

public class CompanyNameTable {
    public static Dataset<CompanyName> GenerateTable(SparkSession session) {
        //字符串编码的模式
        String schema = "id\tname\tcountry_code\timdb_id\tname_pcode_nf\tname_pcode_sf\tmd5sum";
        Encoder<CompanyName> encoder = Encoders.bean(CompanyName.class);

        //根据模式的字符串生成模式
        List<StructField> structFieldList = new ArrayList<>();
        for (String fieldName : schema.split("\t")) {
            DataType dataType = fieldName.contains("id") ? DataTypes.IntegerType : DataTypes.StringType;
            boolean nullable = !fieldName.contains("id");
            StructField structField = DataTypes.createStructField(fieldName, dataType, nullable);
            structFieldList.add(structField);
        }

        StructType structType = DataTypes.createStructType(structFieldList);
        Dataset<CompanyName> ds = session.
                read().
                schema(structType).
                option("header", "true").
                csv("D:\\SparkResource\\dataset\\company_name.csv").
                as(encoder);
        ds.createOrReplaceTempView("company_name");
        return ds;
    }
}
