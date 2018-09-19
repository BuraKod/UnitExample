package assertJ;

import main.Item;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.extractProperty;
import static org.assertj.core.api.Assertions.tuple;

public class ListsTest {

  @Test
    public void testLists() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item(1, "Adele"));
        items.add(new Item(2, "jennifer"));
        items.add(new Item(3, "Lima"));
        items.add(new Item(4, "Tarkan"));
        items.add(new Item(5, "Tiesto"));

        assertThat(items)
                .extracting("name")
                .contains("Tiesto", "Tarkan");

        // Birden fazla parametre verdiğimizde contains işlemine tuple eklememiz gerekiyor.
        assertThat(items)
                .extracting("id", "name")
                .contains(
                        tuple(1,"Adele"),
                        tuple(4,"Tarkan"),
                        tuple(3,"Lima")
                );
        assertThat(
                extractProperty("id",Integer.class).from(items)
        ).containsExactly(1,2,3,4,5);
    }

}
