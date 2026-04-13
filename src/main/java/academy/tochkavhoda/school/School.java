package academy.tochkavhoda.school;

import java.util.*;

public class School {

    private String name;
    private int year;
    private Set<Group> groups;

    public School(String name, int year) {

        if (name == null || name.isBlank()) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        }

        this.name = name;
        this.year = year;
        this.groups = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name == null || name.isBlank()) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        }

        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) {

        for (Group g : groups) {
            if (g.getName().equals(group.getName())) {
                throw new TrainingException(TrainingErrorCode.DUPLICATE_GROUP_NAME);
            }
        }

        groups.add(group);
    }

    public void removeGroup(Group group) {

        if (!groups.remove(group)) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }

    }

    public void removeGroup(String name) {

        Group found = null;

        for (Group g : groups) {

            if (g.getName().equals(name)) {
                found = g;
                break;
            }

        }

        if (found == null) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }

        groups.remove(found);
    }

    public boolean containsGroup(Group group) {
        return groups.contains(group);
    }

}