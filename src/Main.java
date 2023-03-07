import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] possibleNums = {1,2,3,4,5,6,7,8};
        ArrayList<ArrayList> possibleNums2 = new ArrayList<ArrayList>();
        ArrayList<ArrayList> perm = new ArrayList<ArrayList>();

        ArrayList<ArrayList> perm2;

        for(int i = 0; i < possibleNums.length; i++) {
            possibleNums2.add(new ArrayList<Integer>(Arrays.asList(possibleNums[i])));
        }

        perm2 = (ArrayList<ArrayList>) possibleNums2.clone();

        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < possibleNums2.size(); i++) {

                for (int x = 0; x < perm2.size(); x++) {
                    ArrayList<Integer> temp = (ArrayList<Integer>) possibleNums2.get(i).clone();
                    ArrayList<Integer> perm2C = (ArrayList<Integer>) perm2.get(x).clone();

                    temp.addAll(perm2C);

                    ArrayList<Integer> newPerm = temp;

                    perm.add(newPerm);

                }
            }
            perm2 = (ArrayList<ArrayList>) perm.clone();
            perm.clear();
        }

        ArrayList<ArrayList> perm3 = new ArrayList<>();
        for (int i = 0; i < perm2.size(); i++)
        {
            ArrayList<Integer> arr = perm2.get(i);
            boolean good = true;
            for (int j = 0; j < arr.size() - 1; j++)
            {
                int compare = arr.get(j);
                for (int k = j + 1; k < arr.size(); k++)
                {
                    if (compare == arr.get(k))
                    {
                        good = false;
                    }
                }

            }
            if (good)
            {
                perm3.add(arr);
            }
        }

        System.out.println(perm3);
        System.out.println(perm3.size());
    }
}
