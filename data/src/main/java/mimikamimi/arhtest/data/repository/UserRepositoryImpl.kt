package mimikamimi.arhtest.data.repository

import mimikamimi.arhtest.data.storage.UserStorage
import mimikamimi.arhtest.data.storage.UserStorageModel
import mimikamimi.arhtest.domain.models.SaveUserNameModel
import mimikamimi.arhtest.domain.models.DomainUserNameModel
import mimikamimi.arhtest.domain.repository.UserRepositoryIF

class UserRepositoryImpl (private val userStorage: UserStorage): UserRepositoryIF {



    override fun saveUserName(user: SaveUserNameModel): Boolean {
        val userStorageModel = mapToStorage(user)
        return userStorage.save(userStorageModel)
    }

    override fun getUserName(): DomainUserNameModel {
        val user = userStorage.load()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveUserNameModel: SaveUserNameModel):UserStorageModel{
        return UserStorageModel(saveUserNameModel.firstName,saveUserNameModel.secondName)
    }

    private fun mapToDomain(userStorageModel: UserStorageModel):DomainUserNameModel{
        return DomainUserNameModel(userStorageModel.firstName,userStorageModel.secondName)
    }
}