package Length_of_Last_Word;

public class Length_of_Last_Word {
	public static int lengthOfLastWord(String s) {
        int ret=0;
        String receive[]=s.split(" ");
        if(receive.length==0) return ret;
        ret=receive[receive.length-1].length();
        return ret;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="hello world";
		System.out.println(lengthOfLastWord(input));
	}

}
