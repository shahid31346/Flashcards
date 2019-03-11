package com.saishaddai.bwq.db

import com.saishaddai.bwq.model.DataBaseModel
import com.saishaddai.bwq.model.StatusMessages

class UserDatabase {

    fun getUserList() : Pair<StatusMessages, List<DataBaseModel.User>> {
        var myList = ArrayList<DataBaseModel.User>()
        try {
            //TODO implement this method to get the response from a database connection
            return StatusMessages.OK to myList
        } catch (e : Exception) {
            return StatusMessages.CONNECTION_TO_DATABASE_INTERRUPTED to myList
        }
    }
}