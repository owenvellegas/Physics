import java.util.ArrayList;

public class MergeSort
{
    public static <Result extends Comparable<Result>> void mergeSort
            (ArrayList<Result> arrayList)
    {
        if (arrayList.size() <= 1)
        {
            return;
        }
        int mid = arrayList.size() / 2;
        ArrayList<Result> leftHalf = new ArrayList<Result>(arrayList.subList
                (0, mid));
        ArrayList<Result> rightHalf = new ArrayList<Result>(arrayList.subList
                (mid, arrayList.size()));

        // Recursively sort each half
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // Merge the sorted halves
        merge(arrayList, leftHalf, rightHalf);

    }

    private static <Result extends Comparable<Result>> void merge(ArrayList<Result> arrayList,
                                                        ArrayList<Result> leftHalf,
                                                        ArrayList<Result> rightHalf)
    {
        int leftIndex = 0, rightIndex = 0, mergedIndex = 0;

        // Merge the two halves while comparing their elements
        while (leftIndex < leftHalf.size() && rightIndex < rightHalf.size())
        {
            if (leftHalf.get(leftIndex).compareTo(rightHalf.get(rightIndex)) <=
                    0)
            {
                arrayList.set(mergedIndex, leftHalf.get(leftIndex));
                leftIndex++;
            }
            else
            {
                arrayList.set(mergedIndex, rightHalf.get(rightIndex));
                rightIndex++;
            }
            mergedIndex++;
        }

        // Copy any remaining elements from the left half
        while (leftIndex < leftHalf.size())
        {
            arrayList.set(mergedIndex, leftHalf.get(leftIndex));
            leftIndex++;
            mergedIndex++;
        }

        // Copy any remaining elements from the right half
        while (rightIndex < rightHalf.size())
        {
            arrayList.set(mergedIndex, rightHalf.get(rightIndex));
            rightIndex++;
            mergedIndex++;
        }
    }

}
