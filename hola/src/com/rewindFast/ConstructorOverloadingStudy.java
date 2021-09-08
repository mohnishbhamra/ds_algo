package com.rewindFast;

public class ConstructorOverloadingStudy {
    String name;

    public ConstructorOverloadingStudy() {
        this("some name");//this should be the first statement in the constructor who is using it
        System.out.println("created object");
    }

    public ConstructorOverloadingStudy(String assignedName) {
        System.out.println("created object with some assigned name-" + assignedName);
        this.name = assignedName;
    }

    public static void main(String[] args) {
        ConstructorOverloadingStudy obj = new ConstructorOverloadingStudy();
        System.out.println("from main-"+obj.name);
        ConstructorOverloadingStudy obj2 = new ConstructorOverloadingStudy("techie");
        System.out.println("from main-"+obj2.name);

    }
}
