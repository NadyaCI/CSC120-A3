import java.util.Scanner;
import java.util.Random;

class Conversation {
  public static void main(String[] arguments) {
    int rounds = 0;
    String sentence = "";
    String response = "";
    String[] transcript;
    Scanner input = new Scanner(System.in);

    System.out.println("How many rounds of conversation would you like?");
    rounds = input.nextInt();
    transcript = new String[2*rounds+1];
    transcript[0]= new String("Hello! What would you like to talk about?");
    System.out.println("Hello! What would you like to talk about?");
    sentence = input.nextLine();
    for (int i = 0; i<rounds; i++){
      sentence = input.nextLine();
      response = respond(sentence);
      transcript[2*i+1] = sentence;
      transcript[2*i+2] = response; 
      System.out.println(respond(sentence));
    }
    System.out.println("\nTranscript:");
    for (int i = 0; i<2*rounds+1; i++){
      System.out.println(transcript[i]);
    }
  }
  
  public static String respond(String sentence) {
    String[] mirrorWords = new String[] {"I", "I'm", "me", "am", "you", "your", "yours", "you're", "yourself", "my", "mine", "myself"};
    String[] replaceWords = new String[] {"you", "you're", "you", "are", "I", "my", "mine", "myself", "I'm", "your", "yours", "yourself"};
    String[] responses = new String[] {"I see.", "Mm-hmm.", "Very interesting.", "Wow."};
    String[] splitSent = sentence.split(" ");
    String responseSentence = "";
    Random random = new Random();
    int whichResponse = 0;
    boolean wordReplaced = false;
    boolean anyReplaced = false;

    for (int i = 0; i<splitSent.length; i++){
      for (int j = 0; j<mirrorWords.length; j++){
        if (splitSent[i].equalsIgnoreCase(mirrorWords[j]) && wordReplaced == false){
          splitSent[i] = replaceWords[j];
          wordReplaced = true;
          anyReplaced = true;
        }
      }
      wordReplaced = false;
    }

    if (anyReplaced == true){
      responseSentence = String.join(" ", splitSent);
    }
    else{
      whichResponse = random.nextInt(responses.length);
      responseSentence = responses[whichResponse];
    }
    return(responseSentence);
  }
}
