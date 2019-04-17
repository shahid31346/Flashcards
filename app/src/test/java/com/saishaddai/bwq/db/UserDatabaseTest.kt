package com.saishaddai.bwq.db

import com.saishaddai.bwq.model.StatusMessages
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UserDatabaseTest {

    @Before
    fun setUp() {
        print("setUp database")
    }

    @After
    fun tearDown() {
        print("tearDown database")
    }

//    @Test
//    fun testGetUserList() {
//        val userDatabase = UserDatabase()
//        val userListResponse = userDatabase.getUserList()
//        Assert.assertNotNull(userListResponse)
//        Assert.assertEquals(StatusMessages.OK, userListResponse.first)
//        Assert.assertEquals(ArrayList<DataBaseModel.User>(), userListResponse.second)
//    }


    @Test
    fun testSomething() {

    }

}