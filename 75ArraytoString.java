package in.kgcoding;

class ArraytoString {
    public static void main(){
        String[] arr = new String[] {"Java",
                "is", "the", "easy", "language",
                  "to","understand"};
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
          sb.append(str).append(" ");
        }
        System.out.println(sb);
    }
}
