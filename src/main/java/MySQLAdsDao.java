import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 12/15/16.
 */
public class MySQLAdsDao implements Ads {
    public List<Ad> ads;

    private Connection connection;

    public MySQLAdsDao() {
        try {
            DriverManager.registerDriver(new Driver());
            Config config = new Config();
            Connection connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException("Error!", e);
        }
    }

    public Long insert(Ad ad) throws SQLException {
        try {
            Statement statement = connection.createStatement();
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (";
            insertQuery += ad.getUserId() + ", ";
            insertQuery += "'" + ad.getTitle() + "', ";
            insertQuery += "'" + ad.getDescription() + "') ";
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
            List<Ad> ads = new ArrayList<>();

        } catch (SQLException e) {
            throw new RuntimeException("Error!", e);
        }
    }

    public List<Ad> all() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from ads");
            List<Ad> ads = new ArrayList<>();

            while (resultSet.next()) {
                ads.add(new Ad(resultSet.getLong("id"), resultSet.getLong("user_id"), resultSet.getString("title"), resultSet.getString("description")));
            }
            return ads;
        } catch (SQLException e) {
            throw new RuntimeException("Error!", e);
        }
    }
}
