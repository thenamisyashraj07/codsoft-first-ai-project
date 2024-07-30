package CHATBOT;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleChatbot extends JFrame {

    private JTextArea chatArea;
    private JTextField userInputField;
    private JButton sendButton;

    public SimpleChatbot() {
        
        setTitle("AI Chatbot");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(400, 400));

        
        JLabel backgroundLabel = new JLabel(new ImageIcon("D:\\6418e266ecb0ddc9b99c94ad.gif"));
        backgroundLabel.setBounds(0, 0, 1500, 600);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));
        chatArea.setForeground(Color.DARK_GRAY);
        chatArea.setOpaque(false);
        chatArea.setBorder(new EmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBounds(0, 0, 800, 800);
        layeredPane.add(scrollPane, JLayeredPane.PALETTE_LAYER);

        add(layeredPane, BorderLayout.CENTER);

        
        JPanel inputPanel = new JPanel(new BorderLayout());
        userInputField = new JTextField();
        userInputField.setFont(new Font("Arial", Font.PLAIN, 16));
        sendButton = new JButton("Send");
        sendButton.setFont(new Font("Arial", Font.BOLD, 16));
        sendButton.setBackground(new Color(30, 144, 255));
        sendButton.setForeground(Color.WHITE);
        inputPanel.add(userInputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(inputPanel, BorderLayout.SOUTH);

        
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleUserInput();
            }
        });

        
        userInputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleUserInput();
            }
        });
    }

    private void handleUserInput() {
        String userInput = userInputField.getText().trim();
        if (!userInput.isEmpty()) {
            chatArea.append("You: " + userInput + "\n");
            String botResponse = getResponse(userInput);
            chatArea.append("Bot: " + botResponse + "\n");
            userInputField.setText("");
        }
    }

    private String getResponse(String input) {
    
        input = input.toLowerCase();
        if (input.contains("hello") || input.contains("hi")) {
            return "Hello! How can I help you today?";
        } else if (input.contains("how are you")) {
            return "I'm a bot, so I don't have feelings, but thanks for asking!";
        } else if (input.contains("what is your name")) {
            return "I'm a simple chatbot created to assist you.";
        } else if (input.contains("bye") || input.contains("goodbye")) {
            return "Goodbye! Have a great day!";
        } else if (input.contains("what time is it")) {
            return "I don't have the ability to check the time. You might want to look at a clock.";
        } else if (input.contains("tell me a joke")) {
            return "Why don't scientists trust atoms? Because they make up everything!";
        } else if (input.contains("what's the weather")) {
            return "I can't check the weather right now. You should check a weather app or website.";
        } else if (input.contains("help") || input.contains("support")) {
            return "I'm here to assist you. What do you need help with?";
        } else if (input.contains("how old are you")) {
            return "I don't have an age. I'm just a program!";
        } else if (input.contains("what can you do")) {
            return "I can chat with you and provide basic responses to your questions.";
        } else if (input.contains("who created you")) {
            return "I was created by a developer to assist with various tasks.";
        } else if (input.contains("where are you from")) {
            return "I exist on your computer or device. I don't have a physical location.";
        } else if (input.contains("what is the meaning of life")) {
            return "That's a profound question. Many people believe it's to find happiness and purpose.";
        } else if (input.contains("what is your favorite color")) {
            return "As a program, I don't have personal preferences or feelings.";
        } else if (input.contains("can you sing")) {
            return "I wish I could! But I can provide lyrics if you need.";
        } else if (input.contains("how can I contact support")) {
            return "You can usually contact support through the official website or help center.";
        } else if (input.contains("what is the capital of france")) {
            return "The capital of France is Paris.";
        } else if (input.contains("who is the president of the united states")) {
            return "As of my last update, Joe Biden is the President of the United States.";
        } else if (input.contains("what is 2 + 2")) {
            return "2 + 2 equals 4.";
        } else if (input.contains("what's your favorite movie")) {
            return "I don't watch movies, but I can help you find information about them.";
        } else if (input.contains("what's the latest news")) {
            return "I can't browse the web right now. You might want to check a news website or app.";
        } else {
            return "I'm not sure how to respond to that. Can you try asking something else?";
        }
    }
        

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleChatbot chatbot = new SimpleChatbot();
                chatbot.setVisible(true);
            }
        });
    }
}
