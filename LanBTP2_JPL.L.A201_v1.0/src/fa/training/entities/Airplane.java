package fa.training.entities;

public abstract class Airplane {
    protected String id;
    protected String model;
    protected double cruiseSpeed;
    protected double emptyWeight;
    protected double maxTakeoffWeight;

    public Airplane(String id, String model, double cruiseSpeed, double emptyWeight, double maxTakeoffWeight) {
        this.id = id;
        this.model = model;
        this.cruiseSpeed = cruiseSpeed;
        this.emptyWeight = emptyWeight;
        this.maxTakeoffWeight = maxTakeoffWeight;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public double getCruiseSpeed() {
        return cruiseSpeed;
    }

    public double getEmptyWeight() {
        return emptyWeight;
    }

    public double getMaxTakeoffWeight() {
        return maxTakeoffWeight;
    }

    public abstract String getFlyMethod();
}
