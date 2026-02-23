
public class DoOp {
    public static String operate(String[] args) {

        if (args.length != 3) {
            return "Error";
        }
        int first, second;
        String op = args[1];
        try {
            first = Integer.parseInt(args[0]);
            second = Integer.parseInt(args[2]);
            switch (op) {
                case "+":
                    return Integer.toString(first + second);
                case "-":
                    return Integer.toString(first - second);
                case "*":
                    return Integer.toString(first * second);
                case "/":
                    return Integer.toString(first / second);
                case "%":
                    return Integer.toString(first % second);
                default:
                    return "Error" ; 
            }

        } catch (Exception e) {
            return "Error" ;
        }
        
    }

    public static void main(String[] args) {
        System.out.println(DoOp.operate(new String[] { "1", "+", "2" }));
        System.out.println(DoOp.operate(new String[] { "1", "-", "1" }));
        System.out.println(DoOp.operate(new String[] { "1", "%", "0" }));
        System.out.println(DoOp.operate(args));
    }
}