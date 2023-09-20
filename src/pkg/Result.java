package pkg;

public class Result {
    private String event;
    private String gender;
    private String country;
    private String name;
    private String result;
    private String record;
    private int place;

    public Result(String event, String gender, String country, String name, String result, String record, int place) {
        this.event = event;
        this.gender = gender;
        this.country = country;
        this.name = name;
        this.result = result;
        this.record = record;
        this.place = place;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}
