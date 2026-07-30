interface Image {
    void display();
}


public class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage; // null until first needed — this IS the cache

    public ProxyImage(String fileName) {
        this.fileName = fileName;
       
    }

    public void display() {
        if (realImage == null) {
            // First call: pay the real cost once, then cache the result.
            realImage = new RealImage(fileName);
        } else {
            // Subsequent calls: reuse the cached, already-loaded image.
            System.out.println("Using cached image for \"" + fileName + "\" (no reload).");
        }
        realImage.display();
    }

   
    private static class RealImage implements Image {
        private final String fileName;

        RealImage(String fileName) {
            this.fileName = fileName;
            System.out.println("Loading image: " + fileName);
        }

        @Override
        public void display() {
            System.out.println("Displaying image: " + fileName);
        }
    }
}