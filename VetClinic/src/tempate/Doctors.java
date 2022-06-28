package tempate;

public class Doctors extends GeneralData{
    public int experience;

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override

    public String toString(){
        return "Ф.И.О  - " + FIO + "\n" +
                "Стаж - " + experience;
    }
}
