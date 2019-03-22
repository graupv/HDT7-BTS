
public class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {
    //  perimte comparar associaciones
    
    K key;
    V value;

    Association(K k, V v){
        key = k;
        value = v;
    }
    
    public K getKey(){
        return key;
    }

    public void setKey(K k){
        key = k;
    }

    public int hashCode() {
        //  para poder ordenarlas
        return getKey().hashCode();
    }

    public void setValue(V v){
        value = v;
    }

    public V getValue(){
        return value;
    }


    @Override
    public int compareTo(Association<K, V> o) {
        return key.compareTo(o.getKey());
    }
}
