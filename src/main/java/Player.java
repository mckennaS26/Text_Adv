import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

public class Player {
    private HashMap<String, Item> inventory;

    private int hp;

    public Player() {
        inventory = new HashMap<>();
        hp = 100;
    }

    public int getHP() {
        return hp;
    }

    public void adjustHP(int value) {
        hp += value;
    }

    public void setItem(String name, Item item) {
        inventory.put(name, item);
    }

    public Item dropItem(String name) {
        return inventory.remove(name);
    }

    public String getInventoryString()
    {
        String returnString = "Player Inventory:\n";
        Set<String> keys = inventory.keySet();
        for(String names : keys) {
            returnString += "* " + names + "\n";
        }
        return returnString;
    }
}