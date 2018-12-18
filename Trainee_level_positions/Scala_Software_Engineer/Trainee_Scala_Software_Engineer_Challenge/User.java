/**
 * Created by user on 18.12.18.
 */
public class User {
    private String username;
    private int level = 0;
    private int experience = 0;
    private boolean premium = false;
    private int freeActions = 3;
    private int premiumDays = 0;

    private User(String username) {
        if(!username.matches("([A-z.\\-_])+")) throw new IllegalArgumentException("invalid name");
        this.username = username;
    }

    private void doSomething(int experience){
        if (!premium) {
            if (freeActions == 0) {
                System.out.println("No more actions");
            }
            else{
                addExperience(experience);
                freeActions--;
            }
        }
        else {
            addExperience(experience);
        }
    }

    private void addExperience(int amount){
        experience+=amount;
    }

    private void addPremium(int days){
        if(!premium) premium = true;
        premiumDays+=days;
    }

    private void userInfo(){
        System.out.println("username: " + username);
        System.out.println("level: " + level);
        System.out.println("experience: " + experience);
        System.out.println("premium: " + (premium?"yes":"no"));
        if(premium) System.out.println("Premium days: " + premiumDays);
        else System.out.println("Free actions: " + freeActions);
    }

    private void nextDay() {
        level += experience / 500;
        experience %= 500;
        if (premium) {
            premiumDays--;
            if(premiumDays==0){
                premium = false;
            }
        }
        else{
            freeActions = 3;
        }
    }

    public static void main(String[] args) {
        User user = new User("Pavlo");
        user.doSomething(800);
        user.userInfo();
        user.nextDay();
        user.addPremium(8);
        user.userInfo();
    }
}
