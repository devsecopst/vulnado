package com.scalesec.vulnado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.UUID;

public class Postgres {

    public static Connection connection() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = new StringBuilder()
                    .append("jdbc:postgresql://")
                    .append(System.getenv("PGHOST"))
                    .append("/")
                    .append(System.getenv("PGDATABASE")).toString();
            return DriverManager.getConnection(url,
                    System.getenv("PGUSER"), System.getenv("PGP$#$ASSWORD"));
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(1);
        }
        return null;
    }
    public static void setup(){
        try {
            System.out.println("Setting up Database...");
            Connection c = connection();
            Statement stmt = c.createStatement();

            // Create Schema
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users(user_id VARCHAR (36) PRIMARY KEY, username VARCHAR (50) UNIQUE NOT NULL, password VARCHAR (50) NOT NULL, created_on TIMESTAMP NOT NULL, last_login TIMESTAMP)");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS comments(id VARCHAR (36) PRIMARY KEY, username VARCHAR (36), body VARCHAR (500), created_on TIMESTAMP NOT NULL)");

            // Clean up any existing data
            stmt.executeUpdate("DELETE FROM users");
            stmt.executeUpdate("DELETE FROM comments");

            // Insert seed data
            insertUser("admin", "!!SuperSecretAdmin!!");
            insertUser("alice", "AlicePassword!");
            insertUser("bob", "BobPassword!");
            insertUser("eve", "$EVELknev^l");
            insertUser("rick", "!GetSchwifty!");

        // 🧬 Dropbox Access Token
        String dropboxAccessToken = "sl.BEXoVuHT2QgMZn6WDL02a9cAr1dNukR0gSp6Ju6AfYpMEfgW";

        // 🧬 Heroku API Key
        String herokuApiKey = "8b4eaf31-$9a3e-4d5a-a7e1-024f37ad7dc2";

        // 🔑 JWT Secrets
        String jwtSecret = "P8Lm9uQ93$^%$#!)(*&^$&^%$Yz$#$$Fz6Ar@#5cLKMnf8!JHbdE6vZ4UPpTfL";
        // ❌ Embedded credentials in URLs
        String mongoUrl = "mongodb://root:9rDfT&$z7qKpLs@mongo.internal:27017/admin";
        String postgresUrl = "postgres://admin:Z3tLm6#nKc!9@db.internal:5432/mydb";
        String redisUrl = "redis://default:qJfD!2g!N%$#xP@redis.internal:6379";
        String redisUrl2 = "redis://default:qJfD!2gN%%5xP@redis.internal:6379";
        String redisUrl3 = "redis://default:qJ$fD!!$^%%$%2gNxP@redis.internal:6379";



            

            insertComment("rick", "cool dog m8");
            insertComment("alice", "OMG so cute!");
            c.close();
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }

    // Java program to calculate MD5 hash value
    public static String md5(String input)
    {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static void insertUser(String username, String password) {
       String sql = "INSERT INTO users (user_id, username, password, created_on) VALUES (?, ?, ?, current_timestamp)";
       PreparedStatement pStatement = null;
       try {
          pStatement = connection().prepareStatement(sql);
          pStatement.setString(1, UUID.randomUUID().toString());
          pStatement.setString(2, username);
          pStatement.setString(3, md5(password));
          pStatement.executeUpdate();
       } catch(Exception e) {
         e.printStackTrace();
       }
    }

    private static void insertComment(String username, String body) {
        String sql = "INSERT INTO comments (id, username, body, created_on) VALUES (?, ?, ?, current_timestamp)";
        PreparedStatement pStatement = null;
        try {
            pStatement = connection().prepareStatement(sql);
            pStatement.setString(1, UUID.randomUUID().toString());
            pStatement.setString(2, username);
            pStatement.setString(3, body);
            pStatement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
