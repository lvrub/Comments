package net.commments.sample;

public class AttentetiveStudent implements Student {
    private final String name;

    public AttentetiveStudent(String name) {
        this.name = name;
    }

    public void learn(Subject subject) {

        subject.studiedBy(this);
    }

    public String name() {
        return this.name;

    }
}
