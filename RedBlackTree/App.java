package RedBlackTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args)  {
        RedBlackTree tree = new RedBlackTree();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while (true){
                try {
                    int value = Integer.parseInt(reader.readLine());
                    tree.add(value);
                    System.out.println("added");
                } catch (Exception ignored){}
            }
            
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}

