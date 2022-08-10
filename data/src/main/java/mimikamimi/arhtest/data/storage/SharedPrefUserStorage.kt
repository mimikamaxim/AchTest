package mimikamimi.arhtest.data.storage

import android.content.Context

private const val SHARED_PREFS_NAME = "users"
private const val FIRST_NAME_KEY = "first_name"
private const val SECOND_NAME_KEY = "second_name"
private const val DEFAULT_RETURN = "it's not set yet"

class SharedPrefUserStorage(context: Context) : UserStorage {

    val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(userStorageModel: UserStorageModel): Boolean {
        sharedPreferences.edit().putString(FIRST_NAME_KEY, userStorageModel.firstName).apply()
        sharedPreferences.edit().putString(SECOND_NAME_KEY,userStorageModel.secondName).apply()
        return true
    }

    override fun load(): UserStorageModel {
        val firstName =
            sharedPreferences.getString(FIRST_NAME_KEY, DEFAULT_RETURN) ?: DEFAULT_RETURN
        val secondName =
            sharedPreferences.getString(SECOND_NAME_KEY, DEFAULT_RETURN) ?: DEFAULT_RETURN
        return UserStorageModel(firstName, secondName)
    }
}