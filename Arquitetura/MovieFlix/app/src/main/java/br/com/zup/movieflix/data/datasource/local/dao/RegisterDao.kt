package br.com.zup.movieflix.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import br.com.zup.movieflix.register.model.RegisterModel

@Dao
interface RegisterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun registerUser (user: RegisterModel)
}
