package city;

public class Office extends Building{

    private String company;
    private int numberOfTablesPerLevel;

    public Office(int area, int levels, Address address) {
        super(area, levels, address);
    }

    public Office(int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        this.company = company;
        /*if (2 > (area/numberOfTablesPerLevel) || area/numberOfTablesPerLevel < 5) {
            throw new IllegalArgumentException();
        } else {
            this.numberOfTablesPerLevel = numberOfTablesPerLevel;
        }*/
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
    }

    public Office(int area, Address address, String company, int numberOfTablesPerLevel) {
        super(area, address);
        this.company = company;
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
    }

    public Office(int area, Address address) {
        super(area, address);
    }

    @Override
    int calculateNumberOfPeopleCanFit() {
        return this.numberOfTablesPerLevel * (this.getLevels() - 1);
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }
}
