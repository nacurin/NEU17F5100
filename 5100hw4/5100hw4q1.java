class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String q1 = "2-4A0r7-4k223fwer3s---f3sf";
        System.out.println("Q1 answer: " + licenseKey(q1, 4));
    }
    /*
        question1
    */
    public static String licenseKey(String str, int k){
        if(str == null || str.length() < 2)    return str;
        int len = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != '-')    len++;
        }
        int first = len % k;
        StringBuilder sb = new StringBuilder();
        int count = (first == 0 ? k : first);
        for(int i = 0; i < str.length(); i++){
            if(count == 0){
                count = k;
                sb.append("-");
            }  
            if(str.charAt(i) == '-')    continue;
            char c = str.charAt(i);
            if(c > 'a' && c < 'z')  c -= 32;
            sb.append(c);
            count--;
        }
        return sb.toString();
    }
}