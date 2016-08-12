/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shipsinthenight;

import java.util.ArrayList;

    enum pieceType { AIR_CARRIER, BATTLESHIP, SUB, DESTROYER, PATROL };

/**
 *
 * @author allisonfrauenpreis
 */
public class Piece {
    
    
    
    private int size;
    private pieceType type;
    ArrayList<Position> position;
    public int hits = 0;
    public boolean sunk = false;
  
    
    
    public Piece(pieceType pType){
       
        type = pType;
        position = new ArrayList();
        size = 0;
        setup();
        
    }
    
    public void setup(){
        
        switch (type){
            case AIR_CARRIER:
                size = 5;
                break;
            case BATTLESHIP:
                size = 4;
                break;
            case SUB:
                size = 3;
                break;
            case DESTROYER:
                size = 2;
                break;
            case PATROL:
                size = 2;
                break;
            
        }
    }
    
    // sets piece that has at least its origin point and direction set as first two positions
    public void autoSetPositions(){
        
        if (position.size() < 2){
            
            System.out.println("Piece does not have enough positions to be set");
            
        } else { 
            
            
            Position origin = position.get(0);
            Position next = position.get(1);
            
            position.clear();
            
            if (origin.getRow() < next.getRow()){
                
                System.out.println("down");
                // going down
                
                for (int i = 1; i <= size; i++){
                    System.out.println(i);
                    position.add(new Position(origin.getRow()+1, origin.getCol()));
                }
                
            } else if (origin.getRow() > next.getRow()) {
                
                
                System.out.println("up");
                // going up
                
                for (int i = 1; i <= size; i++){
                    
                    position.add(new Position(origin.getRow()-1,origin.getCol()));
                }
                
            } else if (origin.getCol() < next.getCol()){
                
                
                System.out.println("right");
                // going right
                for (int i = origin.getCol(); i <= size+1; i++){
                    
                    position.add(new Position(origin.getRow(),origin.getCol()+1));
                }
                
                
            } else if (origin.getCol() > next.getCol()) {
                
                
                System.out.println("left");
                // going left
                for (int i = origin.getCol(); i <= size; i++){
                    
                    position.add(new Position(origin.getRow(),origin.getCol()-1));
                }
            }
        
            
            
            
        }
    }
    
    public void addHit(){
        
        hits = hits + 1;
        if (hits == size){
            
            sunk = true;
        }
    }
    
    // returns true if this piece exists at this position
    public boolean hasPosition(Position p){
        
        for (Position pos : position){
            
            if (pos.getCol() == p.getCol()){
                
                if (pos.getRow() == p.getRow()){
                    
                    return true;
                }
            }
            
        }
        
        return false;
    }
    
    public int getSize(){
        
        return size;
    }
    
    public ArrayList getPositions(){
        
        return position;
    }
    
    public void addPosition(Position pos){
        
        position.add(pos);
    }
    
    public boolean isSet(){
        
        if (position.size() == size){
            
            return true;
            
        } else {
            return false;
        }
    }
    
    
    
}