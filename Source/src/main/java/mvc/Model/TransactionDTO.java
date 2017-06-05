package mvc.Model;

import mvc.Connection.ConnSQL;
import mvc.POJO.User;

import java.sql.Connection;

public class TransactionDTO {

    private Connection connection = new ConnSQL().getC();

    public boolean checkUser(User user){
        
        return true;
    }
}
