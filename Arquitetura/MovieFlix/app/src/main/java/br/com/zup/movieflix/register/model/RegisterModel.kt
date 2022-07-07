package br.com.zup.movieflix.register.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "register")
data class RegisterModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "register_cod")
    var codRegister: Long = 1,
    @ColumnInfo(name = "user")
    var user: String,
    @ColumnInfo(name = "password")
    var password: String
) : Parcelable
