public class MaxNet {

    public static int way_select(int[][] graf, int[] ability) {
        int[] way = new int[16];
        int num = 0, way_point = 1, way_ability = Integer.MAX_VALUE, way_next = 0;
        while (way_point != 8) {
            if (way_point == graf[num][0]) {
                way_next = num;
                way[num] = 1;
                if (way_ability > ability[num])
                    way_ability = ability[num];
                way_point = graf[way_next][1];
            }
            num++;
            if (way_point < graf[num - 1][0])
                num = 0;
        }
        way_clear(graf, ability, way, way_ability);
        return way_ability;
    }

    public static void way_clear(int[][] graf, int[] ability, int[] way, int way_ability) {
        int r = 0;
        for (int i = 0; i < 16; i++) {
            if (way[i] == 1)
                ability[i] -= way_ability;
            if (ability[i] == 0) {
                graf[i][0] = 0;
                graf[i][1] = 0;
            }
        }
        for (int i = 1; i < 8; i++) {
            for (int j = 0; j < 16; j++) {
                if (i == graf[j][0] || i == graf[j][1])
                    r++;
            }
            if (r == 1) {
                for (int j = 0; j < 16; j++) {
                    if (i == graf[j][0] || i == graf[j][1]) {
                        graf[j][0] = 0;
                        graf[j][1] = 0;
                    }
                }
            }
            r = 0;
        }
    }

    public static void main(String[] args) {

        int[][] graf = new int[][]{
                {1, 2}, {1, 3}, {1, 4}, {1, 5},
                {2, 3}, {2, 5}, {2, 8},
                {3, 4}, {3, 6},
                {4, 5}, {4, 6},
                {5, 7}, {5, 8},
                {6, 5}, {6, 7},
                {7, 8},
        };
        int[] ability = new int[]{32, 95, 75, 20, 5, 23, 16, 18, 6, 24, 9, 20, 94, 11, 7, 81};
        boolean traffic = true;
        int result = 0, n = 0;
        while (traffic) {
            result += way_select(graf, ability);
            for (int i = 0; i < 16; i++) {
                if (graf[i][0] == 0)
                    n++;
            }
            if (n == 16) {
                traffic = false;
                System.out.println("Your result: " + result);
            }
            n = 0;
        }
    }
}
