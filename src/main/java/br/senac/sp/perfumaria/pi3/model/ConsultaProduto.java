/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.perfumaria.pi3.model;

/**
 *
 * @author rbezerra
 */
public class ConsultaProduto {
    private int id;
    


    public ConsultaProduto() {
    }

 public ConsultaProduto(int id) {
        this.id = id;

}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
