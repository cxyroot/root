package kafka;

public class teste {
    public static void main(String[] args) {
        String sql = null;
        sql = "SELECT\n" +
                "\tr.id,\n" +
                "\tr.question_id,\n" +
                "\tr.customers_id,\n" +
                "\tr.question_Title,\n" +
                "\tr.answer,\n" +
                "\tr.create_User_Id,\n" +
                "\tr.create_User_Name,\n" +
                "\tr.create_Time,\n" +
                "\tr.update_User_Id,\n" +
                "\tr.update_User_Name,\n" +
                "\tr.update_Time,\n" +
                "\tr.del_Flag\n" +
                "FROM\n" +
                "\tt_Survey_Answer r\n" +
                "WHERE\n" +
                "\tr.question_Id = '"+"9"+"'\n" +
                "AND r.customers_Id = '"+"9"+"'\n";// SQL语句
        System.out.println(sql);
    }
}
