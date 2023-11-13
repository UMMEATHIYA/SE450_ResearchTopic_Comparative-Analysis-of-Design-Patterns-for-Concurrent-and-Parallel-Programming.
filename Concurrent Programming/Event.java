package Producer_Consumer;

class Event {
    private final String eventData;

    public Event(String eventData) {
        this.eventData = eventData;
    }

    public String getEventData() {
        return eventData;
    }
}