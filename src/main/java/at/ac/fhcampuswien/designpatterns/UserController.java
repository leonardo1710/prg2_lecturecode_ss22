package at.ac.fhcampuswien.designpatterns;

public class UserController {
    private DB db;

    public UserController(DB db){
        this.db = db;
    }

    public void readUsersFromDB(){
        db.getUser();
    }
}
