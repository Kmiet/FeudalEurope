import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

public class App {

    public static void main(String Args[]){
        List<Kingdom> kingdoms = new ArrayList<>();

        List<Land> l1 = new LinkedList<Land>();
        l1.add(new Land("Mauopolska", 10000, LandType.CITY));
        List<Land> l2 = new LinkedList<Land>();
        l2.add(new Land("Mazowszy", 3000, LandType.RURAL));
        l2.add(new Land("Wielkowolska", 2000, LandType.RURAL));
        l1.add(new Land("Slunskje", 4000, LandType.CITY));
        l1.add(new Land("Zakarpacie", 3500, LandType.CITY));
        l2.add(new Land("Wyspa Allin", 9000, LandType.CITY));
        l2.add(new Land("Dalekobrzeg", 500, LandType.RURAL));
        l1.add(new Land("Ycryin", 1000, LandType.RURAL));

        Lord king1 = new Lord(new LinkedList<Vassal>(), l1, "Wacuaf IV");
        kingdoms.add(new Kingdom("Polsza a", king1));

        Lord king2 = new Lord(new LinkedList<Vassal>(), l2, "Tapir Mocny");
        kingdoms.add(new Kingdom("Polsza b", king2));
        System.out.println(kingdoms);

        Lord lurd1 = new Lord(new LinkedList<Vassal>(), new LinkedList<Land>(), "Zawiesina Czarny");
        Lord lurd2 = new Lord(new LinkedList<Vassal>(), new LinkedList<Land>(), "Janusz Pawlacz");
        Lord lurd3 = new Lord(new LinkedList<Vassal>(), new LinkedList<Land>(), "Jurand ze Spychacza");
        Lord lurd4 = new Lord(new LinkedList<Vassal>(), new LinkedList<Land>(), "Zbyszko z Trzech Cytryn");
        Lord lurd5 = new Lord(new LinkedList<Vassal>(), new LinkedList<Land>(), "Jan Wacitejko");

        try {
            List<Land> temp = kingdoms.get(0).king.getLands().subList(0, 2);
            lurd5 = king1.vassalize(lurd5, temp, 100);
            lurd2 = king1.vassalize(lurd2, kingdoms.get(0).king.getLands(), 200);
            lurd1 = lurd5.vassalize(lurd1, lurd5.getLands().subList(0, 1), 500);
            lurd3 = king2.vassalize(lurd3, kingdoms.get(1).king.getLands().subList(0, 1), 300);
            lurd4 = king2.vassalize(lurd4, kingdoms.get(1).king.getLands(), 350);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(king1.getVassals());
    }
}
