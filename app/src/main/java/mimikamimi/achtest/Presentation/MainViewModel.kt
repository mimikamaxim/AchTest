package mimikamimi.achtest.Presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mimikamimi.arhtest.domain.usecase.GetUserNameUC
import mimikamimi.arhtest.domain.usecase.SaveUserNameUC

class MainViewModel(private val getUserNameUC: GetUserNameUC,
                    private val saveUserNameUC:SaveUserNameUC
                    ): ViewModel() {
//    private val context by lazy { applicationContext }
//    private val userStorage by lazy { SharedPrefUserStorage(context) }
//    private val userRepo by lazy { UserRepositoryImpl(userStorage) }
//    private val getUserNameUC by lazy { GetUserNameUC(userRepo) }
//    private val saveUserNameUC by lazy { SaveUserNameUC(userRepo) }

    init {
        Log.e("AAA","VM crated")

    }

    private val resultLiveDataMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveDataMutable

    fun saveUser(text:String){
        val result: Boolean = saveUserNameUC.execute(text)
        resultLiveDataMutable.value = "Save result is $result"
    }

    fun loadUser(){
        val userName = getUserNameUC.execute()
        resultLiveDataMutable.value = "${userName.firstName} ${userName.secondName}"
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }
}