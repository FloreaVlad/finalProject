package mvc.Controller;

import mvc.Model.TransactionDTO;
import mvc.POJO.Book;
import mvc.POJO.helper.WrapperBookUser;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class TransactionController {

    @RequestMapping(value = "/buyBook", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    private @ResponseBody String searchBook(@RequestBody WrapperBookUser wrapper){
        TransactionDTO transaction = new TransactionDTO();
        //transaction.buyBook();

        return "";
    }

}
