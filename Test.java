import Core.ORM.*;
import Models.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.*;
/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        try {
            Model.fetch(User.class).all().where("hey", "hi", "arg2").where("arg1", "operator", "arg2").execute();
            User user =  new User();
            user.getAttributes();
            ResultSet data = (ResultSet)Model.sqlQuery("Select * From personne where prenom = ?" ,
                                                        Arrays.asList("xxxxx"));
            while (data.next()) {
                System.out.println(data.getString(2));
            }
            System.out.println(Model.sqlUpdate("insert into personne (nom,prenom) values(?,?)", Arrays.asList("BenFoulen", "Foulen")));
            System.out.println(Model.find(User.class, 2).posts());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }       
    }
}


