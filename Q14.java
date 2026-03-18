package Intermediate;

interface Serializable{
    void serialize();
}
interface Persistable extends Serializable{
    void save();
}

class UserProfile implements Persistable{
    String name;
    String email;

    UserProfile(String name, String email){
        this.name = name;
        this.email = email;
    }
    @Override
    public void serialize(){
        System.out.println("Serializing: { Name:- "+name+" email:- "+email);
    }
    @Override
    public void save(){
        System.out.println("Saving:- "+name+", email:- "+email);
    }
}


public class Q14 {
    static void main() {
       UserProfile u = new UserProfile("Aman", "amantripathi@gmail.com");
       u.serialize();
       u.save();
    }

}
