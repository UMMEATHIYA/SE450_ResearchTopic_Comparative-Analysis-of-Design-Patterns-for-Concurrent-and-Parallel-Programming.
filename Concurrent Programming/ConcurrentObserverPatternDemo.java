package Producer_Consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentObserverPatternDemo {
    public static void main(String[] args) {
        // Create an EventProducer
        EventProducer eventProducer = new EventProducer();

        // Create multiple EventConsumers
        List<EventConsumer> consumers = new ArrayList<>();
        consumers.add(new EventConsumer("Consumer 1"));
        consumers.add(new EventConsumer("Consumer 2"));
        consumers.add(new EventConsumer("Consumer 3"));

        // Register consumers as observers
        for (EventConsumer consumer : consumers) {
            eventProducer.addObserver(consumer);
        }

        // Create an ExecutorService to run the EventProducer concurrently
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Record the start time
        long startTime = System.currentTimeMillis();

        // Submit the EventProducer for execution
        executorService.submit(eventProducer);

        // Shutdown the executor after a short delay
        try {
            Thread.sleep(6000); // Allow time for the EventProducer to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        // Record the end time
        long endTime = System.currentTimeMillis();

        // Print the execution time for each consumer
        for (EventConsumer consumer : consumers) {
            System.out.println(consumer.getConsumerName() + " execution time: " +
                    (endTime - startTime) + " milliseconds");
        }
    }
}





