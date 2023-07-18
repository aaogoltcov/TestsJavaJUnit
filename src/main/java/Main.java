
public class Main {
  public static void main(String[] args) {
    IntegerConverter number = new IntegerConverter(10);

    System.out.println(number.toBinary());
    System.out.println(number.toOctal());
    System.out.println(number.toHex());
  }
}