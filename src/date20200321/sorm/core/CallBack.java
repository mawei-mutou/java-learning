package date20200321.sorm.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/3/25
 * time        : 15:39
 * description :
 */
public interface CallBack {
    public Object doExecute(Connection conn, PreparedStatement ps, ResultSet resultSet);
}
