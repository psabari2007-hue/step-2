public class StudentResultCard {
    static class Student {
        String name;
        int[] marks;

        Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        void displayResult() {
            int sum = 0;

            for (int mark : marks) {
                sum += mark;
            }

            double average = sum / 3.0;
            char grade;

            if (average >= 75)
                grade = 'B';
            else if (average >= 60)
                grade = 'C';
            else if (average >= 40)
                grade = 'D';
            else
                grade = 'F';

            System.out.printf("%s: Average %.1f, Grade %c%n",
                    name.toUpperCase(), average, grade);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Asha", new int[]{80, 90, 70});
        Student s2 = new Student("Ravi", new int[]{60, 55, 50});

        s1.displayResult();
        s2.displayResult();
    }
}