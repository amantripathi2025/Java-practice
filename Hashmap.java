import java.util.*;

class Tuple {
    int type;
    int key;
    int value;
    
    Tuple(int type, int key) {
        this.type = type;
        this.key = key;
        this.value = -1;
    }
    
    Tuple(int type, int key, int value) {
        this.type = type;
        this.key = key;
        this.value = value;
    }
}

class Hashmap {
    // HashMap implementation using linear probing
    static class MyHashMap {
        private static final int DEFAULT_CAPACITY = 20000;
        private int[] keys;
        private int[] values;
        private boolean[] occupied;
        private int size;
        
        public MyHashMap() {
            keys = new int[DEFAULT_CAPACITY];
            values = new int[DEFAULT_CAPACITY];
            occupied = new boolean[DEFAULT_CAPACITY];
            size = 0;
        }
        
        private int hash(int key) {
            return Math.abs(key) % DEFAULT_CAPACITY;
        }
        
        private int findPosition(int key) {
            int index = hash(key);
            int startIndex = index;
            
            while (occupied[index]) {
                if (keys[index] == key) {
                    return index;
                }
                index = (index + 1) % DEFAULT_CAPACITY;
                if (index == startIndex) {
                    break;
                }
            }
            return -1;
        }
        
        private int findEmptyPosition(int key) {
            int index = hash(key);
            
            while (occupied[index]) {
                if (keys[index] == key) {
                    return index; // Key exists, update value
                }
                index = (index + 1) % DEFAULT_CAPACITY;
            }
            return index;
        }
        
        public void put(int key, int value) {
            int index = findEmptyPosition(key);
            if (occupied[index]) {
                // Update existing key
                values[index] = value;
            } else {
                // Insert new key
                keys[index] = key;
                values[index] = value;
                occupied[index] = true;
                size++;
            }
        }
        
        public int get(int key) {
            int index = findPosition(key);
            if (index != -1 && occupied[index]) {
                return values[index];
            }
            return -1;
        }
        
        public void delete(int key) {
            int index = findPosition(key);
            if (index != -1) {
                occupied[index] = false;
                size--;
            }
        }
        
        public int size() {
            return size;
        }
    }
    
    public static List<Integer> processQueries(List<Tuple> queries) {
        List<Integer> result = new ArrayList<>();
        MyHashMap map = new MyHashMap();
        
        for (Tuple query : queries) {
            switch (query.type) {
                case 1:
                    map.put(query.key, query.value);
                    break;
                case 2:
                    result.add(map.get(query.key));
                    break;
                case 3:
                    map.delete(query.key);
                    break;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        List<Tuple> queries = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            int type = scanner.nextInt();
            
            if (type == 1) {
                int key = scanner.nextInt();
                int value = scanner.nextInt();
                queries.add(new Tuple(type, key, value));
            } else if (type == 2 || type == 3) {
                int key = scanner.nextInt();
                queries.add(new Tuple(type, key));
            }
        }
        
        List<Integer> results = processQueries(queries);
        
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
        
        scanner.close();
    }
}