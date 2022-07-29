import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main ( String[] args ) throws Exception {


        ExecutorService pool = Executors.newFixedThreadPool( Runtime.getRuntime().availableProcessors() );
        String result = pool.invokeAny( new MyCallable( 2, 3 ).call() );
        pool.shutdown();
        System.out.println( "Done the fastest" + result );


    }
}