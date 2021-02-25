package table;

import entity.LinkType;
import entity.MovieCompanies;
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

public class MovieCompaniesTable {

    public static Dataset<MovieCompanies> GenerateTable(SparkSession session) {
        //字符串编码的模式
        String schema = "id\tmovie_id\tcompany_id\tcompany_type_id\tnote";
        Encoder<MovieCompanies> encoder = Encoders.bean(MovieCompanies.class);

        //根据模式的字符串生成模式
        List<StructField> structFieldList = new ArrayList<>();
        for (String fieldName : schema.split("\t")) {
            DataType dataType = fieldName.contains("id") ? DataTypes.IntegerType : DataTypes.StringType;
            boolean nullable = !fieldName.contains("id");
            StructField structField = DataTypes.createStructField(fieldName, dataType, nullable);
            structFieldList.add(structField);
        }

        StructType structType = DataTypes.createStructType(structFieldList);
        Dataset<MovieCompanies> ds = session.
                read().
                schema(structType).
                option("header", "true").
                csv("D:\\SparkResource\\dataset\\movie_companies.csv").
                as(encoder);
        ds.createOrReplaceTempView("movie_companies");
        return ds;
    }
}
