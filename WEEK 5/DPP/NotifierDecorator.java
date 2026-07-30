public abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    protected NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
       
        wrappedNotifier.send(message);
    }
}