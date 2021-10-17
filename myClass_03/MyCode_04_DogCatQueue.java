package myClass_03;
import java.util.LinkedList;
import java.util.Queue;


/**
 * @author shapemind
 * @create 2021-10-17 17:14
 */
/*
实现一种狗猫队列的结构，要求如下：
用户可以调用add方法将cat类或dog类的实例放入队列中；
用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出；
用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出；
用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例；
用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例；
用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
 */
public class MyCode_04_DogCatQueue {
    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    public static class PetEnterQueue {
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return this.pet;
        }

        public long getCount() {
            return this.count;
        }

        public String getEnterPetType() {
            return this.pet.getPetType();
        }
    }

    public static class CatDogQueue {
        private Queue<PetEnterQueue> catQ;
        private Queue<PetEnterQueue> dogQ;
        private long index;

        public CatDogQueue() {
            catQ = new LinkedList<PetEnterQueue>();
            dogQ = new LinkedList<PetEnterQueue>();
            this.index = 0;
        }

        public void add(Pet pet) {
            if (pet.getPetType().equals("dog")) {
                dogQ.add(new PetEnterQueue(pet, index++));
            } else if (pet.getPetType().equals("cat")) {
                catQ.add(new PetEnterQueue(pet, index++));
            } else {
                throw new IllegalArgumentException("Error, not cat or dog!");
            }
        }

        public Pet pollAll() {
            if (!this.catQ.isEmpty() && !this.dogQ.isEmpty()) {
                if (this.catQ.peek().count < this.dogQ.peek().count) {
                    return this.catQ.poll().getPet();
                } else {
                    return this.dogQ.poll().getPet();
                }
            } else if (!this.catQ.isEmpty()) {
                return this.catQ.poll().getPet();
            } else if (!this.catQ.isEmpty()) {
                return this.dogQ.poll().getPet();
            } else {
                throw new RuntimeException("The CatDogQueue is empty");
            }
        }

        public Dog dogPoll() {
            if (!this.dogQ.isEmpty()) {
                return (Dog) this.dogQ.poll().getPet();
            } else {
                throw new RuntimeException("The dogQueue is empty!");
            }
        }

        public Cat catPoll() {
            if (!catQ.isEmpty()) {
                return (Cat) this.catQ.poll().getPet();
            } else {
                throw new RuntimeException("The catQueue is empty!");
            }
        }

        public boolean isEmpty() {
            return this.catQ.isEmpty() && this.dogQ.isEmpty();
        }

        public boolean isDogQueueEmpty() {
            return this.dogQ.isEmpty();
        }

        public boolean isCatQueueEmpty() {
            return this.catQ.isEmpty();
        }

    }

    public static void main(String[] args) {
        CatDogQueue test = new CatDogQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
        System.out.println("===========分隔线============");
        while (!test.isDogQueueEmpty()) {
            System.out.println(test.dogPoll().getPetType());
        }
    }
}
