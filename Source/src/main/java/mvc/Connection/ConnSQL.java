package mvc.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnSQL {

    Connection c = null;
    public ConnSQL(){
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FinalProject",
                    "postgres", "samitrag2");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection getC() {
        return c;
    }

    public void setC(Connection c) {
        this.c = c;
    }

}
