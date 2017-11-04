/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.novo;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author fe_mm
 */
public class MaterialTableView 
{
    private SimpleIntegerProperty Id;
    private SimpleStringProperty Nome;
    private SimpleIntegerProperty Quantidade;
    private SimpleFloatProperty Preço;
    private SimpleStringProperty Tipo;
    private SimpleStringProperty Unidade;
    
    public MaterialTableView(int id, String nome, int quantidade, float preço, String tipo, String unidade)
    {
        this.Id = new SimpleIntegerProperty(id);
        this.Nome = new SimpleStringProperty(nome);
        this.Quantidade = new SimpleIntegerProperty(quantidade);
        this.Preço = new SimpleFloatProperty(preço);
        this.Tipo = new SimpleStringProperty(tipo);
        this.Unidade = new SimpleStringProperty(unidade);
    }
    
    public Integer getId()
    {
        return this.Id.getValue();
    }
    public String getNome()
    {
        return this.Nome.getValue();
    }
    public Integer getQuantidade()
    {
        return this.Quantidade.getValue();
    }
    public Float getPreço()
    {
        return this.Preço.getValue();
    }
    public String getTipo()
    {
        return this.Tipo.getValue();
    }
    public String getUnidade()
    {
        return this.Unidade.getValue();
    }
   
}
