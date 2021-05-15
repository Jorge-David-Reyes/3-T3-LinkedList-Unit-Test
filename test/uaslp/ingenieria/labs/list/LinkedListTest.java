package uaslp.ingenieria.labs.list;
import org.assertj.core.internal.bytebuddy.dynamic.scaffold.MethodGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    public void whenLinkedListIsCreated_thenSizeIsZero(){
        //Inicializacion
        LinkedList<Integer> list = new LinkedList<>();

        //Ejecucion
        int size = list.getSize();

        //Validacion:
        assertEquals(0, size, "Size no es cero");
    }

    @Test
    public void whentheLinkedListIsCreated_thenAddNewNode_thenTheSizeHasToBeOne(){
        //Inicializacion
        LinkedList<Integer> list = new LinkedList<>();

        //Ejecucion
        list.add(2);

        //Validacion
        assertEquals(1, list.getSize(), "size no es uno" );
    }

    @Test
    public void whentheLinkedListIsCreated_thenAddNewNode_thenTheSizeHasToBeTwo(){
        //Inicializacion
        LinkedList<Integer> list = new LinkedList<>();

        //Ejecucion
        list.add(2);
        list.add(3);

        //Validacion
        assertEquals(2, list.getSize(), "size no es dos" );
    }

    @Test
    public void whenCreatingMoreThanOneLinkedList_ThenListsCountIsTwo(){
        //Inicializacion
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        //Ejecucion
        int count = list.getListsCount();

        //Validacion
        assertEquals(2, count, "El numero no es dos");
    }

    @Test
    public void givenALinkedListWith4Elements_thenTheIteratorAccessAllNodes(){
        //Inicializacion
        LinkedList<Integer> list = new LinkedList<>();

        //Ejecucion
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Integer> it = list.getIterator();

        //Validacion
        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertTrue(it.hasNext());
        assertEquals(2, it.next());
        assertTrue(it.hasNext());
        assertEquals(3, it.next());
        assertTrue(it.hasNext());
        assertEquals(4, it.next());
    }

    @Test
    public void givenAListWith4ElementWhenReverseIterator_thenAllElementsAreAccesible(){
        //Inicializacion
        LinkedList<Integer> list = new LinkedList<>();

        //Ejecucion
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Integer> it;
        it = list.getReverseIterator();

        //Validacion
        assertEquals(true, it.hasNext());
        assertTrue(it.hasNext());
        assertEquals(4, it.next());
        assertTrue(it.hasNext());
        assertEquals(3, it.next());
        assertTrue(it.hasNext());
        assertEquals(2, it.next());
        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertEquals(false, it.hasNext());
    }

    @Test
    public void givenLinkedListWith4Elements_thenGetData(){
        //Inicializacion
        LinkedList<Integer> list = new LinkedList<>();

        //Ejecucion
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //Validacion
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));

    }

    @Test
    public void givenALinkedListWithOneElements_thenInsertElementInTheHead() throws MyIndexOutOfBoundsException {
        //Inicializacion
        LinkedList<Integer> list = new LinkedList<>();

        //Ejecucion
        list.add(1);
        Iterator<Integer> it = list.getIterator();

        list.insert(5, Position.BEFORE, it);

        //Validacion
        assertEquals(5, list.get(0));
        assertEquals(2, list.getSize());
    }

    @Test
    public void givenALinkedListWithOneElements_thenInserElementInTheTail() throws MyIndexOutOfBoundsException {
        //Inicializacion
        LinkedList<Integer> list = new LinkedList<>();

        //Ejecucion
        list.add(1);
        Iterator<Integer> it = list.getIterator();

        list.insert(5, Position.AFTER, it);

        //Validacion
        assertEquals(5, list.get(1));
        assertEquals(2, list.getSize());
    }

    @Test
    public void givenALinkedListWithOneElements_thenInserElementInPositionFalse() throws MyIndexOutOfBoundsException {
        //Inicializacion
        LinkedList<Integer> list = new LinkedList<>();

        //Ejecucion
        list.add(1);
        Iterator<Integer> it = list.getIterator();

        //list.insert(5, Position.NUN, it);

        //Validacion
        Assertions.assertThrows(MyIndexOutOfBoundsException.class, ()-> list.insert(5, Position.NUN, it));
        assertEquals(1, list.getSize());
    }

    @Test
    public void givenALinkedListWith4Elements_thenInserElementAFTERTheHead() throws MyIndexOutOfBoundsException {
        //Inicializacion
        LinkedList<Integer> list = new LinkedList<>();

        //Ejecucion
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Integer> it = list.getIterator();
        list.insert(5, Position.AFTER, it);

        //Validacion
        assertEquals(5, list.getSize());
        assertEquals(1, list.get(0));
        assertEquals(5, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(4, list.get(4));
    }

    @Test
    public void givenALinkedListWith4Elements_thenInserElementBEFORETheHead() throws MyIndexOutOfBoundsException {
        //Inicializacion
        LinkedList<Integer> list = new LinkedList<>();


        //Ejecucion
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Integer> it = list.getIterator();
        list.insert(5, Position.BEFORE, it);

        //Validacion
        assertEquals(5, list.getSize());
        assertEquals(5, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(4, list.get(4));
    }

    @Test
    public void givenAlinkedListWith4Elements_thenDeleteHead() throws MyIndexOutOfBoundsException {
        //Inicializacion
        LinkedList<Integer> list = new LinkedList<>();

        //Ejecucion
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.delete(0);

        //Validacion
        assertEquals(3, list.getSize());
        assertEquals(2, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(4, list.get(2));

    }

    @Test
    public void givenAlinkedListWith4Elements_thenDeleteTail() throws MyIndexOutOfBoundsException {
        //Inicializacion
        LinkedList<Integer> list = new LinkedList<>();

        //Ejecucion
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.delete(3);

        //Validacion
        assertEquals(3, list.getSize());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void givenAlinkedListWith4Elements_thenDeleteInTheMiddle() throws MyIndexOutOfBoundsException {
        //Inicializacion
        LinkedList<Integer> list = new LinkedList<>();

        //Ejecucion
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.delete(2);

        //Validacion
        assertEquals(3, list.getSize());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(4, list.get(2));
    }

    @Test
    public void givenAlinkedListWith4Elements_thenDeleteAElementInIndexNonExistent() throws MyIndexOutOfBoundsException {
        //Inicializacion
        LinkedList<Integer> list = new LinkedList<>();

        //Ejecucion
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //list.delete(4);

        //Validacion
        Assertions.assertThrows(MyIndexOutOfBoundsException.class, ()-> list.delete(4));
        assertEquals(4, list.getSize());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
    }

    @Test
    public void givenAlinkedListWithOneElements_thenDeleteAElement() throws MyIndexOutOfBoundsException {
        //Inicializacion
        LinkedList<Integer> list = new LinkedList<>();

        //Ejecucion
        list.add(1);

        list.delete(0);

        //Validacion
        assertEquals(0, list.getSize());
    }
}
