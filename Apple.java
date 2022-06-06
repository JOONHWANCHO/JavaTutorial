public class Main {
  public static void main(String[] args) {
  
	//바구니에 사과를 담을 경우 한바구니에는 사과를 10개를 담을 수 있다.
    //사과가 31개일때 바구니수를 구하라.
    
    int basketSize = 9; // int b = c = 5
    int apple = 64;
    
    int basket = (apple%basketSize==0)? apple/basketSize : apple/basketSize+1;
    
    System.out.println("바구니수:" + basket);
    
  }
}