package net.commments.sample;

public class AttentetiveStudent implements Student {
    private final String name;

    public AttentetiveStudent(String name) {
        this.name = name;
    }

    public void learn() {
        System.out.println(this.name + "is listening...");
    }

    public String name() {
        return this.name;

    }
}
