/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Responsi;

/**
 *
 * @author Lab Informatika
 */
public class Main {

    public static void main(String[] args) {
       MovieModel model = new MovieModel();
       MovieView view = new MovieView(null);
       MovieController controller = new MovieController(model,view);
       view = new MovieView(controller);
       view.setVisible(true);
       
    }
    
}
