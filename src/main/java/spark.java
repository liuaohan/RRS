public class spark {
    public static void main(String[] args) {
        Main.session.sql("SELECT \" +\n" +
                "                \"COUNT(*) \" +\n" +
                "                \"FROM \" +\n" +
                "                \"movie_companies mc,\" +\n" +
                "                \"title t,\" +\n" +
                "                \"movie_info_idx mi_idx \" +\n" +
                "                \"WHERE \" +\n" +
                "                \"t.id=mc.movie_id \" +\n" +
                "                \"AND t.id=mi_idx.movie_id \" +\n" +
                "                \"AND mi_idx.info_type_id=112 \" +\n" +
                "                \"AND mc.company_type_id=2\";");
    }
}
