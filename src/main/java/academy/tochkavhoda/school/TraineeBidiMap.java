package academy.tochkavhoda.school;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.util.Set;

public class TraineeBidiMap {

    private BidiMap<String, Trainee> map;

    public TraineeBidiMap() {
        map = new DualHashBidiMap<>();
    }

    public void addTrainee(Trainee trainee, String passport) {

        if (map.containsValue(trainee)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        }

        if (map.containsKey(passport)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_PASSPORT);
        }

        map.put(passport, trainee);
    }

    public void replaceTraineePassport(Trainee trainee, String passport) {

        if (!map.containsValue(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        if (map.containsKey(passport)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_PASSPORT);
        }

        map.removeValue(trainee);
        map.put(passport, trainee);
    }

    public void removeTrainee(Trainee trainee) {

        if (!map.containsValue(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        map.removeValue(trainee);
    }

    public void removeTraineeByPassport(String passport) {

        if (!map.containsKey(passport)) {
            throw new TrainingException(TrainingErrorCode.PASSPORT_NOT_FOUND);
        }

        map.remove(passport);
    }

    public Trainee getTraineeByPassport(String passport) {

        if (!map.containsKey(passport)) {
            throw new TrainingException(TrainingErrorCode.PASSPORT_NOT_FOUND);
        }

        return map.get(passport);
    }

    public String getPassportByTrainee(Trainee trainee) {

        if (!map.containsValue(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        return map.getKey(trainee);
    }

    public Set<Trainee> getAllTrainees() {
        return map.values();
    }

    public Set<String> getAllPassports() {
        return map.keySet();
    }

    public boolean hasAnybodyPassport(String passport) {
        return map.containsKey(passport);
    }

    public int getTraineesCount() {
        return map.size();
    }

}