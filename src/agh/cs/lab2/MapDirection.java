package agh.cs.lab2;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;


    public String toString(MapDirection kierunek) {
        String a;
        switch (kierunek) {
            case NORTH:
                return a = "Północ";
            case SOUTH:
                return a = "Południe";
            case EAST:
                return a = "Wschód";
            case WEST:
                return a = "Zachód";
            default:
                return a = "";

        }


    }

    public MapDirection next() {
        MapDirection a;
        switch (this) {
            case NORTH:
                a = EAST;
                return a;
            case SOUTH:
                a = WEST;
                return a;
            case WEST:
                a = NORTH;
                return a;
            case EAST:
                a = SOUTH;
                return a;
            default:
                a = null;
                return a;
        }

    }

    public MapDirection previous() {
        MapDirection a;
        switch (this) {
            case NORTH:
                a = WEST;
                return a;
            case SOUTH:
                a = EAST;
                return a;
            case WEST:
                a = SOUTH;
                return a;
            case EAST:
                a = NORTH;
                return a;
            default:
                a = null;
                return a;
        }

    }


}