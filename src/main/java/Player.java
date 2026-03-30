import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

public class Player {
    private HashMap<String, Item> inventory;
    private boolean active;

    private int hp, dmg;

    public Player(int hp, int dmg) {
        inventory = new HashMap<>();
        this.hp = hp;
        this.dmg = dmg;
        active = false;
    }

    public HashMap getInventory() {
        return inventory;
    }
    public int getHP() {
        return hp;
    }

    public void adjustHP(int value) {
        hp += value;
    }

    public int getDmg() {
        return dmg;
    }

    public void adjustDmg(int value) {
        dmg += value;
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