import com.google.gson.Gson;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TicketParse {

    public static TicketList parse() throws IOException {
        Gson gson = new Gson();

        String root = System.getProperty("user.dir");

        //System.out.println(root);
        try (FileReader reader = new FileReader(
                root +"\\src\\main\\resources\\tickets.json")) {
            TicketList ticketList = gson.fromJson(reader, TicketList.class);
            return ticketList;
        } catch (Exception e) {
            System.out.println("Error");
            return null;
        }

    }

}
