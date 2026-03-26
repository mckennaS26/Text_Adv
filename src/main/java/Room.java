import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

public class Room
{
    private String shortDescription;
    private String longDescription;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private HashMap<String, Item> inventory;


    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String shortDescription, String longDescription)
    {
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        exits = new HashMap<>();
        inventory = new HashMap<>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    public void setItem(String name, Item item) {
        inventory.put(name, item);

    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return shortDescription;
    }

    /**
     * @return The long description of the room
     * (the one that was defined in the constructor).
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getRoomDescription()
    {
        return "You are " + longDescription + "\n" + getExitString() + "\n" + getInventoryString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:\n";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += "* " + exit + "\n";
        }
        return returnString;
    }

    public String getInventoryString()
    {
        String returnString = "Room Inventory:\n";
        Set<String> keys = inventory.keySet();
        for(String names : keys) {
            returnString += "* " + names + "\n";
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    public Item getItem(String name) {
        return inventory.remove(name);
    }
}

