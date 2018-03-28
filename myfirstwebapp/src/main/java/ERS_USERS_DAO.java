public interface ERS_USERS_DAO {
    boolean Find_User(String username, String password);
    Users getUser_by_First_name(String data);
    Users getUser_by_User_name(String username);
    Users getUser(int userid);
}
