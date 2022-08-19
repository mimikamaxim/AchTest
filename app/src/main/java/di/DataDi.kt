package di

import mimikamimi.arhtest.data.repository.UserRepositoryImpl
import mimikamimi.arhtest.data.storage.SharedPrefUserStorage
import mimikamimi.arhtest.data.storage.UserStorage
import mimikamimi.arhtest.domain.repository.UserRepositoryIF
import org.koin.dsl.module

val dataModule = module {
    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepositoryIF> {
        UserRepositoryImpl(userStorage = get())
    }
}