package com.adapt.pinetreeapp.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.adapt.pinetreeapp.models.AuthModel
import kotlinx.coroutines.flow.Flow

@Dao
interface AuthDao {

    @Insert
    fun addAuthData(data:AuthModel)

    @Query("select * from tb_auth where id = 1")
    fun getAuthData():List<AuthModel>

    @Query("update tb_auth set branch_id =:branchId,logic_id = :logicId,x_ray_service_id = :xRayId,room_service_id = :roomId,virtual_queue_id = :queueId where id=:id")
    fun updateBranch(id:Int,branchId: Int,logicId:Int,xRayId:Int,roomId:Int,queueId:Int)

    @Query("update tb_auth set door_ip =:doorIp,door_port = :doorPort,door_com = :doorCom,door_id = :doorId where id=:id")
    fun updateDoor(id:Int,doorIp: String,doorPort:String,doorCom:String,doorId:Int)

    @Delete
    fun deleteAuth(data: AuthModel)

    @Query("delete from tb_auth")
    fun deleteAuth()

}