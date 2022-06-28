package tempate;

public class Receiving extends Patients{
    public String status;
    public String dataReceiving;
    public String timeReceiving;
    public String doctor;

    public String getStatus(){
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataReceiving() {
        return dataReceiving;
    }

    public void setDataReceiving(String dataReceiving) {
        this.dataReceiving = dataReceiving;
    }

    public String getTimeReceiving() {
        return timeReceiving;
    }

    public void setTimeReceiving(String timeReceiving) {
        this.timeReceiving = timeReceiving;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString(){
        return "Ф.И.О  - " + FIO + "\n" +
                "Дата приема - " + dataReceiving + "\n" +
                "Время приема - " + timeReceiving + "\n" +
                "Статус - " + status + "\n" +
                "Доктор -"  + doctor;
    }
}
