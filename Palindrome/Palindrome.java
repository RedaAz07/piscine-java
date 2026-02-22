public class Palindrome {
    public static boolean isPalindrome(String s) {
        StringBuilder k =   new StringBuilder(s) ; 
        k.reverse();
        return  s.toLowerCase().equals(k.toString().toLowerCase()) ;

    }
}