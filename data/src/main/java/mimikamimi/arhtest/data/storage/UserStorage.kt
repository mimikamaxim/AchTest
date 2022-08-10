package mimikamimi.arhtest.data.storage

interface UserStorage {
    fun save(userStorageModel: UserStorageModel): Boolean

    fun load (): UserStorageModel


}