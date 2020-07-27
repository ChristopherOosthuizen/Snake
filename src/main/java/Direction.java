public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public void updatePos(int[] pos) {
        switch (this) {
            case NORTH:
                pos[1]--;
                break;
            case SOUTH:
                pos[1]++;
                break;
            case WEST:
                pos[0]--; break;
            case EAST:
                pos[0]++;
                break;
        }
    }
    public boolean canChange(Direction direction){
        switch(direction){
            case NORTH:
            case SOUTH: return this == WEST|| this == EAST;
            default: return this == NORTH|| this == SOUTH;
        }
    }
}