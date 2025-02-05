package fr.epita.assistants.creatureInterface;

import java.util.List;

/**
 * This interface provides communication methods for the objects of the class
 * that implements it. Classes adopting this interface instantiate objects
 * capable of communication.
 */
public interface SpeakableInterface {
    /**
     * Returns the name of the object that can speak
     */
    String getName();

    /**
     * Prints "Hello, my name is {creatureName} and I'm a {creatureClassName}."
     */
    void hello();

    /**
     * Greets the contact
     * The default implementation greets the contact based on its type
     * @param contact the creature to greet
     */
    default void greet(SpeakableInterface contact) {
        String myType = this.getClass().getSimpleName();
        String contactType = contact.getClass().getSimpleName();

        switch (myType) {
            case "Mage":
                if (contactType.equals("Mage")) {
                    System.out.println("I welcome you, " + contact.getName() + ".");
                    return;
                }
                break;

            case "Dragon":
                if (contactType.equals("Dragon")) {
                    System.out.println("Greetings Lord " + contact.getName() + ".");
                    ((Dragon) this).doSomeSparkles();
                    return;
                }
                break;

            case "Mermaid":
                if (contactType.equals("Mermaid")) {
                    System.out.println("Dear " + contact.getName() + ", welcome.");
                    return;
                }
                break;

            case "Human":
                if (contactType.equals("Human")) {
                    System.out.println("Hello " + contact.getName() + ", how are you?");
                    return;
                }
                break;
        }

        // Assign correct greeting for other creatures
        String title = switch (contactType) {
            case "Mage" -> "keeper of Arcane secrets";
            case "Dragon" -> "keeper of Ancient treasures";
            case "Mermaid" -> "keeper of the Seas";
            case "Human" -> "the human";
            default -> "mysterious being";
        };
        System.out.println("Salutations " + contact.getName() + ", " + title + ".");
    }


    /**
     * Allows all speakers in the collection to say hello as explained in the hello() method
     * @param speakers the list of creatures that can speak
     */
    static void helloAll(List<SpeakableInterface> speakers) {
        for (SpeakableInterface speaker : speakers) {
            speaker.hello();
        }
    }
}
