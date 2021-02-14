package com.gabrielazbarreto.easylist.data.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.gabrielazbarreto.easylist.data.db.entity.ProdutoEntity;

@Dao
public interface ProdutoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertProduto(ProdutoEntity... produto);

    @Update
    public void updateProduto(ProdutoEntity... produto);

    @Delete
    void deleteProduto(ProdutoEntity... produto);

    @Query("SELECT * FROM produto")
    public ProdutoEntity[] todosOsProdutos();


}
