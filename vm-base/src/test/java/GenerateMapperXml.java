import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 通过配置文件gmx.properties中的信息生成mapper.xml文件;
 */
public class GenerateMapperXml {

    //默认配置文件
    private static final String DEFAULT_PRO = "gmx.properties";

    private static Properties pros = null;
    private static Connection connection = null;
    //放置mapperbeans的包，如com.zk.mapper；用于设置mapper.xml的命名空间
    private static String mapperBeanBasePackage = null;
    //数据库连接信息
    private static String driverClassName = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    //生成的xml存放路径
    private static String mapperXmlPathTemple = null;
    //存放类名
    private static String[] posClassName = null;
    //存放表名
    private static String[] tablesName = null;
    //命名空间指向的mapper类名格式
    private static String mapperNamespaceClassTemple = null;

    public static void main(String[] args) throws Exception {
        generateMapperXmlByPros();
    }


    //根据properties文件初始化变量
    static {

        ///E:/wzy/workspace/workspace_idea_01/demo/target/test-classes/
        String path = GenerateMapperXml.class.getClassLoader().getResource("./").getPath();
        String prosFile = path + DEFAULT_PRO;

        pros = new Properties();
        try {
            pros.load(new FileInputStream(prosFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (mapperBeanBasePackage == null) {
            mapperBeanBasePackage = (String) pros.get("gmx.mapperBeansBasePackage");
        }
        if (driverClassName == null) {
            driverClassName = (String) pros.get("gmx.driverClassName");
        }
        if (url == null) {
            url = (String) pros.get("gmx.url");
        }
        if (username == null) {
            username = (String) pros.get("gmx.username");
        }
        if (password == null) {
            password = (String) pros.get("gmx.password");
        }
        if (mapperXmlPathTemple == null) {
            mapperXmlPathTemple = (String) pros.get("gmx.mapperXmlPathTemple");
        }
        if (posClassName == null) {
            posClassName = pros.get("gmx.posClassName").toString().replace(" ", "").split(",");
        }
        if (tablesName == null) {
            tablesName = pros.get("gmx.tablesName").toString().replace(" ", "").split(",");
        }
        if (mapperNamespaceClassTemple == null) {
            mapperNamespaceClassTemple = (String) pros.get("gmx.mapperNamespaceClassTemple");
        }

    }


    /**
     * @Title:
     * @Description:根据配置文件批量生产mapper.Xml
     * @Author:ZhangKe
     * @Date:2017/11/16 15:43
     */
    public static void generateMapperXmlByPros() throws ClassNotFoundException {
        for (int i = 0; i < posClassName.length; i++) {
            String poClassName = posClassName[i];
            String tableName = tablesName[i];
            String path = mapperXmlPathTemple;

            System.out.println("cls: " + poClassName);
            System.out.println("tablename : " + tableName);
            System.out.println("--------------------" + tableName + " START --------------------");
            Class clz = Class.forName(poClassName);
            String mapperString = generateMapperFileString(clz, tableName);
            //替换*为表名
            path = path.replace("*", tableName);
            saveToFile(mapperString, path);
            System.out.println("--------------------" + tableName + " END --------------------");
        }


    }


    public static void saveToFile(String str, String path) {


        try {
            File f = new File(path);
            FileOutputStream fos = new FileOutputStream(f);
            if (!f.exists()) {
                f.createNewFile();
            }

            fos.write(str.getBytes());
            fos.flush();
            fos.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {

        if (connection == null) {
            try {
                Class.forName(driverClassName);
                connection = DriverManager
                        .getConnection(url, username, password);
            } catch (Exception e) {
                //throw new BusinessException(e);
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static String generateMapperFileString(Class cls, String tableName) {
        StringBuffer stringBuffer = new StringBuffer();
        String mapperTemple = mapperNamespaceClassTemple;

        mapperTemple = mapperTemple.replace("*", cls.getSimpleName());

        String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"\n" +
                "        \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n" +
                "\n" +
                "<mapper namespace=\"" + mapperBeanBasePackage + "." + mapperTemple
                + "\">\n";

        stringBuffer.append(header);

        String resultMapString = generateResultMap(cls, tableName);

        stringBuffer.append(resultMapString + "\n\n");

        stringBuffer.append(generateAllColumns(tableName) + "\n\n");
        stringBuffer.append(generateColumnsWithoutId(tableName) + "\n\n");
        stringBuffer.append(generateCount(tableName) + "\n\n");
        stringBuffer.append(generateInsertString(tableName) + "\n\n");
        stringBuffer.append(generateDeleteString(tableName) + "\n\n");
        stringBuffer.append(generateUpdateString(cls, tableName) + "\n\n");
        stringBuffer.append(generateListSql(cls, tableName) + "\n\n");
        stringBuffer.append(generateOrdeByListSql(cls, tableName) + "\n\n");

        stringBuffer.append(generateQueryCondition(cls, tableName) + "\n\n");

        stringBuffer.append(generateBatchInsert(cls, tableName) + "\n\n");
        stringBuffer.append(generateSelectByIdSql(cls, tableName) + "\n\n");
        stringBuffer.append(generateSelectInIds(cls, tableName) + "\n\n");
        stringBuffer.append(generateSelectIdList(cls, tableName) + "\n\n");
        stringBuffer.append(generateSelectBy(cls, tableName) + "\n\n");
        stringBuffer.append(generateSelectOneBy(cls, tableName) + "\n\n");
        String footer = "</mapper>";

        stringBuffer.append(footer);

        return stringBuffer.toString();

    }

    public static void printString(Class cls, String tableName) {
        System.out.println("printJavaField----------------------------------------------------");
        printJavaField(tableName);
        System.out.println("generateAllColumns----------------------------------------------------");
        generateAllColumns(tableName);
        System.out.println("generateResultMap----------------------------------------------------");
        generateResultMap(cls, tableName);
        System.out.println("generateInsertString----------------------------------------------------");
        generateInsertString(tableName);
        System.out.println("printUpdateString----------------------------------------------------");
        generateUpdateString(cls, tableName);
        generateDeleteString(tableName);

        generateQueryCondition(cls, tableName);
        generateCount(tableName);
        generateListSql(cls, tableName);
        generateOrdeByListSql(cls, tableName);

    }

    /**
     * List<T> selectBy(@Param("query") Object query);
     * <p>
     * T selectOneBy(@Param("query")Object query);
     *
     * @param cls
     * @param tableName
     * @return
     */
    public static String generateSelectBy(Class cls, String tableName) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n" +
                "\t<select id=\"selectBy\" resultMap=\"" + generateClsMap(cls) + "\">\n" +
                "\t\tSELECT * \n" +
                "\t\tFROM\n" +
                "\t\t" + tableName + "\n" +
                "\t\t<include refid=\"queryCondition\" />\n" +
                "\t</select>");
        return buffer.toString();
    }

    public static String generateSelectOneBy(Class cls, String tableName) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n" +
                "\t<select id=\"selectOneBy\" resultMap=\"" + generateClsMap(cls) + "\">\n" +
                "\t\tSELECT * \n" +
                "\t\tFROM\n" +
                "\t\t" + tableName + "\n" +
                "\t\t<include refid=\"queryCondition\" />\n" +
                "\t\tLIMIT 1 \n" +
                "\t</select>");
        return buffer.toString();
    }


    public static String generateSelectIdList(Class cls, String tableName) {

        return "    <select id=\"selectIdList\" resultType=\"java.lang.Long\">\n" +
                "        SELECT\n" +
                " 		 id \n" +
                "        FROM\n" +
                "        " + tableName + "\n" +
                "        <include refid=\"queryCondition\" />\n" +
                "\n" +
                "    </select>";
    }

    public static String generateClsMap(Class cls) {

        return cls.getSimpleName() + "Map";

    }


    public static String generateSelectInIds(Class cls, String tableName) {
        return "    <select id=\"selectInIds\" resultMap=\"" + generateClsMap(cls) + "\">\n" +
                "        SELECT\n" +
                "        <include refid=\"BASE_ALL_CLOUM\"/>\n" +
                "        FROM\n" +
                "        " + tableName + "\n" +
                "        WHERE id IN\n" +
                "        <foreach item=\"item\" index=\"index\" collection=\"list\" open=\"(\" separator=\",\" close=\")\">\n" +
                "            #{item}\n" +
                "        </foreach>\n" +
                "    </select>\n";

    }

    public static String generateBatchInsert(Class cls, String tableName) {
        StringBuffer buffer = new StringBuffer();

        String base = "<insert id=\"batchInsert\"  useGeneratedKeys=\"true\" parameterType=\"java.util.List\" keyProperty=\"id\">\n" +

                "        INSERT INTO " + tableName + "(\n" +
                "        <include refid=\"BASE_COLUM_WITHOUT_ID\"/>\n" + ")" +
                "        VALUES \n";

        buffer.append(base);

        buffer.append("   <foreach collection =\"list\" item =\"item\" index =\"index\" separator =\",\"> \n");

        buffer.append("(\n");

        ResultSetMetaData metaData = getTableMeta(tableName);
        try {
            int count = metaData.getColumnCount();
            for (int index = 1; index <= count; index++) {
                String column = metaData.getColumnName(index).toLowerCase();
                if ("id".equals(column)) {
                    continue;
                }
                String filedName = convertColumnToFiledName(column);

                buffer.append("#{item." + convertColumnToFiledName(column)
                        + "}" + (index < count ? "," : "") + "\n");
            }

            buffer.append(")\n");
            buffer.append("</foreach> \n");
            buffer.append("</insert>\n");


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return buffer.toString();

    }

    public static String generateOrdeByListSql(Class cls, String tableName) {
        String orderSql = "\t<if test=\"orderBy != null and orderType != null\">\n" +
                "\t\t\torder by ${orderBy} ${orderType}\n" +
                "\t\t</if>\n";
        StringBuffer buffer = new StringBuffer();
        buffer.append("\t<select id=\"selectListOrderBy\" resultMap=\"" + cls.getSimpleName() + "Map" + "\">\n" +
                "\t\tSELECT\n" +
                "\t\t\t<include refid=\"BASE_ALL_CLOUM\"/>\n" +
                "\t\tFROM\n" +
                "\t\t" + tableName + "\n" +
                "\t\t<include refid=\"queryCondition\" />\n" + orderSql +
                "\t\tlimit #{start},#{size}\n" +
                "\n" +
                "\t</select>");
        return buffer.toString();

    }

    public static String generateListSql(Class cls, String tableName) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("\t<select id=\"selectList\" resultMap=\"" + cls.getSimpleName() + "Map" + "\">\n" +
                "\t\tSELECT\n" +
                "\t\t\t<include refid=\"BASE_ALL_CLOUM\"/>\n" +
                "\t\tFROM\n" +
                "\t\t" + tableName + "\n" +
                "\t\t<include refid=\"queryCondition\" />\n" +
                "\t\tLIMIT #{start},#{size}\n" +
                "\n" +
                "\t</select>");
        return buffer.toString();
    }

    public static String generateCount(String tableName) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n" +
                "\t<select id=\"count\" resultType=\"int\">\n" +
                "\t\tSELECT \n" +
                "\t\t\tcount(1)\n" +
                "\t\tFROM\n" +
                "\t\t" + tableName + "\n" +
                "\t\t<include refid=\"queryCondition\" />\n" +
                "\t</select>");
        return buffer.toString();
    }

    public static String generateSelectByIdSql(Class cls, String tableName) {
        String sql = "    <select id=\"select\" resultMap=\"" + cls.getSimpleName() + "Map" + "\">\n" +
                "        SELECT * FROM " + tableName + " WHERE id = #{id}\n" +
                "    </select>\n";
        return sql;
    }

    public static String generateQueryCondition(Class cls, String tableName) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("<sql id=\"queryCondition\">\n");
        buffer.append("<trim prefix=\"where\" prefixOverrides=\"and\">\n");
        buffer.append("<if test=\"query != null\">\n");
        ResultSetMetaData metaData = getTableMeta(tableName);
        try {
            int count = metaData.getColumnCount();
            for (int index = 1; index <= count; index++) {
                String column = metaData.getColumnName(index).toLowerCase();
                if ("id".equals(column)) {
                    continue;
                }
                String filedName = convertColumnToFiledName(column);
                buffer.append("<if test=\"query." + filedName + " != null \">\n");
                buffer.append("\t\tand " + column + "=#{"
                        + "query." + convertColumnToFiledName(column) + "}"
                );
                buffer.append("\n</if>\n");
            }

            buffer.append("</if>\n");
            buffer.append("</trim>\n");
            buffer.append("</sql>\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }

    public static String generateDeleteString(String tableName) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<delete id=\"delete\">\n" +
                "\t\tDELETE\n" +
                "\t\tFROM\n" +
                "\t\t\t" + tableName + "\n" +
                "\t\tWHERE\n" +
                "\t\t\tid = #{id}\n" +
                "\t</delete>");
        return buffer.toString();

    }

    public static String generateUpdateString(Class cls, String tableName) {
        StringBuffer buffer = new StringBuffer();
        String updateSql = "<update id=\"update\" parameterType=\"" + cls.getCanonicalName() + "\" >\n";
        buffer.append(updateSql);
        buffer.append("UPDATE\n" + "\t\t" + tableName + "\n");
        buffer.append("<set>\n");
        ResultSetMetaData metaData = getTableMeta(tableName);
        try {
            int count = metaData.getColumnCount();
            for (int index = 1; index <= count; index++) {
                String column = metaData.getColumnName(index).toLowerCase();
                if ("id".equals(column)) {
                    continue;
                }
                buffer.append("<if test=\"" + convertColumnToFiledName(column) + " != null\">");
                buffer.append(column + "=#{"
                        + convertColumnToFiledName(column) + "}"
                        + (index < count ? "," : ""));
                buffer.append("</if>\n");
            }

            buffer.append("</set>\n");
            buffer.append("WHERE\n");
            buffer.append("id=#{id}\n");
            buffer.append("</update>\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static String generateInsertString(String tableName) {

        String base = "<insert id=\"insert\" useGeneratedKeys=\"true\" keyProperty=\"id\">\n" +
                "        INSERT INTO " + tableName + "(\n" +
                "        <include refid=\"BASE_COLUM_WITHOUT_ID\"/>\n" +
                "        )\n" +
                "        VALUES (\n";

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(base);
        ResultSetMetaData metaData = getTableMeta(tableName);
        try {
            int count = metaData.getColumnCount();
            for (int index = 1; index <= count; index++) {
                String column = metaData.getColumnName(index).toLowerCase();
                if (column.equals("id")) continue;
                stringBuffer.append("#{" + convertColumnToFiledName(column)
                        + "}" + (index < count ? "," : "") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String footer = "       )\n" +
                "\t\t\t\t </insert>";
        stringBuffer.append(footer);
        return stringBuffer.toString();
    }

    public static String generateResultMap(Class cls, String tableName) {
//		<resultMap type="com.jumei.show.dataaccess.domain.dbo.CashCouponIssueDO" id="cashCouponIssueResultMap">
        StringBuffer buffer = new StringBuffer();
        String resMap = "<resultMap type=\"" + cls.getCanonicalName() + "\"" +
                "  id=\"" + cls.getSimpleName() + "Map\"" + ">\n";
        buffer.append(resMap);
        ResultSetMetaData metaData = getTableMeta(tableName);
        try {
            int count = 0;
            try{
                count = metaData.getColumnCount();
            }catch (Exception e){
                System.err.println("表<"+tableName+">不存在");
            }
            for (int index = 1; index <= count; index++) {
                String column = metaData.getColumnName(index).toLowerCase();
                if ("id".equals(column)) {
                    buffer.append("  <id column=\"" + column
                            + "\" property=\"" + convertColumnToFiledName(column)
                            + "\"/>\n");
                } else {
                    buffer.append("  <result column=\"" + column
                            + "\" property=\"" + convertColumnToFiledName(column)
                            + "\"/>\n");
                }

            }
            buffer.append("</resultMap>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static String generateAllColumns(String tableName) {
        return "    <sql id=\"BASE_ALL_CLOUM\">\n" +
                "        id,\n" +
                "        <include refid=\"BASE_COLUM_WITHOUT_ID\"/>\n" +
                "    </sql>";

    }

    public static String generateColumnsWithoutId(String tableName) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("\t<sql id=\"BASE_COLUM_WITHOUT_ID\">\n");
        ResultSetMetaData metaData = getTableMeta(tableName);
        try {
            int count = metaData.getColumnCount();
            for (int index = 1; index <= count; index++) {
                String cname = metaData.getColumnName(index).toLowerCase();
                if (cname.equals("id")) continue;
                buffer.append("\t\t");
                buffer.append(cname + (index < count ? "," : ""));
                buffer.append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        buffer.append("\t</sql>\n");
        return buffer.toString();
    }

    public static void printJavaField(String tableName) {
        ResultSetMetaData metaData = getTableMeta(tableName);
        Map<String, String> colAndCommentMap = getColumnAndComment(tableName);
        try {
            String fieldType;
            int count = metaData.getColumnCount();
            for (int index = 1; index <= count; index++) {
                int type = metaData.getColumnType(index);
                if (type == Types.VARCHAR) {
                    fieldType = "String";
                } else if (type == Types.DECIMAL) {
                    fieldType = "BigDecimal";
                } else if (type == Types.INTEGER) {
                    fieldType = "Integer";
                } else if (type == Types.TINYINT) {
                    fieldType = "Integer";
                } else if (type == Types.DATE || type == Types.TIMESTAMP) {
                    fieldType = "Date";
                } else if (type == Types.DOUBLE) {
                    fieldType = "Double";
                } else if (type == Types.BIGINT) {
                    fieldType = "Long";
                } else {
                    fieldType = "String";
                }
                String columnName = metaData.getColumnName(index);
                String filedString = "private " + fieldType + " " + convertColumnToFiledName(columnName) + ";";

                String commentString = "//" + colAndCommentMap.get(columnName);
                System.out.println(filedString + commentString);
            }
        } catch (
                SQLException e
                )

        {
            e.printStackTrace();
        }

    }

    public static Map<String, String> getColumnAndComment(String tableName) {
        String query = "SELECT COLUMN_NAME,COLUMN_COMMENT FROM information_schema.COLUMNS where TABLE_NAME=?";
        Map<String, String> map = new HashMap<>();
        try {
            PreparedStatement ps = getConnection().prepareStatement(query);
            ps.setString(1, tableName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                map.put(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }


    public static ResultSetMetaData getTableMeta(String tableName) {

        ResultSetMetaData metaData = null;
        if (metaData == null) {
            ResultSet resultSet = null;
            try {
                Connection connection = getConnection();
                PreparedStatement st = connection
                        .prepareStatement("select * FROM " + tableName
                                + " where 1=1");
                resultSet = st.executeQuery();
                metaData = resultSet.getMetaData();
            } catch (Exception e) {
                //throw new BusinessException(e);

            }
        }
        return metaData;
    }


    private static String convertColumnToFiledName(String column) {
        column = column.toLowerCase();
        Pattern pattern = Pattern.compile("(_[a-z])");
        Matcher matcher = pattern.matcher(column);
        while (matcher.find()) {
            String str = matcher.group(0);
            column = column.replaceAll(str, str.replaceAll("_", "")
                    .toUpperCase());
        }
        return column;
    }

    public static String generateMarkDownTable(String tableName) {

        Map<String, String> colAndCommentMap = getColumnAndComment(tableName);
        ResultSetMetaData metaData = getTableMeta(tableName);
        StringBuffer buffer = new StringBuffer();
        buffer.append("|\t列名\t|\t字段类型\t|\t备注\t|\n");
        buffer.append("| --- | --- | --- |\n");
        try {
            int count = metaData.getColumnCount();
            for (int index = 1; index <= count; index++) {
                String columnName = metaData.getColumnName(index).toLowerCase();
                String typeName = metaData.getColumnTypeName(index);
                String commnet = colAndCommentMap.get(columnName);

                buffer.append("|\t" + columnName + "\t");

                buffer.append("|\t" + typeName + "\t");
                buffer.append("|\t" + commnet + "\t|\n");


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }
    //SELECT thumb from ims_site_article where thumb like "%http://www.weize%"
    //SELECT thumb from ims_wechat_news where thumb like "%http://www.weize%"
}
