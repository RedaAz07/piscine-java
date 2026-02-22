public class Palindrome {
    public static boolean isPalindrome(String s) {
    if (s  == null){
        return false ;
    }

        StringBuilder k =   new StringBuilder(s) ; 
        k.reverse();
        return  s.toLowerCase().equals(k.toString().toLowerCase()) ;

    }
}