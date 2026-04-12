class Robot {
    int w, h;
    int posX = 0;
    int posY = 0;
    int direct = 0;
    boolean moved = false;
    int idx = 0;
    ArrayList<int[]> pos = new ArrayList<>();
    ArrayList<Integer> dir = new ArrayList<>();
    public Robot(int width, int height) {
        w = width;
        h = height;
        for (int i = 0; i < w; i++) {
            pos.add(new int[]{i, 0});
            dir.add(0);
        }
        for (int i = 1; i < h; i++) {
            pos.add(new int[]{w - 1, i});
            dir.add(1);
        }
        for (int i = w - 2; i >= 0; i--) {
            pos.add(new int[]{i, h - 1});
            dir.add(2);
        }
        for(int i = h - 2; i > 0; i--){
            pos.add(new int[]{0, i});
            dir.add(3);
        }
        dir.set(0, 3);
    }
    public void step(int num) {
        moved = true;
        idx = (idx + num) % pos.size();
        posX = pos.get(idx)[0];
        posY = pos.get(idx)[1];
        direct = dir.get(idx);
    }
    public int[] getPos() {
        return new int[]{posX, posY};
    }
    public String getDir() {
        if (!moved) return "East";
        if (direct == 0) return "East";
        if (direct == 1) return "North";
        if (direct == 2) return "West";
        return "South";
    }
}