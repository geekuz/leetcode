package designPatterns.observer;

public class Main {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        NewsChannel channel1 = new NewsChannel();
        NewsChannel channel2 = new NewsChannel();

        agency.attach(channel1);
        agency.attach(channel2);

        agency.setNews("New observer pattern released!");
    }
}
