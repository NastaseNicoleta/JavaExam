package org.example;

import repository.AngajatDbRepository;
import service.Service;
import ui.UI;

public class Main {
    public static void main(String[] args) {
        System.out.println("ok");
        System.out.println("Reading data from file");
        String username = "postgres";
        String password = "23311872nN";
        String url = "jdbc:postgresql://localhost:5432/examen";

        AngajatDbRepository userFileRepository = new AngajatDbRepository(url, username, password);
        Service service = new Service(userFileRepository);
        UI console = new UI(service);
        console.run();}
}