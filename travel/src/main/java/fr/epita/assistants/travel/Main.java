package fr.epita.assistants.travel;

public class Main {
    public static void main(String[] args) {
        Country fr = new Country("France", "Europe/Paris", "src/main/resources/travel_times.csv");
        Country usa = new Country("Chicago", "America/Chicago", "src/main/resources/travel_times.csv");
        Travel.travelTo(fr, usa);
        Country frA = new Country("France", "Europe/Paris", "src/main/resources/travel_times.csv");
        System.out.println(frA.travelTimes);
    }
}
