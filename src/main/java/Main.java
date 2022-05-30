import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;

public class Main {

    private static String timeToString(long secs) {
        long hour = secs / 3600;
        long min = secs / 60 % 60;
        long sec = secs / 1 % 60;
        return String.format("%02d:%02d:%02d", hour, min, sec);
    }


    public static Duration percentile(List<Duration> latencies, double percentile) {
        Collections.sort(latencies);
        int index = (int) Math.ceil(percentile / 100.0 * latencies.size());
        return latencies.get(index - 1);
    }


    public static void main(String[] args) throws IOException {
        
        TicketList ticketList = TicketParse.parse();
        ArrayList<Duration> array = new ArrayList();

        for (Ticket tickets : ticketList.getTickets()) {
            array.add(tickets.getDuration());
        }

        OptionalDouble value = array.stream()
                .mapToDouble(Duration::getSeconds)
                .average();
        //System.out.println(value);
        System.out.println("Среднее время полета между городами Владивосток и Тель-Авив : " + timeToString((long) value.getAsDouble()));

        System.out.println("90-й процентиль времени полета между городами  Владивосток и Тель-Авив : "+ timeToString(percentile(array, 90).getSeconds()));
    }
}




