import java.util.Scanner;

public class WordPalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        String reverse = new StringBuilder(word).reverse().toString();

        if (word.equals(reverse))
            System.out.println(reverse + " - palindrome");
        else
            System.out.println(reverse + " - not a palindrome");
    }
}