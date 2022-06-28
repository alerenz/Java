package tempate;

public class Patients extends GeneralData{
    public int id;
    public String dataSignUp;
    public String petAndName;
    public String age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataSignUp() {
        return dataSignUp;
    }

    public void setDataSignUp(String dataSignUp) {
        this.dataSignUp = dataSignUp;
    }

    public String getPetAndName() {
        return petAndName;
    }

    public void setPetAndName(String petAndName) {
        this.petAndName = petAndName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override

    public String toString(){
        return "id - " + id +"\n" +
                "Ф.И.О  - " + FIO + "\n" +
                "Дата регистрации - " + dataSignUp + "\n" +
                "Питомец и его Имя (через тире) - " + petAndName + "\n" +
                "Возраст питомца - " + age;
    }
}
