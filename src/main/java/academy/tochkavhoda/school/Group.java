package academy.tochkavhoda.school;

import java.util.*;

public class Group {

    private String name;
    private String room;
    private List<Trainee> trainees;

    public Group(String name, String room) {
        if (name == null || name.isBlank()) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        }

        if (room == null || room.isBlank()) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        }

        this.name = name;
        this.room = room;
        this.trainees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        }
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        if (room == null || room.isBlank()) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        }
        this.room = room;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }

    public void removeTrainee(Trainee trainee) {
        if (!trainees.remove(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public void removeTrainee(int index) {
        if (index < 0 || index >= trainees.size()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        trainees.remove(index);
    }

    public Trainee getTraineeByFirstName(String firstName) {
        return trainees.stream()
                .filter(t -> t.getFirstName().equals(firstName))
                .findFirst()
                .orElseThrow(() ->
                        new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND));
    }

    public Trainee getTraineeByFullName(String fullName) {
        return trainees.stream()
                .filter(t -> t.getFullName().equals(fullName))
                .findFirst()
                .orElseThrow(() ->
                        new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND));
    }

    public void sortTraineeListByFirstNameAscendant() {
        trainees.sort(Comparator.comparing(Trainee::getFirstName));
    }

    public void sortTraineeListByRatingDescendant() {
        trainees.sort(Comparator.comparing(Trainee::getRating).reversed());
    }

    public void reverseTraineeList() {
        Collections.reverse(trainees);
    }

    public void rotateTraineeList(int positions) {
        Collections.rotate(trainees, positions);
    }

    public List<Trainee> getTraineesWithMaxRating() {

        if (trainees.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        int max = trainees.stream()
                .mapToInt(Trainee::getRating)
                .max()
                .getAsInt();

        List<Trainee> result = new ArrayList<>();

        for (Trainee t : trainees) {
            if (t.getRating() == max) {
                result.add(t);
            }
        }

        return result;
    }

    public boolean hasDuplicates() {

        Set<Trainee> set = new HashSet<>();

        for (Trainee t : trainees) {

            if (!set.add(t)) {
                return true;
            }

        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}