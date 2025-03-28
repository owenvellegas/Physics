import java.util.*;

public class Main
{

    public static final Map<String, Liquid> LIQUID_OPTIONS = Map.of(
            "1", new Liquid("Water", 1000.0),
            "2", new Liquid("Gasoline", 770.0),
            "3", new Liquid("Honey", 1360.0)
    );

    private static int counter = 0;

    public static void main(String[] args)
    {
        ArrayList<BuoyancyData> userTests = new ArrayList<BuoyancyData>();
        ArrayList<Result> sortedResults = new ArrayList<Result>();

        Scanner scnr = new Scanner(System.in);
        // intro to program
        System.out.println("Float or Sink Calculator");
        System.out.println("----------");
        System.out.println("Enter -1 to quit or enter any key to continue:");
        String userInput = scnr.next();

        while (!userInput.equals("-1"))
        {
            counter++;
            BuoyancyData userCubeData = getBuoyancyCalculation();
            userTests.add(userCubeData);
            Result userResult;
            userResult = new Result(userCubeData);
            userResult.densityComparison(userCubeData);

            userCubeData.printTest(userCubeData);
            System.out.println(userResult.toString());
            sortedResults.addLast(userResult);
            System.out.println(
                    "To test a new cube enter any key, to quit enter -1");
            userInput = scnr.next();
        }
        //print cube test data
        for (BuoyancyData currTest : userTests)
        {
            currTest.printTest(currTest);
            System.out.println();
        }
        MergeSort.mergeSort(sortedResults); //sort results arrayList
        //print sorted results list
        System.out.println("Displaying results from most to least buoyant");
        System.out.println("------");
        for (Result currResult : sortedResults)
        {
            System.out.println(currResult.toString());
            System.out.println();
        }
    }

    public static BuoyancyData getBuoyancyCalculation()
    {
        Scanner scnr = new Scanner(System.in);

        Liquid userLiquidChoice = getLiquidChoice(scnr);
        double cubeMass = getCubeMass(scnr);
        double cubeVolume = getCubeVolume(scnr);

        String testName = "test " + counter;

        return new BuoyancyData(cubeMass, cubeVolume, testName,
                userLiquidChoice);
    }

    private static Liquid getLiquidChoice(Scanner scanner)
    {
        String userLiquidChoice = "";
        // set density of liquid
        while (!LIQUID_OPTIONS.containsKey(userLiquidChoice))
        {
            System.out.println("Please choose from the following:");

            LIQUID_OPTIONS.forEach((key, value) ->
            {
                System.out.println("(" + key + ") " + value.name);
            });

            userLiquidChoice = scanner.nextLine();
        }
        return LIQUID_OPTIONS.get(userLiquidChoice);
    }
    private static double getCubeVolume(Scanner scnr)
    {
        double cubeVolume = 0;
        boolean volumeError = true;

        while (volumeError) {
            try
            {
                System.out.println("Choose cube volume in meters cubed:");
                cubeVolume = scnr.nextDouble();
                volumeError = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid input for volume." +
                        " Please enter a valid number");
                scnr.next();
            }
        }
        return cubeVolume;
    }

    private static double getCubeMass(Scanner scnr)
    {
        boolean massError = true;

        double cubeMass = 0;

        while (massError)
        {
            try
            {
                System.out.println("Choose cube mass in kilograms:");
                cubeMass = scnr.nextDouble();
                massError = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid input for mass." +
                        " Please enter a valid number");
                scnr.next();
            }
        }
        return cubeMass;
    }
}
