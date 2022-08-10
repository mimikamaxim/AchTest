package mimikamimi.arhtest.domain.repository

import mimikamimi.arhtest.domain.models.SaveUserNameModel
import mimikamimi.arhtest.domain.models.DomainUserNameModel

interface UserRepositoryIF {
    fun saveUserName(user: SaveUserNameModel): Boolean
    fun getUserName (): DomainUserNameModel
}