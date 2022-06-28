package renz;

import tempate.Doctors;
import tempate.Patients;
import tempate.Receiving;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class List {
    private static String LOGIN = "admIn2610";
    private static String PASSWORD = "admIn2610";
    private boolean bool = true;
    private transient Scanner sc = new Scanner(System.in);
    public ArrayList<Patients> patients = new ArrayList<>();
    public ArrayList<Doctors> doctors = new ArrayList<>();
    public ArrayList<Receiving> receivings  = new ArrayList<>();

    public void start() {
        String login;
        String pass;
        do{
            System.out.println("Введите логин: ");
            login = sc.nextLine();
            System.out.println("Введие пароль");
            pass = sc.nextLine();
        }while (!LOGIN.equals(login) && !PASSWORD.equals(pass));
        while (bool) {
            printList();
            int choiсe= Integer.parseInt(sc.nextLine());
            checkInput(choiсe);
        }
    }


    private  void exitProgramm(){
        System.out.println("Вы вышли из программы!");
        bool=false;
    }
    private  void printList(){
        System.out.println("Выберите действие:\n" +
                "1) Зарегистрировать врача\n" +
                "2) Зарегистрировать пациента\n" +
                "3) Создать прием\n" +
                "4) Изменить статус приема у пациента\n" +
                "5) Изменить данные пациента\n" +
                "6) Вывод списков(выбор)\n" +
                "7) Сохранить данные в файл\n" +
                "8) Удаление\n"+
                "9) Вывод приемов определенного пациента\n"+
                "10) Выход из системы"
        );
    }
    private void checkInput(int input){

        switch (input){
            case 1:
                signInDoctor();
                break;
            case 2:
                signInPatient();
                break;
            case 3:
                createReceiving();
                break;
            case 4:
                updateReceiving();
                break;
            case 5:
                updatePatient();
                break;
            case 6:
                printSpisok();
                break;
            case 7:
                saveToFile();
                break;
            case 8:
                deleteSmth();
                break;
            case 9:
                printPatientReceivings();
                break;
            case 10:
                exitProgramm();
                break;
        }
    }
    private void signInDoctor(){
        Doctors doc = new Doctors();
        System.out.println("Ф.И.О: ");
        doc.FIO = sc.nextLine();
        System.out.println("Стаж: ");
        doc.experience = Integer.parseInt(sc.nextLine());

        doctors.add(doc);
        System.out.println("Успешно добавлено!"+"\n");
        System.out.println();
    }

    private void signInPatient(){
        Patients patient = new Patients();
        System.out.println("id: ");
        patient.id = Integer.parseInt(sc.nextLine());
        System.out.println("Ф.И.О: ");
        patient.FIO = sc.nextLine();
        System.out.println("Дата регисртации(yy-mm-dd): ");
        patient.dataSignUp = sc.nextLine();
        System.out.println("Питомец и его имя(через тире):");
        patient.petAndName = sc.nextLine();
        System.out.println("Возраст питомца( например: 2 года):");
        patient.age = sc.nextLine();
        patients.add(patient);
        System.out.println("Успешно добавлено!"+"\n");
        System.out.println();
    }
    private void createReceiving(){
        Receiving record = new Receiving();
        System.out.println("Ф.И.О: ");
        record.FIO = sc.nextLine();
        System.out.println("Дата приема(yy-mm-dd): ");
        record.dataReceiving = sc.nextLine();
        System.out.println("Время приема: ");
        record.timeReceiving = sc.nextLine();
        System.out.println("Статус приема: ");
        record.status = sc.nextLine();

        System.out.println("Выберите доктора: ");
        int k = 1;
        for (Doctors m : doctors) {
            System.out.println(k + ")" +m );
            k++;
        }
        System.out.println("Ф.И.О доктора: ");
        record.doctor = sc.nextLine();

        receivings.add(record);
        System.out.println("Успешно добавлено!"+"\n");
        System.out.println();
    }
    private void updateReceiving(){
        int k = 1;
        for (Receiving m : receivings) {
            System.out.println(k + ")" +m );
            k++;
        }

        System.out.println("Выберите прием который изменить(если нужно изменить статус - введите те же данные кроме статуса");
        int ch = Integer.parseInt(sc.nextLine());
        ch--;
        System.out.println(receivings.get(ch));

        Receiving change = new Receiving();
        System.out.println("Ф.И.О: ");
        change.FIO = sc.nextLine();
        System.out.println("Дата приема(yy-mm-dd): ");
        change.dataReceiving = sc.nextLine();
        System.out.println("Время приема: ");
        change.timeReceiving = sc.nextLine();
        System.out.println("Статус приема: ");
        change.status = sc.nextLine();

        System.out.println("Выберите доктора: ");
        int k1 = 1;
        for (Doctors m : doctors) {
            System.out.println(k1 + ")" +m );
            k1++;
        }
        System.out.println("Ф.И.О доктора: ");
        change.doctor = sc.nextLine();


        receivings.set(ch,change);
        System.out.println("Успешно изменено!"+"\n");

    }
    private void updatePatient(){
        int k = 1;
        for (Patients m : patients) {
            System.out.println(k + ")" +m );
            k++;
        }

        System.out.println("Выберите пациента, данные которого надо изменить");
        int ch1 = Integer.parseInt(sc.nextLine());
        ch1--;
        System.out.println(receivings.get(ch1));

        Patients change = new Patients();
        System.out.println("id: ");
        change.id = Integer.parseInt(sc.nextLine());
        System.out.println("Ф.И.О: ");
        change.FIO = sc.nextLine();
        System.out.println("Дата регисртации(yy-mm-dd): ");
        change.dataSignUp = sc.nextLine();
        System.out.println("Питомец и его имя(через тире):");
        change.petAndName = sc.nextLine();
        System.out.println("Возраст питомца( например: 2 года):");
        change.age = sc.nextLine();

        patients.set(ch1,change);
        System.out.println("Успешно изменено!"+"\n");
    }

    private void printSpisok(){
        System.out.println("Выберите что надо вывести:\n" +
                "1) Список пациентов\n" +
                "2) Список докторов\n" +
                "3) Список приемов\n"
                );
        int ch = Integer.parseInt(sc.nextLine());
        switch (ch){
            case 1:
                int k1 = 1;
                for (Patients m : patients) {
                    System.out.println(k1 + ")" +m );
                    k1++;
                }
                System.out.println();
                break;
            case 2:
                int k2 = 1;
                for (Doctors m : doctors) {
                    System.out.println(k2 + ")" +m );
                    k2++;
                }
                System.out.println();
                break;
            case 3:
                int k3 = 1;
                for (Receiving m : receivings) {
                    System.out.println(k3 + ")" +m );
                    k3++;
                }
                System.out.println();
                break;
        }
    }

    private void saveToFile(){
        FileOutputStream outputStream = null;
        ObjectOutputStream objectOutput = null;
        String fileName;
        System.out.println("Хотите создать файл и записать в него или же"+
                " записать уже в имеющийся?"+"\n"+
                "1) Создать"+"\n"+
                "2) Записать в имеющийся");
        int ch=Integer.parseInt(sc.nextLine());
        switch (ch){
            case 1 :
                System.out.println("Назовите файл c расширением:");
                fileName = sc.nextLine();
                File file = new File("C://JAVA//"+fileName);
                try {
                    if (file.createNewFile()){
                        System.out.println("Файл создан");
                        try {
                            outputStream = new FileOutputStream(fileName);
                            objectOutput = new ObjectOutputStream(outputStream);
                            objectOutput.writeObject(patients);
                            objectOutput.writeObject(doctors);
                            objectOutput.writeObject(receivings);
                            objectOutput.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    else{
                        System.out.println("Такой файл уже существует");
                    }
                    break;

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.println("Введите название файла:");
                fileName= sc.nextLine();
                try {
                    outputStream = new FileOutputStream(fileName);
                    try {
                        objectOutput = new ObjectOutputStream(outputStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        objectOutput.writeObject(patients);
                        objectOutput.writeObject(doctors);
                        objectOutput.writeObject(receivings);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        objectOutput.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void deleteSmth(){
        System.out.println("Выберите откуда надо удалить:\n" +
                "1) Список пациентов\n" +
                "2) Список докторов\n" +
                "3) Список приемов\n"
        );
        int ch = Integer.parseInt(sc.nextLine());
        switch (ch){
            case 1:
                int k1 = 1;
                for (Patients m : patients) {
                    System.out.println(k1 + ")" +m );
                    k1++;
                }
                System.out.println();
                System.out.println("Выберите номер:");
                int index = Integer.parseInt(sc.nextLine());
                try {
                    patients.remove(index-1);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Пациента под этим номером не существует");
                }

                System.out.println("Пациент успешно удалён!");
                System.out.println();
                break;
            case 2:
                int k2 = 1;
                for (Doctors m : doctors) {
                    System.out.println(k2 + ")" +m );
                    k2++;
                }
                System.out.println();
                System.out.println("Выберите номер:");
                int index1 = Integer.parseInt(sc.nextLine());
                try {
                    doctors.remove(index1-1);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Доктора под этим номером не существует");
                }

                System.out.println("Доктор успешно удалён!");
                System.out.println();
                break;
            case 3:
                int k3 = 1;
                for (Receiving m : receivings) {
                    System.out.println(k3 + ")" +m );
                    k3++;
                }
                System.out.println();
                int index2 = Integer.parseInt(sc.nextLine());
                try {
                    receivings.remove(index2-1);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Приема под этим номером не существует");
                }

                System.out.println("Прием успешно удалён!");
                System.out.println();
                break;
        }
    }

    private void printPatientReceivings(){
        System.out.println("Введите нужное Ф.И.О:");
        String str = sc.nextLine();
        for(Receiving m: receivings){
            if(m.getFIO().equals(str)){
                System.out.println(m);
                System.out.println();
            }
        }
    }
}
