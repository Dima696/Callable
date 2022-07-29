import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<List<Callable<String>>> {

    private int messages;
    private int task;

    public MyCallable ( int messages, int task ) {
        this.messages = messages;
        this.task = task;
    }


    @Override
    public List<Callable<String>> call () throws Exception {
        List<Callable<String>> list = new ArrayList<>();
        for (int i = 0; i < task; i++) {
            list.add( () -> {
                String name = Thread.currentThread().getName();
                int j = 0;
                for (; j < messages; j++) {
                    System.out.printf( "I %s, Hello!\n", name );
                    Thread.sleep( 2000 );
                }
                return String.format( "%s, brought out %d messages", name, j );
            } );
        }
        return list;
    }

}


