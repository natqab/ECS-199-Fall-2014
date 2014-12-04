package yona.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
@Path("/api")
public class HelloWorld {
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/test")
    public HashMap<String,String> responseMsg() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("foo", "bar");
        return map;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/{username}")
    public User get(@PathParam("username") String username){
    	Connection c = null;
        try {
        	String dir = "C:/Users/Watson Wong/Documents/ecs199/HelloWorld/test.db";
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:"+dir);
            c.setAutoCommit(false);
            
            User user = new User("","");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * FROM users where username='"+username+"';" );
            while ( rs.next() ) {
               String rsUsername = rs.getString("username");
               String rsPassword  = rs.getString("password");
               user.setUsername(rsUsername);
               user.setPassword(rsPassword);
            }
            stmt.close();
            c.close();
            return user;
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return null;
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/newUser/{userName}/")
    public Response newUser(User user){
    	Connection c = null;
        try {
        	String dir = "C:/Users/Watson Wong/Documents/ecs199/HelloWorld/test.db";
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:"+dir);
            c.setAutoCommit(false);
            
            Statement stmt = c.createStatement();
            String sql = "insert into users values ('"+user.getUserName()+"','"+user.getPassword()+"');";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
            
            String output = "User saved.";
            return Response.status(200).entity(output).build();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            String output = "Database failed";
            return Response.status(200).entity(output).build();
        }
    }
}
