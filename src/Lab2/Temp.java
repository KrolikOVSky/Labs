package Lab2;

public class Temp {
    public static void run(String[] args) {
        Family family1 = new Family(5, 2, true, 14000f);
        Family family2 = new Family(5, 4, false, 20000f);
        Family family3 = new Family(5, 4, false, 20000f);
        Family family4 = new Family(4, 3, true, 25000f);
        Family family5 = new Family(4, 3, true, 25000f);

        Live live1 = new Live(PlaceOfLive.Home, 8, true, 10000);
        Live live2 = new Live(PlaceOfLive.Home, 10, false, 15000);
        Live live3 = new Live(PlaceOfLive.Flat, 10, false, 15000);
        Live live4 = new Live(PlaceOfLive.Home, 7, true, 15000);
        Live live5 = new Live(PlaceOfLive.Flat, 6, true, 15000);

        System.out.println(live1.accord(family1));
        System.out.println(live2.accord(family2));
        System.out.println(live3.accord(family3));
        System.out.println(live4.accord(family4));
        System.out.println(live5.accord(family5));

        System.out.println(family1.accord(live1));
        System.out.println(family2.accord(live2));
        System.out.println(family3.accord(live3));
        System.out.println(family4.accord(live4));
        System.out.println(family5.accord(live5));
    }
}
