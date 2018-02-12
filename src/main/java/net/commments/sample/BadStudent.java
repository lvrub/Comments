package net.commments.sample;

public class BadStudent implements Student {
    private final String name;

    public BadStudent(String name) {
        this.name = name;
    }

    public void learn(Subject subject) {
        System.out.println(this.name + "is sleeping...");

    }

    public String name() {
        return this.name;
    }
}
