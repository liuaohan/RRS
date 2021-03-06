import entity.*;
import org.apache.hadoop.hdfs.protocol.datatransfer.IOStreamPair;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import table.*;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static SparkSession session = null;

    public static void main(String[] args) throws IOException {
        //System.setProperty("hadoop.home.dir", "E:\\Hadoop\\hadoop-3.2.1");
        session = SparkSession
                .builder()
                .appName("liuaohan")
                .master("local[*]")
                .getOrCreate();


        Dataset<Customer> customerTable = CustomerTable.GenerateTable(session);
        Dataset<Orders> ordersTable = OrdersTable.GenerateTable(session);
        Dataset<Lineitem> lineitemTable = LineitemTable.GenerateTable(session);
        Dataset<Supplier> supplierTable = SupplierTable.GenerateTable(session);
        Dataset<Nation> nationTable = NationTable.GenerateTable(session);
        Dataset<Region> regionTable = RegionTable.GenerateTable(session);

//        Dataset<AkaName> akaNameTable = AkaNameTable.GenerateTable(session);
//        Dataset<AkaTitle> akaTitleTable = AkaTitleTable.GenerateTable(session);
//        Dataset<CastInfo> castInfoTable = CastInfoTable.GenerateTable(session);
//        Dataset<CharName> charNameTable = CharNameTable.GenerateTable(session);
//        Dataset<CompCastType> compCastTypeTable = CompCastTypeTable.GenerateTable(session);
//        Dataset<CompanyName> companyNameTable = CompanyNameTable.GenerateTable(session);
//        Dataset<CompanyType> companyTypeTable = CompanyTypeTable.GenerateTable(session);
//        Dataset<CompleteCast> completeCastTable = CompleteCastTable.GenerateTable(session);
//        Dataset<InfoType> infoTypeTable = InfoTypeTable.GenerateTable(session);
//        Dataset<Keyword> keywordTable = KeywordTable.GenerateTable(session);
//        Dataset<KindType> kindTypeTable = KindTypeTable.GenerateTable(session);


//        Dataset<LinkType> linkTypeTable = LinkTypeTable.GenerateTable(session);
//        Dataset<MovieCompanies> movieCompaniesTable = MovieCompaniesTable.GenerateTable(session);
//        Dataset<MovieInfoIdx> movieInfoIdxTable = MovieInfoIdxTable.GenerateTable(session);
//        Dataset<MovieInfo> movieInfoTable = MovieInfoTable.GenerateTable(session);
//        Dataset<MovieKeyword> movieKeywordTable = MovieKeywordTable.GenerateTable(session);
//        Dataset<MovieLink> movieLinkTable = MovieLinkTable.GenerateTable(session);
//        Dataset<Name> nameTable = NameTable.GenerateTable(session);
//        Dataset<PersonInfo> personInfoTable = PersonInfoTable.GenerateTable(session);
//        Dataset<RoleType> roleTypeTable = RoleTypeTable.GenerateTable(session);
//        Dataset<Title> titleTable = TitleTable.GenerateTable(session);
        /*System.out.println(akaNameTable.count());
        System.out.println(akaTitleTable.count());
        System.out.println(castInfoTable.count());
        System.out.println(charNameTable.count());
        System.out.println(compCastTypeTable.count());
        System.out.println(companyNameTable.count());
        System.out.println(companyTypeTable.count());
        System.out.println(completeCastTable.count());
        System.out.println(infoTypeTable.count());
        System.out.println(keywordTable.count());
        System.out.println(kindTypeTable.count());
        System.out.println(linkTypeTable.count());
        System.out.println(movieCompaniesTable.count());
        System.out.println(movieInfoIdxTable.count());
        System.out.println(movieInfoTable.count());
        System.out.println(movieKeywordTable.count());
        System.out.println(movieLinkTable.count());
        System.out.println(nameTable.count());
        System.out.println(personInfoTable.count());
        System.out.println(roleTypeTable.count());
        System.out.println(titleTable.count());*/

        String sql = "";
/*
        //File f = new File("/home/ubuntu/logs/costtime.txt");
        File f = new File("E:\\tpch\\costtime.txt");
        long pre = System.currentTimeMillis();
        Dataset<Row> dss = session.sql(sql);
        dss.show();
        dss.explain();

        long now = System.currentTimeMillis();
        FileWriter fw = new FileWriter(f,true);
        PrintWriter pw = new PrintWriter(fw);
        String costNow = "";
        costNow = String.valueOf(now - pre) + "\t" + String.valueOf(now);
        pw.println(costNow);
        pw.flush();
*/
        try {
            FileInputStream fis = new FileInputStream("D:\\Projects\\RRS\\src\\main\\resources\\tpch.sql");
            Scanner sc = new Scanner(fis);
            for (int i = 0; i < 1; i++) {
                sql = sc.nextLine();
                sql = sql.replace(";", "");
                long pre = System.currentTimeMillis();
                Dataset<Row> dss = session.sql(sql);
                dss.show();
                dss.explain();
                long now = System.currentTimeMillis();

                File f = new File("E:\\time.txt");
                FileWriter fw = new FileWriter(f, true); // true,进行追加写。
                PrintWriter pw = new PrintWriter(fw);
                pw.println(now - pre);
                pw.flush();
                System.out.println(now - pre);
                //Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        while (true) {

        }
    }
}
