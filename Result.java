import java.text.DecimalFormat;

public class Result implements Comparable<Result>
{

    private double densityOfCube;
    private String floatOrSink;
    private double liquidDensity;
    private String testName;
    private double liquidDisplaced;
    private double percentageOfCubeSunk;

    // create result object to store data
    // Each object of result class will be tied to an object and liquid

    public Result(BuoyancyData currentTest)
    {
        this.densityOfCube = currentTest.getObjectDensity();
        this.liquidDensity = currentTest.getLiquidDensity();
        this.testName = currentTest.getTestName();

        this.percentageOfCubeSunk = ((densityOfCube / liquidDensity) * 100);
        if (percentageOfCubeSunk > 100) percentageOfCubeSunk = 100;
    }
    public void densityComparison(BuoyancyData currentTest)
    {
        if (this.densityOfCube <= this.liquidDensity)
        {
            this.floatOrSink = "Floats";
        }
        else
        {
            this.floatOrSink = "Sinks";
        }
        if (this.floatOrSink.equals("Floats"))
        {
            double densityRatio = this.densityOfCube / this.liquidDensity;
            this.liquidDisplaced =
                    densityRatio * currentTest.getObjectVolume();
        }
        else
        {
            this.liquidDisplaced = currentTest.getObjectVolume();
        }
    }
    @Override
    public int compareTo(Result otherResult)
    {
        if (this.percentageOfCubeSunk < otherResult.percentageOfCubeSunk)
        {
            return -1;
        }
        else
        {
            if (this.percentageOfCubeSunk == otherResult.percentageOfCubeSunk)
            {
                if (this.densityOfCube / this.liquidDensity <
                        otherResult.densityOfCube / otherResult.liquidDensity)
                {
                    return -1;
                }
                else
                {
                    return 1;
                }
            }
            else
            {
                return 1;
            }
        }
    }
    @Override
    public String toString()
    {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        return "Result for " + testName + " was: " + floatOrSink
                + "\nLiquid displaced: " +
                (numberFormat.format(liquidDisplaced)) + "m^3"
                + "\nAmount of cube sank: " +
                (numberFormat.format(percentageOfCubeSunk)) + "%";
    }
}
