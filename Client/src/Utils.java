
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.*;


public class Utils {
    
    public static void displayHome() throws IOException{
        System.out.println("Hello, welcome on our tchat !");
        System.out.println("Please enter a nickname..");

        Scanner sc = App.getScanner();

        String pseudo = sc.next();

        System.out.println("Please enter now the adress of the server..");
        String address = sc.next();

        System.out.println("Finally enter the port you are going to use..");
        String port = sc.next();

        if(verifyInputs(pseudo, address, port)){
            connect(pseudo,address,port);
        }
        else{
            System.out.println("Your inputs are incorrect !! Please try again");
            displayHome();
        }


    }

    public static boolean verifyInputs(String pseudo, String address, String port) {
        // Check pseudo for special characters
        if (!pseudo.matches("^[a-zA-Z0-9_]+$") && pseudo.length() < 20) {
            return false;
        }
        // Check address for invalid characters
        if (!address.matches("^[0-9.:]+$")) {
            return false;
        }
        // Check port for non-numeric characters
        if (!port.matches("^[0-9]+$")) {
            return false;
        }
        return true;
    }

    public static void connect(String pseudo,String adress,String port) throws IOException {
        // for later with the server connection 

        // also add verification if the nickname is already taken or not

        displayConnectedUsers();
    }

    public static void displayConnectedUsers() throws IOException {
        ArrayList<User> users = readUsersFromJson("users.json");

        System.out.println("Users currently connected: ");
        for (User user : users) {
            System.out.println(User.toString(user));
        }
    }

    private static ArrayList<User> readUsersFromJson(String string) {
        return null;
    }

    public static void userConnected(User user) {
        System.out.println("User connected: " + user.getPseudo());
    }
    public static void userDisconnected(User user) {
        System.out.println("User disconnected: " + user.getPseudo());
    }

    /* public static ArrayList<User> readUsersFromJson(String filename) throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(filename);
        Type userListType = new TypeToken<ArrayList<User>>(){}.getType();
        ArrayList<User> users = gson.fromJson(reader, userListType);
        reader.close();
        return users;
        
    } */
    
    /* public static ArrayList<User> readUsersFromJson(String filename) throws IOException, JSONException {
        ArrayList<User> users = new ArrayList<>();
        JSONTokener tokener = new JSONTokener(new FileReader(filename));
        JSONArray jsonArray = new JSONArray(tokener);
        
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            User user = new User();
            user.setId(jsonObject.getInt("id"));
            user.setName(jsonObject.getString("name"));
            user.setAge(jsonObject.getInt("age"));
            users.add(user);
        }
        
        return users;
    } */

   /*  public static ArrayList<String> displayListUser(String nameUser, String idUser) throws IOException {
        String message = ("msg : bonjour")
        String[][] users = { {"user1", "4454564"}, {"user2","1561561651"} };
        ArrayList<String> userList = new ArrayList<>();
    
        for(int i=0; i < users.length; i++){
            userList.add(users[i][0]);
       }

       try {
        
       } catch (Exception e) {
        // TODO: handle exception
       }
    
       return userList;
    } */
    

}
