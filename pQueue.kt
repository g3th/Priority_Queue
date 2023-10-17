import kotlin.system.exitProcess

class priorityQueue {
    var nums = mutableListOf<Int>()

    fun offer(num: Int){
        nums.add(num)
        println(nums)
        sort()
    }

    fun peek(){
        if (nums.isNotEmpty()) {
            println(nums)
            println("Highest priority element returned is: ${nums[0]}")
        } else {
            println("Empty array.")
        }
    }

    fun poll(){
        if (nums.isNotEmpty()) {
            println("Highest priority element ${nums[0]} has been removed.")
            nums.removeAt(0)
            sort()
        } else {
            println("Empty array.")
        }

    }

    fun sort(): MutableList<Int> {
        var index = 0
        while (index != nums.size) {
            for (i in nums.indices) {
                if (i + 1 < nums.size) {
                    if (nums[i] < nums[i + 1]) {
                        val temp = nums[i]
                        nums[i] = nums[i + 1]
                        nums[i + 1] = temp
                    }
                }
            }
            index++
        }
        return nums
    }
}

fun main(){
    val pQueue = priorityQueue()
    while(true){
        println("Enter function:")
        println("1) Offer")
        println("2) Peek")
        println("3) Poll")
        println("Q) Quit")
        val i = readln()
        when (i) {
            "1" -> {
                println("Enter a number: ")
                val n = readln().toInt()
                pQueue.offer(n)
            }
            "2" -> pQueue.peek()
            "3" -> pQueue.poll()
            "Q" -> exitProcess(0)
            else -> {
                println("Invalid")
            }
        }
    }
}
