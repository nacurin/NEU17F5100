Assignment3_YehongSun

---

【1】
Find the error in the following code and explain in few lines why it is wrong. (Score 1)
Here is the code.

Answer:
a) Two constructors with same number of input parameter.
The "public Book(int size)" and "public Book(int price)" both have one input parameter. The java constructor will have error when dealing this.
b) We cannot use "super()" in the class because the Book class has no father class.
c)The "setName" function is wrong and it's not working. It does not need to return anything. And the inner paramter "name" should be assigned by the input. Thus, It should be "this.name = name" to replace the current content.
```java
public class Book{
		int size;
		int price;
		String name;
	
		public Book(int size){  
		/*
		a) Two constructors with same number of input parameter. The "public Book(int size)" and "public Book(int price)" both have one input parameter. The java constructor will have error when dealing this.
		*/
			this.size = size;
		}
	
		public Book(int size, int price, String name){
			super();//We cannot use "super()" in the class because the Book class has no father class.
			this.size = size;
			this.price = price;
			this.name = name;
		}
	
		public Book(int price){
			this.price = price;
		}
	
		public setName(String name){ 
		/*
		c)The "setName" function is wrong and it's not working. It does not need to return anything. And the inner paramter "name" should be assigned by the input. Thus, It should be "this.name = name" to replace the current content.
		*/
			return name;
		}
	}
```

【2】
Find the error in the following code and explain in few lines why it is wrong. (Score 1)
Here is the code.

Answer:
a)The two functions should add public/private at the front of the function.
b)The return type of getTime function should be String. "void" means no return type and content.
c)The content in the getTime function should be "this.time;". "time" means the local variable in the local function.
d)The content in the setTime function should be "this.time = t;". We should use "this.time" to call the inner variable.

```java
	class Clock{
   		String time;
   		
    	void getTime(){ 
    	/*a)The two functions should add public/private at the front of the function. b)The return type of getTime function should be String. c)The content in the getTime function should be "this.time;". */
        	return time;
     	}
     	
    	void setTime(String t){
    	/*
    	d)The content in the setTime function should be "this.time = t;". We should use "this.time" to call the inner variable.
    	*/
        	time = t ;
    	}
	}
```

【3】
Write a Java function to remove vowels in a string. (Score 2)
i. The function should take a string as input.
ii. Should return the input string after omitting the vowels.
Here is the prototype you can work with

Answer:
```
public String removeVowelsFromString(String input){
	if(input == null || input.length() == 0)    return "";
    String vowels = "aeiouAEIOU";
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < input.length(); i++){
        if(vowels.contains(input.charAt(i) + "")){
            continue;
        }else{
            sb.append(input.charAt(i));
        }
    }
    return sb.toString();
}
```
【4】
Write a java function to check if two strings are Anagrams or not. (Score 2)
i. The function should take two input strings.
ii. Should return a boolean ‘true’ if the inputs are Anagrams else return ‘false’.

Answer:
```
public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())    return false;
        
        int[] alphabet = new int[26];
        int[] alphabet2 = new int[26];
        for(int i = 0; i < s.length(); i++){
            char chr = s.charAt(i);
            if(chr < 'a'){
                alphabet[chr - 'A']++;
            }else{
                alphabet2[chr - 'a']++;
            }
        }
        for(int i = 0; i < t.length(); i++){
            char chr = t.charAt(i);
            if(chr < 'a'){
                alphabet[chr - 'A']--;
            }else{
                alphabet2[chr - 'a']--;
            }
        }
        for(int temp : alphabet){
            if(temp != 0)   return false;
        }
        for(int temp : alphabet2){
            if(temp != 0)   return false;
        }
        return true;
}
```
【5】
Create a calculator that can perform the following features. (Total Score 4)
i. The calculator should be able to perform Addition, subtraction, multiplication, division. (Score 2)
ii. Should be able to perform squareRoot, square, cube. (Score 1)
iii. Should be able to convert ‘Fahrenheit-Celsius’ , ‘Feet-Inches’. (Score 1)

Answer:
```
class calculator {
    
    public calculator(){
        
    }
    
    public double Addition(double a, double b){
        return a + b;
    }
    public double subtraction(double a, double b){
        return a - b;
    }
    public double multiplication(double a, double b){
        return a * b;
    }
    public double division(double a, double b){
        return b != 0? a/b : 0;
    }
    public double squareRoot(double a){
        return Math.sqrt(a);
    }
    public double square(double a){
        return a * a;
    }
    public double cube(double a){
        return Math.pow(a, 3);
    }
    public double FtoC(double a){
        return a * 9 / 5 + 32;
    }
    public double FtoI(double a){
        return a * 12;
    }
    public double[] quadratic(double a, double b, double c){
        double[] rst = new double[2];
        double delta = b*b-4*a*c;
        if(delta < 0){
            return rst;
        }else{
            rst[0] = (-b + Math.sqrt(delta))/ 2*a;
            rst[1] = (-b - Math.sqrt(delta))/ 2*a;
        }
        return rst;
    }
}
```