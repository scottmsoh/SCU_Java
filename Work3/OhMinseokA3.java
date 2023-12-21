
    import java.util.Arrays;
    import java.util.Scanner;

    public class OhMinseokA3 {

        public static void main(String[] args) {
            // Create a scanner object for user input
            Scanner scanner = new Scanner(System.in);

            // Prompt and receive string and integer inputs from the user
            System.out.print("Anagram String 1 = ");
            String str1 = scanner.nextLine();
            System.out.print("Anagram String 2 = ");
            String str2 = scanner.nextLine();
            System.out.print("Substring Extraction String 3 = ");
            String str3 = scanner.nextLine();
            System.out.print("Starting index of substring = ");
            int start = scanner.nextInt();
            System.out.print("Ending index of substring = ");
            int end = scanner.nextInt();

            // Check and display if the first two strings are anagrams
            if (isAnagram(str1, str2)) {
                System.out.print("\n");
                System.out.println(str1 + " and " + str2 + " are anagrams of each other.");
            } else {
                System.out.print("\n");
                System.out.println(str1 + " and " + str2 + " are not anagrams of each other.");
            }

            // Extract and display the substring or show an error for invalid indices
            try {
                String substring = extractSubstring(str3, start, end);
                System.out.println(" ");
                System.out.println("The extracted substring is: " + substring);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("\nProgram Completed.");
            // Close the scanner
            scanner.close();
        }

        public static boolean isAnagram(String str1, String str2) {
            // Convert strings to lowercase and remove whitespaces including punctuations (Thanks, Tuhina revise it!)
            str1 = str1.toLowerCase().replaceAll("[^a-z]", "");
            str2 = str2.toLowerCase().replaceAll("[^a-z]", "");

            // Convert strings to character arrays and sort them
            char[] chars1 = str1.toCharArray();
            char[] chars2 = str2.toCharArray();

            Arrays.sort(chars1);
            Arrays.sort(chars2);

            // Return true if sorted character arrays are equal
            return Arrays.equals(chars1, chars2);
        }

         // Extracts a substring from a string based on provided start and end indices.
        public static String extractSubstring(String s, int start, int end) {
            if (start < 0 || end > s.length() || start > end) {
                throw new IllegalArgumentException("\nUsage: java Enter a valid index within the given string length.");
            }
            // Use char array to build the substring without using the substring method
            char[] originalChars = s.toCharArray();
            char[] subChars = new char[end - start + 1];

            for (int i = start; i <= end; i++) {
                subChars[i-start] = originalChars[i];
            }

            // Convert char array to string without using String constructor directly
            StringBuilder substring = new StringBuilder();
            for (char c : subChars) {
                substring.append(c);
            }
            return substring.toString();
        }
    }