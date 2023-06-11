
//public class Task_01 {
//    public static void main(String[] args) {
//        String s = "{name:Ivanov, country:Russia, city:Moscow, age:null}";
//        StringBuilder builder = new StringBuilder(s);
//        s = builder.toString();
//        builder.replace(0,1, "");
//        builder.replace(50,51, "");
//        builder.replace(0, 4, "имя");
//        builder.replace(3, 4, " = ");
//        builder.replace(13, 21, "страна");
//        builder.replace(27, 32, "город");
//        builder.replace(40, 44, "возраст");
//        builder.replace(19, 20, " = ");
//        builder.replace(34, 35, " = ");
//        builder.replace(51, 52, " = ");
//        builder.replace(12, 13, "\n");
//        builder.replace(28, 29, "\n");
//        builder.replace(43, 44, "\n");
//        System.out.println(builder);
//    }
//
//}
public class Task_01 {
    public static void main(String[] args) {
        StringBuilder sqlQuery = new StringBuilder("select * from students where");
        String filterParams = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        sqlQuery.append(getWhereClause(filterParams));
        System.out.println(sqlQuery);
    }
    public static String getWhereClause(String jsonObject) {
        jsonObject = jsonObject.replace("\"", "");
        jsonObject = jsonObject.replace("{", "");
        jsonObject = jsonObject.replace("}", "");
        String[] filterArray = jsonObject.split(", ");
        StringBuilder whereClause = new StringBuilder();
        for (String param:
                filterArray) {
            String[] paramArray = param.split(":");
            if (paramArray[1].equals("null")){
                continue;
            }
            String addedParam = String.format(" and %s = '%s'", paramArray[0], paramArray[1]);
            whereClause.append(addedParam);
        }
        whereClause.delete(0, 4);
        return whereClause.toString();
    }
}