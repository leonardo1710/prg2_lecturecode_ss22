package at.ac.fhcampuswien.designpatterns;

public class App {
    public static void main(String[] args) {
        DB db = new DB();
        UserController ctr = new UserController(db);

        ctr.readUsersFromDB();
    }
}
