package ch.floriankaufmann.dummbbellonly;

public class Exercise {

    private int mId;
    private String mName;
    private String mSets;
    private String mReps;
    private int mStoredReps;
    private int mStoredWeight;
    private String mLink;

    public int getStoredWeight() {
        return mStoredWeight;
    }

    public void setStoredWeight(int storedWeight) {
        mStoredWeight = storedWeight;
    }

    public int getStoredReps() {
        return mStoredReps;
    }

    public void setStoredReps(int storedReps) {
        mStoredReps = storedReps;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public Exercise() {

    }

    public Exercise(String name, String sets, String reps,int storedReps, int storedWeight, String link) {
        mName = name;
        mSets = sets;
        mReps = reps;
        mStoredReps = storedReps;
        mStoredWeight = storedWeight;
        mLink = link;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setSets(String sets) {
        mSets = sets;
    }

    public void setReps(String reps) {
        mReps = reps;
    }

    public void setLink(String link) {
        mLink = link;
    }

    public Exercise(int id, String name, String sets, String reps,int storedReps, int storedWeight, String link) {
        mId = id;

        mName = name;
        mSets = sets;
        mReps = reps;
        mStoredReps = storedReps;
        mStoredWeight = storedWeight;
        mLink = link;
    }



    public String getLink() {
        return mLink;
    }

    public String getName() {
        return mName;
    }

    public String getSets() {
        return mSets;
    }

    public String getReps() {
        return mReps;
    }
}
