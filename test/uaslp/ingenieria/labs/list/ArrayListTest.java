package uaslp.ingenieria.labs.list;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest{
    @Test
    public void whenArrayListIsCreated_thenSizeIsZero(){
        //Inicializacion
        ArrayList<Integer> list = new ArrayList<>();

        //Ejecucion
        int size = list.getSize();

        //Validacion:
        assertEquals(0, size, "Size no es cero");
    }

    @Test
    public void givenANewArray_whenAddElemen_thanSizeIsOne(){
        //Inicializacion
        ArrayList<Integer> list = new ArrayList<>();

        //Ejecucion
        list.add(500);

        //Validacion:
        assertEquals(1, list.getSize());
    }

    @Test
    public void givenANewArray_whenAddElemen_thanSizeIsTwo(){
        //Inicializacion
        ArrayList<Integer> list = new ArrayList<>();

        //Ejecucion
        list.add(500);
        list.add(100);

        //Validacion:
        assertEquals(2, list.getSize(), "Deberia tener dos elemntos");

    }

    @Test
    public void MethodInsertInArrayListNotImplemented_OnlyInLinkedList(){
        ArrayList<Integer> list = new ArrayList<>();
        Iterator it = null;
        list.insert(20, Position.AFTER, it);
        list.insert(30, Position.AFTER, it);

        assertEquals(2, list.getSize(), "Deberia tener dos elemntos");
    }

    @Test
    public void givenANewArray_whenNoCapacity_thenSizeAndCapacityIncrements(){
        //Inicializacion
        ArrayList<Integer> list = new ArrayList<>();

        //Ejecucion
        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        list.add(1000);

        //Validacion:
        assertEquals(5, list.getSize(), "Deberia tener cinco elemntos");
        assertEquals(500, list.get(0));
        assertEquals(600, list.get(1));
        assertEquals(700, list.get(2));
        assertEquals(800, list.get(3));
        assertEquals(1000, list.get(4));
    }

    @Test
    public void givenAListWith5Element_whenIterator_thenAllElementsAreAccesible(){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);
        list.add(1000);


        Iterator<Integer> it = list.getIterator();

        //Validacion
        assertTrue(it.hasNext());
        assertEquals(500, it.next());
        assertTrue(it.hasNext());
        assertEquals(600, it.next());
        assertTrue(it.hasNext());
        assertEquals(700, it.next());
        assertTrue(it.hasNext());
        assertEquals(800, it.next());
        assertTrue(it.hasNext());
        assertEquals(1000, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void givenAListWith5Element_whenReverseIterator_thenAllElementsAreAccesible(){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);
        list.add(1000);


        Iterator<Integer> it;
        it = list.getReverseIterator();

        //Validacion
        assertTrue(it.hasNext());
        assertEquals(1000, it.next());
        assertTrue(it.hasNext());
        assertEquals(800, it.next());
        assertTrue(it.hasNext());
        assertEquals(700, it.next());
        assertTrue(it.hasNext());
        assertEquals(600, it.next());
        assertTrue(it.hasNext());
        assertEquals(500, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void givenAnExistentArrayWith4Elements_whenDeleteElementHead_thenSizeDecrements() throws MyIndexOutOfBoundsException {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        list.delete(0);

        //Validacion
        assertEquals(3, list.getSize(), "Deberia tener tres elementos");
        assertEquals(600, list.get(0));
        assertEquals(700, list.get(1));
        assertEquals(800, list.get(2));

    }

    @Test
    public void givenAnExistentArrayWith4Elements_whenDeleteElementInTheMiddle_thenSizeDecrements() throws MyIndexOutOfBoundsException {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        list.delete(1);

        //Validacion
        assertEquals(3, list.getSize(), "Deberia tener tres elementos");
        assertEquals(500, list.get(0));
        assertEquals(700, list.get(1));
        assertEquals(800, list.get(2));

    }

    @Test
    public void givenAnExistentArrayWith4Elements_whenDeleteTailElement_thenSizeDecrements() throws MyIndexOutOfBoundsException {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        list.delete(3);

        //Validacion
        assertEquals(3, list.getSize(), "Deberia tener tres elementos");
        assertEquals(500, list.get(0));
        assertEquals(600, list.get(1));
        assertEquals(700, list.get(2));

    }

    @Test
    public void givenAnExistentArrayWith4Elements_whenDeleteElementAtIndex5_thenIndexOutPfBoundExceptionIs() {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        //Ejecucion

        //Vlaidacion
        Assertions.assertThrows(MyIndexOutOfBoundsException.class, ()-> list.delete(5));

    }
}