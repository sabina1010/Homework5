package com.company;

import java.util.Arrays;

public class Family {
    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother.getName() + " " + mother.getSurname() +
                ", father=" + father.getName() + " " + father.getSurname() +
                ", children=" + Arrays.deepToString(children) +
                ", pet=" + pet +
                '}';
    }

    public Family(Human mother, Human father) {
        this.pet = getPet();
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
        father.setFamily(this);
        mother.setFamily(this);
    }

    public void addChild(Human child) {
        if (child != null) {
            Human[] children = new Human[this.children.length + 1];
            for (int i = 0; i < this.children.length; i++) {
                children[i] = getChildren()[i];

            }
            children[children.length - 1] = child;
            setChildren(children);
            child.setFamily(this);
        } else {
            getChildren();

        }


    }

    public void deleteChild(int index) {
        if (index > getChildren().length - 1) {
            getChildren();
        } else {
            Human[] children = new Human[getChildren().length - 1];
            if (children.length == 0) {
                children = new Human[0];
            } else {
                for (int i = 0, j = 0; i < getChildren().length; i++) {
                    if (i == index) {
                        continue;
                    }
                    children[j++] = getChildren()[i];
                }
            }
            setChildren(children);
        }

    }

    public int countFamily() {
        return 2 + this.children.length;

    }

    public void greetPet() {
        System.out.println("Hello, " + pet.getNickName());
    }

    public void describePet() {
        String slyLevel = "";
        if (pet.getTrickLevel() > 50) {
            slyLevel = "very sly";
        } else {
            slyLevel = "almost not sly";
        }

        System.out.println("I have " + pet.getSpecies() + ", he is " + pet.getAge() + " years old, he is " + slyLevel);
    }


}
