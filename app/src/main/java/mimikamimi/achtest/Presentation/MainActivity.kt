package mimikamimi.achtest.Presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import mimikamimi.achtest.R
import mimikamimi.arhtest.data.repository.UserRepositoryImpl
import mimikamimi.arhtest.data.storage.SharedPrefUserStorage
import mimikamimi.arhtest.domain.usecase.GetUserNameUC
import mimikamimi.arhtest.domain.usecase.SaveUserNameUC
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {


    private val vm: MainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("AAA", "Activity created")
//        vm = ViewModelProvider(this, MainViewModelFactory(context = this))
//            .get(MainViewModel::class.java)
        val dataTextView = findViewById<TextView>(R.id.data_text_view)
        val dataEditField = findViewById<EditText>(R.id.data_edit_text)
        val btnReceiveData = findViewById<Button>(R.id.receive_btn)
        val btnSendData = findViewById<Button>(R.id.btn_put_data)
        vm.resultLive.observe(this) {
            dataTextView.text = it
        }
        btnSendData.setOnClickListener {
            val text = dataEditField.text.toString()
            vm.saveUser(text)
        }
        btnReceiveData.setOnClickListener {
            vm.loadUser()
        }
    }


}