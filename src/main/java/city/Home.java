package city;

public class Home extends Building{

    public final static int SQUARE_METERS_NEED_PER_PERSON = 20;

    public Home(int area, int levels, Address address) {
        super(area, address);
        if (levels > 3) {
            throw new IllegalArgumentException();
        }
    }

    public Home(int area, Address address) {
        super(area, address);
    }

    @Override
    int calculateNumberOfPeopleCanFit() {
        return (getArea() * getLevels() / SQUARE_METERS_NEED_PER_PERSON);
    }
}
