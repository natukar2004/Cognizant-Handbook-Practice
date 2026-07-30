
public class ProxyPatternDemo {
    public static void main(String[] args) {
        
        Image image1 = new ProxyImage("vacation_photo.jpg");
        Image image2 = new ProxyImage("profile_picture.png");

        System.out.println("Proxy objects created. Notice: nothing has loaded yet.\n");

        System.out.println("--- First display of image1 (triggers remote load) ---");
        image1.display();

        System.out.println("\n--- Second display of image1 (should use cache, no reload) ---");
        image1.display();

        System.out.println("\n--- First display of image2 (triggers its own remote load) ---");
        image2.display();

        System.out.println("\n--- Third display of image1 (still cached) ---");
        image1.display();
    }
}