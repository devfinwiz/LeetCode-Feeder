class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashMap<Integer, ArrayList<Integer>> xMap = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> yMap = new HashMap<>();
        for (int[] obst : obstacles) {
            xMap.putIfAbsent(obst[0], new ArrayList<>());
            xMap.get(obst[0]).add(obst[1]);
            yMap.putIfAbsent(obst[1], new ArrayList<>());
            yMap.get(obst[1]).add(obst[0]);
        }
        int x = 0, y = 0;
        int newX, newY;
        int direct = 1;
        int maxDist = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) {
                direct = (direct % 4) + 1;
                continue;
            }
            else if (commands[i] == -2) {
                direct = (direct + 2) % 4 + 1;
                continue;
            }
            for (int j = 0; j < commands[i]; j++) {
                newX = x;
                newY = y;
                if (direct == 1) newY++;
                else if (direct == 2) newX++;
                else if (direct == 3) newY--;
                else newX--;
                boolean blocked = false;
                if (newX == x) {
                    if (yMap.containsKey(newY) && yMap.get(newY).contains(newX)) {
                        blocked = true;
                    }
                }
                if (newY == y) {
                    if (xMap.containsKey(newX) && xMap.get(newX).contains(newY)) {
                        blocked = true;
                    }
                }
                if (blocked) break;
                x = newX;
                y = newY;
                maxDist = Math.max(maxDist, x * x + y * y);
            }
        }
        return maxDist;
    }
}