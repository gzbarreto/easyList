package com.gabrielazbarreto.easylist.data.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "produto")
public class ProdutoEntity {
    @PrimaryKey
    public String nome;
    //TODO: add foreign key to list entity
    public String categoria;
    public boolean status;
    public boolean  preco;
    public double quantidade;
    public String unidade;


}
