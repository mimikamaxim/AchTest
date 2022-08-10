package mimikamimi.arhtest.domain.usecase

import mimikamimi.arhtest.domain.models.SaveUserNameModel
import mimikamimi.arhtest.domain.repository.UserRepositoryIF
import java.lang.Exception

class SaveUserNameUC(private val userRepo:UserRepositoryIF) {
    fun execute (param: String): Boolean{
        var names: List<String> = param.split(" ")
        if (names.lastIndex!=1)
            return false
        println(names[0])
        println(names[1])
        return userRepo.saveUserName(SaveUserNameModel(names[0],names[1]))
    }
}