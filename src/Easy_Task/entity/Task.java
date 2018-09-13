package Easy_Task.entity;

public class Task {
    private long id;
    private String title;
    private String description;
    private int date;
    private int hour;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDate() {
        return date;
    }

    public int getHour() {
        return hour;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }



}
