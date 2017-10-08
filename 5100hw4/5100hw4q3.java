class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        IpAddress ip = new IpAddress("216.27.6.136");
        System.out.println(ip.getDottedDecimal());
        System.out.println(ip.getOctet(4));
        System.out.println(ip.getOctet(1));
        System.out.println(ip.getOctet(3));
        System.out.println(ip.getOctet(2));
    }
}
class IpAddress{
    protected String dottedDecimal;
    protected int firstOctet;
    protected int secondOctet;
    protected int thirdOctet;
    protected int fourthOctet;
    public IpAddress(String ip){
        this.dottedDecimal = ip;
        int count = 0;
        for(int i = 0; i < ip.length(); i++){
            if(ip.charAt(i) == '.'){
                count++;
                continue;
            }
            if(count == 0){
                int num = ip.charAt(i) - '0';
                firstOctet = firstOctet * 10 + num;
            }else if(count == 1){
                int num = ip.charAt(i) - '0';
                secondOctet = secondOctet * 10 + num;
            }else if(count == 2){
                int num = ip.charAt(i) - '0';
                thirdOctet = thirdOctet * 10 + num;
            }else{
                int num = ip.charAt(i) - '0';
                fourthOctet = fourthOctet * 10 + num;
            }
        }
    }
    public String getDottedDecimal(){
        return this.dottedDecimal;
    }
    
    public int getOctet(int index){
        if(index == 0){
            return firstOctet;
        }else if(index == 1){
            return secondOctet;
        }else if(index == 2){
            return thirdOctet;
        }else{
            return fourthOctet;
        }
    }
    
}