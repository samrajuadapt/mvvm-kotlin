package com.adapt.pinetreeapp.database


import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.adapt.pinetreeapp.database.dao.AuthDao
import com.adapt.pinetreeapp.database.dao.VisitDao
import com.adapt.pinetreeapp.models.AuthModel
import com.adapt.pinetreeapp.models.VisitModel

@androidx.room.Database(entities = [AuthModel::class,VisitModel::class],version = 1)
abstract class Database: RoomDatabase() {

    abstract fun authDao():AuthDao
    abstract fun visitDao():VisitDao

    companion object {
        @Volatile
        private var INSTANCE:Database?=null

        fun getInstance(ctx:Context):Database{
            val DB_NAME:String = "pine_db";
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    ctx.applicationContext,
                    Database::class.java,
                    DB_NAME
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }
}