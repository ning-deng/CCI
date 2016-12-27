package chapter3;

import java.util.LinkedList;

/**
 * Created by ning on 12/27/16.
 */
public class animalShelter {

    public LinkedList<animal> animals=new LinkedList<>();

    public class animal{
        public String name;
        public String type;

        public animal(String type, String name){
            this.name=name;
            this.type=type;
        }
    }

    public void enqueue(String type, String name){
        animal newAnimal=new animal(type,name);
        animals.add(newAnimal);
    }

    public void enqueue(animal newAnimal){
        animals.add(newAnimal);
    }

    public animal dequequeAny(){
        if(animals!=null && !animals.isEmpty()){
            return animals.pollFirst();
        }
        return null;
    }

    public animal dequeueDog(){
        animal oldestDog=null;
        for(int i=0;i<animals.size();i++){
           if(animals.get(i).type=="dog"){
               oldestDog=animals.get(i);
               animals.remove(i);
               break;
           }
        }
        return oldestDog;
    }

    public animal dequeueCat(){
        animal oldestCat=null;
        for(int i=0;i<animals.size();i++){
            if(animals.get(i).type=="cat"){
                oldestCat=animals.get(i);
                animals.remove(i);
                break;
            }
        }
        return oldestCat;
    }

    public static void main(String args[]){
        animalShelter as=new animalShelter();
        as.enqueue("cat","Tom");
        as.enqueue("cat","Jack");
        as.enqueue("dog","Jerry");
        as.enqueue("cat","Tim");
        as.enqueue("dog","Apple");

        as.dequequeAny();
        as.dequeueDog();
        as.dequeueCat();
    }

}
