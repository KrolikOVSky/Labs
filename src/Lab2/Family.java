package Lab2;

public class Family implements Comparable<Family> {

    private final static String FAMILY_FORMAT_STRING = "Adults = %d\tChildren = %d\tHave dog or cat = %s\tHow much money = %.3f";

    private int adults;
    private int children;
    private boolean haveAnimals;
    private float moneyOfPay;

    public Family() {
        this.adults = 0;
        this.children = 0;
        this.haveAnimals = false;
        this.moneyOfPay = 0f;
    }

    public Family(int adults, int children, boolean haveAnimals, float moneyOfPay) {
        this.adults = adults;
        this.children = children;
        this.haveAnimals = haveAnimals;
        this.moneyOfPay = moneyOfPay;
    }

    public Family(Family family) {
        adults = family.adults;
        children = family.children;
        haveAnimals = family.haveAnimals;
        moneyOfPay = family.moneyOfPay;
    }

    public int getAdults() {
        return adults;
    }

    public int getChildren() {
        return children;
    }

    public boolean getHaveAnimals() {
        return haveAnimals;
    }

    public float getMoneyOfPay() {
        return moneyOfPay;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public void setHaveAnimals(boolean haveAnimals) {
        this.haveAnimals = haveAnimals;
    }

    public void setMoneyOfPay(float moneyOfPay) {
        this.moneyOfPay = moneyOfPay;
    }

    @Override
    public boolean equals(Object ob) {
        if (ob == this) return true;
        if (ob == null) return false;
        if (getClass() != ob.getClass()) return false;
        Family family = (Family) ob;
        return (adults == family.adults) && (children == family.children) && (haveAnimals == family.haveAnimals) && (moneyOfPay == family.moneyOfPay);
    }

    @Override
    public int hashCode() {
        return 7 * (Integer.valueOf(adults)).hashCode() + 11 * (Integer.valueOf(children)).hashCode() + 13 * (Boolean.valueOf(haveAnimals)).hashCode() + 17 * (Float.valueOf(moneyOfPay)).hashCode();
    }

    @Override
    public String toString() {
        return String.format(FAMILY_FORMAT_STRING, adults, children, haveAnimals, moneyOfPay);
    }

    @Override
    public int compareTo(Family family) {
        if (adults < family.adults) return -1;
        if ((adults == family.adults) && (children < 0)) return -1;
        if ((adults == family.adults) && (children == 0) && (moneyOfPay < 0)) return -1;
        if ((adults == family.adults) && (children == 0) && (moneyOfPay == 0) && !haveAnimals && family.haveAnimals)
            return -1;
        if ((adults == family.adults) && (children == 0) && (moneyOfPay == 0) && haveAnimals == family.haveAnimals)
            return 0;
        else return 1;
    }

    public float sumOfPay() {
        return moneyOfPay / (adults + children);
    }

    public boolean accord(Live live) {
        if (((getAdults() + getChildren()) > 8 && live.getPlace() == PlaceOfLive.Home) || ((getAdults() + getChildren()) < 8 && (live.getPlace() == PlaceOfLive.Home || live.getPlace() == PlaceOfLive.Flat)) &&
                live.getHaveBalcony() == getHaveAnimals() &&
                getMoneyOfPay() >= live.getRent() &&
                ((getAdults() + ((int) Math.ceil(getChildren() / 2.0))) < live.getCountOfRooms()))
            return true;
        else return false;
    }
}
