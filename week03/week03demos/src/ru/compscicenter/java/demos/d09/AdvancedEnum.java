package ru.compscicenter.java.demos.d09;

public class AdvancedEnum {

    public static void main(String[] args) {
//        Direction[] values = Direction.values();
//        for (Direction value : values) {
//            System.out.println(value);
//        }

        Direction up = Direction.forCode("U");
        System.out.println(up);
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;

        public String getCode() {
            return String.valueOf(name().charAt(0));
        }

        public Direction opposite() {
            switch (this) {
                case UP:
                    return DOWN;
                case DOWN:
                    return UP;
                case LEFT:
                    return RIGHT;
                case RIGHT:
                    return LEFT;
                default:
                    throw new IllegalStateException("Unexpected direction " + this);
            }
        }


        public static Direction forCode(String code) {
            for (Direction direction : values()) {
                if (direction.getCode().equals(code)) {
                    return direction;
                }
            }
            throw new IllegalArgumentException();
        }
    }
}
