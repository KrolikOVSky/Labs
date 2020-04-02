package Lab2;

public class Main{

    private static void bubbleSort(Comparable[] array){
        boolean flag;
        for(int m = array.length - 1; m > 0; m--){
            flag = true;
            for (int i = 0; i < m; i++){
                if(array[i].compareTo(array[i + 1]) > 0){
                    Comparable temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    flag = false;
                }
                if(flag) break;
            }
        }
    }

    private static void printArray(Family[] array){
        for(Family family : array)
            System.out.printf("%s, Hash Code: %d\n",family, family.hashCode());
    }

    private static void printArray(Live[] array){
        for(Live live : array)
            System.out.printf("%s, Hash Code: %d\n",live, live.hashCode());
    }

    public static void main(String[] args) {
        Live live1 = new Live(PlaceOfLive.Home, 8, true, 10000);
        Live live2 = live1;
        Live live3 = new Live(live1);
        Live live4 = new Live(PlaceOfLive.Flat, 10, false, 15000);
        Live live5 = null;

        System.out.printf("live1: %s;\thashCode: %d\n", live1, live1.hashCode());
        System.out.printf("live2: %s;\thashCode: %d\n", live2, live2.hashCode());
        System.out.printf("live3: %s;\thashCode: %d\n", live3, live3.hashCode());
        System.out.printf("live4: %s;\thashCode: %d\n", live4, live4.hashCode());
        System.out.printf("live5: %s;\n", live5);

        Family[] familyArray = new Family[6];
        familyArray[0] = new Family(5, 2, true, 14000f);
        familyArray[1] = new Family(5, 2, true, 20000f);
        familyArray[2] = new Family(5, 2, false, 14000f);
        familyArray[3] = new Family(5, 4, true, 14000f);
        familyArray[4] = new Family(3, 2, true, 14000f);
        familyArray[5] = new Family(5, 2, true, 14000f);

        System.out.println("\nBefore sorting family");
        printArray(familyArray);
        bubbleSort(familyArray);
        System.out.println("\nAfter sorting family");
        printArray(familyArray);

        Live[] liveArray = new Live[6];

        liveArray[0] = new Live(PlaceOfLive.Home, 10, false, 15000);
        liveArray[1] = new Live(PlaceOfLive.Home, 10, false, 25000);
        liveArray[2] = new Live(PlaceOfLive.Home, 10, true, 15000);
        liveArray[3] = new Live(PlaceOfLive.Home, 8, false, 15000);
        liveArray[4] = new Live(PlaceOfLive.Flat, 10, false, 15000);
        liveArray[5] = new Live(PlaceOfLive.Home, 10, false, 15000);

        System.out.println("\nBefore sorting live");
        printArray(liveArray);
        bubbleSort(liveArray);
        System.out.println("\nAfter sorting live");
        printArray(liveArray);

        Live live = new Live(PlaceOfLive.Home, 7, true, 15000);

        Family family1 = new Family(5, 3, true, 14000f);
        Family family2 = new Family(5, 4, false, 20000f);
        Family family3 = new Family(5, 4, false, 20000f);
        Family family4 = new Family(4, 3, true, 25000f);
        Family family5 = new Family(4, 3, true, 25000f);

        System.out.printf("\nlive: %s\n\n", live);

        System.out.printf("family1: %s;\n", family1);
        System.out.printf("family2: %s;\n", family2);
        System.out.printf("family3: %s;\n", family3);
        System.out.printf("family4: %s;\n", family4);
        System.out.printf("family5: %s;\n", family5);

        System.out.println();

        System.out.printf("family1.accord(live): %s\n", family1.accord(live));
        System.out.printf("live.accord(family1): %s\n", live.accord(family1));
        System.out.printf("family2.accord(live): %s\n", family2.accord(live));
        System.out.printf("live.accord(family2): %s\n", live.accord(family2));
        System.out.printf("family3.accord(live): %s\n", family3.accord(live));
        System.out.printf("live.accord(family3): %s\n", live.accord(family3));
        System.out.printf("family4.accord(live): %s\n", family4.accord(live));
        System.out.printf("live.accord(family4): %s\n", live.accord(family4));
        System.out.printf("family5.accord(live): %s\n", family5.accord(live));
        System.out.printf("live.accord(family5): %s\n", live.accord(family5));

        live.setPlace(PlaceOfLive.Flat);
        live.setCountOfRooms(4);
        live.setHaveBalcony(false);
        live.setRent(17000);

        family5.setAdults(3);
        family5.setChildren(7);
        family5.setHaveAnimals(false);
        family5.setMoneyOfPay(19000f);

        if(family5.accord(live)){
            System.out.printf("Объект %s\n",family5);
            System.out.println("соответствует объекту");
            System.out.println(live);
        }
        else{
            System.out.printf("\nОбъект\n%s\n",family5);
            System.out.println("не соответствует объекту");
            System.out.println(live);
        }

    }
}
