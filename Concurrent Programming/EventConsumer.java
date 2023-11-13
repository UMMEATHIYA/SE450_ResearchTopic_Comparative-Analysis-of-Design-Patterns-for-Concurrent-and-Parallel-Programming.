package Producer_Consumer;

import java.util.Observable;
import java.util.Observer;

class EventConsumer implements Observer {
    private final String consumerName;

    public EventConsumer(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerName() {
        return consumerName;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Event) {
            Event event = (Event) arg;
            System.out.println(consumerName + " received: " + event.getEventData());
        }
    }
}