// ArrayListResultTypeConverter.kt
import androidx.room.TypeConverter
import com.example.youtubehomeclone.models.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ArrayListResultTypeConverter {

        private val gson = Gson()

        @TypeConverter
        fun fromArrayList(value: ArrayList<Result>?): String {
                return gson.toJson(value)
        }

        @TypeConverter
        fun toArrayList(value: String): ArrayList<Result>? {
                val listType = object : TypeToken<ArrayList<Result>>() {}.type
                return gson.fromJson(value, listType)
        }
}
