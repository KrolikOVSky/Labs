package Lab2;

public class Live implements Comparable<Live> {
    private int countOfRooms;
    private boolean haveBalcony;
    private double rent;
    private PlaceOfLive place;
    private final String LIVE_STRING_FORMAT = "Type of place: %s\t\tCount of rooms: %s\t\tBalcony: %s\t\tRent: %.2f";

    public Live() {
        this.place = PlaceOfLive.Flat;
        this.countOfRooms = 3;
        this.haveBalcony = true;
        this.rent = 25000.0;
    }

    public Live(PlaceOfLive place, int countOfRooms, boolean haveBalcony, double rent) {
        this.place = place;
        this.countOfRooms = countOfRooms;
        this.haveBalcony = haveBalcony;
        this.rent = rent;
    }

    public Live(Live live){
        place = live.place;
        countOfRooms = live.countOfRooms;
        haveBalcony = live.haveBalcony;
        rent = live.rent;
    }

    //Getters
    public PlaceOfLive getPlace() {
        return this.place;
    }
    public int getCountOfRooms() {
        return this.countOfRooms;
    }
    public boolean getHaveBalcony() {
        return this.haveBalcony;
    }
    public double getRent() {
        return this.rent;
    }

    ///Setters
    public void setPlace(PlaceOfLive place) {
        this.place = place;
    }
    public void setCountOfRooms(int countOfRooms) {
        this.countOfRooms = countOfRooms;
    }
    public void setHaveBalcony(boolean haveBalcony) {
        this.haveBalcony = haveBalcony;
    }
    public void setRent(double rent) {
        this.rent = rent;
    }

    @Override
    public int hashCode() {
        return 5 * place.hashCode() +
                7 * (Integer.valueOf(countOfRooms)).hashCode() +
                9 * (Boolean.valueOf(haveBalcony)).hashCode() +
                11 * (Double.valueOf(rent)).hashCode();
    }

    @Override
    public boolean equals(Object ob) {
        if (ob == this) return true;
        if (ob == null) return false;
        if (getClass() != ob.getClass()) return false;
        Live live = (Live) ob;
        return (place.equals(live.place)) && (countOfRooms == live.countOfRooms) && (haveBalcony == live.haveBalcony) && (rent == live.rent);
    }

    @Override
    public String toString() {
        return String.format(LIVE_STRING_FORMAT, place, countOfRooms, haveBalcony, rent);
    }

    @Override
    public int compareTo(Live live) {
        if (place.compareTo(live.place) < 0) return -1;
        if (place.compareTo(live.place) == 0 && countOfRooms < live.countOfRooms) return -1;
        if (place.compareTo(live.place) == 0 && countOfRooms == live.countOfRooms && !haveBalcony && live.haveBalcony) return -1;
        if (place.compareTo(live.place) == 0 && countOfRooms == live.countOfRooms && haveBalcony == live.haveBalcony && rent < live.rent) return -1;
        if (place.compareTo(live.place) == 0 && countOfRooms == live.countOfRooms && haveBalcony == live.haveBalcony && rent == live.rent) return 0;
        else return 1;
    }

    public boolean accord(Family family) {
        if (((family.getAdults() + family.getChildren()) > 8 && getPlace() == PlaceOfLive.Home) || ((family.getAdults() + family.getChildren()) < 8 && (getPlace() == PlaceOfLive.Home || getPlace() == PlaceOfLive.Flat)) &&
                getHaveBalcony() == family.getHaveAnimals() &&
                family.getMoneyOfPay() >= getRent() &&
                ((family.getAdults() + ((int)Math.ceil(family.getChildren() / 2.0))) < getCountOfRooms()))
            return true;
        else return false;
    }
}
