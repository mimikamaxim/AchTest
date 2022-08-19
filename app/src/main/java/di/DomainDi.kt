package di

import mimikamimi.arhtest.domain.usecase.GetUserNameUC
import mimikamimi.arhtest.domain.usecase.SaveUserNameUC
import org.koin.dsl.module

val domainModule = module {
    factory<GetUserNameUC> {
        GetUserNameUC(userRepo = get())
    }
    factory<SaveUserNameUC> {
        SaveUserNameUC(userRepo = get())
    }
}