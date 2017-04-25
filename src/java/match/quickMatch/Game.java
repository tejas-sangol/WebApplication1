/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package match.quickMatch;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tejas
 */
public class Game {
    private String gameId;
    private String type;
    private String player1;
    private String player2;
    private Integer move1;
    private Integer move2;
    private Integer move3;
    private Integer move4;
    private Integer move5;
    private Integer move6;
    private Integer move7;
    private Integer move8;
    private Integer move9;
    private Integer state; 
    
    private static Connection currentCon;
    public Game() throws SQLException
    {
        gameId = null;
        type = null;
        player1 = null;
        player2 = null;
        move1 = 0;
        move2 = 0;
        move3 = 0;
        move4 = 0;
        move5 = 0;
        move6 = 0;
        move7 = 0;
        move8 = 0;
        move9 = 0;
        
        if(currentCon==null)
        {
             DriverManager.registerDriver(new Driver());
            currentCon=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/pfour","root","root"); 
        }
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public Integer getMove1() {
        return move1;
    }

    public void setMove1(Integer move1) {
        this.move1 = move1;
    }

    public Integer getMove2() {
        return move2;
    }

    public void setMove2(Integer move2) {
        this.move2 = move2;
    }

    public Integer getMove3() {
        return move3;
    }

    public void setMove3(Integer move3) {
        this.move3 = move3;
    }

    public Integer getMove4() {
        return move4;
    }

    public void setMove4(Integer move4) {
        this.move4 = move4;
    }

    public Integer getMove5() {
        return move5;
    }

    public void setMove5(Integer move5) {
        this.move5 = move5;
    }

    public Integer getMove6() {
        return move6;
    }

    public void setMove6(Integer move6) {
        this.move6 = move6;
    }

    public Integer getMove7() {
        return move7;
    }

    public void setMove7(Integer move7) {
        this.move7 = move7;
    }

    public Integer getMove8() {
        return move8;
    }

    public void setMove8(Integer move8) {
        this.move8 = move8;
    }

    public Integer getMove9() {
        return move9;
    }

    public void setMove9(Integer move9) {
        this.move9 = move9;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    
    private  static void add(Game game, ResultSet rs) throws SQLException 
    {
        game.setGameId(rs.getString("gameId"));
        game.setType(rs.getString("type"));
        game.setPlayer1(rs.getString("player1"));
        game.setPlayer2(rs.getString("player2"));
        game.setMove1(rs.getInt("move1"));
        game.setMove2(rs.getInt("move2"));
        game.setMove3(rs.getInt("move3"));
        game.setMove4(rs.getInt("move4"));
        game.setMove5(rs.getInt("move5"));
        game.setMove6(rs.getInt("move6"));
        game.setMove7(rs.getInt("move7"));
        game.setMove8(rs.getInt("move8"));
        game.setMove9(rs.getInt("move9"));
        game.setState(rs.getInt("state"));
    }
    
    public static Game getGameById(String gameId)
    {
        Game game = null;
        try {
                     Statement stmt=currentCon.createStatement(); 
                     ResultSet rs = stmt.executeQuery("select * from game where gameId="+gameId); 
                     game = new Game();
                     while(rs.next())
                     {
                         add(game,rs);
                     }
                     return game;
        } catch (SQLException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return game;
        }
                       
    }
    
    public static ArrayList<Game> getActiveGamesByPlayerId(String playerId)
    {
        ArrayList<Game> games = new ArrayList<Game>();
        try
        {
            Statement stmt=currentCon.createStatement(); 
                     ResultSet rs = stmt.executeQuery("select * from game where (player1="+playerId + " or  player2="+playerId+ ") and state=1"); 
                     while(rs.next())
                     {
                         Game game = new Game();
                         add(game,rs);
                         games.add(game);
                     }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            return games;
        }
    }
    
    public static ArrayList<Game> getWonGamesByPlayerId(String playerId)
    {
        ArrayList<Game> games = new ArrayList<Game>();
        try
        {
            Statement stmt=currentCon.createStatement(); 
                     ResultSet rs = stmt.executeQuery("select * from game where (player1="+playerId + " and state=2)  or  (player2="+playerId+ " and state=3)"); 
                     while(rs.next())
                     {
                         Game game = new Game();
                         add(game,rs);
                         games.add(game);
                     }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            return games;
        }
    }
    
    public static ArrayList<Game> getLostGamesByPlayerId(String playerId)
    {
        ArrayList<Game> games = new ArrayList<Game>();
        try
        {
            Statement stmt=currentCon.createStatement(); 
                     ResultSet rs = stmt.executeQuery("select * from game where (player1="+playerId + " and state=3)  or  (player2="+playerId+ " and state=2)"); 
                     while(rs.next())
                     {
                         Game game = new Game();
                         add(game,rs);
                         games.add(game);
                     }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            return games;
        }
    }
    
    public static ArrayList<Game> getDrawnByPlayerId(String playerId)
    {
        ArrayList<Game> games = new ArrayList<Game>();
        try
        {
            Statement stmt=currentCon.createStatement(); 
                     ResultSet rs = stmt.executeQuery("select * from game where (player1="+playerId + " and state=2)  or  (player2="+playerId+ " and state=4"); 
                     while(rs.next())
                     {
                         Game game = new Game();
                         add(game,rs);
                         games.add(game);
                     }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            return games;
        }
    }


}




