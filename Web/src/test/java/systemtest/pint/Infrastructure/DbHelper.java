package systemtest.pint.Infrastructure;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by DionnyS on 11/28/2015.
 */
public class DbHelper {
    public void executeScript() throws FileNotFoundException {
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/pintdb?" +
                            "user=root&password=root");

            new ScriptRunner(conn, false, true).runScript(new InputStreamReader(getClass().getResourceAsStream("/pintdb.sql")));

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
