fun main() {
    val array = IntArray(20)
    for (i in 0..array.lastIndex) {
        array[i] = i + 1
    }
    println("Створений масив від 1 до 20")
    println(array.joinToString())

    println("Task1")
    println("Масив, в якому до парних елементів додали 10")
    val task1array = task1(array.copyOf())
    println(task1array)

    println("Task2")
    task2()

    println("Task3 - bubble sort")
    val task3ArrayBubble = task3bubbleSort(array.copyOf())
    println(task3ArrayBubble)

    println("Task3 - insertion sort")
    val task3bArrayInsertion = task3insertionSort(array.copyOf())
    println(task3bArrayInsertion)

}

//Створити масив числових даних від 1 до 20. Додати до кожного парного числа 10. Вивести результат на екран

fun task1(array: IntArray): String {
    for (n in 0..array.size-1) {
        if ( array[n] % 2 == 0) {
            array[n] += 10
        }
    }
    val task1Array = array.joinToString()
    return task1Array
}

//Створити масив рядкових даних, наприклад, назв міст. В кожному елементі перевести в верхній реєстр першу і останню букву кожного елемента. Вивести результат на екран

fun task2() {
    val stringsArray = arrayOf("london", "bremen", "manchester", "liverpool", "kherson", "lviv", "paris" )
    println("Масив даних міст")
    println(stringsArray.joinToString())
    for (i in stringsArray.indices) {
        stringsArray[i] = stringsArray[i].replaceFirstChar { it.uppercase() }
    }
    for (i in stringsArray.indices) {
        val lastIndex = stringsArray[i].length - 1
        val modifiedString = stringsArray[i].replaceRange(lastIndex, lastIndex + 1, stringsArray[i][lastIndex].uppercase())
        stringsArray[i] = modifiedString
    }
    println("Перетворений масив даних, з переведеними в верхній реєстр першої і останньої букв")
    println(stringsArray.joinToString())
}

// Створити масив числових даних від 1 до 20 в довільному порядку. Написати функцію сортування елементів за зростанням.
//Бульбашкове сортування
fun task3bubbleSort(array: IntArray) :String {
    array.shuffle()
    println("Масив, в довільному порядку для бульбашкового сортування")
    println(array.joinToString())
    var count = 0
    for (i in 0 until array.size-1) {
        count +=1
        for (j in 0 until array.size-1) {
            if (array[j] > array[j+1]) {
                val temp = array[j]
                array[j] = array[j+1]
                array[j+1] = temp
            }
        }
    }
    println("Відсортувалось за ${count} циклів. Відсортований масив:")
    return array.joinToString()
}

//Сортування вставками
fun task3insertionSort(array: IntArray) :String {
    array.shuffle()
    println("Масив, в довільному порядку для сортування вставками")
    println(array.joinToString())
    var count = 0
    for (i in 1 until array.size) {
        count += 1
        for (j in i downTo 1) {
            if (array[j] < array[j-1]) {
                val temp = array[j]
                array[j] = array[j-1]
                array[j-1] = temp
            } else {
                break
            }
        }
    }
    println("Відсортувалось за ${count} циклів. Відсортований масив:")
    return array.joinToString()
}