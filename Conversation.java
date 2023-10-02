import java.util.Scanner;

class Conversation {
  public static void main(String[] arguments) {
    int rounds = 0;
    String sentence = "";

    Scanner input = new Scanner(System.in);
    System.out.println("How many rounds of conversation would you like?");
    rounds = input.nextInt();
    //System.out.println("hi" + rounds);
    for (int i = 0; i<rounds; i++){
      System.out.println("What would you like to talk about?");
      sentence = input.nextLine();

    }
  }
}
