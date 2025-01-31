package com.week3.day2;
import java.util.*;

public class CustomHashMap {
    //hashmap class
    static class HashMap<K,V>{
        //node class
        private class Node{
            K key;
            V value;
            //constructor
            public Node(K key,V value){
                this.key = key;
                this.value = value;
            }

        }
        private int n; //number of node
        private int N; //number of bucket
        private LinkedList<Node> bucket[];

        //constructor of hashmap class
        public  HashMap(){
            this.N = 4;
            this.bucket = new LinkedList[16];
            for(int i =0;i<4;i++){
                this.bucket[i] = new LinkedList<>();
            }
        }

        //return bucket index
        private int hashFunction(K key){
            int bucketIndex = key.hashCode();
            return  Math.abs(bucketIndex)%N;
        }
        //return linkedlist index
        private int searchInLL(K key,int bucketIndex){
            LinkedList<Node> ll = bucket[bucketIndex];
            int dataIndex = 0;
            for(int i =0;i<ll.size();i++){
                return dataIndex;
            }
            return -1;
        }

        //insertion method
        public void put(K key,V value){
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key,bucketIndex);
            if(dataIndex==-1){
                bucket[bucketIndex].add(new Node(key,value));
                n++;

            } else{
                Node data = bucket[bucketIndex].get(dataIndex);
                data.value = value;
            }

        }

        //deletion method
        public V remove(K key){
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key,bucketIndex);
            if(dataIndex == -1){
                return null;
            } else {
                Node node = bucket[bucketIndex].remove(dataIndex);
                return node.value;
            }
        }

        //retrieval method
        public V get(K key){
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key,bucketIndex);
            if(dataIndex == -1){
                return null;
            } else {
                Node node = bucket[bucketIndex].get(dataIndex);
                return node.value;
            }
        }

    }

    public static void main(String[] args) {
        // Create a HashMap to store the name and age
        HashMap<String, Integer> map = new HashMap<>();

        // Insert elements
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);

        // Retrieve elements
        System.out.println("Alice's age: " + map.get("Alice"));
        System.out.println("Bob's age: " + map.get("Bob"));

        //update alice age
        map.put("Alice",30);
        System.out.println("Alice's age: " + map.get("Alice"));

        // Remove an element
        map.remove("Bob");
        System.out.println("Bob's age after removal: " + map.get("Bob"));



    }
}
