package main;

public class Holiday {
    public static void main(String[] args) {
        CurrentYear year = new CurrentYear(2023).next();
        System.out.println(year);
    }

    public static class CurrentYear {
        int year;

        public CurrentYear(int year) {
            this.year = year;
        }

        public CurrentYear next() {
            return new CurrentYear(++this.year);
        }

        @Override
        public String toString() {
            return "C новым " + year + " годом!!!";
        }
    }
}
