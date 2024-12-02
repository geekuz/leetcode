package leetcode1;

import java.util.ArrayList;

public class FindTheWinner {
/*    public int findTheWinner(int n, int k) {
        int winner = 0;


        for (int i = 1; i <= n; i++) {
            winner = (winner + k) % i;
        }

        return winner + 1;
    }*/

    public static int findTheWinner(int n, int k) {
        ArrayList<Integer> circle = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            circle.add(i);
        }
        int cur_ind = 0;

        while (circle.size() > 1) {
            int next_to_remove = (cur_ind + k - 1) % circle.size();
            circle.remove(next_to_remove);
            cur_ind = next_to_remove;
        }

        return circle.get(0);
    }

    public static void main(String[] args) {
        int theWinner = findTheWinner(5, 2);
        System.out.println(theWinner);
    }
}