package idiomatic_kotlin

import java.util.*


// https://qiita.com/takahirom/items/87d46150088aadccb481

// Kotlinらしい書きかた


//------ 式を使う ------//
// ダメ
fun getDefaultLocale(deliveryArea: String): Locale {
    val deliverAreaLower = deliveryArea.toLowerCase()
    if (deliverAreaLower == "germany" || deliverAreaLower == "austria") {
        return Locale.GERMAN
    }

    if (deliverAreaLower == "usa" || deliverAreaLower == "great britain") {
        return Locale.ENGLISH
    }

    if (deliverAreaLower == "france") {
        return Locale.FRENCH
    }

    return Locale.ENGLISH
}

// こっちで書こう
fun getDefaultLocale2(deliveryArea: String) = when (deliveryArea.toLowerCase()) {
    "germany", "austria" -> Locale.GERMAN
    "usa", "great britain" -> Locale.ENGLISH
    "france" -> Locale.FRENCH
    else -> Locale.ENGLISH
}

// try-catchも式
val json = """{"message":"HELLO"}"""
val message = try {
    //JSONObject(json).getString("message")
    json.toUpperCase()
} catch (ex: Exception) {
    json
}



