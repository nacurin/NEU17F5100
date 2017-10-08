class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Course java = new Course("java");
        Student kid = new Student("kid", 1);
        java.registerStudent(kid);
        System.out.println(java.registered[0].name);
        System.out.println(intToRoman(412));
    }
    //Q5
    public static String intToRoman(int num) {
        int[] nums =      {1000,  900,  500,  400,  100,   90,  50,   40,   10,    9,   5,    4,   1};
        String[] romans = { "M", "CM",  "D", "CD",  "C", "XC", "L", "XL",  "X", "IX", "V", "IV", "I"};

        StringBuilder rst = new StringBuilder();
        while(num > 0){
            for(int i = 0; i < nums.length; i++){
                if(num - nums[i] >= 0){
                    num -= nums[i];
                    rst.append(romans[i]);
                    break;
                }
            }
        }
        return rst.toString();
    }
    //extra
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if(len % 2 == 1){
            return findKth(nums1, 0, nums2, 0, len / 2 + 1);
        } else {
            return (findKth(nums1, 0, nums2, 0, len / 2) + 
                    findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;  
        }
    }

    private int findKth(int[] A, int startA, int[] B, int startB, int k){
        if(startA == A.length) return B[startB + k - 1];
        if(startB == B.length) return A[startA + k - 1];
        if(k == 1) return Math.min(A[startA], B[startB]);

        int keyA = (startA + k / 2 - 1 < A.length)
                    ? A[startA + k / 2 - 1]
                    : Integer.MAX_VALUE;
        int keyB = (startB + k / 2 - 1 < B.length)
                    ? B[startB + k / 2 - 1]
                    : Integer.MAX_VALUE;
        if(keyA < keyB){
            return findKth(A, startA + k / 2, B, startB, k - k / 2);
        } else {
            return findKth(A, startA, B, startB + k / 2, k - k / 2);
        }
    }
}
//Q4
class Student {
    String name;
    int id;
    public Student(String str, int i){
        this.name = str;
        this.id = i;
    }
}

class Course {
    String name;
    int numberOfStudent;
    Student[] registered;
    public Course (String name){
        this.name = name;
        registered = new Student[10];
    }
    public Student[] getStudents(){
        return registered;
    }
    public boolean isFull(){
        return numberOfStudent == 10 ? true : false;
    }
    public void registerStudent(Student a){
        if(!isFull()){
            for(int i = 0; i < 10; i++){
                if(registered[i] == null){
                    numberOfStudent++;
                    registered[i] = a;
                    return;
                }
            }
        }
    }
}