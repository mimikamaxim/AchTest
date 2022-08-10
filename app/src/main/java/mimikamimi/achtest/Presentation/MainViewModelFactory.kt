package mimikamimi.achtest.Presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mimikamimi.arhtest.data.repository.UserRepositoryImpl
import mimikamimi.arhtest.data.storage.SharedPrefUserStorage
import mimikamimi.arhtest.domain.usecase.GetUserNameUC
import mimikamimi.arhtest.domain.usecase.SaveUserNameUC

class MainViewModelFactory(context: Context): ViewModelProvider.Factory {
    private val getUserNameUC by lazy { GetUserNameUC(userRepo) }
    private val saveUserNameUC by lazy { SaveUserNameUC(userRepo) }
    private val userStorage by lazy { SharedPrefUserStorage(context) }
    private val userRepo by lazy { UserRepositoryImpl(userStorage) }
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUC,saveUserNameUC) as T
    }
}