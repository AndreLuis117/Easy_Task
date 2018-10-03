package Easy_Task.entity;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;

public class Task {
    private SimpleLongProperty taskId;
    private SimpleStringProperty taskName;
    private SimpleStringProperty taskDescription;


    public String getTaskHour() {
        return taskHour.get();
    }

    public SimpleStringProperty taskHourProperty() {
        return taskHour;
    }

    public void setTaskHour(String taskHour) {

        this.taskHour.set(taskHour);
    }

    private SimpleStringProperty taskHour;
    private SimpleStringProperty taskDate;


    //Construtor sem parametro
    public Task (){}

    //Constrtur com parametro
    public Task(long id, String name, String description){
        this.taskId = new SimpleLongProperty(id);
        this.taskName = new SimpleStringProperty(name);
        this.taskDescription = new SimpleStringProperty(description);

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

    public void setTaskDate(Date taskDate) {
        this.taskDate.set(String.valueOf(taskDate));
    }
}




