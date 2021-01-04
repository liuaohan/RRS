package table;

import entity.MovieKeyword;
import entity.MovieLink;
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

public class MovieLinkTable {
    //id	movie_id	linked_movie_id	link_type_id
    public static Dataset<MovieLink> GenerateTable(SparkSession session) {
        //字符串编码的模式
        String schema = "id\tmovie_id\tlinked_movie_id\tlink_type_id";
        Encoder<MovieLink> encoder = Encoders.bean(MovieLink.class);

        //根据模式的字符串生成模式
        List<StructField> structFieldList = new ArrayList<>();
        for (String fieldName : schema.split("\t")) {
            DataType dataType = fieldName.contains("id") ? DataTypes.IntegerType : DataTypes.StringType;
            boolean nullable = !fieldName.contains("id");
            StructField structField = DataTypes.createStructField(fieldName, dataType, nullable);
            structFieldList.add(structField);
        }

        StructType structType = DataTypes.createStructType(structFieldList);
        Dataset<MovieLink> ds = session.
                read().
                schema(structType).
                option("header", "true").
                csv("E:\\IMDB\\test_files\\test_files_open_source\\imdb_data_csv\\movie_link.csv").
                as(encoder);
        ds.createOrReplaceTempView("movie_link");
        return ds;
    }
}
