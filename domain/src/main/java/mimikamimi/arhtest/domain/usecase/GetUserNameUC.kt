package mimikamimi.arhtest.domain.usecase

import mimikamimi.arhtest.domain.models.DomainUserNameModel
import mimikamimi.arhtest.domain.repository.UserRepositoryIF

class GetUserNameUC (val userRepo:UserRepositoryIF) {
    fun execute():DomainUserNameModel{
        return userRepo.getUserName()
    }
}