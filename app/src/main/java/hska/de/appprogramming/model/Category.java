package hska.de.appprogramming.model;

/**
 * Created by Alina on 08.05.2018.
 */

public enum Category {
    THINKING("Denken"), ARTS_AND_CRAFT("Handwerken"), MUSIC("Musik"),
    SOCIAL_SCIENCE("Sozialwissenschaften"), SPORTS("Sport"), LANGUAGE("Sprachen"),
    SCIENCE("Naturwissenschaften"), OTHERS("Sonstiges");

    private final String name;

    private Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name;
    }
}
