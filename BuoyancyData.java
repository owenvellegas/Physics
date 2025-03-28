import java.text.DecimalFormat;

public class BuoyancyData
{
    private double objectDensity;
    private double mass;
    private double volume;
    private String testName;
    private String liquidChoice;
    private double liquidDensity;

    public BuoyancyData(double mass, double volume, String name, Liquid liquid)
    {
        this.mass = mass;
        this.volume = volume;
        this.objectDensity = (mass/volume);
        this.testName = name;
        this.liquidChoice = liquid.name;
        this.liquidDensity = liquid.density;
    }
    public double getObjectDensity()
    {
        return this.objectDensity;
    }
    public double getObjectVolume() { return this.volume; }
    public double getLiquidDensity()
    {
        return this.liquidDensity;
    }
    public String getTestName() { return this.testName; }

    public void printTest(BuoyancyData currTest)
    {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        System.out.println("Test data for " + this.testName + ":");
        System.out.println("---------");
        System.out.println("Liquid choice: " + this.liquidChoice);
        System.out.println("Cube Mass: " + this.mass + "kg");
        System.out.println("Cube Volume: " + this.volume + "m^3");
        System.out.println("Cube Density: " + numberFormat.format(this.objectDensity) + "kgm^3");
        System.out.println("Liquid Density: " + this.liquidDensity + "kgm^3");
    }
}