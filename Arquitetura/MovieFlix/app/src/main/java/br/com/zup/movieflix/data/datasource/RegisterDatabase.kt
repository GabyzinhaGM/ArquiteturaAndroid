package br.com.zup.movieflix.data.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.zup.movieflix.data.datasource.local.dao.RegisterDao
import br.com.zup.movieflix.register.model.RegisterModel

@Database(entities = [RegisterModel::class], version = 1)
abstract class RegisterDatabase : RoomDatabase() {

    abstract fun registerDao(): RegisterDao

    companion object {
        @Volatile
        private var INSTANCE: RegisterDatabase? = null
        fun getDatabase(context: Context): RegisterDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RegisterDatabase::class.java,
                    "register_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
