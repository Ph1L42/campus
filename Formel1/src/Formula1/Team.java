package Formula1;


import java.util.LinkedList;
import java.util.List;

public class Team {
    private String fullTeamName;
    private String shortTeamName;
    private String base;
    private String teamChef;
    private Car activeCar;
    private Car car;
    private int firstTeamEntry;
    private int worldChampionships;
    private int highestRaceFinnish;
    private int polePositions;
    private int fastestLaps;

    private List<Driver> drivers = new LinkedList<>();
    private List<Driver> reserveDrivers = new LinkedList<>();

    public String getFullTeamName() {
        return fullTeamName;
    }

    public void setFullTeamName(String fullTeamName) {
        this.fullTeamName = fullTeamName;
    }

    public String getShortTeamName() {
        return shortTeamName;
    }

    public void setShortTeamName(String shortTeamName) {
        this.shortTeamName = shortTeamName;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTeamChef() {
        return teamChef;
    }

    public void setTeamChef(String teamChef) {
        this.teamChef = teamChef;
    }

    public Car getActiveCar() {
        return activeCar;
    }

    public void setActiveCar(Car activeCar) {
        this.activeCar = activeCar;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers.addAll(drivers);
    }

    public List<Driver> getReserveDrivers() {
        return reserveDrivers;
    }

    public void setReserveDrivers(List<Driver> reserveDrivers) {
        this.reserveDrivers.addAll(reserveDrivers);
    }

    public int getFirstTeamEntry() {
        return firstTeamEntry;
    }

    public void setFirstTeamEntry(int firstTeamEntry) {
        this.firstTeamEntry = firstTeamEntry;
    }

    public int getWorldChampionships() {
        return worldChampionships;
    }

    public void setWorldChampionships(int worldChampionships) {
        this.worldChampionships = worldChampionships;
    }

    public int getHighestRaceFinnish() {
        return highestRaceFinnish;
    }

    public void setHighestRaceFinnish(int highestRaceFinnish) {
        this.highestRaceFinnish = highestRaceFinnish;
    }

    public int getPolePositions() {
        return polePositions;
    }

    public void setPolePositions(int polePositions) {
        this.polePositions = polePositions;
    }

    public int getFastestLaps() {
        return fastestLaps;
    }

    public void setFastestLaps(int fastestLaps) {
        this.fastestLaps = fastestLaps;
    }


    public Team() {
    }

    public Team(String shortTeamName, String base, String teamChef, Car activeCar, Driver driver1, Driver driver2) {
        this.shortTeamName = shortTeamName;
        this.base = base;
        this.teamChef = teamChef;
        this.activeCar = activeCar;
        this.drivers.add(driver1);
        this.drivers.add(driver2);
    }

    public Team(String fullTeamName, String shortTeamName, String base, String teamChef, Car activeCar, Driver driver1, Driver driver2,
                List<Driver> reserveDrivers, int firstTeamEntry, int worldChampionships, int highestRaceFinnish, int polePositions, int fastestLaps) {
        this.fullTeamName = fullTeamName;
        this.shortTeamName = shortTeamName;
        this.base = base;
        this.teamChef = teamChef;
        this.activeCar = activeCar;
        this.drivers.add(driver1);
        this.drivers.add(driver2);
        this.reserveDrivers.addAll(reserveDrivers);
        this.firstTeamEntry = firstTeamEntry;
        this.worldChampionships = worldChampionships;
        this.highestRaceFinnish = highestRaceFinnish;
        this.polePositions = polePositions;
        this.fastestLaps = fastestLaps;
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void removeDriver(Driver driver) {
        drivers.remove(driver);
    }

    public void promoteReserveDriver(Driver driver) {
        reserveDrivers.remove(driver);
        drivers.add(driver);
    }

    public void demoteDriver(Driver driver) {
        drivers.remove(driver);
        reserveDrivers.add(driver);
    }


}
