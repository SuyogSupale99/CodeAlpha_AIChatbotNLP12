import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AIChatbotNLP {

    // Function for simple NLP preprocessing
    public static String preprocessInput(String input) {
        input = input.toLowerCase();                 
        input = input.replaceAll("[^a-zA-Z0-9 ]", ""); 
        input = input.trim();                        
        return input;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Rule-based chatbot knowledge base
        Map<String, String> chatbot = new HashMap<>();

        chatbot.put("hello", "Hello! Welcome to the AI Chatbot.");
        chatbot.put("hi", "Hi there! How can I help you?");
        chatbot.put("how are you", "I am fine and ready to help you!");
        chatbot.put("what is your name", "I am a Java-based AI Chatbot.");
        chatbot.put("who created you", "I was created using Java programming.");
        chatbot.put("what is java", "Java is a powerful object-oriented programming language.");
        chatbot.put("what is ai", "AI stands for Artificial Intelligence.");
        chatbot.put("what is nlp", "NLP means Natural Language Processing used for understanding human language.");
        chatbot.put("what is machine learning", "Machine Learning allows systems to learn from data and improve automatically.");
        chatbot.put("bye", "Goodbye! Have a great day.");

        System.out.println("=======================================");
        System.out.println("   AI CHATBOT STARTED");
        System.out.println("=======================================");
        System.out.println("Type 'bye' to exit the chatbot.\n");

        while (true) {
            System.out.print("You: ");
            String userInput = sc.nextLine();

            // NLP preprocessing
            userInput = preprocessInput(userInput);

            // Exit condition
            if (userInput.equals("bye")) {
                System.out.println("Bot: " + chatbot.get("bye"));
                break;
            }

            boolean found = false;

            // Simple NLP keyword matching
            for (String key : chatbot.keySet()) {
                if (userInput.contains(key)) {
                    System.out.println("Bot: " + chatbot.get(key));
                    found = true;
                    break;
                }
            }

            // Default response
            if (!found) {
                System.out.println("Bot: Sorry, I don't understand that. Please ask something else.");
            }
        }

        sc.close();
    }
}