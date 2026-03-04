public class ArrayList<E> implements List<E>{

    //internal fields
    private E[] data; // The array that stores the elements
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        data = (E[]) new Object[10];    // Start with a default capacity
        size = 0;                       // Empty list at the start 
    }

    @Override
    public Boolean add(E e) {
        if (size == data.length) {
            resize(data.length * 2);   // double the capacity if full
        }
        data[size] = e;
        size++;
        return true;
    }

    private void resize(int newCapacity) {
        @SuppressWarnings("unchecked")
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i]; // copy elements over
        }
        data = newData; // Update reference
    }

    @Override
    public int size(){
        return size;
    }
    
    @Override
    public void add(int index, E element) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size:" + size);
        

        //resize if necessary
        if (size == data.length)
            resize(data.length * 2);

        for(int i = size; i > index; i--){
            data[i] = data[i--];
        }
        data[index] = element;
        size++;
            
    }
    @Override
    public Boolean remove(Object o) {
        // TODO Auto-generated method stub
        for(int i = 0; i < size; i++){
            if(data[i].equals(o)){
                for(int j = i; j < size - 1; j++){
                   data[j] = data[j + 1]; 
                }
                data[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index must be positive and within bounds.");

        E removed = data[index];

        for(int i = index; i < size - 1; i++){
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;

        //Check if it's full 25%
        if(size > 0 && size < data.length/4) 
            resize(data.length / 2);
        
        return removed;


    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < size; i++){
            sb.append(data[i]);
            if (i < size - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
        }

    
    @SuppressWarnings("unchecked")
    @Override
    public void clear(){
        data = (E[]) new Object[10];
        size = 0;
    }
}
    


