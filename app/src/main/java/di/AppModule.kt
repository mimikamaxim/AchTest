package di

import mimikamimi.achtest.Presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel>{
        MainViewModel(
            getUserNameUC = get(),
            saveUserNameUC = get()
        )
    }
}