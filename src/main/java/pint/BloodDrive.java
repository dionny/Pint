package pint;

public class BloodDrive {

    private final long id;
    private String title;
    private String description;
    private long startTime;
    private long endTime;
    private String address;
    private int numberOfDonors;


    public BloodDrive(long id, String title, String description, long startTime, long endTime, String address, int numberOfDonors) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.address = address;
        this.numberOfDonors = numberOfDonors;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return "{title:" + this.title + "}";
    }
}