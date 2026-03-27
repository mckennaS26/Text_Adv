public class Game
{
    private Parser parser;
    private Room currentRoom;
    private Player player;
    private Player ghost;
    Room outside, livingRoom, kitchen, hallwayStairs, bedroom, bathroom, study, secretPassage, attic;
    Item rapier, wornFile, ornateKey, goldKey, driedHerbs, salt, trunk, armoire, dustyNotes, fullMirror, brassKey ;

    /**
     * Create the game and initialise its internal map.
     */
    public Game()
    {
        createRooms();
        parser = new Parser();
        player = new Player(100,2);
        ghost = new Player(10, 2);

    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        // create the rooms
        outside = new Room(
                "You stand just outside the door of a house.",
                "The facade of a quaint Victorian house stands before you. It has a turret that extends off \n" +
                        "the front corner of the house. It seems rather well kept, but there are weeds starting to peek\n" +
                        "out of the sidewalk cracks. The navy paint has seen better days and the front door in front of\n" +
                        "you is warped and the stain is gone in patches. You stand on the rickety porch that groans when\n" +
                        "you move."
        );

        livingRoom = new Room(
                "You are inside the living room.",
                "It is not very messy except for the eclectic and eerie decorating style and a few objects\n" +
                        "that seem missing or misplaced.\n\n" +
                        "This downstairs level is open concept and the front door enters directly into the living room.\n" +
                        "There is a staircase next to the door and beyond the living room, you can see a small kitchen.\n\n" +
                        "The living room is full of bookcases and directly to your left is a coat rack with a single coat\n" +
                        "on it. Next to the coat rack is an overflowing umbrella holder that strangely has a rapier.\n"+
                        "There is a couch and a few chairs on the right, facing the right wall that has a single tv on\n" +
                        "top of a short bookcase. There are a large number of framed pictures of many people covering the\n" +
                        "but no one person appears more than twice. There is a large rug in the middle of the room and\n" +
                        "a low coffee table on top of it. There is an old mug sitting atop the table and next to it, a\n" +
                        "worn file. The walls are all decorated with different trinkets, none cohesive, except for the\n" +
                        "the fact that most are made of silver. One of these silver trinkets is an ornate key in\n" +
                        "an empty picture frame."
        );

        kitchen = new Room(
                "You are inside the small kitchen attached to the living room.",
                "There is a large old mahogany table in the middle of the kitchen, taking up most\n" +
                        "of the space. The kitchen is open directly into the living room so there is no real\n" +
                        "barrier between.\n\n"+
                        "   It contains all the basic amenities, a stove, fridge,\n" +
                        "sink,...etc. that are all spaced out by a multitude of dark oak cabinets. There is\n"+
                        "a strange contraption on top of the stone counter. The counter wraps fully around\n" +
                        "atop the bottom cabinets. There is a small vase full of spoons, ladles, tongs,\n" +
                        "and other cooking tools with a cord on which a gold key hangs. Most noticeably there\n" +
                        "is a long string that wraps along the wall and has multiple dried plants clipped to it.\n "+
                        "The counter is covered in multiple large jars with names for different spices and \n" +
                        "ingredients. There are a few you don't recognize, but the largest jar, normally \n"+
                        "reserved for flour, has the printed 'flour' label taped over. Written in sharpie on the \n"+
                        "tape is 'Salt'. Like the coffee table, the large table seems to have been left in a hurry,\n"+
                        " with breakfast leftovers still lying about. On the left wall there is a pantry with two\n" +
                        " doors that you can't seem to open, they have no handles on them."
        );

        hallwayStairs = new Room(
                "You are on the stairs leading to a hallway",
                "The old inclined stairs off of the living room lead into a small hallway. The\n"+
                        "hallway is only large enough for a few shelves and passage between three doors. Along\n"+
                        "the stairs and on every wall of the hallway, continues the many framed pictures of\n" +
                        "different people and the strange collection of objects that started in the living room.\n"+
                        "The shelves are yet again filled with a multitude of books. Next to one of the bookshelves\n"+
                        "is a large, musty, glass case that seems to be filled with memorabilia for a fencing prodigy."
        );

        bedroom = new Room(
                "You are inside a small bedroom.",
                "The bedroom has a single large bed and an old oak armoire. At the foot of the bed is a trunk.\n"+
                        "There is a vanity opposite the bed and they both are parallel to the outside wall with a window.\n" +
                        "Unlike the rest of the house, this room does not have any pictures of people, only scenic \n" +
                        "views and a large collection of postcards from all over the world. The postcards are stuck\n" +
                        "to the wall behind the headboard and lead up ont the ceiling. The armoire is locked, but it\n" +
                        "has a grate inlet in the doors, so you can see some long coats and nice dresses inside. The\n"+
                        "vanity has a single drawer and a large jewelry box in the middle of it. The trunk is large\n" +
                        "and ornate. It has an large, clunky rusted padlock holding it shut. There is a door opposite\n"+
                        "the window."
        );

        bathroom = new Room(
                "You are inside a bathroom.",
                "The bathroom is the same length as the bedroom. It has an new full length mirror,\n"+
                        "a large modern tub with a standing shower next to it. There is a toilet opposite the\n"+
                        "tub. Next to the mirror is a line of old oak cabinets with a sink in the middle of them.\n"+
                        "Surrounding the sink is a couple of candles that and a singular soap bar.\n"+
                        "There is another large mirror above the sink at eye level. The full length mirror\n"+
                        "is extruded from the wall and has hinges on its side. This bathroom looks pristine,\n"+
                        "almost too much. It doesn't really match the rest of the house."
        );

        study = new Room(
                "You are in an old, ornate study.",
                "The study is straight out of an old academic's dream. The outer-facing walls have floor to ceiling,\n"+
                        "multi-paned windows with large burgundy curtains tied to the sides. The rest of the walls are\n"+
                        "completely covered in floor to ceiling bookcases with a rolling ladder to traverse them. There isn't\n"+
                        "a single empty slot in the bookcase except for one on the a bookcase on the north wall. In the\n"+
                        "center of the room is a large, ornate desk covered in embellishments and drawers. Atop the desk is\n"+
                        "an open journal, an array of papers strewn about, and a single pen, laid across the journal."
        );

        secretPassage = new Room(
                "You are on a platform with a spiral staircase leading above and below you.",
                "Behind the bookshelf is this dark passageway. There is a tight, metal, spiraling staircase that\n"+
                        "extends above and below you. You are on a short platform and a break in the railing in front\n"+
                        "of you that allows you onto the stairs. There ia platform like this one about a floor above\n"+
                        "you and it is too dark to see below. There is another platform on the opposite wall of you, about\n"+
                        "half-way between your level and the one above."
        );

        attic = new Room(
                "You are in a dark, dank, musty attic.",
                "The attic is large, it almost seems larger that the house's footprint. It's dank and all light is\n" +
                        "coming through a small window to your left that is mostly boarded up. there are cobwebs in every corner\n" +
                        "and a large metal table in the center of the room. The table is plain and yet seems somehow different\n" +
                        "from the average table. There is a dark shadow in the west corner of the room and a wall of tools to\n" +
                        "your right. None seem to be electrically powered and honestly look over the top and downright scary.\n" +
                        "Below the opposite wall is a large, locked file cabinet. Nestled between the file cabinet and the adjacent\n" +
                        "wall is another desk, much smaller and simpler than the one in the study, but also much more covered in an\n" +
                        "array of papers."
        );

        // initialise room exits
        outside.setExit("inside", livingRoom);

        livingRoom.setExit("east", kitchen);
        livingRoom.setExit("stairs", hallwayStairs);

        kitchen.setExit("west", livingRoom);
        kitchen.setExit("pantry", secretPassage);

        hallwayStairs.setExit("downstairs", livingRoom);
        hallwayStairs.setExit("upstairs 1", bedroom);
        hallwayStairs.setExit("upstairs 2", bathroom);
        hallwayStairs.setExit("upstairs 3", study);

        bedroom.setExit("east", bathroom);
        bedroom.setExit("hallway", hallwayStairs);

        bathroom.setExit("east", study);
        bathroom.setExit("west", bedroom);
        bathroom.setExit("hallway", hallwayStairs);

        study.setExit("bookcase",secretPassage);
        study.setExit("hallway", hallwayStairs);
        study.setExit("west", bathroom);

        secretPassage.setExit("escape", outside);
        secretPassage.setExit("upstairs trapdoor", attic);
        secretPassage.setExit("downstairs pantry", kitchen);

        attic.setExit("trapdoor", secretPassage);


        exampleItem = new Item(0);
        exampleItem2 = new Item(0);
        hpBottle = new Item(10);
        outside.setItem("health potion", hpBottle);
        outside.setItem("ice sword", exampleItem);
        outside.setItem("flame bottle", exampleItem2);


        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play()
    {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing. Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a text based adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getShortDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("What are you on about...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;

            case LOOK:
                look(command);
                break;

            case DROP:
                drop(command);
                break;

            case GRAB:
                grabItem(command);
                break;

            case DRINK:
                drinkItem(command);
                break;

            case OPEN:
                open(command);
                break;

            case PRESS:
                pressButton(command);
                break;

            case DISPEL:
                dispelGhost(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:
    private void drinkItem(Command command) {
        if(!command.hasSecondWord()) {
            System.out. println("Drink what?");
            return;
        }

        String itemName = command.getSecondWord();
        if ( command.hasThirdWord()) {
            itemName += " " + command.getThirdWord();
        }

        //can check to see if the item is in the room inventory, and if it is tell them to pick it up
        Item itemToDrink = player.dropItem(itemName);

        //you can add a boolean valuee to an item to see if it is "drinkable"
        if(itemToDrink == null) {
            System.out.println("You can't drink that");
        } else{
            player.adjustHP(itemToDrink.getHPValue());
            System.out.println("new player hp is " + player.getHP());
        }
    }
    private void look(Command command) {
        if(command.hasSecondWord()) {
            System.out.println("Thats for my eyes only, not yours!");
            return;
        }
        System.out.println(currentRoom.getRoomDescription());
    }

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the
     * command words.
     */
    private void printHelp()
    {
        System.out.println("You are stuck in a dark dingy house. You are");
        System.out.println("trying to escape.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void grabItem(Command command) {
        if(!command.hasSecondWord()) {
            System.out.println("Grab what?");
            return;
        }

        String itemName = command.getSecondWord();

        if(command.hasThirdWord()) {
            itemName += " " + command.getThirdWord();
        }

        Item itemToGrab = currentRoom.getItem(itemName);

        if(itemToGrab == null) {
            System.out.println("You can't grab that!");
            return;
        }else {
            player.setItem(itemName, itemToGrab);
            System.out.println(player.getInventoryString());
        }
    }

    private void drop(Command command) {
        if(!command.hasSecondWord()) {
            System.out.println("You don't have that?");
            return;
        }

        String itemName = command.getSecondWord();

        if(command.hasThirdWord()) {
            itemName += " " + command.getThirdWord();
        }

        Item itemToDrop = player.dropItem(itemName);

        if(itemToDrop == null) {
            System.out.println("You can't drop that!");
            return;
        }else {
            currentRoom.setItem(itemName, itemToDrop);
            System.out.println(currentRoom.getInventoryString());
        }
    }

    /**
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("That's not a door, thats a wall");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getShortDescription());
        }
    }

    private void pressButton(Command command) {
        if(!currentRoom.equals(study)) {
            System.out.println("There's nothing to press here");
        }

        if(!command.hasSecondWord()) {
            System.out.println("Press what?");
        }

        String buttonName = command.getSecondWord();

        if(command.hasThirdWord()) {
            buttonName += " " + command.getThirdWord();
        }

        if(!buttonName.equals("desk button")) {
            System.out.println("That's not a button!?");
        }

        if(buttonName.equals("desk button")) {
            System.out.println("The panel the button is on opens into a drawer that contains a single silver key" );
            player.setItem();
        }




    }

    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command)
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
