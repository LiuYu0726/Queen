package com.liuyu;

import java.util.ArrayList;
import java.util.List;

public class TestQueen {
    private int[] row;
    private int[] column;
    private int[] cross1;
    private int[] cross2;
    private final static int HAS_NOT = 0;
    private final static int HAS = 1;


    List<int[]> queenList = new ArrayList<>();

    public TestQueen() {
        row = new int[8];
        column = new int[8];
        cross1 = new int[15];
        cross2 = new int[15];
    }

    private void clearOut() {
        for (int i = 0; i < 8; i++) {
            row[i] = column[i] = HAS_NOT;
        }
        for (int i = 0; i < 15; i++) {
            cross1[i] = cross2[i] = HAS_NOT;
        }
    }

    private void traversal(int r) {

        if (r > 7) {
            for (int[] ints : queenList) {
                System.out.print("(" + ints[0] + "," + ints[1] + ")");
            }
            System.out.println();
            return;
        }
        for (int c = 0; c < 8; c++) {
            if (row[r] == HAS_NOT) {
                if (this.column[c] == HAS_NOT) {
                    if (cross1[c + r] == HAS_NOT) {
                        if (cross2[r - c + 7] == HAS_NOT) {
                            column[c] = cross1[c + r] = cross2[r - c + 7] = HAS;
                            queenList.add(new int[]{r, c});
                            traversal(r + 1);
                            column[c] = cross1[c + r] = cross2[r - c + 7] = HAS_NOT;
                            queenList.remove(r);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TestQueen testQueen = new TestQueen();
        testQueen.clearOut();
        testQueen.traversal(0);
    }

}
