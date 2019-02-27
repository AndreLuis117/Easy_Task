package back_end.entity;


import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Task {
    private SimpleLongProperty taskId;
    private SimpleStringProperty taskName;
    private SimpleStringProperty taskDescription;
    private SimpleStringProperty taskHour;
    private SimpleStringProperty taskDate;
    private  SimpleStringProperty taskStatus;


    public String getTaskHour() {
        return taskHour.get();
    }

    public SimpleStringProperty taskHourProperty() {
        return taskHour;
    }

    public void setTaskHour(String taskHour) {

        this.taskHour.set(taskHour);
    }



    //Construtor sem parametro
    public Task (){
        this(0, "", "", "", "","");
    }

    //Constrtur com parametro
    public Task(long id, String name, String description, String hour, String date, String status){
        this.taskId = new SimpleLongProperty(id);
        this.taskName = new SimpleStringProperty(name);
        this.taskDescription = new SimpleStringProperty(description);
        this.taskDate = new SimpleStringProperty(date);
        this.taskHour = new SimpleStringProperty(hour);
        this.taskStatus = new SimpleStringProperty(status);

    }

    public String getTaskDescription() {

        return taskDescription.get();
    }


    public void setTaskDescription(String taskDescription) {

        this.taskDescription.set(taskDescription);
    }




    public long getTaskId() {
        return taskId.get();
    }

    public void setTaskId(long taskId) {
        this.taskId.set(taskId);
    }

    public String getTaskName() {

        return taskName.get();
    }

    public void setTaskName(String taskName) {

        this.taskName.set(taskName);
    }


    public String getTaskDate() {
        return taskDate.get();
    }

    public SimpleStringProperty taskDateProperty() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate.set(taskDate);
    }

    public String getTaskStatus() {
        return taskStatus.get();
    }

    public SimpleStringProperty taskStatusProperty() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus.set(taskStatus);
    }
}




