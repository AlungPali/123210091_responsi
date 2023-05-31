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
public class MovieController {
    private MovieModel model;
    private MovieView view;
    
    public MovieController(MovieModel model, MovieView view){
        this.model = model;
        this.view = view;
    }
    
    public void tambahData(){
        String judul = view.getJudul();
        double alur = view.getAlur();
        double penokohan = view.getPenokohan();
        double akting = view.getAkting();
        
        model.tambahData(judul, alur, penokohan, akting);
    }
    
}
