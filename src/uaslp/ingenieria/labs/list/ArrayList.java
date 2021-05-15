package uaslp.ingenieria.labs.list;

public class ArrayList <H> implements List<H>{

    private Object array[];
    private int size;

    // cuando se crea una arrayList el size =0
    public ArrayList() {
        this.array = new Object[1];
    }

    @Override
    public void add(H data){
        if(size >= array.length){
            Object[] arrayClone = new Object[array.length + 2];
            System.arraycopy(array, 0, arrayClone, 0, array.length);
            this.array = arrayClone;
        }
        this.array[size] = data;
        size++;
    }

    @Override
    public H get(int index) {
        return (H)this.array[index];
    }

    @Override
    public void delete(int index) throws MyIndexOutOfBoundsException{
        if(array.length - (index + 1) >= 0){
            System.arraycopy(this.array, index + 1, this.array, index + 1 - 1, array.length - (index +1));
        }else{
            throw new MyIndexOutOfBoundsException();
        }
        size--;
    }

    public class ForwardIterator implements Iterator<H>{
        private int index;

        public boolean hasNext(){

            return index < size;
        }

        public H next(){
            return (H)array[index++];
        }
    }

    public class ReverseIterator implements Iterator<H> {

        private int reverseIndex=size-1;

        public boolean hasNext(){

            return reverseIndex >= 0;
        }

        public H next(){
            return (H)array[reverseIndex--];
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<H> getIterator() {
        return new ForwardIterator();
    }

    @Override
    public void insert(H data, Position position, Iterator<H> it) {
        if(size >= array.length){
            Object[] arrayClone = new Object[array.length + 2];
            System.arraycopy(array, 0, arrayClone, 0, array.length);
            this.array = arrayClone;
        }
        this.array[size] = data;
        size++;
    }

    @Override
    public ReverseIterator getReverseIterator() {
        return new ReverseIterator();
    }
}

