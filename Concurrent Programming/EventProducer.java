package Producer_Consumer;

import java.util.Observable;

class EventProducer extends Observable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            Event event = new Event("Event #" + i);
            setChanged();
            notifyObservers(event);
            try {
                Thread.sleep(1000); // Simulate some processing time between events
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
