/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmarker;

/**
 *
 * @author Larry
 */
public class Student implements Comparable<Student> {
    
    
        private String name;
        private int score;  
    
        
        public void setName(String name){
            
            this.name = name;
        }
        
        public String getName(){ return name;}
        
        public void setScore(int score){
            this.score = score;
        }
        
        public int getScore(){
            return score;
        }

    @Override
    public int compareTo(Student s) { 
        
        return s.score - this.score;
    }
}
