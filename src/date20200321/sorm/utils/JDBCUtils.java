package date20200321.sorm.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/21
 * time        : 18:45
 * description :
 */
public class JDBCUtils {

    /**
     * 给sql设参
     * @param ps
     * @param params
     */
    public static void handleParams(PreparedStatement ps, Object[] params) {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                try {
                    ps.setObject(i + 1, params[i]);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
