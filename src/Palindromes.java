import java.util.Scanner;

public class Palindromes {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder palindrome = new StringBuilder();
		while(readInput(scan, palindrome)) {
			if(isPalindrome(palindrome.toString()))
				System.out.println("Palindrome");
			else
				System.out.println("Not a Palindrome");
		}
		scan.close();
	}	
	
	public static boolean readInput(Scanner scan, StringBuilder output) {
		if(scan.hasNextInt()) {
			int lines = scan.nextInt();
			scan.nextLine();
			for (int i = 0; i < lines; i++)
				output.append(scan.nextLine());
			normalize(output);
			return true;
		}
		return false;
	}
	
	public static void normalize(StringBuilder s) {
		int fillIndex = 0;
		for(int i = 0; i < s.length(); i++)	
			if(Character.isAlphabetic(s.charAt(i)))
				s.setCharAt(fillIndex++, Character.toLowerCase(s.charAt(i)));	
		s.setLength(fillIndex);
	}
	
	public static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++)
			if(s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		return true;
	}
}
