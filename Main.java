package spacestation;

public class Main {
    public static void main(String[] args) {
        SpaceStation station = new SpaceStation();
        station.addModule(new LivingModule("Harmony", 4, 12.5));
        station.addModule(new LabModule("Destiny", 6, 20.0));
        station.addModule(new SolarModule("Array-A", 8, 4.0));
        station.addModule(new SolarModule("Array-B", 6, 4.0));

        PowerBalanceVisitor power = new PowerBalanceVisitor();
        station.accept(power);
        System.out.println("Power balance: " + power.getBalanceKw() + " kW");

        CrewCapacityVisitor crew = new CrewCapacityVisitor();
        station.accept(crew);
        System.out.println("Crew capacity: " + crew.getCapacity());

        InspectionReportVisitor inspection = new InspectionReportVisitor();
        station.accept(inspection);
        System.out.print("Inspection report:\n" + inspection.getReport());
    }
}
