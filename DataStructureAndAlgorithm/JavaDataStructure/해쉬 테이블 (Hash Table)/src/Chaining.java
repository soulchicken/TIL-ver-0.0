public class Chaining {
    public Slot[] hashTable;

    public Chaining(int size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;
        Slot next;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int hashFunc(String key) {
        // 적당히 만든 해쉬함수
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public void saveData(String key, String value) {
        int address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
           if(this.hashTable[address].key == key) {
               this.hashTable[address].value = value;
           } else {
               int currAddress = address + 1;
               while (this.hashTable[currAddress] != null) {
                    if (this.hashTable[currAddress].key == key) {
                        this.hashTable[currAddress].value = value;
                        return;
                    } else {
                        currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return;
                        }
                    }
               }
               this.hashTable[currAddress] = new Slot(key,value);
           }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
    }

    public String getData(String key) {
        int address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
           if (this.hashTable[address].key == key) {
               return this.hashTable[address].value;
           }
           int currAddress = address + 1;
           while (this.hashTable[currAddress] != null) {
               if(this.hashTable[currAddress].key == key) {
                   return this.hashTable[currAddress].value;
               }
               currAddress++;
               if (currAddress >= this.hashTable.length) {
                   return null;
               }
           }
        }
        return null;
    }
}
