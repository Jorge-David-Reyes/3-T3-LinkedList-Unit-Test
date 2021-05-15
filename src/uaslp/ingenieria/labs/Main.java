package uaslp.ingenieria.labs;

import uaslp.ingenieria.labs.list.*;

public class Main {
    public static void main(String[] args) throws MyIndexOutOfBoundsException {
        int cuenta =  LinkedList.getListsCount();

        List<Integer> lista1 = new LinkedList<>();
        List<String> lista2 = new ArrayList<>();

        lista1.add(1);
        lista1.add(2);
        lista1.add(3);
        lista1.add(4);
        lista1.add(5);
        lista1.add(6);

        lista2.add("Azul");
        lista2.add("Gris");
        lista2.add("Rojo");
        lista2.add("Amarillo");
        lista2.add("Morado");
        lista2.add("Verde");

        lista1.delete(3);

        System.out.println("---------------------");

        System.out.println("El tamaño es:" + lista1.getSize());

        Iterator<Integer> it = lista1.getIterator();

        while(it.hasNext()){
            int element = it.next();

            System.out.println("Dato: " + element);
        }

        System.out.println("---------------------");

        it = lista1.getReverseIterator();

        while(it.hasNext()){
            int element = it.next();

            System.out.println("Dato: " + element);
        }

        System.out.println("---------------------");

        Iterator<String> itStrings = lista2.getIterator();

        while(itStrings.hasNext()){
            System.out.println(itStrings.next());
        }

    }
}
