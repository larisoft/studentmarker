/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmarker;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Larry
 */
public class Solution {
        
        //what we do is 
        //collect student scores 
        //and add them to two queues; one FIFO, the other; a priority queue
       public Solution(){
       System.out.println("Please Enter the number of students you are grading");
       Scanner scanner = new Scanner(System.in); 
       int no = scanner.nextInt(); 
       
       //scanner acts weitd when you collect integer, so we head straight to next line.
       scanner.nextLine();
       
       //normal FIFO queue
       Queue<Student> normalqueue = new LinkedList<Student>();
       
       //priority queue
       PriorityQueue<Student> priorityQueue = new PriorityQueue<>();
       
       Student student; 
       //loop to collect all student data
       int i = 0;
       int counter = 0;
       while(i < no){
           counter++;
           student = new Student();
           speak("Student " + counter + ": Enter Name:"); 
           String name = scanner.nextLine();  
           speak("Enter Score");
           
           int score  = scanner.nextInt(); 
           //move to next line 
           scanner.nextLine();
           
           student.setName(name);
           student.setScore(score);
           normalqueue.add(student);
           priorityQueue.offer(student);
           i++;
       }
       
       int choice = 5;
       while(choice!=-1){
           speak("Press \n'1'  + ENTER to get results in the order in which they were entered \n'2' + ENTER To get results in order of highest score \n'-1' + ENTER To Quit");
           choice = scanner.nextInt();
           scanner.nextLine();
           
           switch(choice){
               
               case 1:
                   output(normalqueue);
                   break;
               case 2: 
                   output(priorityQueue);
                   break;
                   
               default:
                   if(choice!=-1)
                   speak("Dont understand you. Please try again");
                   break;
           }
           
       }
         
        
             
       }
       
       
       public void output(Queue queue){
          
       if(queue == null || queue.isEmpty()){
           speak("Empty!!!!");
           return;
       }
           
       Iterator it = queue.iterator();
       
       int counter = 0;
       while(!queue.isEmpty()){
           counter++;
           Student s = (Student) queue.poll();
           speak(counter+". Name: " + s.getName()+" score: " + s.getScore());
       }
       
       }
       
       
       //we use this to print all output
       public void speak(String message){
           System.out.println(message);
       }
}
