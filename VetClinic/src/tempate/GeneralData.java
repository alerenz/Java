package tempate;

import java.io.Serializable;

public class GeneralData implements Serializable {
    public String FIO;
    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    @Override

    public String toString(){
        return "Ф.И.О  - " + FIO;
    }

}
