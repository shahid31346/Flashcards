package com.saishaddai.bwq.model

sealed class Response<in R> {
    data class Ok<T>(val data: T): Response<T>()
    sealed class Fail: Response<Any?>() {
        object WrongParameters : Fail()
        object ConnectionToDatabaseInterrupted : Fail()
        object ConnectionToApiInterrupted : Fail()
        object WrongServer : Fail()
        object DefaultParametersUsed : Fail()
        object NoResultsFound : Fail()
    }


    //usage
//    class UserDatabase {
//        fun getUserList(): Response<List<DatabaseModel.User>> {
//            return try {
//                val myList = mutableListOf<DatabaseModel.User>()
//                Response.Ok(myList)
//            } catch (e: Exception) {
//                Response.Fail.ConnectionToDatabaseInterrupted
//            }
//        }
//
//        fun validateUser(user: DatabaseModel.User): Response<UserId> {
//            return try {
//                var userId = UserId(-1)
//                if (userId.id == -1) Response.Fail.WrongParameters
//                else Response.Ok(userId)
//            } catch (e: Exception) {
//                Response.Fail.ConnectionToApiInterrupted
//            }
//        }
//    }

    //asserting in an unit test
//    fun testGetUserList() {
//        val userdatabase = UserDatabase()
//        val userListResponse = userdatabase.getUserList()
//
//        assert(userListResponse is Response.Ok && userListResponse.data.isEmpty())
//    }
}
